package io.github.teamgensouspark.kekkai.danmaku.form.impl;

import java.util.HashMap;

import org.lwjgl.opengl.GL11;

import io.github.teamgensouspark.kekkai.utils.ScalaJ;
import net.katsstuff.teamnightclipse.danmakucore.client.helper.DanCoreRenderHelper;
import net.katsstuff.teamnightclipse.danmakucore.danmaku.DanmakuState;
import net.katsstuff.teamnightclipse.danmakucore.danmaku.form.IRenderForm;
import net.katsstuff.teamnightclipse.danmakucore.danmaku.form.RenderingProperty;
import net.katsstuff.teamnightclipse.danmakucore.data.ShotData;
import net.katsstuff.teamnightclipse.danmakucore.impl.form.FormGeneric;
import net.katsstuff.teamnightclipse.mirror.client.helper.MirrorRenderHelper;
import net.katsstuff.teamnightclipse.mirror.client.shaders.MirrorShaderProgram;
import net.katsstuff.teamnightclipse.mirror.data.Quat;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import scala.collection.immutable.Map;

public abstract class AbstractSphere extends FormGeneric {

    public AbstractSphere(String name) {
        super(name);
    }

    @SideOnly(Side.CLIENT)
    public abstract void afterRender(DanmakuState danmaku, double x, double y, double z, Quat orientation,
            float partialTicks,
            RenderManager manager);

    @SideOnly(Side.CLIENT)
    @Override
    public IRenderForm createRenderer() {
        return new IRenderForm() {
            @SideOnly(Side.CLIENT)
            @Override
            public Map<String, RenderingProperty> defaultAttributeValues() {
                HashMap<String, RenderingProperty> _renderProperty = new HashMap<String, RenderingProperty>();
                _renderProperty.put("coreSize", new RenderingProperty(1.1F, 0.5F, 10F));
                _renderProperty.put("coreHardness", new RenderingProperty(2.5F, 0.5F, 10F));
                _renderProperty.put("edgeHardness", new RenderingProperty(3F, 0.5F, 10F));
                _renderProperty.put("edgeGlow", new RenderingProperty(3F, 0.5F, 10F));
                return ScalaJ.asScalaImtMap(_renderProperty);
            }

            @SideOnly(Side.CLIENT)
            @Override
            public void renderLegacy(DanmakuState danmaku, double x, double y, double z, Quat orientation,
                    float partialTicks,
                    RenderManager manager) {
                ShotData shot = danmaku.shot();
                Float alpha = 0.3F;
                DanCoreRenderHelper.transformDanmaku(shot, orientation);
                Double dist = x * x + y * y + z * z;
                MirrorRenderHelper.drawSphere(shot.coreColor(), 1F, dist);
                GlStateManager.enableBlend();
                GlStateManager.blendFunc(GL11.GL_ONE, GL11.GL_ONE);
                GlStateManager.depthMask(false);
                GlStateManager.scale(1.2F, 1.2F, 1.2F);
                MirrorRenderHelper.drawSphere(shot.edgeColor(), alpha, dist);
                GlStateManager.depthMask(true);
                GlStateManager.disableBlend();
            }

            @SideOnly(Side.CLIENT)
            @Override
            public void renderShaders(DanmakuState danmaku, double x, double y, double z, Quat orientation,
                    float partialTicks,
                    RenderManager manager, MirrorShaderProgram shaderProgram) {
                ShotData shot = danmaku.shot();
                Double dist = x * x + y * y + z * z;
                DanCoreRenderHelper.updateDanmakuShaderAttributes(shaderProgram, this, shot);
                DanCoreRenderHelper.transformDanmaku(shot, orientation);

                GlStateManager.enableBlend();
                GlStateManager.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
                MirrorRenderHelper.drawSphere(DanCoreRenderHelper.OverwriteColorEdge(), 1F, dist);
                GlStateManager.disableBlend();
                afterRender(danmaku, x, y, z, orientation, partialTicks, manager);
            }

            @SideOnly(Side.CLIENT)
            @Override
            public ResourceLocation shader(DanmakuState arg0) {
                return DanCoreRenderHelper.fancyDanmakuShaderLoc();
            }

        };
    }

}

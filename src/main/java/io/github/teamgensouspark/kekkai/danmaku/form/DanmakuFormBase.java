package io.github.teamgensouspark.kekkai.danmaku.form;

import net.katsstuff.teamnightclipse.danmakucore.client.helper.DanCoreRenderHelper;
import net.katsstuff.teamnightclipse.danmakucore.danmaku.DanmakuState;
import net.katsstuff.teamnightclipse.danmakucore.danmaku.form.IRenderForm;
import net.katsstuff.teamnightclipse.danmakucore.danmaku.form.RenderingProperty;
import net.katsstuff.teamnightclipse.danmakucore.impl.form.FormGeneric;
import net.katsstuff.teamnightclipse.mirror.client.shaders.MirrorShaderProgram;
import net.katsstuff.teamnightclipse.mirror.data.Quat;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import scala.collection.immutable.Map;
import scala.collection.immutable.Map$;

public class DanmakuFormBase extends FormGeneric {
    public DanmakuFormBase(String name){
        super(name);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IRenderForm createRenderer() {
        return new IRenderForm() {

            @Override
            public void renderLegacy(DanmakuState danmaku, double x, double y, double z, Quat orientation,
                    float partialTicks, RenderManager manager) {
            }

            @Override
            public void renderShaders(DanmakuState danmaku, double x, double y, double z, Quat orientation,
                    float partialTicks, RenderManager manager, MirrorShaderProgram shaderProgram) {
            }

            @Override
            public Map<String, RenderingProperty> defaultAttributeValues() {
                return Map$.MODULE$.empty();
            }

            @Override
            public ResourceLocation shader(DanmakuState state) {
                return DanCoreRenderHelper.baseDanmakuShaderLoc();
            }

        };
    }

}

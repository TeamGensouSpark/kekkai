package io.github.teamgensouspark.kekkai.danmaku.form;

import java.util.HashMap;

import io.github.teamgensouspark.kekkai.utils.ScalaJ;
import net.katsstuff.teamnightclipse.danmakucore.client.helper.DanCoreRenderHelper;
import net.katsstuff.teamnightclipse.danmakucore.danmaku.DanmakuState;
import net.katsstuff.teamnightclipse.danmakucore.danmaku.form.IRenderForm;
import net.katsstuff.teamnightclipse.danmakucore.danmaku.form.RenderingProperty;
import net.katsstuff.teamnightclipse.danmakucore.data.ShotData;
import net.katsstuff.teamnightclipse.mirror.client.shaders.MirrorShaderProgram;
import net.katsstuff.teamnightclipse.mirror.data.Quat;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import scala.collection.immutable.Map;

@SideOnly(Side.CLIENT)
public abstract class BaseRenderForm implements IRenderForm {

    @Override
    public Map<String, RenderingProperty> defaultAttributeValues() {
        return ScalaJ.asScalaImtMap(new HashMap<String, RenderingProperty>());
    }

    /**
     * Do your rendering like normal in here. Note that the texture is already
     * applied, lighting is disabled, and the entity is translated to it's
     * position. You do not need to call glPushMatrix or glPopMatrix.
     */
    @Override
    public abstract void renderLegacy(DanmakuState danmaku, double x, double y, double z, Quat orientation,
            float partialTicks,
            RenderManager manager);

    /**
     * Do more fancy and performant rendering using shaders and other good stuff.
     */
    @Override
    public void renderShaders(DanmakuState danmaku, double x, double y, double z, Quat orientation, float partialTicks,
            RenderManager manager, MirrorShaderProgram shaderProgram) {
        ShotData shot = danmaku.shot();
        DanCoreRenderHelper.updateDanmakuShaderAttributes(shaderProgram, this, shot);
        renderLegacy(
                danmaku.copy(danmaku.entity(),
                        danmaku.extra().copy(danmaku.extra().user(), danmaku.extra().source(),
                                danmaku.extra().shot().copy(shot.form(), shot.renderProperties(),
                                        DanCoreRenderHelper.OverwriteColorEdge(),
                                        DanCoreRenderHelper.OverwriteColorCore(), shot.damage(),
                                        shot.getSizeX(), shot.getSizeY(), shot.getSizeZ(), shot.delay(), shot.end(),
                                        shot.subEntity(), shot.subEntityProperties()),
                                danmaku.extra().subEntity(), danmaku.extra().movement(), danmaku.extra().rotation()),
                        danmaku.tracking()),
                x, y, z, orientation, partialTicks,
                manager);
    }

    /**
     * The shader to use for renderShaders. The danmaku renderer will handle
     * beginning and ending the shader program.
     */
    @Override
    public ResourceLocation shader(DanmakuState danmaku) {
        return DanCoreRenderHelper.baseDanmakuShaderLoc();
    }

}

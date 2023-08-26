package io.github.teamgensouspark.kekkai.danmaku.form.impl;

import org.lwjgl.opengl.GL11;

import io.github.teamgensouspark.kekkai.Kekkai;
import net.katsstuff.teamnightclipse.danmakucore.client.helper.DanCoreRenderHelper;
import net.katsstuff.teamnightclipse.danmakucore.danmaku.DanmakuState;
import net.katsstuff.teamnightclipse.mirror.data.Quat;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;

public class Butterfly extends AbstractSphere {

    public Butterfly(String name) {
        super(name);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void afterRender(DanmakuState danmaku, double x, double y, double z, Quat orientation, float partialTicks,
            RenderManager manager) {
        System.out.println("do after legacy render");
        GlStateManager.pushMatrix();

        DanCoreRenderHelper.transformDanmaku(danmaku.shot(), orientation);

        Minecraft.getMinecraft().getTextureManager()
                .bindTexture(Kekkai.resource.getPNG("textures/danmaku/form/render_test"));
        Tessellator tes = Tessellator.getInstance();
        BufferBuilder bb = tes.getBuffer();

        float u1 = 0F;
        float u2 = 1F;
        float v1 = 0F;
        float v2 = 1F;
        double width = 1d;
        double length = 1d;

        GlStateManager.disableCull();
        GlStateManager.scale(3f, 3f, 3f);
        GlStateManager.rotate(orientation.toQuaternion());
        GlStateManager.enableLight(1);
        bb.begin(GL11.GL_QUADS, DefaultVertexFormats.POSITION_TEX);
        bb.pos(width, 0.0F, length).tex(u2, v1).endVertex();
        bb.pos(-width, 0.0F, length).tex(u1, v1).endVertex();
        bb.pos(-width, 0.0F, -length).tex(u1, v2).endVertex();
        bb.pos(width, 0.0F, -length).tex(u2, v2).endVertex();
        tes.draw();

        GlStateManager.enableCull();

        GlStateManager.popMatrix();

    }

}

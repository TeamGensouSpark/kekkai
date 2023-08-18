package io.github.teamgensouspark.kekkai.danmaku;

import net.katsstuff.teamnightclipse.danmakucore.danmaku.DanmakuTemplate;
import net.katsstuff.teamnightclipse.danmakucore.danmaku.DanmakuTemplate.Builder;
import net.minecraft.entity.EntityLivingBase;

public class DanmakuBuilder {
    public static Builder getBuilder() {
        return DanmakuTemplate.builder();
    }

    public static Builder getBuilderWithEntity(EntityLivingBase entity) {
        return getBuilder().setUser(entity).setWorld(entity.world);
    }

}

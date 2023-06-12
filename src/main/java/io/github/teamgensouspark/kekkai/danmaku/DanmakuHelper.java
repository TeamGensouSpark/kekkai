package io.github.teamgensouspark.kekkai.danmaku;

import net.katsstuff.teamnightclipse.danmakucore.danmaku.DanmakuTemplate;
import net.katsstuff.teamnightclipse.danmakucore.danmaku.DanmakuTemplate.Builder;
import net.minecraft.entity.EntityLivingBase;

public class DanmakuHelper {
    public static Builder get_builder() {
        return DanmakuTemplate.builder();
    }

    public static Builder get_builder_e(EntityLivingBase entity) {
        return DanmakuTemplate.builder().setUser(entity).setWorld(entity.world);
    }
    
}

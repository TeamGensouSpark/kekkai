package io.github.teamgensouspark.kekkai.danmaku.subentity.impl;

import io.github.teamgensouspark.kekkai.utils.KekkaiHelper;
import net.katsstuff.teamnightclipse.danmakucore.danmaku.DanmakuState;
import net.katsstuff.teamnightclipse.danmakucore.danmaku.DanmakuUpdate;
import net.katsstuff.teamnightclipse.danmakucore.impl.subentity.SubEntityDefault;
import net.katsstuff.teamnightclipse.mirror.data.Vector3;
import net.minecraft.entity.EntityLivingBase;

public class TrackingTargetSubEntity extends SubEntityDefault {
    @Override
    public DanmakuUpdate subEntityTick(DanmakuState danmakuState) {
        EntityLivingBase target;
        // BUG the server and client different performance here
        try {
            target = KekkaiHelper.getSpellcardEntity(danmakuState.shot()).target().get();
        } catch (Exception e) {
            return super.subEntityTick(danmakuState);
        }
        Vector3 newDirection;
        if (target != null) {
            newDirection = (Vector3) Vector3.directionToPos(danmakuState.pos(), new Vector3(target));
        } else {
            newDirection = danmakuState.direction();
        }
        return super.subEntityTick(
                danmakuState.copy(danmakuState.entity().setDirection(newDirection), danmakuState.extra(),
                        danmakuState.tracking()));
    }
}

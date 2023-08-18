package io.github.teamgensouspark.kekkai.danmaku.subentity.impl;

import io.github.teamgensouspark.kekkai.utils.KekkaiHelper;
import net.katsstuff.teamnightclipse.danmakucore.danmaku.DanmakuState;
import net.katsstuff.teamnightclipse.danmakucore.danmaku.DanmakuUpdate;
import net.katsstuff.teamnightclipse.danmakucore.impl.subentity.SubEntityDefault;
import net.katsstuff.teamnightclipse.mirror.data.Vector3;
import net.minecraft.entity.Entity;

public class TrackingTargetSubEntity extends SubEntityDefault {
    @Override
    public DanmakuUpdate subEntityTick(DanmakuState danmaku) {
        Vector3 newDirection = danmaku.direction();
        try {
            Entity entity = KekkaiHelper.getTargetWithDanmakuState(danmaku);
            if (entity != null) {
                if (entity.getDistance(danmaku.pos().x(), danmaku.pos().y(), danmaku.pos().z()) > 4) {
                    newDirection = (Vector3) Vector3.directionToPos(danmaku.pos(), new Vector3(entity));
                }
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return super.subEntityTick(
                danmaku.copy(danmaku.entity().setDirection(newDirection), danmaku.extra(), danmaku.tracking()));
    }
}

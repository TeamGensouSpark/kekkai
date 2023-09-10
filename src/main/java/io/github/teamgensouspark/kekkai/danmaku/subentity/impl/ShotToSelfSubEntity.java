package io.github.teamgensouspark.kekkai.danmaku.subentity.impl;

import net.katsstuff.teamnightclipse.danmakucore.danmaku.DanmakuState;
import net.katsstuff.teamnightclipse.danmakucore.impl.subentity.SubEntityDefault;
import net.katsstuff.teamnightclipse.mirror.data.Vector3;

public class ShotToSelfSubEntity extends SubEntityDefault {

    @Override
    public DanmakuState onCreate(DanmakuState danmaku) {
        return super.onCreate(danmaku).copy(
                danmaku.entity()
                        .setDirection(
                                (Vector3) Vector3.directionToPos(danmaku.pos(), new Vector3(danmaku.user().get()))),
                danmaku.extra(), danmaku.tracking());
    }

}

package io.github.teamgensouspark.kekkai.danmaku;

import net.katsstuff.teamnightclipse.danmakucore.danmaku.DanmakuEntityData;
import net.katsstuff.teamnightclipse.danmakucore.danmaku.TrackerData;
import net.katsstuff.teamnightclipse.danmakucore.danmaku.subentity.SubEntity;
import net.katsstuff.teamnightclipse.danmakucore.data.MovementData;
import net.katsstuff.teamnightclipse.danmakucore.data.RotationData;
import net.katsstuff.teamnightclipse.danmakucore.data.ShotData;
import net.katsstuff.teamnightclipse.mirror.data.Vector3;
import net.katsstuff.teamnightclipse.danmakucore.danmaku.DanmakuState;
import net.katsstuff.teamnightclipse.danmakucore.danmaku.ExtraDanmakuData;

public class DanmakuStateModifier {
    DanmakuState danmaku;

    DanmakuEntityData entityData;
    ExtraDanmakuData extra;
    TrackerData tracker;

    public DanmakuStateModifier(DanmakuState danmaku) {
        this.danmaku = danmaku;
        this.entityData = danmaku.entity();
        this.extra = danmaku.extra();
        this.tracker = danmaku.tracking();
    }

    public DanmakuEntityData getEntityData() {
        return entityData;
    }

    public ExtraDanmakuData getExtraData() {
        return extra;
    }

    public TrackerData getTrackerData() {
        return tracker;
    }

    public DanmakuStateModifier setDirection(Vector3 direction) {
        this.entityData.setDirection(direction);
        return this;
    }

    public DanmakuStateModifier setMovement(MovementData movement) {
        this.extra = this.extra.copy(extra.user(), extra.source(), extra.shot(), extra.subEntity(), movement,
                extra.rotation());
        return this;
    }

    public DanmakuStateModifier setShot(ShotData shot) {
        this.extra = this.extra.copy(extra.user(), extra.source(), shot, extra.subEntity(), extra.movement(),
                extra.rotation());
        return this;
    }

    public DanmakuStateModifier setRotation(RotationData rotation) {
        this.extra = this.extra.copy(extra.user(), extra.source(), extra.shot(), extra.subEntity(), extra.movement(),
                rotation);
        return this;
    }

    public DanmakuStateModifier setSubEntity(SubEntity entity) {
        this.extra = this.extra.copy(extra.user(), extra.source(), extra.shot(), entity, extra.movement(),
                extra.rotation());
        return this;
    }

    public DanmakuState getDanmaku() {
        return danmaku.copy(entityData, extra, tracker);
    }
}

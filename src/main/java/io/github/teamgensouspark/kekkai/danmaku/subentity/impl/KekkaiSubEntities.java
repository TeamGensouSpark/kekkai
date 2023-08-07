package io.github.teamgensouspark.kekkai.danmaku.subentity.impl;

import io.github.teamgensouspark.kekkai.danmaku.subentity.SubEntityBase;
import net.katsstuff.teamnightclipse.danmakucore.danmaku.subentity.SubEntityType;

public class KekkaiSubEntities {
    public static final SubEntityType TRACKING = new SubEntityBase<>("tracking_target", TrackingTargetSubEntity.class);
}

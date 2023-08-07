package io.github.teamgensouspark.kekkai.utils;

import io.github.teamgensouspark.kekkai.interfaces.IContainsTarget;
import net.katsstuff.teamnightclipse.danmakucore.data.AbstractShotData;
import net.katsstuff.teamnightclipse.danmakucore.data.ShotData;
import net.minecraft.entity.Entity;

public class KekkaiHelper {
    public static ShotData setTarget(ShotData shotData, Entity target) {
        IContainsTarget ict_shotData = (IContainsTarget) (AbstractShotData) shotData;
        return ict_shotData.setTarget(target);
    }

    public static Entity getTarget(ShotData shotData) {
        IContainsTarget ict_shotData = (IContainsTarget) (AbstractShotData) shotData;
        return ict_shotData.getTarget();
    }

    public static Boolean hasTarget(ShotData shotData) {
        IContainsTarget ict_shotData = (IContainsTarget) (AbstractShotData) shotData;
        return ict_shotData.hasTarget();
    }
}

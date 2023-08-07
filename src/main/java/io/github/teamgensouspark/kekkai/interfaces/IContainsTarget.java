package io.github.teamgensouspark.kekkai.interfaces;

import net.minecraft.entity.Entity;
import net.katsstuff.teamnightclipse.danmakucore.data.ShotData;


public interface IContainsTarget {
    public abstract Entity getTarget();
    public abstract ShotData setTarget(Entity target);
    public abstract Boolean hasTarget();
}

package io.github.teamgensouspark.kekkai.utils;

import net.katsstuff.teamnightclipse.mirror.data.AbstractVector3;
import net.katsstuff.teamnightclipse.mirror.data.Vector3;

public class Vector3Utils {
    public static Vector3 pos2pos(AbstractVector3 from, AbstractVector3 to) {
        return (Vector3) Vector3.directionToPos(from, to);
    }
}

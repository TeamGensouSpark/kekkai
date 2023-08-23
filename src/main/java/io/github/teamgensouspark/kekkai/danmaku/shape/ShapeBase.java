package io.github.teamgensouspark.kekkai.danmaku.shape;

import net.katsstuff.teamnightclipse.danmakucore.shape.Shape;
import net.katsstuff.teamnightclipse.danmakucore.shape.ShapeResult;
import net.katsstuff.teamnightclipse.mirror.data.Quat;
import net.katsstuff.teamnightclipse.mirror.data.Vector3;
import scala.collection.immutable.Set;

public class ShapeBase implements Shape{

    @Override
    public void doEffects(Vector3 arg0, Quat arg1, int arg2, ShapeResult arg3, Set<ShapeResult> arg4) {
        throw new UnsupportedOperationException("Unimplemented method 'doEffects'");
    }

    @Override
    public ShapeResult draw(Vector3 arg0, Quat arg1, int arg2) {
        throw new UnsupportedOperationException("Unimplemented method 'draw'");
    }
    
}

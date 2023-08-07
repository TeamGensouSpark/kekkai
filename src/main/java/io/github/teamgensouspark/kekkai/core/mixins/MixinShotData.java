package io.github.teamgensouspark.kekkai.core.mixins;

import java.util.HashMap;
import java.util.Map;

import org.spongepowered.asm.mixin.Mixin;

import io.github.teamgensouspark.kekkai.interfaces.IContainsObjectMap;
import io.github.teamgensouspark.kekkai.interfaces.IContainsTarget;
import net.katsstuff.teamnightclipse.danmakucore.data.ShotData;
import net.minecraft.entity.Entity;

@Mixin(value = ShotData.class, remap = false)
public abstract class MixinShotData implements IContainsTarget, IContainsObjectMap {
    private Entity target = null;
    private Map<String, Object> objMap = new HashMap<String, Object>();

    public Entity getTarget() {
        return target;
    }

    public ShotData setTarget(Entity target) {
        this.target = target;
        return (ShotData) (Object) this;
    }

    public Map<String, Object> getMap() {
        return objMap;
    };

    public void writeKeyIntoMap(String key, Object value) {
        objMap.put(key, value);
    };

    public Object getValueFromMap(String key) {
        return objMap.get(key);
    };

}

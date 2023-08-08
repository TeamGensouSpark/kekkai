package io.github.teamgensouspark.kekkai.core.mixins;

import java.util.HashMap;
import java.util.Map;

import org.spongepowered.asm.mixin.Mixin;

import io.github.teamgensouspark.kekkai.interfaces.IContainsObjectMap;
import io.github.teamgensouspark.kekkai.interfaces.IContainsSpellcardEntity;
import net.katsstuff.teamnightclipse.danmakucore.data.ShotData;
import net.katsstuff.teamnightclipse.danmakucore.entity.spellcard.SpellcardEntity;

@Mixin(value = ShotData.class, remap = false)
public abstract class MixinShotData implements IContainsSpellcardEntity, IContainsObjectMap {
    private SpellcardEntity spellcard = null;
    private Map<String, Object> objMap = new HashMap<String, Object>();

    public SpellcardEntity getSpellcardEntity() {
        return this.spellcard;
    };

    public ShotData setSpellcardEntity(SpellcardEntity spellcard) {
        this.spellcard = spellcard;
        return (ShotData) (Object) this;
    };

    public Boolean hasSpellcardEntity() {
        if (spellcard != null) {
            return true;
        }
        return false;
    };

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

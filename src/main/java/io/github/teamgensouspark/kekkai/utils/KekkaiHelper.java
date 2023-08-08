package io.github.teamgensouspark.kekkai.utils;

import io.github.teamgensouspark.kekkai.interfaces.IContainsSpellcardEntity;
import net.katsstuff.teamnightclipse.danmakucore.data.AbstractShotData;
import net.katsstuff.teamnightclipse.danmakucore.data.ShotData;
import net.katsstuff.teamnightclipse.danmakucore.entity.spellcard.SpellcardEntity;

public class KekkaiHelper {
    public static ShotData setSpellcardEntity(ShotData shotData, SpellcardEntity spellcard) {
        IContainsSpellcardEntity icse_shotData = (IContainsSpellcardEntity) (AbstractShotData) shotData;
        return icse_shotData.setSpellcardEntity(spellcard);
    }

    public static SpellcardEntity getSpellcardEntity(ShotData shotData) {
        IContainsSpellcardEntity icse_shotData = (IContainsSpellcardEntity) (AbstractShotData) shotData;
        return icse_shotData.getSpellcardEntity();
    }

    public static Boolean hasSpellcardEntity(ShotData shotData) {
        IContainsSpellcardEntity icse_shotData = (IContainsSpellcardEntity) (AbstractShotData) shotData;
        return icse_shotData.hasSpellcardEntity();
    }
}

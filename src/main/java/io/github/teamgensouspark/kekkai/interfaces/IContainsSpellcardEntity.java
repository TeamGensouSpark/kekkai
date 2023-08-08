package io.github.teamgensouspark.kekkai.interfaces;

import net.katsstuff.teamnightclipse.danmakucore.data.ShotData;
import net.katsstuff.teamnightclipse.danmakucore.entity.spellcard.SpellcardEntity;


public interface IContainsSpellcardEntity {
    public abstract SpellcardEntity getSpellcardEntity();
    public abstract ShotData setSpellcardEntity(SpellcardEntity spellcard);
    public abstract Boolean hasSpellcardEntity();
}

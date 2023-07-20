package io.github.teamgensouspark.kekkai.example;

import io.github.teamgensouspark.kekkai.spellcard.SpellCardBase;
import net.katsstuff.teamnightclipse.danmakucore.entity.living.TouhouCharacter;
import net.katsstuff.teamnightclipse.danmakucore.entity.spellcard.SpellcardEntity;


public class MySpellCardBase<T extends SpellcardEntity> extends SpellCardBase<T>{
    public MySpellCardBase(String name, Class<T> spellcard, TouhouCharacter character) {
        super(name, spellcard, character);

        MySpellCards.SPELL_CARDS.add(this);
    }
}

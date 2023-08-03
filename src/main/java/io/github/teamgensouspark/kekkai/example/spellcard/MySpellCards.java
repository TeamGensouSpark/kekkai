package io.github.teamgensouspark.kekkai.example.spellcard;

import java.util.ArrayList;
import java.util.List;

import io.github.teamgensouspark.kekkai.character.TouhouExCharacter;
import io.github.teamgensouspark.kekkai.spellcard.SpellCardBase;
import io.github.teamgensouspark.kekkai.utils.KekkaiRegister;
import net.katsstuff.teamnightclipse.danmakucore.entity.spellcard.Spellcard;

public class MySpellCards {
    public static void initSpellCard() {
    };

    public static final Spellcard EXAMPLE_CARD = KekkaiRegister.RegistSpellcard(new SpellCardBase<>("example_card",
            MySpellCardEntity.class,
            TouhouExCharacter.MEGUMU_IIZUNAMARU));

}

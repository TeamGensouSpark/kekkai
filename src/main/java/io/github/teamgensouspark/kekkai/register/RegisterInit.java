package io.github.teamgensouspark.kekkai.register;

import java.util.ArrayList;
import java.util.List;

import io.github.teamgensouspark.kekkai.example.MySpellCardEntity;
import io.github.teamgensouspark.kekkai.spellcard.SpellCardBase;
import net.katsstuff.teamnightclipse.danmakucore.entity.living.TouhouCharacter;
import net.katsstuff.teamnightclipse.danmakucore.entity.spellcard.Spellcard;
import net.minecraft.item.Item;

public class RegisterInit {
    public static final List<Spellcard> SPELL_CARDS = new ArrayList<>();
    public static final List<Item> ITEMS = new ArrayList<>();

    public static final Spellcard EXAMPLE_CARD = new SpellCardBase<>("example_card", MySpellCardEntity.class, TouhouCharacter.REIMU_HAKUREI);
}

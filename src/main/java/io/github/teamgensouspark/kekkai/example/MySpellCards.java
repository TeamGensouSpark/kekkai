package io.github.teamgensouspark.kekkai.example;

import io.github.teamgensouspark.kekkai.proxy.Const;
import net.katsstuff.teamnightclipse.danmakucore.entity.spellcard.Spellcard;
import net.katsstuff.teamnightclipse.danmakucore.entity.spellcard.SpellcardDummy;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;

@ObjectHolder(Const.MODID)
public class MySpellCards {
    @ObjectHolder("example_card")
    public static final Spellcard EXAMPLE_CARD = SpellcardDummy.instance();
}

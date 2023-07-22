package io.github.teamgensouspark.kekkai.example;

import java.util.ArrayList;
import java.util.List;

import io.github.teamgensouspark.kekkai.Consts;
import io.github.teamgensouspark.kekkai.character.TouhouExCharacter;
import net.katsstuff.teamnightclipse.danmakucore.entity.spellcard.Spellcard;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber(modid = Consts.MODID)
public class MySpellCards {
    public static void initSpellCard() {
    };

    public static final List<Spellcard> SPELL_CARDS = new ArrayList<>();

    public static final Spellcard EXAMPLE_CARD = new MySpellCardBase<>("example_card",
            MySpellCardEntity.class,
            TouhouExCharacter.MEGUMU_IIZUNAMARU);

    @SubscribeEvent
    public static void onSpellCardRegister(RegistryEvent.Register<Spellcard> event) {
        event.getRegistry().registerAll(SPELL_CARDS.toArray(new Spellcard[0]));
    }

}

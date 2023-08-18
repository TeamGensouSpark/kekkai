package io.github.teamgensouspark.kekkai.example.spellcard;

import io.github.teamgensouspark.kekkai.KekkaiModInfo;
import io.github.teamgensouspark.kekkai.character.TouhouExCharacter;
import io.github.teamgensouspark.kekkai.spellcard.SpellCardBase;
import net.katsstuff.teamnightclipse.danmakucore.entity.spellcard.Spellcard;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber(modid = KekkaiModInfo.MODID)
public class MySpellCards {
    public static void initSpellCard() {
    };

    public static final Spellcard EXAMPLE_CARD = new SpellCardBase<>("example_card",
            MySpellCardEntity.class,
            TouhouExCharacter.MEGUMU_IIZUNAMARU);

    @SubscribeEvent
    public static void onSpellcardRegister(RegistryEvent.Register<Spellcard> event) {
        event.getRegistry().registerAll(EXAMPLE_CARD);
    }

}

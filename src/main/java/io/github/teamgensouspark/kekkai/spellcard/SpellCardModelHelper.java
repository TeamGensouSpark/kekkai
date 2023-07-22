package io.github.teamgensouspark.kekkai.spellcard;

import java.util.ArrayList;
import java.util.List;

import io.github.teamgensouspark.kekkai.Consts;
import net.katsstuff.teamnightclipse.danmakucore.entity.spellcard.Spellcard;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber(modid = Consts.MODID)
public class SpellCardModelHelper {
    public static void initSpellCardBake() {
    };

    public static final List<Spellcard> BAKE_SPELLCARDS = new ArrayList<>();
    public static final Item SPELLCARD_HELPER = new Item().setTranslationKey("spellcard_helper")
            .setRegistryName(Consts.MODID, "spellcard_helper").setCreativeTab(null);

    @SubscribeEvent
    public static void onItemRegister(RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(
                SPELLCARD_HELPER);
    }

    @SubscribeEvent
    public static void onModelRegister(ModelRegistryEvent event) {
        for (Spellcard sp : BAKE_SPELLCARDS) {
            ModelLoader.setCustomModelResourceLocation(SPELLCARD_HELPER, 0, sp.itemModel());
        }
    }
}

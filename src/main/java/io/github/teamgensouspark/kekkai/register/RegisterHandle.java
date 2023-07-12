package io.github.teamgensouspark.kekkai.register;

import io.github.teamgensouspark.kekkai.interfaces.IHasModel;
import net.katsstuff.teamnightclipse.danmakucore.entity.spellcard.Spellcard;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber
public class RegisterHandle {

    public static void preInitRegistries(){}

    @SubscribeEvent
    public static void onItemRegister(RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(RegisterInit.ITEMS.toArray(new Item[0]));
    }
    @SubscribeEvent
    public static void onSpellCardRegister(RegistryEvent.Register<Spellcard> event){
        event.getRegistry().registerAll(RegisterInit.SPELL_CARDS.toArray(new Spellcard[0]));
    }

    @SubscribeEvent
    public static void onModelRegister(ModelRegistryEvent event) {
        for(Item item : RegisterInit.ITEMS){
            if(item instanceof IHasModel) {
                ((IHasModel)item).registerModels();
            }
        }
    }
}
package io.github.teamgensouspark.kekkai.annotation;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

import org.reflections.Reflections;

import io.github.teamgensouspark.kekkai.KekkaiModInfo;
import net.katsstuff.teamnightclipse.danmakucore.entity.living.TouhouCharacter;
import net.katsstuff.teamnightclipse.danmakucore.entity.spellcard.Spellcard;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber(modid = KekkaiModInfo.MODID)
public class ReflexBus {
    public static List<String> SPELLCARD_PACKAGES = new ArrayList<>();

    @SubscribeEvent
    public static void reg_spellcard(RegistryEvent.Register<Spellcard> event) {
        for (String packageName : SPELLCARD_PACKAGES) {
            Reflections ref = new Reflections(packageName);
            for (Class<?> clazz : ref.getTypesAnnotatedWith(SpellcardHandler.class)) {
                SpellcardHandler handler = clazz.getDeclaredAnnotation(SpellcardHandler.class);
                try {
                    Constructor<?> cons = handler.spellcard().getDeclaredConstructor(String.class, Class.class,
                            TouhouCharacter.class);
                    Spellcard card = (Spellcard) cons.newInstance(handler.name(), clazz,
                            TouhouCharacter.getByFullName(handler.characterFullName())
                                    .orElse(TouhouCharacter.REIMU_HAKUREI));
                    event.getRegistry().register(card);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

}

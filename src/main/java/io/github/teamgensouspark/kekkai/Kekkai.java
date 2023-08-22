package io.github.teamgensouspark.kekkai;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

import io.github.teamgensouspark.kekkai.config.KekkaiKeyBindings;
import io.github.teamgensouspark.kekkai.example.spellcard.MySpellCards;
import io.github.teamgensouspark.kekkai.spellcard.SpellCardModelHelper;
import io.github.teamgensouspark.kekkai.utils.ModResource;

@Mod(modid = KekkaiModInfo.MODID, name = KekkaiModInfo.NAME, version = KekkaiModInfo.VERSION, dependencies = "required-after:mirror@[0.4.0,);required-after:danmakucore")
public class Kekkai {
    public static Logger logger;

    public static ModResource resource = new ModResource(KekkaiModInfo.MODID);

    @EventHandler
    public static void PreInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
        SpellCardModelHelper.initSpellCardBake();
        MySpellCards.initSpellCard();
        KekkaiKeyBindings.initKeyBindings();
    }
}

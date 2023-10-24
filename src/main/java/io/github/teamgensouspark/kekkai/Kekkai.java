package io.github.teamgensouspark.kekkai;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

import io.github.teamgensouspark.kekkai.example.spellcard.MySpellCards;
import io.github.teamgensouspark.kekkai.proxy.CommonProxy;
import io.github.teamgensouspark.kekkai.spellcard.SpellCardModelHelper;
import io.github.teamgensouspark.kekkai.utils.ModCompat;
import io.github.teamgensouspark.kekkai.utils.ModResource;

@Mod(modid = KekkaiModInfo.MODID, name = KekkaiModInfo.NAME, version = KekkaiModInfo.VERSION, dependencies = "required-after:mirror@[0.4.0,);required-after:danmakucore")
public class Kekkai {
    public static Logger logger;

    public static ModResource resource = new ModResource(KekkaiModInfo.MODID);
    @SidedProxy(clientSide = KekkaiModInfo.CLIENT_PROXY, serverSide = KekkaiModInfo.COMMON_PROXY)
    public static CommonProxy proxy;

    @EventHandler
    public static void PreInit(FMLPreInitializationEvent event) {

        logger = event.getModLog();
        new ModCompat("mixinbooter")
                .ifNotLoadedThen(() -> logger.warn(
                        "Install MixinBooter to enable patch danmakucore! -> https://modrinth.com/mod/mixinbooter"));
        SpellCardModelHelper.initSpellCardBake();
        MySpellCards.initSpellCard();
        proxy.init();
    }
}

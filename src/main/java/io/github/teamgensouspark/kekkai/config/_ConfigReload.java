package io.github.teamgensouspark.kekkai.config;

import io.github.teamgensouspark.kekkai.KekkaiModInfo;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber(modid = KekkaiModInfo.MODID)
public class _ConfigReload {
    @SubscribeEvent
    public static void reloadConfig(ConfigChangedEvent event) {
        if (event.getModID().equals(KekkaiModInfo.MODID)) {
            ConfigManager.sync(KekkaiModInfo.MODID, Config.Type.INSTANCE);
        }
    }

}

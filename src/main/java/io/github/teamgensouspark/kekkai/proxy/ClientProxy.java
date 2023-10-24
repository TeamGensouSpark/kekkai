package io.github.teamgensouspark.kekkai.proxy;

import org.lwjgl.input.Keyboard;

import io.github.teamgensouspark.kekkai.KekkaiModInfo;
import io.github.teamgensouspark.kekkai.config.KekkaiConfig;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.client.settings.KeyConflictContext;
import net.minecraftforge.client.settings.KeyModifier;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent.KeyInputEvent;

public class ClientProxy extends CommonProxy {
    public static final KeyBinding HIDE_HUD = new KeyBinding("key.kekkai.hidehud", KeyConflictContext.IN_GAME,
            KeyModifier.CONTROL, Keyboard.KEY_P, "key.category.kekkai");

    @Override
    public void init() {
        ClientRegistry.registerKeyBinding(HIDE_HUD);
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onKeyPressed(KeyInputEvent event) {
        if (HIDE_HUD.isPressed()) {
            KekkaiConfig.showDanData = !KekkaiConfig.showDanData;
            ConfigManager.sync(KekkaiModInfo.MODID, Config.Type.INSTANCE);
        }
    }
}

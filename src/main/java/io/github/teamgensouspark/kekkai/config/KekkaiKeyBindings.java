package io.github.teamgensouspark.kekkai.config;

import org.lwjgl.input.Keyboard;

import io.github.teamgensouspark.kekkai.Kekkai;
import io.github.teamgensouspark.kekkai.KekkaiModInfo;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.client.settings.KeyConflictContext;
import net.minecraftforge.client.settings.KeyModifier;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent.KeyInputEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@EventBusSubscriber(modid = KekkaiModInfo.MODID)
public class KekkaiKeyBindings {
    public static final KeyBinding HIDE_HUD = new KeyBinding("key.kekkai.hidehud", KeyConflictContext.IN_GAME,
            KeyModifier.CONTROL, Keyboard.KEY_P, "key.category.kekkai");

    public static void initKeyBindings() {
        ClientRegistry.registerKeyBinding(HIDE_HUD);
    }

    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public static void onKeyPressed(KeyInputEvent event) {
        if (HIDE_HUD.isPressed()) {
            KekkaiConfig.showDanData = !KekkaiConfig.showDanData;
            ConfigManager.sync(KekkaiModInfo.MODID, Config.Type.INSTANCE);
        }
    }
}

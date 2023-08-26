package io.github.teamgensouspark.kekkai.danmaku.form.impl;

import io.github.teamgensouspark.kekkai.KekkaiModInfo;
import net.katsstuff.teamnightclipse.danmakucore.danmaku.form.Form;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber(modid = KekkaiModInfo.MODID)
public class KekkaiForms {
    public static final Form FORM_BUTTERFLY = new Butterfly("form_butterfly");

    @SubscribeEvent
    public static void onSubEntityRegister(RegistryEvent.Register<Form> event) {
        event.getRegistry().registerAll(FORM_BUTTERFLY);
    }
}

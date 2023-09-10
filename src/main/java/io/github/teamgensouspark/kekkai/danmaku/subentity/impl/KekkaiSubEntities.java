package io.github.teamgensouspark.kekkai.danmaku.subentity.impl;

import io.github.teamgensouspark.kekkai.KekkaiModInfo;
import io.github.teamgensouspark.kekkai.danmaku.subentity.SubEntityBase;
import net.katsstuff.teamnightclipse.danmakucore.danmaku.subentity.SubEntityType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber(modid = KekkaiModInfo.MODID)
public class KekkaiSubEntities {
    public static final SubEntityType TRACKING = new SubEntityBase<TrackingTargetSubEntity>("tracking_target",
            TrackingTargetSubEntity.class);
    public static final SubEntityType TOSELF = new SubEntityBase<ShotToSelfSubEntity>("shot_to_self",
            ShotToSelfSubEntity.class);

    @SubscribeEvent
    public static void onSubEntityRegister(RegistryEvent.Register<SubEntityType> event) {
        event.getRegistry().registerAll(TRACKING, TOSELF);
    }
}

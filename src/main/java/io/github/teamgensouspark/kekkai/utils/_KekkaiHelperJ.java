package io.github.teamgensouspark.kekkai.utils;

import java.util.function.Consumer;

import net.katsstuff.teamnightclipse.danmakucore.capability.dancoredata.IDanmakuCoreData;
import net.katsstuff.teamnightclipse.danmakucore.javastuff.TouhouHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/*
 * DO NOT USE THIS CLASS DIRECTLY.
 * The {@link KekkaiHelper} will extends this.
 */
public abstract class _KekkaiHelperJ {
    @SideOnly(Side.SERVER)
    public static void changeAndSyncEntityData(Consumer<IDanmakuCoreData> operator, Entity target, Double radius) {
        TouhouHelper.changeAndSyncEntityData(operator, target, radius);
    }

    @SideOnly(Side.SERVER)
    public static void changeAndSyncPlayerData(Consumer<IDanmakuCoreData> operator, EntityPlayer target) {
        TouhouHelper.changeAndSyncPlayerData(operator, target);
    }
}

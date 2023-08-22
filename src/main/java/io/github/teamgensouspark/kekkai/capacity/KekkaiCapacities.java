package io.github.teamgensouspark.kekkai.capacity;

import java.util.function.Consumer;

import javax.annotation.Nullable;

import io.github.teamgensouspark.kekkai.enums.EnumTouhouCapacity;
import net.katsstuff.teamnightclipse.danmakucore.capability.dancoredata.IDanmakuCoreData;
import net.katsstuff.teamnightclipse.danmakucore.javastuff.TouhouHelper;
import net.minecraft.entity.player.EntityPlayer;

public class KekkaiCapacities {
    EntityPlayer player;

    public KekkaiCapacities(EntityPlayer player) {
        this.player = player;
    }

    public IDanmakuCoreData getDanmakuCoreData() {
        return TouhouHelper.getDanmakuCoreData(player).orElseGet(null);
    }

    public KekkaiCapacities getSyncPlayer(Consumer<IDanmakuCoreData> consumer) {
        TouhouHelper.changeAndSyncPlayerData(consumer, player);
        return this;
    }

    public Boolean hasDanmakuCoreData() {
        return getDanmakuCoreData() == null;
    }

    public KekkaiCapacities shrink(EnumTouhouCapacity capacity, @Nullable Integer amount) {
        if (amount == null) {
            amount = 1;
        }
        return add(capacity, -amount);
    }

    public KekkaiCapacities shrink(EnumTouhouCapacity capacity) {
        return add(capacity, -1);
    }

    public KekkaiCapacities add(EnumTouhouCapacity capacity, @Nullable Number amount) {
        if (amount == null) {
            amount = 1;
        }
        final Number _amount = amount;
        switch (capacity) {
            case POWER:
                getSyncPlayer(data -> data.addPower(_amount.floatValue()));
                break;
            case BOMB:
                getSyncPlayer(data -> data.addBombs(_amount.intValue()));
                break;
            case LIFE:
                getSyncPlayer(data -> data.addLives(_amount.intValue()));
                break;
            case SCORE:
                getSyncPlayer(data -> data.addScore(_amount.intValue()));
                break;
            default:
                getSyncPlayer(data -> data.addPower(_amount.floatValue()));
                break;
        }
        return this;
    }

    public KekkaiCapacities add(EnumTouhouCapacity capacity) {
        return add(capacity, 1);
    }

    public Number getCapacity(EnumTouhouCapacity capacity) {
        switch (capacity) {
            case POWER:
                return getDanmakuCoreData().power();
            case BOMB:
                return getDanmakuCoreData().bombs();
            case LIFE:
                return getDanmakuCoreData().lives();
            case SCORE:
                return getDanmakuCoreData().score();
            default:
                return getDanmakuCoreData().power();
        }
    }
}

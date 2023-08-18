package io.github.teamgensouspark.kekkai.utils;

import javax.annotation.Nullable;

import io.github.teamgensouspark.kekkai.Kekkai;
import net.katsstuff.teamnightclipse.danmakucore.danmaku.DanmakuState;
import net.katsstuff.teamnightclipse.danmakucore.danmaku.DanmakuTemplate.Builder;
import net.katsstuff.teamnightclipse.danmakucore.entity.spellcard.SpellcardEntity;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;

public class KekkaiHelper {
    public static @Nullable Entity getTargetWithDanmakuState(DanmakuState danmaku) {
        if (danmaku.user().nonEmpty()) {
            NBTTagCompound nbt = danmaku.user().get().getEntityData();
            if (nbt.hasKey(KekkaiNBTKeys.DANMKU_TARGET)) {
                return danmaku.world()
                        .getEntityByID(danmaku.user().get().getEntityData().getInteger(KekkaiNBTKeys.DANMKU_TARGET));
            } else {
                Kekkai.logger.error("No Such target preset in user?");
            }
        }
        return null;
    }

    public static Builder applyTargetWithSpellcard(Builder builder, SpellcardEntity spellcard) {
        NBTTagCompound nbt = builder.user().getEntityData();
        if (spellcard.target().nonEmpty()) {
            nbt.setInteger(KekkaiNBTKeys.DANMKU_TARGET, spellcard.target().get().getEntityId());
        } else {
            Kekkai.logger.error("No Such target preset in spellcardEntity ?");
        }
        return builder;
    }

}

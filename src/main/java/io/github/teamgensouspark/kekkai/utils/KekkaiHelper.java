package io.github.teamgensouspark.kekkai.utils;

import javax.annotation.Nullable;

import io.github.teamgensouspark.kekkai.Kekkai;
import io.github.teamgensouspark.kekkai.enums.EnumTouhouCapacity;
import io.github.teamgensouspark.kekkai.enums.EnumTouhouScore;
import net.katsstuff.teamnightclipse.danmakucore.danmaku.DanmakuState;
import net.katsstuff.teamnightclipse.danmakucore.danmaku.DanmakuTemplate.Builder;
import net.katsstuff.teamnightclipse.danmakucore.entity.EntityFallingData;
import net.katsstuff.teamnightclipse.danmakucore.entity.spellcard.SpellcardEntity;
import net.katsstuff.teamnightclipse.danmakucore.scalastuff.TouhouHelper;
import net.katsstuff.teamnightclipse.mirror.data.Vector3;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import scala.Option;

public class KekkaiHelper extends _KekkaiHelperJ {
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

    public static EntityFallingData getTouhouCapacityEntity(World world, Vector3 pos, Vector3 direction,
            @Nullable EnumTouhouCapacity type) {
        if (type == null) {
            type = EnumTouhouCapacity.POWER;
        }
        EntityFallingData entity;
        switch (type) {
            case BIGPOWER:
                entity = TouhouHelper.createBigPower(world, pos, direction);
                break;
            case LIFE:
                entity = TouhouHelper.createLife(world, pos, direction);
                break;
            case BOMB:
                entity = TouhouHelper.createBomb(world, pos, direction);
                break;
            default:
                entity = TouhouHelper.createPower(world, pos, direction);
                break;
        }
        return entity;
    }

    public static void spawnTouhouCapacity(World world, Vector3 pos, Vector3 direction,
            @Nullable EnumTouhouCapacity type) {
        if (!world.isRemote) {
            world.spawnEntity(getTouhouCapacityEntity(world, pos, direction, type));
        }
    }

    public static EntityFallingData getTouhouScoreEntity(World world, Option<Entity> target, Vector3 pos,
            Vector3 direction,
            @Nullable EnumTouhouScore type) {
        if (type == null) {
            type = EnumTouhouScore.BLUE;
        }
        EntityFallingData entity;
        switch (type) {
            case BLUE:
                entity = TouhouHelper.createScoreBlue(world, target, pos, direction);
                break;
            case GREEN:
                entity = TouhouHelper.createScoreGreen(world, target, pos, direction);
                break;
            default:
                entity = TouhouHelper.createScoreBlue(world, target, pos, direction);
                break;
        }
        return entity;
    }

    public static void spawnTouhouScore(World world, Option<Entity> target, Vector3 pos,
            Vector3 direction,
            @Nullable EnumTouhouScore type) {
        if (!world.isRemote) {
            world.spawnEntity(getTouhouScoreEntity(world, target, pos, direction, type));
        }
    }
}

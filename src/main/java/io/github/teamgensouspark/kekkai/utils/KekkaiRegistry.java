package io.github.teamgensouspark.kekkai.utils;

import javax.annotation.Nullable;

import io.github.teamgensouspark.kekkai.KekkaiModInfo;
import net.katsstuff.teamnightclipse.danmakucore.danmaku.DanmakuVariant;
import net.katsstuff.teamnightclipse.danmakucore.danmaku.form.Form;
import net.katsstuff.teamnightclipse.danmakucore.danmaku.subentity.SubEntityType;
import net.katsstuff.teamnightclipse.danmakucore.entity.living.phase.PhaseType;
import net.katsstuff.teamnightclipse.danmakucore.entity.spellcard.Spellcard;
import net.katsstuff.teamnightclipse.danmakucore.registry.DanmakuRegistry;
import net.katsstuff.teamnightclipse.danmakucore.registry.RegistryValue;
import net.minecraftforge.registries.IForgeRegistry;

public class KekkaiRegistry {
    public static IForgeRegistry<Spellcard> REG_SPELLCARDS;
    public static IForgeRegistry<SubEntityType> REG_SUBENTITYTYPE;
    public static IForgeRegistry<Form> REG_FORMS;
    public static IForgeRegistry<DanmakuVariant> REG_DANMAKUVARIANT;
    public static IForgeRegistry<PhaseType> REG_PHASE;

    static {
        REG_SPELLCARDS = DanmakuRegistry.Spellcard();
        REG_SUBENTITYTYPE = DanmakuRegistry.SubEntity();
        REG_FORMS = DanmakuRegistry.Form();
        REG_DANMAKUVARIANT = DanmakuRegistry.DanmakuVariant();
        REG_PHASE = DanmakuRegistry.Phase();
    }

    public static <T extends RegistryValue<T>> T getRandomObject(Class<T> clazz) {
        return DanmakuRegistry.getRandomObject(clazz, KekkaiModInfo.RND);
    }

    @Nullable
    public static <T extends RegistryValue<T>> T getObjById(Class<T> clazz, int id) {
        return DanmakuRegistry.getObjById(clazz, id);
    }

    public static <T extends RegistryValue<T>> int getId(Class<T> clazz, T obj) {
        return DanmakuRegistry.getId(clazz, obj);
    }
}

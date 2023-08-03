package io.github.teamgensouspark.kekkai.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import io.github.teamgensouspark.kekkai.Consts;
import net.katsstuff.teamnightclipse.danmakucore.danmaku.form.Form;
import net.katsstuff.teamnightclipse.danmakucore.danmaku.subentity.SubEntityType;
import net.katsstuff.teamnightclipse.danmakucore.entity.spellcard.Spellcard;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber(modid = Consts.MODID)
public class KekkaiRegister {
    public static void initKekkaiRegister() {
    };

    public static final List<Spellcard> KEKKAI_SPELLCARDS = new ArrayList<>();
    public static final List<SubEntityType> KEKKAI_SUBENTITYTYPES = new ArrayList<>();
    public static final List<Form> KEKKAI_FORMS = new ArrayList<>();

    public static Spellcard RegistSpellcard(Spellcard spellcard) {
        KEKKAI_SPELLCARDS.add(spellcard);
        return spellcard;
    }

    public static Form RegistForm(Form form) {
        KEKKAI_FORMS.add(form);
        return form;
    }

    public static SubEntityType RegistSubEntityType(SubEntityType subentity) {
        KEKKAI_SUBENTITYTYPES.add(subentity);
        return subentity;
    }

    public static SubEntityType[] RegistSubEntityTypeAll(SubEntityType[] subentities) {
        KEKKAI_SUBENTITYTYPES.addAll(Arrays.asList(subentities));
        return subentities;
    }

    public static Form[] RegistFormAll(Form[] forms) {
        KEKKAI_FORMS.addAll(Arrays.asList(forms));
        return forms;
    }

    public static Spellcard[] RegistSpellcardAll(Spellcard[] spellcards) {
        KEKKAI_SPELLCARDS.addAll(Arrays.asList(spellcards));
        return spellcards;
    }

    @SubscribeEvent
    public static void onSpellcardRegister(RegistryEvent.Register<Spellcard> event) {
        event.getRegistry().registerAll(KEKKAI_SPELLCARDS.toArray(new Spellcard[0]));
    }

    @SubscribeEvent
    public static void onFormRegister(RegistryEvent.Register<Form> event) {
        event.getRegistry().registerAll(KEKKAI_FORMS.toArray(new Form[0]));
    }

    @SubscribeEvent
    public static void onSubEntityRegister(RegistryEvent.Register<SubEntityType> event) {
        event.getRegistry().registerAll(KEKKAI_SUBENTITYTYPES.toArray(new SubEntityType[0]));
    }

}

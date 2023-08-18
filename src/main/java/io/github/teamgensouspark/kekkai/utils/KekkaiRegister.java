package io.github.teamgensouspark.kekkai.utils;

import net.katsstuff.teamnightclipse.danmakucore.danmaku.form.Form;
import net.katsstuff.teamnightclipse.danmakucore.danmaku.subentity.SubEntityType;
import net.katsstuff.teamnightclipse.danmakucore.entity.spellcard.Spellcard;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.IForgeRegistry;

public class KekkaiRegister {
    public static IForgeRegistry<Spellcard> REG_SPELLCARDS;
    public static IForgeRegistry<SubEntityType> REG_SUBENTITYTYPE;
    public static IForgeRegistry<Form> REG_FORMS;

    static {
        REG_SPELLCARDS = GameRegistry.findRegistry(Spellcard.class);
        REG_SUBENTITYTYPE = GameRegistry.findRegistry(SubEntityType.class);
        REG_FORMS = GameRegistry.findRegistry(Form.class);
    }

}

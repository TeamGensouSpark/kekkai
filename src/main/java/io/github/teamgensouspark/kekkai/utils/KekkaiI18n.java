package io.github.teamgensouspark.kekkai.utils;

import net.katsstuff.teamnightclipse.danmakucore.entity.living.TouhouCharacter;
import net.minecraft.client.resources.I18n;

public class KekkaiI18n {
    public static String getTouhouCharName(TouhouCharacter character) {
        if (!I18n.hasKey(String.format("touhouCharacter.name.%s", character.getFullName()))) {
            return character.getShortName().concat(" (Need Translation)");
        }
        return I18n.format(String.format("touhouCharacter.name.%s", character.getFullName()));
    }
}

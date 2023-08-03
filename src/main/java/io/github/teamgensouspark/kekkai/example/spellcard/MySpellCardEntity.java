package io.github.teamgensouspark.kekkai.example.spellcard;

import io.github.teamgensouspark.kekkai.color.AtomColors;
import io.github.teamgensouspark.kekkai.danmaku.DanmakuBuilder;
import net.katsstuff.teamnightclipse.danmakucore.entity.spellcard.EntitySpellcard;
import net.katsstuff.teamnightclipse.danmakucore.entity.spellcard.Spellcard;
import net.katsstuff.teamnightclipse.danmakucore.entity.spellcard.SpellcardEntity;
import net.katsstuff.teamnightclipse.danmakucore.javastuff.DanmakuCreationHelper;
import net.katsstuff.teamnightclipse.danmakucore.lib.LibColor;
import net.katsstuff.teamnightclipse.danmakucore.lib.data.LibShotData;
import net.katsstuff.teamnightclipse.mirror.data.Quat;
import net.minecraft.entity.EntityLivingBase;
import scala.Option;

public class MySpellCardEntity extends SpellcardEntity {

    public MySpellCardEntity(Spellcard spellcard, EntitySpellcard cardEntity, Option<EntityLivingBase> target) {
        super(spellcard, cardEntity, target);
    }

    @Override
    public void onSpellcardUpdate() {
        if (time() % 5 == 0) {
            DanmakuCreationHelper.createWideShot(
                    Quat.orientationOf(this.user()),
                    DanmakuBuilder.getBuilderWithEntity(this.user())
                            .setShot(LibShotData.SHOT_MEDIUM.setMainColor(AtomColors.ATOM_COLOR_GREEN))
                            .build(),
                    1,
                    2,
                    0,
                    1F);
        }
    }

}

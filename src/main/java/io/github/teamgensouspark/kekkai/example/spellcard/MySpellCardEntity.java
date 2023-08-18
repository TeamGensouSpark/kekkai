package io.github.teamgensouspark.kekkai.example.spellcard;

import io.github.teamgensouspark.kekkai.color.AtomColors;
import io.github.teamgensouspark.kekkai.danmaku.DanmakuBuilder;
import io.github.teamgensouspark.kekkai.danmaku.subentity.impl.KekkaiSubEntities;
import io.github.teamgensouspark.kekkai.utils.KekkaiHelper;
import net.katsstuff.teamnightclipse.danmakucore.entity.spellcard.EntitySpellcard;
import net.katsstuff.teamnightclipse.danmakucore.entity.spellcard.Spellcard;
import net.katsstuff.teamnightclipse.danmakucore.entity.spellcard.SpellcardEntity;
import net.katsstuff.teamnightclipse.danmakucore.scalastuff.DanmakuCreationHelper;
import net.katsstuff.teamnightclipse.danmakucore.lib.data.LibShotData;
import net.minecraft.entity.EntityLivingBase;
import scala.Option;

public class MySpellCardEntity extends SpellcardEntity {

    public MySpellCardEntity(Spellcard spellcard, EntitySpellcard cardEntity, Option<EntityLivingBase> target) {
        super(spellcard, cardEntity, target);
    }

    @Override
    public void onSpellcardUpdate() {
        if (time() % 5 == 0) {
            DanmakuCreationHelper.createRingShot(
                    KekkaiHelper.applyTargetWithSpellcard(DanmakuBuilder.getBuilderWithEntity(this.user())
                            .setShot(LibShotData.SHOT_MEDIUM
                                    .setMainColor(AtomColors.ATOM_COLORS_HELPER.randomColor())
                                    .setSubEntity(KekkaiSubEntities.TRACKING)),
                            this)
                            .build(),
                    3,
                    0,
                    0,
                    0d);
        }
    }

}

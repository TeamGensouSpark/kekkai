package io.github.teamgensouspark.kekkai.example;


import io.github.teamgensouspark.kekkai.danmaku.DanmakuHelper;
import net.katsstuff.teamnightclipse.danmakucore.danmaku.DanmakuTemplate;
import net.katsstuff.teamnightclipse.danmakucore.entity.spellcard.EntitySpellcard;
import net.katsstuff.teamnightclipse.danmakucore.entity.spellcard.Spellcard;
import net.katsstuff.teamnightclipse.danmakucore.entity.spellcard.SpellcardEntity;
import net.katsstuff.teamnightclipse.danmakucore.javastuff.DanmakuCreationHelper;
import net.katsstuff.teamnightclipse.danmakucore.lib.data.LibShotData;
import net.katsstuff.teamnightclipse.mirror.data.Quat;
import net.minecraft.entity.EntityLivingBase;
import scala.Option;

public class MySpellCardEntity extends SpellcardEntity{

    public MySpellCardEntity(Spellcard spellcard, EntitySpellcard cardEntity, Option<EntityLivingBase> target) {
        super(spellcard, cardEntity, target);
    }

    @Override
    public void onSpellcardUpdate() {
        DanmakuCreationHelper.createWideShot(
            Quat.orientationOf(this.user()),
            DanmakuHelper.get_builder_e(this.user())
            .setShot(LibShotData.SHOT_CIRCLE.setSize(1.5F))
            .build(),
            2,
            15,
            0,
            1F);
        return;
    }

}

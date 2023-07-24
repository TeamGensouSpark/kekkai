package io.github.teamgensouspark.kekkai.spellcard;

import java.lang.reflect.Constructor;

import io.github.teamgensouspark.kekkai.Kekkai;
import net.katsstuff.teamnightclipse.danmakucore.entity.living.TouhouCharacter;
import net.katsstuff.teamnightclipse.danmakucore.entity.spellcard.EntitySpellcard;
import net.katsstuff.teamnightclipse.danmakucore.entity.spellcard.Spellcard;
import net.katsstuff.teamnightclipse.danmakucore.entity.spellcard.SpellcardEntity;
import net.minecraft.entity.EntityLivingBase;
import scala.Option;

public class SpellCardBase<T extends SpellcardEntity> extends Spellcard{
    int level = 1;
    int removeTime = 50;
    int endTime = 50;
    String name;
    TouhouCharacter character;
    Class<T> spellcard;
    public SpellCardBase (String name,Class<T> spellcard,TouhouCharacter character){
        super(name);
        this.name=name;
        this.character=character;
        this.spellcard=spellcard;
        SpellCardModelHelper.BAKE_SPELLCARDS.add(this);
    }
    
    @Override
    public SpellcardEntity instantiate(EntitySpellcard entitySpellcard, Option<EntityLivingBase> target) {
        try {
            Constructor<T> constructor = this.spellcard.getDeclaredConstructor(Spellcard.class,EntitySpellcard.class,Option.class);
            constructor.setAccessible(true);
            return constructor.newInstance(this,entitySpellcard,target);
        } catch (Exception e) {
            Kekkai.logger.error("Reflect Failed");
            return new SpellcardEntity(this,entitySpellcard,target) {
                @Override
                public void onSpellcardUpdate() {}
            };
        }
    }

    @Override
    public int level() {
        return this.level;
    }

    public Spellcard setlevel(int level){
        this.level=level;
        return this;
    }

    @Override
    public int removeTime() {
        return this.removeTime;
    }

    public Spellcard setremoveTime(int removeTime){
        this.removeTime=removeTime;
        return this;
    }

    @Override
    public int endTime() {
        return this.endTime;
    }

    public Spellcard setendTime(int endTime){
        this.endTime=endTime;
        return this;
    }

    @Override
    public TouhouCharacter touhouUser() {
        return this.character;
    }

    public Spellcard setTouhouUser(TouhouCharacter character){
        this.character= character;
        return this;
    }
}

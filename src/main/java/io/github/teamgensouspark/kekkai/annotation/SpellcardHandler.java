package io.github.teamgensouspark.kekkai.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import io.github.teamgensouspark.kekkai.spellcard.SpellCardBase;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface SpellcardHandler {
    Class<?> spellcard() default SpellCardBase.class;

    String characterFullName() default "REIMU_HAKUREI";

    String name();
}

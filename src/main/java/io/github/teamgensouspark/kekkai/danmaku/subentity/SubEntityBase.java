package io.github.teamgensouspark.kekkai.danmaku.subentity;

import java.lang.reflect.Constructor;

import io.github.teamgensouspark.kekkai.Kekkai;
import net.katsstuff.teamnightclipse.danmakucore.danmaku.DanmakuState;
import net.katsstuff.teamnightclipse.danmakucore.danmaku.DanmakuUpdate;
import net.katsstuff.teamnightclipse.danmakucore.danmaku.subentity.SubEntity;
import net.katsstuff.teamnightclipse.danmakucore.danmaku.subentity.SubEntityType;

public class SubEntityBase<T extends SubEntity> extends SubEntityType {
    Class<T> subentity;

    public SubEntityBase(String name, Class<T> subentity) {
        super(name);
        this.subentity = subentity;
    }

    @Override
    public SubEntity instantiate() {
        try {
            Constructor<T> constructor = this.subentity.getDeclaredConstructor();
            constructor.setAccessible(true);
            return constructor.newInstance();
        } catch (Exception e) {
            Kekkai.logger.error("Reflect Failed");
            return new SubEntity() {
                @Override
                public DanmakuUpdate subEntityTick(DanmakuState state) {
                    return state.update();
                }
            };
        }
    }

}

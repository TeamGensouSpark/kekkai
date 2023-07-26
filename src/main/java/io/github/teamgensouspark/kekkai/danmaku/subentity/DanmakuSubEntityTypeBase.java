package io.github.teamgensouspark.kekkai.danmaku.subentity;

import net.katsstuff.teamnightclipse.danmakucore.danmaku.subentity.SubEntity;
import net.katsstuff.teamnightclipse.danmakucore.danmaku.subentity.SubEntityType;

public class DanmakuSubEntityTypeBase extends SubEntityType{

    @Override
    public SubEntity instantiate() {
        return new DanmakuSubEntityBase();
    }
    
}

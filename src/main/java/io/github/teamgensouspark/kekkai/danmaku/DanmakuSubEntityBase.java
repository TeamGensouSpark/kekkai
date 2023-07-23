package io.github.teamgensouspark.kekkai.danmaku;

import net.katsstuff.teamnightclipse.danmakucore.danmaku.DanmakuState;
import net.katsstuff.teamnightclipse.danmakucore.danmaku.DanmakuUpdate;
import net.katsstuff.teamnightclipse.danmakucore.impl.subentity.SubEntityDefault;

public class DanmakuSubEntityBase extends SubEntityDefault{
    @Override
    public DanmakuUpdate subEntityTick(DanmakuState state) {
        return state.update();
    }

    
}

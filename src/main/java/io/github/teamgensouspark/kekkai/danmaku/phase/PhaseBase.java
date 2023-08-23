package io.github.teamgensouspark.kekkai.danmaku.phase;

import net.katsstuff.teamnightclipse.danmakucore.entity.living.phase.Phase;
import net.katsstuff.teamnightclipse.danmakucore.entity.living.phase.PhaseManager;
import net.katsstuff.teamnightclipse.danmakucore.entity.living.phase.PhaseType;

public class PhaseBase extends PhaseType {

    @Override
    public Phase instantiate(PhaseManager pm) {
        return pm.currentPhase();
    }

}

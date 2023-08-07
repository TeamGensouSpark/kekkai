package io.github.teamgensouspark.kekkai.core;

import java.util.Collections;
import java.util.List;

import zone.rong.mixinbooter.ILateMixinLoader;

public class LateMixinInit implements ILateMixinLoader {
    @Override
    public List<String> getMixinConfigs() {
        return Collections.singletonList("mixins.kekkai.dancore.json");
    }

}

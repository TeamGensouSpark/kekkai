package io.github.teamgensouspark.kekkai.core;

import java.util.List;

import java.util.Collections;
import zone.rong.mixinbooter.ILateMixinLoader;

public class LateMixinInit implements ILateMixinLoader{
    @Override
    public List<String> getMixinConfigs() {
        return Collections.singletonList("mixins.kekkai.dancore.json");
    }
    
}

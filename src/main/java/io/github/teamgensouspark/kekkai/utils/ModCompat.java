package io.github.teamgensouspark.kekkai.utils;

import net.minecraftforge.fml.common.Loader;

public class ModCompat {
    public ModResource resource;
    private String modid;

    public ModCompat(String modid) {
        resource = new ModResource(modid);
        this.modid = modid;
    }

    public boolean isLoaded() {
        return Loader.isModLoaded(modid);
    }

    public void ifLoadedThen(Runnable F) {
        if (isLoaded()) {
            F.run();
        }
    }

    public void ifNotLoadedThen(Runnable F) {
        if (!isLoaded()) {
            F.run();
        }
    }
}

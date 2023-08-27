package io.github.teamgensouspark.kekkai.utils;

import net.minecraft.util.ResourceLocation;

public class ModResource {
    private String modid;

    public ModResource(String modid) {
        this.modid = modid;
    }

    public ResourceLocation getResource(String path) {
        return new ResourceLocation(modid, path);
    }

    public ResourceLocation getPNG(String path) {
        return this.getResource(path.concat(".png"));
    }
    

}

package io.github.teamgensouspark.kekkai.utils;

import javax.annotation.Nonnull;

import net.minecraft.util.ResourceLocation;

public class ModResource {
    private String modid;
    
    public ModResource(String modid) {
        this.modid = modid;
    }

    @Nonnull
    public ResourceLocation getResource(String path) {
        return new ResourceLocation(modid, path);
    }

    @Nonnull
    public ResourceLocation getPNG(String path) {
        return this.getResource(path.concat(".png"));
    }

    

}

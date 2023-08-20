package io.github.teamgensouspark.kekkai.core.mixins;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import io.github.teamgensouspark.kekkai.config.KekkaiConfig;
import net.katsstuff.teamnightclipse.danmakucore.client.handler.HUDHandler;

@Mixin(value = HUDHandler.class, remap = false)
public abstract class MixinHUDHandler {
    @Inject(method = "onDraw", at = @At(value = "HEAD"), cancellable = true)
    private void do_onDraw(CallbackInfo ci) {
        if (!KekkaiConfig.showDanData) {
            ci.cancel();
        }
    }
}

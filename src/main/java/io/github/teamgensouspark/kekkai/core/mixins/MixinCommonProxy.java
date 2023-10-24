package io.github.teamgensouspark.kekkai.core.mixins;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.katsstuff.teamnightclipse.danmakucore.CommonProxy;

@Mixin(value = CommonProxy.class, remap = false)
public class MixinCommonProxy {
    @Inject(method = "serverStopped", at = @At(value = "HEAD"), cancellable = true)
    private void inject_ServerStopped(CallbackInfo ci) {
        if (((CommonProxy) (Object) this).serverDanmakuHandler() == null) {
            ci.cancel();
        }
    }
}

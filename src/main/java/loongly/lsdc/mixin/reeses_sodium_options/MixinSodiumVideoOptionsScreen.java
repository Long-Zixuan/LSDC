package loongly.lsdc.mixin.reeses_sodium_options;

import me.flashyreese.mods.reeses_sodium_options.client.gui.SodiumVideoOptionsScreen;

import me.jellysquid.mods.sodium.client.gui.options.OptionPage;

import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import loongly.lsdc.client.gui.LSDCGameOptionPages;
import loongly.lsdc.client.LSDCClientMod;

import java.util.List;


@Mixin(SodiumVideoOptionsScreen.class)
public class MixinSodiumVideoOptionsScreen {

    @Shadow @Final
    private List<OptionPage> pages;


    @Inject(method = "<init>(Lnet/minecraft/client/gui/screen/Screen;)V", at = @At("TAIL"))
    private void addSSPBOptionPage(CallbackInfo ci)
    {
        if(!LSDCClientMod.options().isSimpUI)
        {
            this.pages.add(LSDCGameOptionPages.softInfo());
            this.pages.add(LSDCGameOptionPages.cpuInfo());
            this.pages.add(LSDCGameOptionPages.gpuInfo());
            this.pages.add(LSDCGameOptionPages.memoryInfo());
        }
        else
        {
            this.pages.add(LSDCGameOptionPages.lsdc());
        }
    }
}
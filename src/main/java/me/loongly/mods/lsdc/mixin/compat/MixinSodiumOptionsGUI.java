package me.loongly.mods.lsdc.mixin.compat;

import me.loongly.mods.lsdc.client.LSDCClientMod;
import me.loongly.mods.lsdc.client.gui.LSDCGameOptionPages;
import me.jellysquid.mods.sodium.client.gui.SodiumOptionsGUI;
import me.jellysquid.mods.sodium.client.gui.options.OptionPage;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin(value = SodiumOptionsGUI.class, remap = false)
public class MixinSodiumOptionsGUI {

    @Shadow
    @Final
    private List<OptionPage> pages;

    @Inject(method = "<init>", at = @At("TAIL"))
    private void init(CallbackInfo info) {
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

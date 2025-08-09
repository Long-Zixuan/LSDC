package me.loongly.mods.lsdc.mixin.compat;

import me.loongly.mods.lsdc.client.LSDCClientMod;
import me.loongly.mods.lsdc.client.gui.SuggestRSOScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.text.Text;
import net.minecraftforge.fml.ModList;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TitleScreen.class)
public abstract class MixinTitleScreen extends Screen {

    protected MixinTitleScreen(Text title) {
        super(title);
    }

    @Inject(method = "init", at = @At(value = "RETURN"))
    private void postInit(CallbackInfo ci) {
        if (!ModList.get().isLoaded("reeses_sodium_options") && !LSDCClientMod.options().notificationSettings.hideRSORecommendation && !LSDCClientMod.options().hasSuggestedRSO()) {
            this.client.setScreen(new SuggestRSOScreen(this));
            LSDCClientMod.options().setSuggestedRSO(true);
        }
    }
}

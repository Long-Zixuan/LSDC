package loongly.lsdc.mixin;

import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;
import net.fabricmc.loader.api.SemanticVersion;
import net.fabricmc.loader.api.Version;
import net.fabricmc.loader.api.VersionParsingException;

import org.objectweb.asm.tree.ClassNode;
import org.spongepowered.asm.mixin.extensibility.IMixinConfigPlugin;
import org.spongepowered.asm.mixin.extensibility.IMixinInfo;

import loongly.lsdc.client.LSDCClientMod;

import java.util.List;
import java.util.Optional;
import java.util.Set;


public class LSDCMixinPlugin implements IMixinConfigPlugin {

    @Override
    public void onLoad(String mixinPackage) {}

    @Override
    public String getRefMapperConfig() {return null;}

    @Override
    public boolean shouldApplyMixin(String targetClassName, String mixinClassName) {
        if(mixinClassName.equals("loongly.lsdc.mixin.reeses_sodium_options.MixinSodiumVideoOptionsScreen")) {
            Optional<ModContainer> rsoOptionalModContainer = FabricLoader.getInstance().getModContainer("reeses-sodium-options");

            if(rsoOptionalModContainer.isPresent()) {
                SemanticVersion rsoVersion = (SemanticVersion) rsoOptionalModContainer.get().getMetadata().getVersion();
                try {
                    // don't load the RSO options mixin for RSO versions >= 1.4.2
                    if(rsoVersion.compareTo(Version.parse("1.4.2")) >= 0) {
                        LSDCClientMod.LOGGER.warn("[LSDC] Reese's Sodium Options >= 1.4.2 detected. Mixin 'loongly.lsdc.mixin.reeses_sodium_options.MixinSodiumVideoOptionsScreen' will not be enabled");
                        return false;
                    }
                    else {
                        return true;
                    }
                }
                catch (VersionParsingException e) {
                    return false; // this should never happen
                }
            }
            else {
                LSDCClientMod.LOGGER.warn("[LSDC] Reese's Sodium Options not present. Mixin 'loongly.lsdc.mixin.reeses_sodium_options.MixinSodiumVideoOptionsScreen' will not be enabled");
                return false;
            }
        }

        return true;
    }

    @Override
    public void acceptTargets(Set<String> myTargets, Set<String> otherTargets) {}

    @Override
    public List<String> getMixins() {return null;}

    @Override
    public void preApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {}

    @Override
    public void postApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {}
}

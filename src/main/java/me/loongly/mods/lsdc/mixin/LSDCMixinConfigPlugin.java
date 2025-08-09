package me.loongly.mods.lsdc.mixin;

import net.caffeinemc.caffeineconfig.AbstractCaffeineConfigMixinPlugin;
import net.caffeinemc.caffeineconfig.CaffeineConfig;
import net.minecraftforge.fml.loading.FMLPaths;

public class LSDCMixinConfigPlugin extends AbstractCaffeineConfigMixinPlugin {

    private static final String MIXIN_PACKAGE_ROOT = "me.loongly.mods.lsdc.mixin.";

    @Override
    protected CaffeineConfig createConfig() {
        return CaffeineConfig.builder("Sodium Device Check").withSettingsKey("sodium-device-check:options")
                .addMixinOption("compat", true) // Should not allow users to turn this off
                .build(FMLPaths.CONFIGDIR.get().resolve("sodium-device-check.properties"));
    }

    @Override
    protected String mixinPackageRoot() {
        return MIXIN_PACKAGE_ROOT;
    }
}
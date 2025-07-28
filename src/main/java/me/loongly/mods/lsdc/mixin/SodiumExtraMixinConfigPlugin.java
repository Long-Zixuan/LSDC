package me.loongly.mods.lsdc.mixin;

import me.loongly.mods.lsdc.client.LSDCClientMod;
import net.caffeinemc.caffeineconfig.AbstractCaffeineConfigMixinPlugin;
import net.caffeinemc.caffeineconfig.CaffeineConfig;

public class SodiumExtraMixinConfigPlugin extends AbstractCaffeineConfigMixinPlugin {

    private static final String MIXIN_PACKAGE_ROOT = "me.loongly.mods.lsdc.mixin.";

    @Override
    protected CaffeineConfig createConfig() {
        return LSDCClientMod.mixinConfig();
    }

    @Override
    protected String mixinPackageRoot() {
        return MIXIN_PACKAGE_ROOT;
    }
}

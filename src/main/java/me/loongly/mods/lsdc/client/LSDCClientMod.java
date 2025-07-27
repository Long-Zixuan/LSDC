package me.loongly.mods.lsdc.client;

import me.loongly.mods.lsdc.client.gui.LSDCGameOptions;
import net.caffeinemc.caffeineconfig.CaffeineConfig;
import net.minecraftforge.fml.loading.FMLPaths;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class LSDCClientMod {
    public static final Logger LOGGER = LogManager.getLogger("Embeddium Device Check");
    private static LSDCGameOptions CONFIG;
    private static CaffeineConfig MIXIN_CONFIG;

    public static LSDCGameOptions options() {
        if (CONFIG == null) {
            CONFIG = loadConfig();
        }

        return CONFIG;
    }

    public static void caiDan(){}

    public static CaffeineConfig mixinConfig() {
        if (MIXIN_CONFIG == null) {
            MIXIN_CONFIG = CaffeineConfig.builder("Sodium Device Check").withSettingsKey("sodium-extra:options")
                    .addMixinOption("adaptive_sync", true)
                    .addMixinOption("animation", true)
                    .addMixinOption("biome_colors", true)
                    .addMixinOption("cloud", true)
                    .addMixinOption("compat", true, false)
                    .addMixinOption("fog", true)
                    .addMixinOption("fog_falloff", true)
                    .addMixinOption("gui", true)
                    .addMixinOption("instant_sneak", true)
                    .addMixinOption("light_updates", true)
                    .addMixinOption("optimizations", true)
                    .addMixinOption("optimizations.beacon_beam_rendering", true)
                    .addMixinOption("optimizations.draw_helpers", false)
                    .addMixinOption("optimizations.fast_weather", false)
                    .addMixinOption("particle", true)
                    .addMixinOption("prevent_shaders", true)
                    .addMixinOption("profiler", true)
                    .addMixinOption("reduce_resolution_on_mac", true)
                    .addMixinOption("render", true)
                    .addMixinOption("render.block", true)
                    .addMixinOption("render.block.entity", true)
                    .addMixinOption("render.entity", true)
                    .addMixinOption("sky", true)
                    .addMixinOption("sky_colors", true)
                    .addMixinOption("sodium", true)
                    .addMixinOption("sodium.accessibility", true)
                    .addMixinOption("sodium.fog", true)
                    .addMixinOption("sodium.cloud", true)
                    .addMixinOption("sodium.resolution", true)
                    .addMixinOption("sodium.scrollable_page", true)
                    .addMixinOption("sodium.vsync", true)
                    .addMixinOption("stars", true)
                    .addMixinOption("steady_debug_hud", true)
                    .addMixinOption("sun_moon", true)
                    .addMixinOption("toasts", true)

                    .withLogger(LSDCClientMod.LOGGER)
                    .withInfoUrl("https://github.com/FlashyReese/sodium-extra-fabric/wiki/Configuration-File")
                    .build(FMLPaths.CONFIGDIR.get().resolve("sodium-extra.properties"));
        }
        return MIXIN_CONFIG;
    }

    private static LSDCGameOptions loadConfig() {
        return LSDCGameOptions.load(FMLPaths.CONFIGDIR.get().resolve("sodium-device-check.json").toFile());
    }

    public LSDCClientMod() {
    }
}

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
            MIXIN_CONFIG = CaffeineConfig.builder("Sodium Device Check").withSettingsKey("lsdc:options")

                    .withLogger(LSDCClientMod.LOGGER)
                    .build(FMLPaths.CONFIGDIR.get().resolve("lsdc.properties"));
        }
        return MIXIN_CONFIG;
    }

    private static LSDCGameOptions loadConfig() {
        return LSDCGameOptions.load(FMLPaths.CONFIGDIR.get().resolve("sodium-device-check.json").toFile());
    }

    public LSDCClientMod() {
    }
}

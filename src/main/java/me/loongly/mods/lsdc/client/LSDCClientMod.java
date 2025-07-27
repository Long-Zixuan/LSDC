package me.loongly.mods.lsdc.client;

import me.loongly.mods.lsdc.client.gui.LSDCGameOptionPages;
import me.loongly.mods.lsdc.client.gui.LSDCGameOptions;
import net.caffeinemc.caffeineconfig.CaffeineConfig;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.loading.FMLPaths;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.embeddedt.embeddium.api.OptionGUIConstructionEvent;
import org.embeddedt.embeddium.api.OptionGroupConstructionEvent;
import org.embeddedt.embeddium.api.OptionPageConstructionEvent;
import org.embeddedt.embeddium.client.gui.options.OptionIdentifier;
import org.embeddedt.embeddium.client.gui.options.StandardOptions;

@Mod(value = LSDCClientMod.MOD_ID, dist = Dist.CLIENT)
public class LSDCClientMod {
    public static final String MOD_ID = "embeddium_device_check";
    public static final Logger LOGGER = LogManager.getLogger("Embeddium Device Check");
    private static lsdcGameOptions CONFIG;
    private static CaffeineConfig MIXIN_CONFIG;

    public static lsdcGameOptions options() {
        if (CONFIG == null) {
            CONFIG = loadConfig();
        }

        return CONFIG;
    }

    public static CaffeineConfig mixinConfig() {
        if (MIXIN_CONFIG == null) {
            MIXIN_CONFIG = CaffeineConfig.builder("Sodium Extra").withSettingsKey("embeddium_device_check", "lsdc:options")
                    .withLogger(LSDCClientMod.LOGGER)
                    .build(FMLPaths.CONFIGDIR.get().resolve("lsdc.properties"));
        }
        return MIXIN_CONFIG;
    }

    private static lsdcGameOptions loadConfig() {
        return lsdcGameOptions.load(FMLPaths.CONFIGDIR.get().resolve("sodium-device-check-options.json").toFile());
    }

    public LSDCClientMod() {
        OptionGUIConstructionEvent.BUS.addListener(event ->
        {
            if(!options().isSimpUI)
            {
                event.addPage(LSDCGameOptionPages.softInfo());
                event.addPage(LSDCGameOptionPages.cpuInfo());
                event.addPage(LSDCGameOptionPages.gpuInfo());
                event.addPage(LSDCGameOptionPages.memoryInfo());
            }
            else
            {
                event.addPage(LSDCGameOptionPages.lsdc());
            }
        });
    }

    public static OptionIdentifier<Void> optionIdentifier(String path) {
        return OptionIdentifier.create(MOD_ID, path);
    }
}

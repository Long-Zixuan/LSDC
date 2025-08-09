package me.loongly.mods.lsdc.client;

import me.loongly.mods.lsdc.api.system.SystemAndGLInfo;
import me.loongly.mods.lsdc.client.gui.LSDCGameOptions;
import net.minecraft.util.Util;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import net.minecraftforge.fml.loading.FMLPaths;
import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

@Mod("lsdc")
@OnlyIn(Dist.CLIENT)
public class LSDCClientMod
{


    private static LSDCGameOptions CONFIG;
    private static Logger LOGGER;

    public static Logger logger()
    {
        if (LOGGER == null)
        {
            LOGGER = LogManager.getLogger("Sodium Device Check");
        }

        return LOGGER;
    }

    public static LSDCGameOptions options()
    {
        if (CONFIG == null)
        {
            CONFIG = loadConfig();
        }

        return CONFIG;
    }

    public static void caiDan()
    {
        Util.getOperatingSystem().open("https://www.curseforge.com/minecraft/mc-mods/sodium-device-check");
    }



    private static LSDCGameOptions loadConfig()
    {
        return LSDCGameOptions.load(FMLPaths.CONFIGDIR.get().resolve("sodium-device-check-options.json").toFile());
    }

    public LSDCClientMod()
    {
        SystemAndGLInfo.initInstance();
    }
}

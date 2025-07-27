package me.loongly.mods.lsdc;

import me.loongly.mods.lsdc.api.system.SystemAndGLInfo;
import net.minecraftforge.fml.common.Mod;

@Mod(EmbeddiumDeviceCheckMod.MOD_ID)
public final class EmbeddiumDeviceCheckMod {
    public static final String MOD_ID = "embeddium_device_check";

    public EmbeddiumDeviceCheckMod()
    {
        SystemAndGLInfo.initInstance();
    }
}

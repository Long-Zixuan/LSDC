package loongly.lsdc.forge.services;

import net.minecraftforge.fml.loading.FMLPaths;

import loongly.lsdc.common.services.IPlatformHelper;

import java.nio.file.Path;


public class ForgePlatformHelper implements IPlatformHelper {

    @Override
    public Path getConfigDirectory() {
        return FMLPaths.CONFIGDIR.get();
    }
}

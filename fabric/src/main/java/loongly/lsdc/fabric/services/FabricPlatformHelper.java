package loongly.lsdc.fabric.services;

import net.fabricmc.loader.api.FabricLoader;

import loongly.lsdc.common.services.IPlatformHelper;

import java.nio.file.Path;


public class FabricPlatformHelper implements IPlatformHelper {

    @Override
    public Path getConfigDirectory() {
        return FabricLoader.getInstance().getConfigDir();
    }
}

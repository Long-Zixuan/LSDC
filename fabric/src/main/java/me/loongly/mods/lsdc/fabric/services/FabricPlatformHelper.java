package me.loongly.mods.lsdc.fabric.services;

import net.fabricmc.loader.api.FabricLoader;

import java.nio.file.Path;

import me.loongly.mods.lsdc.common.services.IPlatformHelper;


public class FabricPlatformHelper implements IPlatformHelper 
{

    @Override
    public Path getConfigDirectory() 
    {
        return FabricLoader.getInstance().getConfigDir();
    }
}

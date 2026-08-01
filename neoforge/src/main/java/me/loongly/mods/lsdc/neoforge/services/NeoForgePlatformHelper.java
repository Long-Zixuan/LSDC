package me.loongly.mods.lsdc.neoforge.services;

import net.neoforged.fml.loading.FMLPaths;

import java.nio.file.Path;

import me.loongly.mods.lsdc.common.services.IPlatformHelper;


public class NeoForgePlatformHelper implements IPlatformHelper 
{

    @Override
    public Path getConfigDirectory() 
    {
        return FMLPaths.CONFIGDIR.get();
    }
}

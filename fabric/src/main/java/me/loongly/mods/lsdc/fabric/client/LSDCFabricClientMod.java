package me.loongly.mods.lsdc.fabric.client;

import me.loongly.mods.lsdc.common.client.LSDCClientMod;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;


@Environment(EnvType.CLIENT)
public class LSDCFabricClientMod implements ClientModInitializer 
{

	@Override
	public void onInitializeClient() 
	{
		LSDCClientMod.onInitClient();
	}
}

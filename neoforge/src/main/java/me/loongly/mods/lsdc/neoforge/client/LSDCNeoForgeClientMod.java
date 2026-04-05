package me.loongly.mods.lsdc.neoforge.client;

import me.loongly.mods.lsdc.common.client.LSDCClientMod;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;


@Mod("lsdc")
public class LSDCNeoForgeClientMod 
{

	public LSDCNeoForgeClientMod(IEventBus eventBus) 
	{
		LSDCClientMod.onInitClient();
	}
}
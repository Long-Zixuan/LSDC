package me.loongly.mods.lsdc.common.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import me.loongly.mods.lsdc.common.client.options.LSDCOptions;

public class LSDCClientMod
{

	public static final Logger LOGGER = LoggerFactory.getLogger("LSDC");

	private static final LSDCOptions CONFIG = LSDCOptions.load();


	public static LSDCOptions options() 
	{
		return CONFIG;
	}

	public static void onInitClient() 
	{
		LOGGER.info("[LSDC] LoongLy:Sodium Device Check init!");
	}

	static int chickCount = 0;
	public static void caiDan(boolean v)
	{
		System.out.println("Do Nothing");
		chickCount++;
		if (chickCount == 10)
		{
			chickCount = 0;
			net.minecraft.util.Util.getPlatform()
					.openUri("https://github.com/Long-Zixuan");
		}
	}
}

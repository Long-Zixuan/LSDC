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

	public static void caiDan(boolean v){}
}

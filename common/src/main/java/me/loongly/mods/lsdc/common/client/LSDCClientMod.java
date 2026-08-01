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
		var ls = "[LSDC]\r\n"+ //
						"      ____                                    ____ \r\n" + //
						"     /   /                                   /   /   \r\n" + //
						"    /   /    ____________  ______  _____    /   /    ___ ___ \r\n" + //
						"   /   /___ /  _  /  _  / /     / /  _  \\  /   /___ |  //  /\r\n" + //
						"  /_______/ \\____/\\____/ /  /  /  \\__   / /_______/  \\    /\r\n" + //
						" ___________________________________/  /______________/  /\r\n" + //
						"/___LoongLy Software 2026_______________________________/\r\n" + //
						"[LSDC]LoongLy:Sodium Device Check init successful!\r\n";
		LOGGER.info(ls);
	}

	static int chickCount = 0;
	public static void caiDan(boolean v)
	{
		//System.out.println("Do Nothing");
		chickCount++;
		if (chickCount == 10)
		{
			LOGGER.info("[LSDC] Suprise!");
			chickCount = 0;
			net.minecraft.Util.getPlatform()
					.openUri("https://github.com/Long-Zixuan");
		}
	}
}

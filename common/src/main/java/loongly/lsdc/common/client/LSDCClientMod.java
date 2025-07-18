package loongly.lsdc.common.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import loongly.lsdc.common.client.gui.LSDCGameOptions;
import net.minecraft.Util;
import loongly.lsdc.common.api.system.*;


public class LSDCClientMod {

	public static final Logger LOGGER = LoggerFactory.getLogger("LSDC");

	private static LSDCGameOptions CONFIG;


	public static LSDCGameOptions options() {
		return CONFIG;
	}

	public static void onInitClient() {
		CONFIG = LSDCGameOptions.load();
		SystemAndGLInfo.getInstance();

		LOGGER.info("Init LSDC Config");
	}

	static int chickCount = 0;
	public static void caiDan()
	{
		System.out.println("Do Nothing");
		chickCount++;
		if (chickCount == 10)
		{
			chickCount = 0;
			Util.getPlatform()
					.openUri("https://mod.3dmgame.com/u/23059615/Home");
		}
	}
}

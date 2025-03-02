package loongly.lsdc.common.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import loongly.lsdc.common.client.gui.LSDCGameOptions;


public class LSDCClientMod {

	public static final Logger LOGGER = LoggerFactory.getLogger("LSDC");

	private static LSDCGameOptions CONFIG;


	public static LSDCGameOptions options() {
		return CONFIG;
	}

	public static void onInitClient() {
		/*CONFIG = LSDCGameOptions.load();
		CONFIG.updateShadowyness(CONFIG.shadowynessPercent);*/

		LOGGER.info("");
	}
}

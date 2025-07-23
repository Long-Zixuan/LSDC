package loongly.lsdc.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import loongly.lsdc.client.gui.LSDCGameOptions;
import loongly.lsdc.api.system.*;

@Environment(EnvType.CLIENT)
public class LSDCClientMod implements ClientModInitializer{

	public static final Logger LOGGER = LoggerFactory.getLogger("LSDC");

	private static LSDCGameOptions CONFIG;


	public static LSDCGameOptions options() {
		return CONFIG;
	}


	@Override
	public void onInitializeClient() {
		CONFIG = LSDCGameOptions.load();
		SystemAndGLInfo.initInstance();

		LOGGER.info("Init LSDC Config");
	}

	public static void caiDan()
	{
		System.out.println("Do Nothing");

	}
}

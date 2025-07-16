package loongly.lsdc.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import loongly.lsdc.client.gui.LSDCGameOptions;
//import loongly.lsdc.reflection.ReflectionAoFaceData;
//import loongly.lsdc.reflection.ReflectionSmoothLightPipeline;


@Environment(EnvType.CLIENT)
public class LSDCClientMod implements ClientModInitializer {

	public static final Logger LOGGER = LogManager.getLogger("LSDC");
	private static LSDCGameOptions CONFIG;


	public static LSDCGameOptions options() {
		return CONFIG;
	}

	@Override
	public void onInitializeClient()
	{
		try
		{
			CONFIG = LSDCGameOptions.load();

			LOGGER.info("[LSDC] Sodium device check");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public static void caiDan(){

	}

}

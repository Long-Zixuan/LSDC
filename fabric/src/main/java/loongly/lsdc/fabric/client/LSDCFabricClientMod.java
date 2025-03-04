package loongly.lsdc.fabric.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

import loongly.lsdc.common.client.LSDCClientMod;


@Environment(EnvType.CLIENT)
public class LSDCFabricClientMod implements ClientModInitializer {

	@Override
	public void onInitializeClient() {
		LSDCClientMod.onInitClient();
	}
}

package loongly.lsdc.neoforge.client;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

import loongly.lsdc.common.client.LSDCClientMod;


@Mod("lzx_sodium_device_check")
public class LSDCNeoForgeClientMod {

	public LSDCNeoForgeClientMod(IEventBus eventBus) {
		LSDCClientMod.onInitClient();
	}
}

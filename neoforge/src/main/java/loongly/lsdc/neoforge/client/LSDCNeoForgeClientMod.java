package loongly.lsdc.neoforge.client;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

import loongly.lsdc.common.client.LSDCClientMod;


@Mod("lsdc")
public class LSDCNeoForgeClientMod {

	public LSDCNeoForgeClientMod(IEventBus eventBus) {
		LSDCClientMod.onInitClient();
	}
}

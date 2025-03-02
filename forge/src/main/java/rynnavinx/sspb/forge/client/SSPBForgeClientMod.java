package loongly.lsdc.forge.client;

import net.minecraftforge.fml.common.Mod;

import loongly.lsdc.common.client.LSDCClientMod;


@Mod("sspb")
public class SSPBForgeClientMod {

	public SSPBForgeClientMod() {
		LSDCClientMod.onInitClient();
	}
}

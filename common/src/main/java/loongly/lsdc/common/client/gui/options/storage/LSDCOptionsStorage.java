package loongly.lsdc.common.client.gui.options.storage;

import net.caffeinemc.mods.sodium.client.gui.options.storage.OptionStorage;

import loongly.lsdc.common.client.LSDCClientMod;
import loongly.lsdc.common.client.gui.LSDCGameOptions;

import java.io.IOException;


public class LSDCOptionsStorage implements OptionStorage<LSDCGameOptions> {

    private final LSDCGameOptions options = LSDCClientMod.options();


    public LSDCGameOptions getData() {
        return this.options;
    }

    public void save() {
        try {
            this.options.writeChanges();
        }
        catch (IOException e) {
            throw new RuntimeException("Couldn't save SSPB config changes", e);
        }

        LSDCClientMod.LOGGER.info("[SSPB] Saved changes to SSPB config");
    }
}

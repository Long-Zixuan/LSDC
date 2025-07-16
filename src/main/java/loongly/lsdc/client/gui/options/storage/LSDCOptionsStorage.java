package loongly.lsdc.client.gui.options.storage;

import java.io.IOException;
import me.jellysquid.mods.sodium.client.gui.options.storage.OptionStorage;

import loongly.lsdc.client.LSDCClientMod;
import loongly.lsdc.client.gui.LSDCGameOptions;

import java.io.IOException;

public class LSDCOptionsStorage implements OptionStorage<LSDCGameOptions>
{
    private final LSDCGameOptions options = LSDCClientMod.options();


    public LSDCGameOptions getData()
    {
        return this.options;
    }

    public void save()
    {
        try
        {
            this.options.writeChanges();
        }
        catch (IOException e)
        {
            throw new RuntimeException("Couldn't save LSDC config changes", e);
        }

        LSDCClientMod.LOGGER.info("[LSDC] Saved changes to LSDC config");
    }
}

package me.loongly.mods.lsdc.client.gui.options.storage;

import me.loongly.mods.lsdc.client.LSDCClientMod;
import me.loongly.mods.lsdc.client.gui.LSDCGameOptions;
import me.jellysquid.mods.sodium.client.gui.options.storage.OptionStorage;

public class LSDCOptionsStorage implements OptionStorage<lsdcGameOptions> {
    private final LSDCGameOptions options = LSDCClientMod.options();

    @Override
    public LSDCGameOptions getData() {
        return this.options;
    }

    @Override
    public void save() {
        this.options.writeChanges();
    }
}

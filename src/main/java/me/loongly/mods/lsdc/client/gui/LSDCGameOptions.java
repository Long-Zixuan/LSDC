package me.loongly.mods.lsdc.client.gui;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;
import it.unimi.dsi.fastutil.objects.Object2BooleanArrayMap;
import it.unimi.dsi.fastutil.objects.Object2IntArrayMap;
import me.loongly.mods.lsdc.client.LSDCClientMod;
import me.jellysquid.mods.sodium.client.gui.options.TextProvider;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.lwjgl.glfw.GLFW;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Map;

public class LSDCGameOptions {
    private static final Gson gson = new GsonBuilder()
            .registerTypeAdapter(Identifier.class, new Identifier.Serializer())
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .setPrettyPrinting()
            .excludeFieldsWithModifiers(Modifier.PRIVATE)
            .create();
    public boolean isSimpUI = false;
    private File file;

    public static LSDCGameOptions load(File file) {
        LSDCGameOptions config;

        if (file.exists()) {
            try (FileReader reader = new FileReader(file)) {
                config = gson.fromJson(reader, LSDCGameOptions.class);
            } catch (Exception e) {
                LSDCClientMod.LOGGER.error("Could not parse config, falling back to defaults!", e);
                config = new LSDCGameOptions();
            }
        } else {
            config = new LSDCGameOptions();
        }

        config.file = file;
        config.writeChanges();

        return config;
    }

    public void writeChanges() {
        File dir = this.file.getParentFile();

        if (!dir.exists()) {
            if (!dir.mkdirs()) {
                throw new RuntimeException("Could not create parent directories");
            }
        } else if (!dir.isDirectory()) {
            throw new RuntimeException("The parent file is not a directory");
        }

        try (FileWriter writer = new FileWriter(this.file)) {
            gson.toJson(this, writer);
        } catch (IOException e) {
            throw new RuntimeException("Could not save configuration file", e);
        }
    }

}

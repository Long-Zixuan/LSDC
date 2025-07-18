package loongly.lsdc.common.client.gui;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import loongly.lsdc.common.services.IPlatformHelper;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Modifier;
import java.nio.file.Files;
import java.nio.file.Path;


public class LSDCGameOptions {

    private static final String DEFAULT_FILE_NAME = "lzx-sodium-device-check-options.json";
    private static final Gson GSON = new GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .setPrettyPrinting()
            .excludeFieldsWithModifiers(Modifier.PRIVATE)
            .create();
    private Path configPath;

    public boolean isSimpUI;




    public LSDCGameOptions(){

    }

    public static LSDCGameOptions load() {
        Path path = IPlatformHelper.INSTANCE.getConfigDirectory().resolve(DEFAULT_FILE_NAME);
        LSDCGameOptions config;

        if (Files.exists(path)) {
            try (FileReader reader = new FileReader(path.toFile())) {
                config = GSON.fromJson(reader, LSDCGameOptions.class);
            }
            catch (IOException e) {
                throw new RuntimeException("Could not parse LSDC config", e);
            }
        }
        else {
            config = new LSDCGameOptions();
        }

        config.configPath = path;

        try {
            config.writeChanges();
        }
        catch (IOException e) {
            throw new RuntimeException("Couldn't update LSDC config", e);
        }

        return config;
    }

    public void writeChanges() throws IOException {
        Path dir = this.configPath.getParent();

        if (!Files.exists(dir)) {
            Files.createDirectories(dir);
        }
        else if (!Files.isDirectory(dir)) {
            throw new IOException("Not a directory: " + dir);
        }

        Files.writeString(this.configPath, GSON.toJson(this));
    }

}

package me.loongly.mods.lsdc.common.client.options;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import me.loongly.mods.lsdc.common.client.LSDCClientMod;
import me.loongly.mods.lsdc.common.services.IPlatformHelper;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Modifier;
import java.nio.file.Files;
import java.nio.file.Path;


public class LSDCOptions 
{
    private static final String DEFAULT_FILE_NAME = "sodium-device-check-options.json";
    private static final Gson GSON = new GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .setPrettyPrinting()
            .excludeFieldsWithModifiers(Modifier.PRIVATE, Modifier.STATIC)
            .create();
    private Path configPath;

    public LSDCOptions()
    {
        
    }

    public void save() 
    {
        try 
        {
            writeChanges();
        }
        catch (IOException e) 
        {
            throw new RuntimeException("Couldn't save LSDC options changes", e);
        }

        LSDCClientMod.LOGGER.info("[LSDC] Saved changes to LSDC options");
    }

    public static LSDCOptions load() 
    {
        Path path = IPlatformHelper.INSTANCE.getConfigDirectory().resolve(DEFAULT_FILE_NAME);
        LSDCOptions config;

        if (Files.exists(path)) 
        {
            try (FileReader reader = new FileReader(path.toFile())) 
            {
                config = GSON.fromJson(reader, LSDCOptions.class);
            }
            catch (IOException e) 
            {
                throw new RuntimeException("Could not parse LSDC options", e);
            }
        }
        else 
        {
            config = new LSDCOptions();
        }

        config.configPath = path;

        try 
        {
            config.writeChanges();
        }
        catch (IOException e) 
        {
            throw new RuntimeException("Couldn't update LSDC options", e);
        }
        return config;
    }

    private void writeChanges() throws IOException 
    {
        Path dir = this.configPath.getParent();

        if (!Files.exists(dir)) 
        {
            Files.createDirectories(dir);
        }
        else if (!Files.isDirectory(dir)) 
        {
            throw new IOException("Not a directory: " + dir);
        }

        Files.writeString(this.configPath, GSON.toJson(this));
    }

}

package loongly.lsdc.common.services;

import java.nio.file.Path;


public interface IPlatformHelper {

    IPlatformHelper INSTANCE = Services.load(IPlatformHelper.class);

    Path getConfigDirectory();
}
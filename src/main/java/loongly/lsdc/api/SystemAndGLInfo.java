package loongly.lsdc.api;

import org.lwjgl.opengl.GL11;
import org.lwjgl.system.MemoryStack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.hardware.*;

import java.util.Map;
import java.util.HashMap;

import java.io.InputStream;


import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import java.util.concurrent.*;

public class SystemAndGLInfo
{
    private static SystemAndGLInfo instance = null;

    public static synchronized void initInstance()
    {
        if(instance != null)
        {
            return;
        }
        instance = new SystemAndGLInfo(0);
    }

    public static SystemAndGLInfo getInstance()
    {
        if(instance == null)//防止init函数执行失败
        {
            synchronized(SystemAndGLInfo.class)
            {
                if(instance == null)
                {
                    instance = new SystemAndGLInfo();
                }
            }
        }
        return instance;
    }

    private RefMap<String,String> mobileSocPathNumberToSocNameMap;
    private RefMap<String,String> mobileGPUPathNumberToGPUNameMap;


    private boolean isMobileSoc = false;

    private SystemInfo systemInfo = null;
    private HardwareAbstractionLayer infoHardware = null;
    private CPUInfo cpuInfo = null;
    public CPUInfo getCpuInfo()
    {
        return cpuInfo;
    }
    private List<GPUInfo>gpuInfoList;

    public List<GPUInfo> getGpuInfoList()
    {
        return gpuInfoList;
    }

    private List<MemoryInfo>memoryInfoList;

    public List<MemoryInfo> getMemoryInfoList()
    {
        return memoryInfoList;
    }

    /*Memory Info */

    public double getJVMTotalMemory()
    {
        Runtime runtime = Runtime.getRuntime();
        return runtime.totalMemory() / (1024 * 1024);
    }

    public static class MemoryInfo
    {
        private String name;
        private String vendor;
        private double size;
        private double clockSpeed;
        private String type;
        private String bankLabel;

        public String getName()
        {
            return this.name;
        }

        public String getVendor()
        {
            return this.vendor;
        }

        public double getSize()
        {
            return this.size;
        }

        public double getClockSpeed()
        {
            return this.clockSpeed;
        }

        public String getType()
        {
            return this.type;
        }

        public String getBankLabel()
        {
            return this.bankLabel;
        }

        public MemoryInfo(String _name, String _vendor, double _size, double _clockSpeed, String _type, String _bankLabel)
        {
            this.name = _name;
            this.vendor = _vendor;
            this.size = _size;
            this.clockSpeed = _clockSpeed;
            this.type = _type;
            this.bankLabel = _bankLabel;
        }
    }

    private void initMemoryInfo()
    {
        List<PhysicalMemory> physicalMemories = infoHardware.getMemory().getPhysicalMemory();
        memoryInfoList = new ArrayList();

        for (int i = 0; i < physicalMemories.size(); i++) {
            PhysicalMemory memory = physicalMemories.get(i);
            MemoryInfo memoryInfo = new MemoryInfo(memory.getBankLabel(), memory.getManufacturer(),
                    memory.getCapacity() / (1024 * 1024), memory.getClockSpeed() / (1024 * 1024 * 1024), memory.getMemoryType(),
                    memory.getBankLabel());
            memoryInfoList.add(memoryInfo);
                /*log.info("制造商：{}", memory.getManufacturer());
                log.info("内存类型：{}", memory.getMemoryType());
                log.info("插槽标识：{}", memory.getBankLabel());
                log.info("容量：{} MB", memory.getCapacity() / (1024 * 1024));
                log.info("时钟频率：{} MHz", memory.getClockSpeed());*/
        }
    }

    /*GPU Info*/

    public static class GPUInfo
    {
        private String name;
        private String vendor;
        private double vRam;
        private int gpuCount;

        public String getName()
        {
            return this.name;
        }

        public String getVendor()
        {
            return this.vendor;
        }

        public double getVRam()
        {
            return this.vRam;
        }

        public int getGpuCount()
        {
            return this.gpuCount;
        }

        public GPUInfo(String _name, String _vendor, double _vRam)
        {
            this.name = _name;
            this.vendor = _vendor;
            this.vRam = _vRam;
        }
    }

    public void initGPUInfo()
    {
        gpuInfoList = new ArrayList();

        CentralProcessor processor = infoHardware.getProcessor();

        String GPUPartNumber = processor.getProcessorIdentifier().getName();

        String GPUName = getMobileGPUNameWithPathNumber(GPUPartNumber);
        if(!GPUName.equals(GPUPartNumber))
        {
            GPUInfo gpuInfo = new GPUInfo(GPUName, processor.getProcessorIdentifier().getVendor(), 0);
            gpuInfoList.add(gpuInfo);
        }
        else
        {
            List<GraphicsCard> graphicsCards = infoHardware.getGraphicsCards();

            for (int i = 0; i < graphicsCards.size(); i++)
            {
                GPUInfo gpuInfo = new GPUInfo(graphicsCards.get(i).getName(), graphicsCards.get(i).getVendor(), graphicsCards.get(i).getVRam() / (1024 * 1024 * 1024));
                gpuInfoList.add(gpuInfo);
            }
        }
    }

    private String getMobileGPUNameWithPathNumber(String pathNumber)
    {
        if(mobileGPUPathNumberToGPUNameMap.containsKey(pathNumber))
        {
            return mobileGPUPathNumberToGPUNameMap.get(pathNumber);
        }
        return pathNumber;
    }

    /*CPU Info */
    public static class CPUInfo
    {
        private String name;
        private String vendor;
        private String family;
        private String model;
        private int cores;
        private int threads;
        private double frequency;

        public String getName()
        {
            return this.name;
        }

        public String getVendor()
        {
            return this.vendor;
        }

        public String getFamily()
        {
            return this.family;
        }

        public String getModel()
        {
            return this.model;
        }

        public int getCores()
        {
            return this.cores;
        }

        public int getThreads()
        {
            return this.threads;
        }

        public double getFrequency()
        {
            return this.frequency;
        }
        public CPUInfo(String _name, String _vendor, String _family, String _model, int _cores, int _threads, double _frequency)
        {
            this.name = _name;
            this.vendor = _vendor;
            this.family = _family;
            this.model = _model;
            this.cores = _cores;
            this.threads = _threads;
            this.frequency = _frequency;
        }
    }

    public void initCPUInfo()
    {
        try
        {
            String CPUName = "";
            CentralProcessor processor = infoHardware.getProcessor();

            CPUName = processor.getProcessorIdentifier().getName();

            if(CPUName == null || CPUName.equals(""))
            {
                CPUName = System.getProperty("os.arch") + " based CPU";
            }

            cpuInfo = new CPUInfo(getMobileSocNameWithPathNumber(CPUName), processor.getProcessorIdentifier().getVendor(),
                    processor.getProcessorIdentifier().getFamily(), processor.getProcessorIdentifier().getModel(),
                    processor.getPhysicalProcessorCount(), processor.getLogicalProcessorCount(),
                    processor.getProcessorIdentifier().getVendorFreq());
        }
        catch (Exception e)
        {
            cpuInfo = new CPUInfo(System.getProperty("os.arch") + " based CPU", "Unknown", "Unknown", "Unknown", 0, 0, 0);
        }
    }

    private String getMobileSocNameWithPathNumber(String pathNumber)
    {
        if(mobileSocPathNumberToSocNameMap.containsKey(pathNumber))
        {
            isMobileSoc = true;
            return mobileSocPathNumberToSocNameMap.get(pathNumber);
        }
        return pathNumber;
    }

    /*Software Info API*/

    public String getJDKVersion()
    {
        return System.getProperty("java.version");
    }

    public String getGLVersion()
    {
        String glInfo = "Unknown";
        try (MemoryStack stack = MemoryStack.stackPush())
        {
            // 获取OpenGL版本
            String version = GL11.glGetString(GL11.GL_VERSION);

            System.out.println("OpenGL Version: " + version);
            glInfo = version;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return "Unknown";
        }
        return glInfo;
    }

    public String getOSName()
    {
        return System.getProperty("os.name");
    }
    public String getOSVersion()
    {
        return System.getProperty("os.version");
    }

    public boolean isUsingPojavLauncher() {
        if (System.getenv("POJAV_RENDERER") != null) {
            //System.out.println("Detected presence of environment variable POJAV_LAUNCHER, which seems to indicate we are running on Android");

            return true;
        }

        String librarySearchPaths = System.getProperty("java.library.path", null);

        if (librarySearchPaths != null) {
            for (String path : librarySearchPaths.split(":")) {
                if (isKnownAndroidPathFragment(path)) {
                    // System.out.println("Found a library search path which seems to be hosted in an Android filesystem: {}", path);

                    return true;
                }
            }
        }

        /*var workingDirectory = System.getProperty("user.home", null);

        if (workingDirectory != null) {
            if (isKnownAndroidPathFragment(workingDirectory)) {
                System.out.println("Working directory seems to be hosted in an Android filesystem: {}", workingDirectory);
            }
        }*/
        return false;
    }

    private boolean isKnownAndroidPathFragment(String path) {
        return path.matches("/data/user/[0-9]+/net\\.kdt\\.pojavlaunch");
    }

    private SystemAndGLInfo(int i)//有参构造函数的参数仅仅为了和无参构造函数区分，除此之外无意义（有参构造函数不能在一瞬间初始化完成所有类内成员）
    {
        systemInfo = new SystemInfo();
        infoHardware = systemInfo.getHardware();
        CompletableFuture.runAsync(() ->
        {
            mobileSocPathNumberToSocNameMap = new RefMap<>();
            RefMap.initMapWithPathAndURL("/assets/lsdc/soc_map/MobileSocPathNumberToName.json",
                    "https://gitee.com/zixuan_long/Json/raw/master/sodium/soc_map/MobileSocPathNumberToName.json"
                    ,mobileSocPathNumberToSocNameMap);
            initCPUInfo();

        });
        CompletableFuture.runAsync(() ->
        {
            mobileGPUPathNumberToGPUNameMap = new RefMap<>();
            RefMap.initMapWithPathAndURL("/assets/lsdc/soc_map/MobileGPUPathNumberToName.json",
                    "https://gitee.com/zixuan_long/Json/raw/master/sodium/soc_map/MobileGPUPathNumberToName.json"
                    ,mobileGPUPathNumberToGPUNameMap);
            initGPUInfo();

        });
        initMemoryInfo();

    }

    private SystemAndGLInfo()
    {
        systemInfo = new SystemInfo();
        infoHardware = systemInfo.getHardware();
        CompletableFuture.runAsync(() ->
        {
            mobileSocPathNumberToSocNameMap = new RefMap<>();
            RefMap.initMapWithPathAndURL("/assets/lsdc/soc_map/MobileSocPathNumberToName.json",
                    "https://gitee.com/zixuan_long/Json/raw/master/sodium/soc_map/MobileSocPathNumberToName.json"
                    ,mobileSocPathNumberToSocNameMap);
        });
        CompletableFuture.runAsync(() ->
        {
            mobileGPUPathNumberToGPUNameMap = new RefMap<>();
            RefMap.initMapWithPathAndURL("/assets/lsdc/soc_map/MobileGPUPathNumberToName.json",
                    "https://gitee.com/zixuan_long/Json/raw/master/sodium/soc_map/MobileGPUPathNumberToName.json"
                    ,mobileGPUPathNumberToGPUNameMap);
        });
        initCPUInfo();
        initGPUInfo();
        initMemoryInfo();

    }

}

//LZX-Idea2023-2024-12-18-001
//LZX completed this api at 2024-12-18  11；46
//LoongLy Software 2025/07/16 Update
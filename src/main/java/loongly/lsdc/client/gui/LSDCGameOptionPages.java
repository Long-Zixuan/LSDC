package loongly.lsdc.client.gui;


import com.google.common.collect.ImmutableList;

import com.google.common.collect.ImmutableList;

import me.jellysquid.mods.sodium.client.gui.options.OptionFlag;
import me.jellysquid.mods.sodium.client.gui.options.OptionGroup;
import me.jellysquid.mods.sodium.client.gui.options.OptionImpl;
import me.jellysquid.mods.sodium.client.gui.options.OptionPage;
import me.jellysquid.mods.sodium.client.gui.options.control.ControlValueFormatter;
import me.jellysquid.mods.sodium.client.gui.options.control.SliderControl;
import me.jellysquid.mods.sodium.client.gui.options.control.TickBoxControl;

import net.minecraft.client.resource.language.I18n;

import loongly.lsdc.client.gui.options.storage.LSDCOptionsStorage;
import loongly.lsdc.api.SystemAndGLInfo;
import loongly.lsdc.client.LSDCClientMod;

import java.util.ArrayList;
import java.util.List;
public class LSDCGameOptionPages
{

    private static final LSDCOptionsStorage lsdcOpts = new LSDCOptionsStorage();

    static String buildInfoStr(String infoNameKey,String infoValue)
    {
        return I18n.translate(infoNameKey)+":"+infoValue;
    }
    public static OptionPage cpuInfo()
    {
        List<OptionGroup> groups = new ArrayList<>();
        initCPUPages( groups);
        return new OptionPage(I18n.translate("CPU Info"), ImmutableList.copyOf(groups));
    }

    static void initCPUPages(List<OptionGroup> groups)
    {
        groups.add(OptionGroup.createBuilder()
                .add(OptionImpl.createBuilder(boolean.class, lsdcOpts)
                        .setName(I18n.translate("CPU Info"))
                        .setTooltip(I18n.translate("CPU Info"))
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> LSDCClientMod.caiDan(), opts -> true)
                        // .setImpact(OptionImpact.LOW)
                        .setFlags(OptionFlag.REQUIRES_RENDERER_RELOAD)
                        .build())
                .add(OptionImpl.createBuilder(boolean.class, lsdcOpts)
                        .setName(I18n.translate(SystemAndGLInfo.getInstance().getCpuInfo().getName()))
                        .setTooltip(I18n.translate("CPU Name"))
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> LSDCClientMod.caiDan(), opts -> true)
                        // .setImpact(OptionImpact.LOW)
                        .setFlags(OptionFlag.REQUIRES_RENDERER_RELOAD)
                        .build())
                .add(OptionImpl.createBuilder(boolean.class, lsdcOpts)
                        .setName(buildInfoStr("Vendor",
                                String.valueOf(SystemAndGLInfo.getInstance().getCpuInfo().getVendor())))
                        .setTooltip(I18n.translate("Vendor"))
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> LSDCClientMod.caiDan(), opts -> true)
                        .setFlags(OptionFlag.REQUIRES_RENDERER_RELOAD)
                        .build())
                .add(OptionImpl.createBuilder(boolean.class, lsdcOpts)
                        .setName(buildInfoStr("Number of Cores",
                                String.valueOf(SystemAndGLInfo.getInstance().getCpuInfo().getCores())))
                        .setTooltip(I18n.translate("Number of Cores"))
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> LSDCClientMod.caiDan(), opts -> true)
                        .setFlags(OptionFlag.REQUIRES_RENDERER_RELOAD)
                        .build())
                .add(OptionImpl.createBuilder(boolean.class, lsdcOpts)
                        .setName(buildInfoStr("Number of Threads",
                                String.valueOf(SystemAndGLInfo.getInstance().getCpuInfo().getThreads())))
                        .setTooltip(I18n.translate("Number of Threads"))
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> LSDCClientMod.caiDan(), opts -> true)
                        .setFlags(OptionFlag.REQUIRES_RENDERER_RELOAD)
                        .build())
                .add(OptionImpl.createBuilder(boolean.class, lsdcOpts)
                        .setName(buildInfoStr("Frequency",
                                String.format( "%.2f",
                                        (float)SystemAndGLInfo.getInstance().getCpuInfo().getFrequency() / 1000000000.0f) + "GHz"))
                        .setTooltip(I18n.translate("Frequency"))
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> LSDCClientMod.caiDan(), opts -> true)
                        .setFlags(OptionFlag.REQUIRES_RENDERER_RELOAD)
                        .build())
                .build());
    }

    public static OptionPage gpuInfo()
    {
        List<OptionGroup> groups = new ArrayList<>();
        initGPUPages( groups);
        return new OptionPage(I18n.translate("GPU Info"), ImmutableList.copyOf(groups));
    }

    static void initGPUPages(List<OptionGroup> groups)
    {
        groups.add(OptionGroup.createBuilder()
                .add(OptionImpl.createBuilder(boolean.class, lsdcOpts)
                        .setName(I18n.translate("GPU Info"))
                        .setTooltip(I18n.translate("GPU Info"))
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> LSDCClientMod.caiDan(), opts -> true)
                        .setFlags(OptionFlag.REQUIRES_RENDERER_RELOAD)
                        .build())
                .build());
        for(int i = 0 ; i < SystemAndGLInfo.getInstance().getGpuInfoList().size() ; i++){
            groups.add(OptionGroup.createBuilder()
                    .add(OptionImpl.createBuilder(boolean.class, lsdcOpts)
                            .setName(I18n.translate("GPU")+" "+ Integer.toString(i + 1))
                            .setTooltip(I18n.translate("GPU")+" "+ Integer.toString(i + 1))
                            .setControl(TickBoxControl::new)
                            .setBinding((opts, value) -> LSDCClientMod.caiDan(), opts -> true)
                            .setFlags(OptionFlag.REQUIRES_RENDERER_RELOAD)
                            .build())
                    .add(OptionImpl.createBuilder(boolean.class, lsdcOpts)
                            .setName(I18n.translate(SystemAndGLInfo.getInstance().getGpuInfoList().get(i).getName()))
                            .setTooltip(I18n.translate("GPU Name"))
                            .setControl(TickBoxControl::new)
                            .setBinding((opts, value) -> LSDCClientMod.caiDan(), opts -> true)
                            .setFlags(OptionFlag.REQUIRES_RENDERER_RELOAD)
                            .build())
                    .add(OptionImpl.createBuilder(boolean.class, lsdcOpts)
                            .setName(buildInfoStr("Vendor",
                                    SystemAndGLInfo.getInstance().getGpuInfoList().get(i).getVendor()))
                            .setTooltip(I18n.translate("Vendor"))
                            .setControl(TickBoxControl::new)
                            .setBinding((opts, value) -> LSDCClientMod.caiDan(), opts -> true)
                            .setFlags(OptionFlag.REQUIRES_RENDERER_RELOAD)
                            .build())
                    .add(OptionImpl.createBuilder(boolean.class, lsdcOpts)
                            .setName(buildInfoStr("VRAM",
                                    String.format("%.2f",SystemAndGLInfo.getInstance().getGpuInfoList().get(i).getVRam())+"GB"))
                            .setTooltip(I18n.translate("VRAM"))
                            .setControl(TickBoxControl::new)
                            .setBinding((opts, value) -> LSDCClientMod.caiDan(), opts -> true)
                            .setFlags(OptionFlag.REQUIRES_RENDERER_RELOAD)
                            .build())
                    .build());
        }
    }

    public static OptionPage memoryInfo()
    {
        List<OptionGroup> groups = new ArrayList<>();
        initMemoryPages( groups);
        return new OptionPage(I18n.translate("RAM Info"), ImmutableList.copyOf(groups));
    }

    static void initMemoryPages(List<OptionGroup> groups)
    {
        groups.add(OptionGroup.createBuilder()
                .add(OptionImpl.createBuilder(boolean.class, lsdcOpts)
                        .setName(I18n.translate("RAM Info"))
                        .setTooltip(I18n.translate("RAM Info"))
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> LSDCClientMod.caiDan(), opts -> true)
                        //   .setImpact(OptionImpact.LOW)
                        .setFlags(OptionFlag.REQUIRES_RENDERER_RELOAD)
                        .build())
                .build());
        groups.add(OptionGroup.createBuilder()
                .add(OptionImpl.createBuilder(boolean.class, lsdcOpts)
                        .setName(I18n.translate("JVM Total RAM"))
                        .setTooltip(I18n.translate("RAM Name"))
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> LSDCClientMod.caiDan(), opts -> true)
                        //      .setImpact(OptionImpact.LOW)
                        .setFlags(OptionFlag.REQUIRES_RENDERER_RELOAD)
                        .build())
                .add(OptionImpl.createBuilder(boolean.class, lsdcOpts)
                        .setName(buildInfoStr("RAM Size",
                                String.format("%.2f",SystemAndGLInfo.getInstance().getJVMTotalMemory()) +"MB"))
                        .setTooltip(I18n.translate("RAM Size"))
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> LSDCClientMod.caiDan(), opts -> true)
                        //   .setImpact(OptionImpact.LOW)
                        .setFlags(OptionFlag.REQUIRES_RENDERER_RELOAD)
                        .build())
                .build());
        for(int i = 0 ; i < SystemAndGLInfo.getInstance().getMemoryInfoList().size() ; i++){
            groups.add(OptionGroup.createBuilder()
                    .add(OptionImpl.createBuilder(boolean.class, lsdcOpts)
                            .setName(I18n.translate("RAM")+" "+Integer.toString(i + 1))
                            .setTooltip(I18n.translate("RAM")+" "+Integer.toString(i + 1))
                            .setControl(TickBoxControl::new)
                            .setBinding((opts, value) -> LSDCClientMod.caiDan(), opts -> true)
                            //    .setImpact(OptionImpact.LOW)
                            .setFlags(OptionFlag.REQUIRES_RENDERER_RELOAD)
                            .build())
                    .add(OptionImpl.createBuilder(boolean.class, lsdcOpts)
                            .setName(I18n.translate(SystemAndGLInfo.getInstance().getMemoryInfoList().get(i).getName()) )
                            .setTooltip(I18n.translate("RAM Name"))
                            .setControl(TickBoxControl::new)
                            .setBinding((opts, value) -> LSDCClientMod.caiDan(), opts -> true)
                            //    .setImpact(OptionImpact.LOW)
                            .setFlags(OptionFlag.REQUIRES_RENDERER_RELOAD)
                            .build())
                    .add(OptionImpl.createBuilder(boolean.class, lsdcOpts)
                            .setName(buildInfoStr("Vendor",
                                    SystemAndGLInfo.getInstance().getMemoryInfoList().get(i).getVendor()))
                            .setTooltip(I18n.translate("Vendor"))
                            .setControl(TickBoxControl::new)
                            .setBinding((opts, value) -> LSDCClientMod.caiDan(), opts -> true)
                            .setFlags(OptionFlag.REQUIRES_RENDERER_RELOAD)
                            .build())
                    .add(OptionImpl.createBuilder(boolean.class, lsdcOpts)
                            .setName(buildInfoStr("RAM Size",
                                    String.format("%.2f",SystemAndGLInfo.getInstance().getMemoryInfoList().get(i).getSize()) +"MB"))
                            .setTooltip(I18n.translate("RAM Size"))
                            .setControl(TickBoxControl::new)
                            .setBinding((opts, value) -> LSDCClientMod.caiDan(), opts -> true)
                            //    .setImpact(OptionImpact.LOW)
                            .setFlags(OptionFlag.REQUIRES_RENDERER_RELOAD)
                            .build())
                    .add(OptionImpl.createBuilder(boolean.class, lsdcOpts)
                            .setName(buildInfoStr("Clock Speed",
                                    String.format("%.2f",SystemAndGLInfo.getInstance().getMemoryInfoList().get(i).getClockSpeed())+"GHz"))
                            .setTooltip(I18n.translate("Clock Speed"))
                            .setControl(TickBoxControl::new)
                            .setBinding((opts, value) -> LSDCClientMod.caiDan(), opts -> true)
                            // .setImpact(OptionImpact.LOW)
                            .setFlags(OptionFlag.REQUIRES_RENDERER_RELOAD)
                            .build())
                    .build());
        }
    }
    public static OptionPage softInfo()
    {
        List<OptionGroup> groups = new ArrayList<>();
        initSoftPages( groups);
        return new OptionPage(I18n.translate("Device Info"), ImmutableList.copyOf(groups));
    }

    static void initSoftPages(List<OptionGroup> groups)
    {
        groups.add(OptionGroup.createBuilder()
                .add(OptionImpl.createBuilder(boolean.class, lsdcOpts)
                        .setName(I18n.translate("Enable simplified UI"))
                        .setTooltip(I18n.translate("If you have installed the “Sodium Extra” or “Reese's Sodium Options” modules, you can enable this option. If you have not installed the above modules, the information will not be fully displayed after enabling this option. This option will take effect when this interface is reopened(You have't install Fabric API!)"))
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> opts.isSimpUI = value, opts -> opts.isSimpUI)
                        .setFlags(OptionFlag.REQUIRES_RENDERER_RELOAD)
                        .build())
                .build());
        groups.add(OptionGroup.createBuilder()
                .add(OptionImpl.createBuilder(boolean.class, lsdcOpts)
                        .setName(I18n.translate("OS Info"))
                        .setTooltip(I18n.translate("OS Info"))
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> LSDCClientMod.caiDan(), opts -> true)
                        // .setImpact(OptionImpact.LOW)
                        .setFlags(OptionFlag.REQUIRES_RENDERER_RELOAD)
                        .build())
                .add(OptionImpl.createBuilder(boolean.class, lsdcOpts)
                        .setName(buildInfoStr("OS Name",
                                SystemAndGLInfo.getInstance().getOSName()))
                        .setTooltip(I18n.translate("OS Name"))
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> LSDCClientMod.caiDan(), opts -> true)
                        // .setImpact(OptionImpact.LOW)
                        .setFlags(OptionFlag.REQUIRES_RENDERER_RELOAD)
                        .build())
                .add(OptionImpl.createBuilder(boolean.class, lsdcOpts)
                        .setName(buildInfoStr("OS Version",
                                SystemAndGLInfo.getInstance().getOSVersion()))
                        .setTooltip(I18n.translate("OS Version"))
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> LSDCClientMod.caiDan(), opts -> true)
                        // .setImpact(OptionImpact.LOW)
                        .setFlags(OptionFlag.REQUIRES_RENDERER_RELOAD)
                        .build())
                .build());
        groups.add(OptionGroup.createBuilder()
                .add(OptionImpl.createBuilder(boolean.class, lsdcOpts)
                        .setName(I18n.translate("Java Info"))
                        .setTooltip(I18n.translate("Java Info"))
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> LSDCClientMod.caiDan(), opts -> true)
                        // .setImpact(OptionImpact.LOW)
                        .setFlags(OptionFlag.REQUIRES_RENDERER_RELOAD)
                        .build())
                .add(OptionImpl.createBuilder(boolean.class, lsdcOpts)
                        .setName(buildInfoStr("Java Version",SystemAndGLInfo.getInstance().getJDKVersion()))
                        .setTooltip(I18n.translate("Java Version"))
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> LSDCClientMod.caiDan(), opts -> true)
                        // .setImpact(OptionImpact.LOW)
                        .setFlags(OptionFlag.REQUIRES_RENDERER_RELOAD)
                        .build())
                .build());
        groups.add(OptionGroup.createBuilder()
                .add(OptionImpl.createBuilder(boolean.class, lsdcOpts)
                        .setName(I18n.translate("OpenGL Info"))
                        .setTooltip(I18n.translate("OpenGL Info"))
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> LSDCClientMod.caiDan(), opts -> true)
                        // .setImpact(OptionImpact.LOW)
                        .setFlags(OptionFlag.REQUIRES_RENDERER_RELOAD)
                        .build())
                .add(OptionImpl.createBuilder(boolean.class, lsdcOpts)
                        .setName(buildInfoStr("OpenGL Version",SystemAndGLInfo.getInstance().getGLVersion()))
                        .setTooltip(I18n.translate("OpenGL Version"))
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> LSDCClientMod.caiDan(), opts -> true)
                        // .setImpact(OptionImpact.LOW)
                        .setFlags(OptionFlag.REQUIRES_RENDERER_RELOAD)
                        .build())
                .build());
    }
    public static OptionPage lsdc()
    {
        List<OptionGroup> groups = new ArrayList<>();
        initSoftPages( groups);
        initCPUPages( groups);
        initGPUPages( groups);
        initMemoryPages( groups);
        return new OptionPage(I18n.translate("Device Info"), ImmutableList.copyOf(groups));
    }

}

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
    public static OptionPage cpuInfo()
    {
        List<OptionGroup> groups = new ArrayList<>();
        initCPUPages( groups);
        return new OptionPage(I18n.translate("sodium.options.pages.cpuinfo"), ImmutableList.copyOf(groups));
    }

    static void initCPUPages(List<OptionGroup> groups)
    {
        groups.add(OptionGroup.createBuilder()
                .add(OptionImpl.createBuilder(boolean.class, lsdcOpts)
                        .setName(I18n.translate("sodium.options.pages.cpuinfo"))
                        .setTooltip(I18n.translate("sodium.options.pages.cpuinfo"))
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> LSDCClientMod.caiDan(), opts -> true)
                        // .setImpact(OptionImpact.LOW)
                        .setFlags(OptionFlag.REQUIRES_RENDERER_RELOAD)
                        .build())
                .add(OptionImpl.createBuilder(boolean.class, lsdcOpts)
                        .setName(I18n.translate(SystemAndGLInfo.getInstance().cpuInfo.getName()))
                        .setTooltip(I18n.translate("sodium.cpuInfo.name"))
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> LSDCClientMod.caiDan(), opts -> true)
                        // .setImpact(OptionImpact.LOW)
                        .setFlags(OptionFlag.REQUIRES_RENDERER_RELOAD)
                        .build())
                .add(OptionImpl.createBuilder(boolean.class, lsdcOpts)
                        .setName(I18n.translate(SystemAndGLInfo.getInstance().cpuInfo.getVendor()))
                        .setTooltip(I18n.translate("sodium.hardware.vendor"))
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> LSDCClientMod.caiDan(), opts -> true)
                        //   .setImpact(OptionImpact.LOW)
                        .setFlags(OptionFlag.REQUIRES_RENDERER_RELOAD)
                        .build())
                .add(OptionImpl.createBuilder(boolean.class, lsdcOpts)
                        .setName(I18n.translate(String.valueOf(SystemAndGLInfo.getInstance().cpuInfo.getCores())))
                        .setTooltip(I18n.translate("sodium.cpuInfo.cores"))
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> LSDCClientMod.caiDan(), opts -> true)
                        //  .setImpact(OptionImpact.LOW)
                        .setFlags(OptionFlag.REQUIRES_RENDERER_RELOAD)
                        .build())
                .add(OptionImpl.createBuilder(boolean.class, lsdcOpts)
                        .setName(I18n.translate(String.valueOf(SystemAndGLInfo.getInstance().cpuInfo.getThreads())))
                        .setTooltip(I18n.translate("sodium.cpuInfo.threads"))
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> LSDCClientMod.caiDan(), opts -> true)
                        //     .setImpact(OptionImpact.LOW)
                        .setFlags(OptionFlag.REQUIRES_RENDERER_RELOAD)
                        .build())
                .add(OptionImpl.createBuilder(boolean.class, lsdcOpts)
                        .setName(I18n.translate(String.format( "%.2f",(float)SystemAndGLInfo.getInstance().cpuInfo.getFrequency() / 1000000000.0f) + "GHz"))
                        .setTooltip(I18n.translate("sodium.cpuInfo.frequency"))
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> LSDCClientMod.caiDan(), opts -> true)
                        //    .setImpact(OptionImpact.LOW)
                        .setFlags(OptionFlag.REQUIRES_RENDERER_RELOAD)
                        .build())
                .build());
    }

    public static OptionPage gpuInfo()
    {
        List<OptionGroup> groups = new ArrayList<>();
        initGPUPages( groups);
        return new OptionPage(I18n.translate("sodium.options.pages.gpuinfo"), ImmutableList.copyOf(groups));
    }

    static void initGPUPages(List<OptionGroup> groups)
    {
        groups.add(OptionGroup.createBuilder()
                .add(OptionImpl.createBuilder(boolean.class, lsdcOpts)
                        .setName(I18n.translate("sodium.options.pages.gpuinfo"))
                        .setTooltip(I18n.translate("sodium.options.pages.gpuinfo"))
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> LSDCClientMod.caiDan(), opts -> true)
                        //   .setImpact(OptionImpact.LOW)
                        .setFlags(OptionFlag.REQUIRES_RENDERER_RELOAD)
                        .build())
                .build());
        for(int i = 0 ; i < SystemAndGLInfo.getInstance().gpuInfoList.size() ; i++){
            groups.add(OptionGroup.createBuilder()
                    .add(OptionImpl.createBuilder(boolean.class, lsdcOpts)
                            .setName(I18n.translate(SystemAndGLInfo.getInstance().gpuInfoList.get(i).getName()))
                            .setTooltip(I18n.translate("sodium.gpuInfo.name"))
                            .setControl(TickBoxControl::new)
                            .setBinding((opts, value) -> LSDCClientMod.caiDan(), opts -> true)
                            //   .setImpact(OptionImpact.LOW)
                            .setFlags(OptionFlag.REQUIRES_RENDERER_RELOAD)
                            .build())
                    .add(OptionImpl.createBuilder(boolean.class, lsdcOpts)
                            .setName(I18n.translate(SystemAndGLInfo.getInstance().gpuInfoList.get(i).getVendor()) )
                            .setTooltip(I18n.translate("sodium.hardware.vendor"))
                            .setControl(TickBoxControl::new)
                            .setBinding((opts, value) -> LSDCClientMod.caiDan(), opts -> true)
                            //     .setImpact(OptionImpact.LOW)
                            .setFlags(OptionFlag.REQUIRES_RENDERER_RELOAD)
                            .build())
                    .add(OptionImpl.createBuilder(boolean.class, lsdcOpts)
                            .setName(I18n.translate(String.format("%.2f",SystemAndGLInfo.getInstance().gpuInfoList.get(i).getVRam())+"GB"))
                            .setTooltip(I18n.translate("sodium.gpuInfo.vram"))
                            .setControl(TickBoxControl::new)
                            .setBinding((opts, value) -> LSDCClientMod.caiDan(), opts -> true)
                            //    .setImpact(OptionImpact.LOW)
                            .setFlags(OptionFlag.REQUIRES_RENDERER_RELOAD)
                            .build())
                    .build());
        }
    }

    public static OptionPage memoryInfo()
    {
        List<OptionGroup> groups = new ArrayList<>();
        initMemoryPages( groups);
        return new OptionPage(I18n.translate("sodium.options.pages.memoryInfo"), ImmutableList.copyOf(groups));
    }

    static void initMemoryPages(List<OptionGroup> groups)
    {
        groups.add(OptionGroup.createBuilder()
                .add(OptionImpl.createBuilder(boolean.class, lsdcOpts)
                        .setName(I18n.translate("sodium.options.pages.memoryInfo"))
                        .setTooltip(I18n.translate("sodium.options.pages.memoryInfo"))
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> LSDCClientMod.caiDan(), opts -> true)
                        //   .setImpact(OptionImpact.LOW)
                        .setFlags(OptionFlag.REQUIRES_RENDERER_RELOAD)
                        .build())
                .build());
        groups.add(OptionGroup.createBuilder()
                .add(OptionImpl.createBuilder(boolean.class, lsdcOpts)
                        .setName(I18n.translate("sodium.memoryInfo.jvmTol"))
                        .setTooltip(I18n.translate("sodium.memoryInfo.name"))
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> LSDCClientMod.caiDan(), opts -> true)
                        //      .setImpact(OptionImpact.LOW)
                        .setFlags(OptionFlag.REQUIRES_RENDERER_RELOAD)
                        .build())
                .add(OptionImpl.createBuilder(boolean.class, lsdcOpts)
                        .setName(I18n.translate(String.format("%.2f",SystemAndGLInfo.getInstance().getJVMTotalMemory()) +"MB"))
                        .setTooltip(I18n.translate("sodium.memoryInfo.size"))
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> LSDCClientMod.caiDan(), opts -> true)
                        //   .setImpact(OptionImpact.LOW)
                        .setFlags(OptionFlag.REQUIRES_RENDERER_RELOAD)
                        .build())
                .build());
        for(int i = 0 ; i < SystemAndGLInfo.getInstance().memoryInfoList.size() ; i++){
            groups.add(OptionGroup.createBuilder()
                    .add(OptionImpl.createBuilder(boolean.class, lsdcOpts)
                            .setName(I18n.translate(SystemAndGLInfo.getInstance().memoryInfoList.get(i).getName()) )
                            .setTooltip(I18n.translate("sodium.memoryInfo.name"))
                            .setControl(TickBoxControl::new)
                            .setBinding((opts, value) -> LSDCClientMod.caiDan(), opts -> true)
                            //    .setImpact(OptionImpact.LOW)
                            .setFlags(OptionFlag.REQUIRES_RENDERER_RELOAD)
                            .build())
                    .add(OptionImpl.createBuilder(boolean.class, lsdcOpts)
                            .setName(I18n.translate(SystemAndGLInfo.getInstance().memoryInfoList.get(i).getVendor()))
                            .setTooltip(I18n.translate("sodium.hardware.vendor"))
                            .setControl(TickBoxControl::new)
                            .setBinding((opts, value) -> LSDCClientMod.caiDan(), opts -> true)
                            //    .setImpact(OptionImpact.LOW)
                            .setFlags(OptionFlag.REQUIRES_RENDERER_RELOAD)
                            .build())
                    .add(OptionImpl.createBuilder(boolean.class, lsdcOpts)
                            .setName(I18n.translate(String.format("%.2f",SystemAndGLInfo.getInstance().memoryInfoList.get(i).getSize()) +"MB"))
                            .setTooltip(I18n.translate("sodium.memoryInfo.size"))
                            .setControl(TickBoxControl::new)
                            .setBinding((opts, value) -> LSDCClientMod.caiDan(), opts -> true)
                            //    .setImpact(OptionImpact.LOW)
                            .setFlags(OptionFlag.REQUIRES_RENDERER_RELOAD)
                            .build())
                    .add(OptionImpl.createBuilder(boolean.class, lsdcOpts)
                            .setName(I18n.translate(String.format("%.2f",SystemAndGLInfo.getInstance().memoryInfoList.get(i).getClockSpeed())+"GHz"))
                            .setTooltip(I18n.translate("sodium.memoryInfo.clockSpeed"))
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
        return new OptionPage(I18n.translate("sodium.options.pages.lsdc"), ImmutableList.copyOf(groups));
    }

    static void initSoftPages(List<OptionGroup> groups)
    {
        groups.add(OptionGroup.createBuilder()
                .add(OptionImpl.createBuilder(boolean.class, lsdcOpts)
                        .setName(I18n.translate("sodium.options.pages.simpleUI"))
                        .setTooltip(I18n.translate("sodium.options.pages.simpleUITooltip"))
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> opts.isSimpUI = value, opts -> opts.isSimpUI)
                        .setFlags(OptionFlag.REQUIRES_RENDERER_RELOAD)
                        .build())
                .build());
        groups.add(OptionGroup.createBuilder()
                .add(OptionImpl.createBuilder(boolean.class, lsdcOpts)
                        .setName(I18n.translate("sodium.options.pages.sysinfo"))
                        .setTooltip(I18n.translate("sodium.options.pages.sysinfo"))
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> LSDCClientMod.caiDan(), opts -> true)
                        // .setImpact(OptionImpact.LOW)
                        .setFlags(OptionFlag.REQUIRES_RENDERER_RELOAD)
                        .build())
                .add(OptionImpl.createBuilder(boolean.class, lsdcOpts)
                        .setName(I18n.translate(SystemAndGLInfo.getInstance().getOSInfo()))
                        .setTooltip(I18n.translate("sodium.options.pages.sysname"))
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> LSDCClientMod.caiDan(), opts -> true)
                        // .setImpact(OptionImpact.LOW)
                        .setFlags(OptionFlag.REQUIRES_RENDERER_RELOAD)
                        .build())
                .build());
        groups.add(OptionGroup.createBuilder()
                .add(OptionImpl.createBuilder(boolean.class, lsdcOpts)
                        .setName(I18n.translate("sodium.options.pages.jdkinfo"))
                        .setTooltip(I18n.translate("sodium.options.pages.jdkinfo"))
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> LSDCClientMod.caiDan(), opts -> true)
                        // .setImpact(OptionImpact.LOW)
                        .setFlags(OptionFlag.REQUIRES_RENDERER_RELOAD)
                        .build())
                .add(OptionImpl.createBuilder(boolean.class, lsdcOpts)
                        .setName(I18n.translate(SystemAndGLInfo.getInstance().getJDKVersion()))
                        .setTooltip(I18n.translate("sodium.options.pages.jdkversion"))
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> LSDCClientMod.caiDan(), opts -> true)
                        // .setImpact(OptionImpact.LOW)
                        .setFlags(OptionFlag.REQUIRES_RENDERER_RELOAD)
                        .build())
                .build());
        groups.add(OptionGroup.createBuilder()
                .add(OptionImpl.createBuilder(boolean.class, lsdcOpts)
                        .setName(I18n.translate("sodium.options.pages.glinfo"))
                        .setTooltip(I18n.translate("sodium.options.pages.glinfo"))
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> LSDCClientMod.caiDan(), opts -> true)
                        // .setImpact(OptionImpact.LOW)
                        .setFlags(OptionFlag.REQUIRES_RENDERER_RELOAD)
                        .build())
                .add(OptionImpl.createBuilder(boolean.class, lsdcOpts)
                        .setName(I18n.translate(SystemAndGLInfo.getInstance().getGLVersion()))
                        .setTooltip(I18n.translate("sodium.options.pages.glversion"))
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
        return new OptionPage(I18n.translate("sodium.options.pages.lsdc"), ImmutableList.copyOf(groups));
    }

}

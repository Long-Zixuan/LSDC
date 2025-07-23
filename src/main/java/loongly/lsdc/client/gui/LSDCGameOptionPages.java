package loongly.lsdc.client.gui;

import com.google.common.collect.ImmutableList;

import me.jellysquid.mods.sodium.client.gui.options.OptionFlag;
import me.jellysquid.mods.sodium.client.gui.options.OptionGroup;
import me.jellysquid.mods.sodium.client.gui.options.OptionImpl;
import me.jellysquid.mods.sodium.client.gui.options.OptionPage;
import me.jellysquid.mods.sodium.client.gui.options.control.ControlValueFormatter;
import me.jellysquid.mods.sodium.client.gui.options.control.SliderControl;
import me.jellysquid.mods.sodium.client.gui.options.control.TickBoxControl;

import net.minecraft.text.TranslatableText;

import loongly.lsdc.client.gui.options.storage.LSDCOptionsStorage;

import java.util.ArrayList;
import java.util.List;

import loongly.lsdc.api.system.SystemAndGLInfo;
import loongly.lsdc.client.LSDCClientMod;


public class LSDCGameOptionPages {

    private static final LSDCOptionsStorage lsdcOpts = new LSDCOptionsStorage();

    public static OptionPage cpuInfo()
    {
        List<OptionGroup> groups = new ArrayList<>();
        initCPUPages( groups);
        return new OptionPage(new TranslatableText("sodium.options.pages.cpuinfo"), ImmutableList.copyOf(groups));
    }

    static TranslatableText buildInfoComponent(String infoNameKey,String infoValue)
    {
        return new TranslatableText(new TranslatableText(infoNameKey).getString() + ":"+infoValue);
    }

    static void initCPUPages(List<OptionGroup> groups)
    {
        groups.add(OptionGroup.createBuilder()
        .add(OptionImpl.createBuilder(boolean.class, lsdcOpts)
                        .setName(new TranslatableText("sodium.options.pages.cpuinfo"))
                        .setTooltip(new TranslatableText("sodium.options.pages.cpuinfo"))
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> LSDCClientMod.caiDan(), opts -> true)
                        // .setImpact(OptionImpact.LOW)
                        .setFlags(OptionFlag.REQUIRES_RENDERER_RELOAD)
                        .build())
                .add(OptionImpl.createBuilder(boolean.class, lsdcOpts)
                        .setName(new TranslatableText(SystemAndGLInfo.getInstance().getCpuInfo().getName()))
                        .setTooltip(new TranslatableText("sodium.cpuInfo.name"))
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> LSDCClientMod.caiDan(), opts -> true)
                        // .setImpact(OptionImpact.LOW)
                        .setFlags(OptionFlag.REQUIRES_RENDERER_RELOAD)
                        .build())
                .add(OptionImpl.createBuilder(boolean.class, lsdcOpts)
                        .setName(buildInfoComponent("sodium.hardware.vendor",
                                SystemAndGLInfo.getInstance().getCpuInfo().getVendor()))
                        .setTooltip(new TranslatableText("sodium.hardware.vendor"))
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> LSDCClientMod.caiDan(), opts -> true)
                        //   .setImpact(OptionImpact.LOW)
                        .setFlags(OptionFlag.REQUIRES_RENDERER_RELOAD)
                        .build())
                .add(OptionImpl.createBuilder(boolean.class, lsdcOpts)
                        .setName(buildInfoComponent("sodium.cpuInfo.cores",
                                String.valueOf(SystemAndGLInfo.getInstance().getCpuInfo().getCores())))
                        .setTooltip(new TranslatableText("sodium.cpuInfo.cores"))
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> LSDCClientMod.caiDan(), opts -> true)
                        .setFlags(OptionFlag.REQUIRES_RENDERER_RELOAD)
                        .build())
                .add(OptionImpl.createBuilder(boolean.class, lsdcOpts)
                        .setName(buildInfoComponent("sodium.cpuInfo.threads",
                                String.valueOf(SystemAndGLInfo.getInstance().getCpuInfo().getThreads())))
                        .setTooltip(new TranslatableText("sodium.cpuInfo.threads"))
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> LSDCClientMod.caiDan(), opts -> true)
                        //     .setImpact(OptionImpact.LOW)
                        .setFlags(OptionFlag.REQUIRES_RENDERER_RELOAD)
                        .build())
                .add(OptionImpl.createBuilder(boolean.class, lsdcOpts)
                        .setName(buildInfoComponent("sodium.cpuInfo.frequency",String.
                                format(String.format( "%.2f",
                                        (float)SystemAndGLInfo.getInstance().getCpuInfo().getFrequency() / 1000000000.0f) + "GHz")))
                        .setTooltip(new TranslatableText("sodium.cpuInfo.frequency"))
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
        return new OptionPage(new TranslatableText("sodium.options.pages.gpuinfo"), ImmutableList.copyOf(groups));
    }

    static void initGPUPages(List<OptionGroup> groups)
    {
        groups.add(OptionGroup.createBuilder()
                .add(OptionImpl.createBuilder(boolean.class, lsdcOpts)
                        .setName(new TranslatableText("sodium.options.pages.gpuinfo"))
                        .setTooltip(new TranslatableText("sodium.options.pages.gpuinfo"))
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> LSDCClientMod.caiDan(), opts -> true)
                        //   .setImpact(OptionImpact.LOW)
                        .setFlags(OptionFlag.REQUIRES_RENDERER_RELOAD)
                        .build())
                .build());
        for(int i = 0 ; i < SystemAndGLInfo.getInstance().getGpuInfoList().size() ; i++){
            groups.add(OptionGroup.createBuilder()
                    .add(OptionImpl.createBuilder(boolean.class, lsdcOpts)
                            .setName(new TranslatableText(new TranslatableText("sodium.gpu")
                                    .getString()+" "+Integer.toString(i + 1)))
                            .setTooltip(new TranslatableText(" "))
                            .setControl(TickBoxControl::new)
                            .setBinding((opts, value) -> LSDCClientMod.caiDan(), opts -> true)
                            //   .setImpact(OptionImpact.LOW)
                            .setFlags(OptionFlag.REQUIRES_RENDERER_RELOAD)
                            .build())
                    .add(OptionImpl.createBuilder(boolean.class, lsdcOpts)
                            .setName(new TranslatableText(SystemAndGLInfo.getInstance().getGpuInfoList().get(i).getName()))
                            .setTooltip(new TranslatableText("sodium.gpuInfo.name"))
                            .setControl(TickBoxControl::new)
                            .setBinding((opts, value) -> LSDCClientMod.caiDan(), opts -> true)
                            //   .setImpact(OptionImpact.LOW)
                            .setFlags(OptionFlag.REQUIRES_RENDERER_RELOAD)
                            .build())
                    .add(OptionImpl.createBuilder(boolean.class, lsdcOpts)
                            .setName(buildInfoComponent("sodium.hardware.vendor",
                                    SystemAndGLInfo.getInstance().getGpuInfoList().get(i).getVendor()))
                            .setTooltip(new TranslatableText("sodium.hardware.vendor"))
                            .setControl(TickBoxControl::new)
                            .setBinding((opts, value) -> LSDCClientMod.caiDan(), opts -> true)
                            //     .setImpact(OptionImpact.LOW)
                            .setFlags(OptionFlag.REQUIRES_RENDERER_RELOAD)
                            .build())
                    .add(OptionImpl.createBuilder(boolean.class, lsdcOpts)
                                    .setName(buildInfoComponent("sodium.gpuInfo.vram",String.format("%.2f",
                                            SystemAndGLInfo.getInstance().getGpuInfoList().get(i).getVRam())+"GB"))
                            .setTooltip(new TranslatableText("sodium.gpuInfo.vram"))
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
        return new OptionPage(new TranslatableText("sodium.options.pages.memoryInfo"), ImmutableList.copyOf(groups));
    }

    static void initMemoryPages(List<OptionGroup> groups)
    {
         groups.add(OptionGroup.createBuilder()
                .add(OptionImpl.createBuilder(boolean.class, lsdcOpts)
                        .setName(new TranslatableText("sodium.options.pages.memoryInfo"))
                        .setTooltip(new TranslatableText("sodium.options.pages.memoryInfo"))
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> LSDCClientMod.caiDan(), opts -> true)
                        .setFlags(OptionFlag.REQUIRES_RENDERER_RELOAD)
                        .build())
                .build());
        groups.add(OptionGroup.createBuilder()
                .add(OptionImpl.createBuilder(boolean.class, lsdcOpts)
                        .setName(new TranslatableText("sodium.memoryInfo.jvmTol"))
                        .setTooltip(new TranslatableText("sodium.memoryInfo.name"))
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> LSDCClientMod.caiDan(), opts -> true)
                        .setFlags(OptionFlag.REQUIRES_RENDERER_RELOAD)
                        .build())
                .add(OptionImpl.createBuilder(boolean.class, lsdcOpts)
                        .setName(buildInfoComponent("sodium.memoryInfo.size",
                                String.format("%.2f",SystemAndGLInfo.getInstance().getJVMTotalMemory()) +"MB"))
                        .setTooltip(new TranslatableText("sodium.memoryInfo.size"))
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> LSDCClientMod.caiDan(), opts -> true)
                        .setFlags(OptionFlag.REQUIRES_RENDERER_RELOAD)
                        .build())
                .build());
        for(int i = 0 ; i < SystemAndGLInfo.getInstance().getMemoryInfoList().size() ; i++){
            groups.add(OptionGroup.createBuilder()
                    .add(OptionImpl.createBuilder(boolean.class, lsdcOpts)
                            .setName(new TranslatableText( new TranslatableText("sodium.memnory")
                                    .getString()+" "+Integer.toString(i + 1)))
                            .setTooltip(new TranslatableText(" "))
                            .setControl(TickBoxControl::new)
                            .setBinding((opts, value) -> LSDCClientMod.caiDan(), opts -> true)
                            .setFlags(OptionFlag.REQUIRES_RENDERER_RELOAD)
                            .build())
                    .add(OptionImpl.createBuilder(boolean.class, lsdcOpts)
                            .setName(new TranslatableText(SystemAndGLInfo.getInstance().getMemoryInfoList().get(i).getName()) )
                            .setTooltip(new TranslatableText("sodium.memoryInfo.name"))
                            .setControl(TickBoxControl::new)
                            .setBinding((opts, value) -> LSDCClientMod.caiDan(), opts -> true)
                            //    .setImpact(OptionImpact.LOW)
                            .setFlags(OptionFlag.REQUIRES_RENDERER_RELOAD)
                            .build())
                    .add(OptionImpl.createBuilder(boolean.class, lsdcOpts)
                            .setName(buildInfoComponent("sodium.hardware.vendor",
                                    SystemAndGLInfo.getInstance().getMemoryInfoList().get(i).getVendor()))
                            .setTooltip(new TranslatableText("sodium.hardware.vendor"))
                            .setControl(TickBoxControl::new)
                            .setBinding((opts, value) -> LSDCClientMod.caiDan(), opts -> true)
                            .setFlags(OptionFlag.REQUIRES_RENDERER_RELOAD)
                            .build())
                    .add(OptionImpl.createBuilder(boolean.class, lsdcOpts)
                            .setName(buildInfoComponent("sodium.memoryInfo.size",
                                    String.format("%.2f", SystemAndGLInfo.getInstance().getMemoryInfoList().get(i).getSize()) +"MB"))
                            .setTooltip(new TranslatableText("sodium.memoryInfo.size"))
                            .setControl(TickBoxControl::new)
                            .setBinding((opts, value) -> LSDCClientMod.caiDan(), opts -> true)
                            .setFlags(OptionFlag.REQUIRES_RENDERER_RELOAD)
                            .build())
                    .add(OptionImpl.createBuilder(boolean.class, lsdcOpts)
                            .setName(buildInfoComponent("sodium.memoryInfo.clockSpeed",
                                    String.format("%.2f", SystemAndGLInfo.getInstance().getMemoryInfoList().get(i).getClockSpeed())+"GHz"))
                            .setTooltip(new TranslatableText("sodium.memoryInfo.clockSpeed"))
                            .setControl(TickBoxControl::new)
                            .setBinding((opts, value) -> LSDCClientMod.caiDan(), opts -> true)
                            .setFlags(OptionFlag.REQUIRES_RENDERER_RELOAD)
                            .build())
                    .build());
        }
    }
    public static OptionPage softInfo()
    {
        List<OptionGroup> groups = new ArrayList<>();
        initSoftPages( groups);
        return new OptionPage(new TranslatableText("sodium.options.pages.lsdc"), ImmutableList.copyOf(groups));
    }

    static void initSoftPages(List<OptionGroup> groups)
    {
        groups.add(OptionGroup.createBuilder()
                .add(OptionImpl.createBuilder(boolean.class, lsdcOpts)
                        .setName(new TranslatableText("sodium.options.pages.simpleUI"))
                        .setTooltip(new TranslatableText("sodium.options.pages.simpleUITooltip"))
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> opts.isSimpUI = value, opts -> opts.isSimpUI)
                        .setFlags(OptionFlag.REQUIRES_RENDERER_RELOAD)
                        .build())
                .build());
        groups.add(OptionGroup.createBuilder()
                .add(OptionImpl.createBuilder(boolean.class, lsdcOpts)
                        .setName(new TranslatableText("sodium.options.pages.sysinfo"))
                        .setTooltip(new TranslatableText("sodium.options.pages.sysinfo"))
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> LSDCClientMod.caiDan(), opts -> true)
                        .setFlags(OptionFlag.REQUIRES_RENDERER_RELOAD)
                        .build())
                .add(OptionImpl.createBuilder(boolean.class, lsdcOpts)
                        .setName(buildInfoComponent("sodium.options.pages.sysname",
                                SystemAndGLInfo.getInstance().getOSName()))
                        .setTooltip(new TranslatableText("sodium.options.pages.sysname"))
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> LSDCClientMod.caiDan(), opts -> true)
                        .setFlags(OptionFlag.REQUIRES_RENDERER_RELOAD)
                        .build())
                .add(OptionImpl.createBuilder(boolean.class, lsdcOpts)
                        .setName(buildInfoComponent("sodium.options.pages.sysversion",
                                SystemAndGLInfo.getInstance().getOSVersion()))
                        .setTooltip(new TranslatableText("sodium.options.pages.sysversion"))
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> LSDCClientMod.caiDan(), opts -> true)
                        .setFlags(OptionFlag.REQUIRES_RENDERER_RELOAD)
                        .build())
                .build());

        groups.add(OptionGroup.createBuilder()
                .add(OptionImpl.createBuilder(boolean.class, lsdcOpts)
                        .setName(new TranslatableText("sodium.options.pages.jdkinfo"))
                        .setTooltip(new TranslatableText("sodium.options.pages.jdkinfo"))
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> LSDCClientMod.caiDan(), opts -> true)
                        .setFlags(OptionFlag.REQUIRES_RENDERER_RELOAD)
                        .build())
                .add(OptionImpl.createBuilder(boolean.class, lsdcOpts)
                        .setName(buildInfoComponent("sodium.options.pages.jdkversion",
                                SystemAndGLInfo.getInstance().getJDKVersion()))
                        .setTooltip(new TranslatableText("sodium.options.pages.jdkversion"))
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> LSDCClientMod.caiDan(), opts -> true)
                        .setFlags(OptionFlag.REQUIRES_RENDERER_RELOAD)
                        .build())
                .build());
        groups.add(OptionGroup.createBuilder()
                .add(OptionImpl.createBuilder(boolean.class, lsdcOpts)
                        .setName(new TranslatableText("sodium.options.pages.glinfo"))
                        .setTooltip(new TranslatableText("sodium.options.pages.glinfo"))
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> LSDCClientMod.caiDan(), opts -> true)
                        .setFlags(OptionFlag.REQUIRES_RENDERER_RELOAD)
                        .build())
                .add(OptionImpl.createBuilder(boolean.class, lsdcOpts)
                        .setName(buildInfoComponent("sodium.options.pages.glversion",
                                SystemAndGLInfo.getInstance().getGLVersion()))
                        .setTooltip(new TranslatableText("sodium.options.pages.glversion"))
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> LSDCClientMod.caiDan(), opts -> true)
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
        return new OptionPage(new TranslatableText("sodium.options.pages.lsdc"), ImmutableList.copyOf(groups));
    }
}

//LoongLy Software Update 2025/07/21

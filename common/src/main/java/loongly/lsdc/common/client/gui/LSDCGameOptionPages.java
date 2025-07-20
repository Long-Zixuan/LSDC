package loongly.lsdc.common.client.gui;

import com.google.common.collect.ImmutableList;

import net.caffeinemc.mods.sodium.client.gui.options.OptionFlag;
import net.caffeinemc.mods.sodium.client.gui.options.OptionGroup;
import net.caffeinemc.mods.sodium.client.gui.options.OptionImpl;
import net.caffeinemc.mods.sodium.client.gui.options.OptionPage;
import net.caffeinemc.mods.sodium.client.gui.options.control.ControlValueFormatter;
import net.caffeinemc.mods.sodium.client.gui.options.control.SliderControl;
import net.caffeinemc.mods.sodium.client.gui.options.control.TickBoxControl;

import net.minecraft.network.chat.Component;

import loongly.lsdc.common.client.gui.options.storage.LSDCOptionsStorage;

import java.util.ArrayList;
import java.util.List;

import loongly.lsdc.common.api.system.SystemAndGLInfo;
import loongly.lsdc.common.client.LSDCClientMod;


public class LSDCGameOptionPages {

    private static final LSDCOptionsStorage lsdcOpts = new LSDCOptionsStorage();

    public static OptionPage cpuInfo()
    {
        List<OptionGroup> groups = new ArrayList<>();
        initCPUPages( groups);
        return new OptionPage(Component.translatable("sodium.options.pages.cpuinfo"), ImmutableList.copyOf(groups));
    }

    static void initCPUPages(List<OptionGroup> groups)
    {
        groups.add(OptionGroup.createBuilder()
        .add(OptionImpl.createBuilder(boolean.class, lsdcOpts)
                        .setName(Component.translatable("sodium.options.pages.cpuinfo"))
                        .setTooltip(Component.translatable("sodium.options.pages.cpuinfo"))
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> LSDCClientMod.caiDan(), opts -> true)
                        // .setImpact(OptionImpact.LOW)
                        .setFlags(OptionFlag.REQUIRES_RENDERER_RELOAD)
                        .build())
                .add(OptionImpl.createBuilder(boolean.class, lsdcOpts)
                        .setName(Component.translatable(SystemAndGLInfo.getInstance().getCpuInfo().getName()))
                        .setTooltip(Component.translatable("sodium.cpuInfo.name"))
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> LSDCClientMod.caiDan(), opts -> true)
                        // .setImpact(OptionImpact.LOW)
                        .setFlags(OptionFlag.REQUIRES_RENDERER_RELOAD)
                        .build())
                .add(OptionImpl.createBuilder(boolean.class, lsdcOpts)
                        .setName(Component.translatable("sodium.hardware.vendor").
                                append(Component.literal(":"+SystemAndGLInfo.getInstance().getCpuInfo().getVendor())))
                        .setTooltip(Component.translatable("sodium.hardware.vendor"))
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> LSDCClientMod.caiDan(), opts -> true)
                        //   .setImpact(OptionImpact.LOW)
                        .setFlags(OptionFlag.REQUIRES_RENDERER_RELOAD)
                        .build())
                .add(OptionImpl.createBuilder(boolean.class, lsdcOpts)
                        .setName(Component.translatable("sodium.cpuInfo.cores").
                                append(Component.literal(":" + String.valueOf(SystemAndGLInfo.getInstance().getCpuInfo().getCores()))))
                        .setTooltip(Component.translatable("sodium.cpuInfo.cores"))
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> LSDCClientMod.caiDan(), opts -> true)
                        //  .setImpact(OptionImpact.LOW)
                        .setFlags(OptionFlag.REQUIRES_RENDERER_RELOAD)
                        .build())
                .add(OptionImpl.createBuilder(boolean.class, lsdcOpts)
                        .setName(Component.translatable("sodium.cpuInfo.threads")
                                .append(Component.literal(String.valueOf(":" + SystemAndGLInfo.getInstance().getCpuInfo().getThreads()))))
                        .setTooltip(Component.translatable("sodium.cpuInfo.threads"))
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> LSDCClientMod.caiDan(), opts -> true)
                        //     .setImpact(OptionImpact.LOW)
                        .setFlags(OptionFlag.REQUIRES_RENDERER_RELOAD)
                        .build())
                .add(OptionImpl.createBuilder(boolean.class, lsdcOpts)
                        .setName(Component.translatable("sodium.cpuInfo.frequency")
                                .append(Component.literal(String.
                                        format(":"+String.format( "%.2f",
                                                (float)SystemAndGLInfo.getInstance().getCpuInfo().getFrequency() / 1000000000.0f) + "GHz"))))
                        .setTooltip(Component.translatable("sodium.cpuInfo.frequency"))
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
        return new OptionPage(Component.translatable("sodium.options.pages.gpuinfo"), ImmutableList.copyOf(groups));
    }

    static void initGPUPages(List<OptionGroup> groups)
    {
        groups.add(OptionGroup.createBuilder()
                .add(OptionImpl.createBuilder(boolean.class, lsdcOpts)
                        .setName(Component.translatable("sodium.options.pages.gpuinfo"))
                        .setTooltip(Component.translatable("sodium.options.pages.gpuinfo"))
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> LSDCClientMod.caiDan(), opts -> true)
                        //   .setImpact(OptionImpact.LOW)
                        .setFlags(OptionFlag.REQUIRES_RENDERER_RELOAD)
                        .build())
                .build());
        for(int i = 0 ; i < SystemAndGLInfo.getInstance().getGpuInfoList().size() ; i++){
            groups.add(OptionGroup.createBuilder()
                    .add(OptionImpl.createBuilder(boolean.class, lsdcOpts)
                            .setName(Component.translatable("sodium.gpu")
                                    .append(Component.literal(" "+Integer.toString(i + 1))))
                            .setTooltip(Component.translatable(" "))
                            .setControl(TickBoxControl::new)
                            .setBinding((opts, value) -> LSDCClientMod.caiDan(), opts -> true)
                            //   .setImpact(OptionImpact.LOW)
                            .setFlags(OptionFlag.REQUIRES_RENDERER_RELOAD)
                            .build())
                    .add(OptionImpl.createBuilder(boolean.class, lsdcOpts)
                            .setName(Component.translatable(SystemAndGLInfo.getInstance().getGpuInfoList().get(i).getName()))
                            .setTooltip(Component.translatable("sodium.gpuInfo.name"))
                            .setControl(TickBoxControl::new)
                            .setBinding((opts, value) -> LSDCClientMod.caiDan(), opts -> true)
                            //   .setImpact(OptionImpact.LOW)
                            .setFlags(OptionFlag.REQUIRES_RENDERER_RELOAD)
                            .build())
                    .add(OptionImpl.createBuilder(boolean.class, lsdcOpts)
                            .setName(Component.translatable("sodium.hardware.vendor").
                                    append(Component.literal(":"+SystemAndGLInfo.getInstance().getGpuInfoList().get(i).getVendor())))
                            .setTooltip(Component.translatable("sodium.hardware.vendor"))
                            .setControl(TickBoxControl::new)
                            .setBinding((opts, value) -> LSDCClientMod.caiDan(), opts -> true)
                            //     .setImpact(OptionImpact.LOW)
                            .setFlags(OptionFlag.REQUIRES_RENDERER_RELOAD)
                            .build())
                    .add(OptionImpl.createBuilder(boolean.class, lsdcOpts)
                            .setName(Component.translatable("sodium.gpuInfo.vram")
                                    .append(Component.literal(":"+String.format("%.2f",
                                            SystemAndGLInfo.getInstance().getGpuInfoList().get(i).getVRam())+"GB")))
                            .setTooltip(Component.translatable("sodium.gpuInfo.vram"))
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
        return new OptionPage(Component.translatable("sodium.options.pages.memoryInfo"), ImmutableList.copyOf(groups));
    }

    static void initMemoryPages(List<OptionGroup> groups)
    {
         groups.add(OptionGroup.createBuilder()
                .add(OptionImpl.createBuilder(boolean.class, lsdcOpts)
                        .setName(Component.translatable("sodium.options.pages.memoryInfo"))
                        .setTooltip(Component.translatable("sodium.options.pages.memoryInfo"))
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> LSDCClientMod.caiDan(), opts -> true)
                        //   .setImpact(OptionImpact.LOW)
                        .setFlags(OptionFlag.REQUIRES_RENDERER_RELOAD)
                        .build())
                .build());
        groups.add(OptionGroup.createBuilder()
                .add(OptionImpl.createBuilder(boolean.class, lsdcOpts)
                        .setName(Component.translatable("sodium.memoryInfo.jvmTol"))
                        .setTooltip(Component.translatable("sodium.memoryInfo.name"))
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> LSDCClientMod.caiDan(), opts -> true)
                        //      .setImpact(OptionImpact.LOW)
                        .setFlags(OptionFlag.REQUIRES_RENDERER_RELOAD)
                        .build())
                .add(OptionImpl.createBuilder(boolean.class, lsdcOpts)
                        .setName(Component.translatable("sodium.memoryInfo.size")
                                .append(Component.literal(":"+String.format("%.2f",SystemAndGLInfo.getInstance().getJVMTotalMemory()) +"MB")))
                        .setTooltip(Component.translatable("sodium.memoryInfo.size"))
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> LSDCClientMod.caiDan(), opts -> true)
                        //   .setImpact(OptionImpact.LOW)
                        .setFlags(OptionFlag.REQUIRES_RENDERER_RELOAD)
                        .build())
                .build());
        for(int i = 0 ; i < SystemAndGLInfo.getInstance().getMemoryInfoList().size() ; i++){
            groups.add(OptionGroup.createBuilder()
                    .add(OptionImpl.createBuilder(boolean.class, lsdcOpts)
                            .setName(Component.translatable("sodium.memnory")
                                    .append(Component.literal(" "+Integer.toString(i + 1))))
                            .setTooltip(Component.translatable(" "))
                            .setControl(TickBoxControl::new)
                            .setBinding((opts, value) -> LSDCClientMod.caiDan(), opts -> true)
                            //    .setImpact(OptionImpact.LOW)
                            .setFlags(OptionFlag.REQUIRES_RENDERER_RELOAD)
                            .build())
                    .add(OptionImpl.createBuilder(boolean.class, lsdcOpts)
                            .setName(Component.translatable(SystemAndGLInfo.getInstance().getMemoryInfoList().get(i).getName()) )
                            .setTooltip(Component.translatable("sodium.memoryInfo.name"))
                            .setControl(TickBoxControl::new)
                            .setBinding((opts, value) -> LSDCClientMod.caiDan(), opts -> true)
                            //    .setImpact(OptionImpact.LOW)
                            .setFlags(OptionFlag.REQUIRES_RENDERER_RELOAD)
                            .build())
                    .add(OptionImpl.createBuilder(boolean.class, lsdcOpts)
                            .setName(Component.translatable("sodium.hardware.vendor")
                                    .append(Component.literal(":"+SystemAndGLInfo.getInstance().getMemoryInfoList().get(i).getVendor())))
                            .setTooltip(Component.translatable("sodium.hardware.vendor"))
                            .setControl(TickBoxControl::new)
                            .setBinding((opts, value) -> LSDCClientMod.caiDan(), opts -> true)
                            //    .setImpact(OptionImpact.LOW)
                            .setFlags(OptionFlag.REQUIRES_RENDERER_RELOAD)
                            .build())
                    .add(OptionImpl.createBuilder(boolean.class, lsdcOpts)
                            .setName(Component.translatable("sodium.memoryInfo.size")
                                    .append(Component.literal(":"+String.format("%.2f",
                                            SystemAndGLInfo.getInstance().getMemoryInfoList().get(i).getSize()) +"MB")))
                            .setTooltip(Component.translatable("sodium.memoryInfo.size"))
                            .setControl(TickBoxControl::new)
                            .setBinding((opts, value) -> LSDCClientMod.caiDan(), opts -> true)
                            //    .setImpact(OptionImpact.LOW)
                            .setFlags(OptionFlag.REQUIRES_RENDERER_RELOAD)
                            .build())
                    .add(OptionImpl.createBuilder(boolean.class, lsdcOpts)
                            .setName(Component.translatable("sodium.memoryInfo.clockSpeed")
                                    .append(Component.literal(":"+String.format("%.2f",
                                            SystemAndGLInfo.getInstance().getMemoryInfoList().get(i).getClockSpeed())+"GHz")))
                            .setTooltip(Component.translatable("sodium.memoryInfo.clockSpeed"))
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
        return new OptionPage(Component.translatable("sodium.options.pages.lsdc"), ImmutableList.copyOf(groups));
    }

    static void initSoftPages(List<OptionGroup> groups)
    {
        groups.add(OptionGroup.createBuilder()
                .add(OptionImpl.createBuilder(boolean.class, lsdcOpts)
                        .setName(Component.translatable("sodium.options.pages.simpleUI"))
                        .setTooltip(Component.translatable("sodium.options.pages.simpleUITooltip"))
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> opts.isSimpUI = value, opts -> opts.isSimpUI)
                        .setFlags(OptionFlag.REQUIRES_RENDERER_RELOAD)
                        .build())
                .build());
        groups.add(OptionGroup.createBuilder()
                .add(OptionImpl.createBuilder(boolean.class, lsdcOpts)
                        .setName(Component.translatable("sodium.options.pages.sysinfo"))
                        .setTooltip(Component.translatable("sodium.options.pages.sysinfo"))
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> LSDCClientMod.caiDan(), opts -> true)
                        // .setImpact(OptionImpact.LOW)
                        .setFlags(OptionFlag.REQUIRES_RENDERER_RELOAD)
                        .build())
                .add(OptionImpl.createBuilder(boolean.class, lsdcOpts)
                        .setName(Component.translatable("sodium.options.pages.sysname")
                                .append(Component.literal(":"+SystemAndGLInfo.getInstance().getOSName())))
                        .setTooltip(Component.translatable("sodium.options.pages.sysname"))
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> LSDCClientMod.caiDan(), opts -> true)
                        // .setImpact(OptionImpact.LOW)
                        .setFlags(OptionFlag.REQUIRES_RENDERER_RELOAD)
                        .build())
                .add(OptionImpl.createBuilder(boolean.class, lsdcOpts)
                        .setName(Component.translatable("sodium.options.pages.sysversion")
                                .append(Component.literal(":"+SystemAndGLInfo.getInstance().getOSVersion())))
                        .setTooltip(Component.translatable("sodium.options.pages.sysversion"))
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> LSDCClientMod.caiDan(), opts -> true)
                        // .setImpact(OptionImpact.LOW)
                        .setFlags(OptionFlag.REQUIRES_RENDERER_RELOAD)
                        .build())
                .build());

        groups.add(OptionGroup.createBuilder()
                .add(OptionImpl.createBuilder(boolean.class, lsdcOpts)
                        .setName(Component.translatable("sodium.options.pages.jdkinfo"))
                        .setTooltip(Component.translatable("sodium.options.pages.jdkinfo"))
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> LSDCClientMod.caiDan(), opts -> true)
                        // .setImpact(OptionImpact.LOW)
                        .setFlags(OptionFlag.REQUIRES_RENDERER_RELOAD)
                        .build())
                .add(OptionImpl.createBuilder(boolean.class, lsdcOpts)
                        .setName(Component.translatable("sodium.options.pages.jdkversion")
                                .append(Component.literal(":"+SystemAndGLInfo.getInstance().getJDKVersion())))
                        .setTooltip(Component.translatable("sodium.options.pages.jdkversion"))
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> LSDCClientMod.caiDan(), opts -> true)
                        // .setImpact(OptionImpact.LOW)
                        .setFlags(OptionFlag.REQUIRES_RENDERER_RELOAD)
                        .build())
                .build());
        groups.add(OptionGroup.createBuilder()
                .add(OptionImpl.createBuilder(boolean.class, lsdcOpts)
                        .setName(Component.translatable("sodium.options.pages.glinfo"))
                        .setTooltip(Component.translatable("sodium.options.pages.glinfo"))
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> LSDCClientMod.caiDan(), opts -> true)
                        // .setImpact(OptionImpact.LOW)
                        .setFlags(OptionFlag.REQUIRES_RENDERER_RELOAD)
                        .build())
                .add(OptionImpl.createBuilder(boolean.class, lsdcOpts)
                        .setName(Component.translatable("sodium.options.pages.glversion")
                                .append(Component.literal(":"+SystemAndGLInfo.getInstance().getGLVersion())))
                        .setTooltip(Component.translatable("sodium.options.pages.glversion"))
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
        return new OptionPage(Component.translatable("sodium.options.pages.lsdc"), ImmutableList.copyOf(groups));
    }
}

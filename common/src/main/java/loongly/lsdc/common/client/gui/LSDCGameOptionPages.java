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
        groups.add(OptionGroup.createBuilder()
                .add(OptionImpl.createBuilder(boolean.class, lsdcOpts)
                        .setName(Component.translatable(SystemAndGLInfo.getInstance().cpuInfo.getName()))
                        .setTooltip(Component.translatable("sodium.cpuInfo.name"))
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> LSDCClientMod.caiDan(), opts -> true)
                       // .setImpact(OptionImpact.LOW)
                        .setFlags(OptionFlag.REQUIRES_RENDERER_RELOAD)
                        .build())
                .add(OptionImpl.createBuilder(boolean.class, lsdcOpts)
                        .setName(Component.translatable(SystemAndGLInfo.getInstance().cpuInfo.getVendor()))
                        .setTooltip(Component.translatable("sodium.hardware.vendor"))
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> LSDCClientMod.caiDan(), opts -> true)
                     //   .setImpact(OptionImpact.LOW)
                        .setFlags(OptionFlag.REQUIRES_RENDERER_RELOAD)
                        .build())
                .add(OptionImpl.createBuilder(boolean.class, lsdcOpts)
                        .setName(Component.translatable(String.valueOf(SystemAndGLInfo.getInstance().cpuInfo.getCores())))
                        .setTooltip(Component.translatable("sodium.cpuInfo.cores"))
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> LSDCClientMod.caiDan(), opts -> true)
                      //  .setImpact(OptionImpact.LOW)
                        .setFlags(OptionFlag.REQUIRES_RENDERER_RELOAD)
                        .build())
                .add(OptionImpl.createBuilder(boolean.class, lsdcOpts)
                        .setName(Component.translatable(String.valueOf(SystemAndGLInfo.getInstance().cpuInfo.getThreads())))
                        .setTooltip(Component.translatable("sodium.cpuInfo.threads"))
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> LSDCClientMod.caiDan(), opts -> true)
                   //     .setImpact(OptionImpact.LOW)
                        .setFlags(OptionFlag.REQUIRES_RENDERER_RELOAD)
                        .build())
                .add(OptionImpl.createBuilder(boolean.class, lsdcOpts)
                        .setName(Component.translatable(String.valueOf(SystemAndGLInfo.getInstance().cpuInfo.getFrequency()) + "GHz"))
                        .setTooltip(Component.translatable("sodium.cpuInfo.frequency"))
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> LSDCClientMod.caiDan(), opts -> true)
                    //    .setImpact(OptionImpact.LOW)
                        .setFlags(OptionFlag.REQUIRES_RENDERER_RELOAD)
                        .build())
                .build());
        return new OptionPage(Component.translatable("sodium.options.pages.cpuinfo"), ImmutableList.copyOf(groups));
    }

    public static OptionPage gpuInfo()
    {
        List<OptionGroup> groups = new ArrayList<>();
        for(int i = 0 ; i < SystemAndGLInfo.getInstance().gpuInfoList.size() ; i++){
            groups.add(OptionGroup.createBuilder()
                    .add(OptionImpl.createBuilder(boolean.class, lsdcOpts)
                            .setName(Component.translatable(SystemAndGLInfo.getInstance().gpuInfoList.get(i).getName()))
                            .setTooltip(Component.translatable("sodium.gpuInfo.name"))
                            .setControl(TickBoxControl::new)
                            .setBinding((opts, value) -> LSDCClientMod.caiDan(), opts -> true)
                         //   .setImpact(OptionImpact.LOW)
                            .setFlags(OptionFlag.REQUIRES_RENDERER_RELOAD)
                            .build())
                    .add(OptionImpl.createBuilder(boolean.class, lsdcOpts)
                            .setName(Component.translatable(SystemAndGLInfo.getInstance().gpuInfoList.get(i).getVendor()) )
                            .setTooltip(Component.translatable("sodium.hardware.vendor"))
                            .setControl(TickBoxControl::new)
                            .setBinding((opts, value) -> LSDCClientMod.caiDan(), opts -> true)
                       //     .setImpact(OptionImpact.LOW)
                            .setFlags(OptionFlag.REQUIRES_RENDERER_RELOAD)
                            .build())
                    .add(OptionImpl.createBuilder(boolean.class, lsdcOpts)
                            .setName(Component.translatable(String.format("%.2f",SystemAndGLInfo.getInstance().gpuInfoList.get(i).getVRam())+"GB"))
                            .setTooltip(Component.translatable("sodium.gpuInfo.vram"))
                            .setControl(TickBoxControl::new)
                            .setBinding((opts, value) -> LSDCClientMod.caiDan(), opts -> true)
                        //    .setImpact(OptionImpact.LOW)
                            .setFlags(OptionFlag.REQUIRES_RENDERER_RELOAD)
                            .build())
                    .build());
        }
        return new OptionPage(Component.translatable("sodium.options.pages.gpuinfo"), ImmutableList.copyOf(groups));
    }

    public static OptionPage memoryInfo()
    {
        List<OptionGroup> groups = new ArrayList<>();
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
                        .setName(Component.translatable(String.format("%.2f",SystemAndGLInfo.getInstance().getJVMTotalMemory()) +"MB"))
                        .setTooltip(Component.translatable("sodium.memoryInfo.size"))
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> LSDCClientMod.caiDan(), opts -> true)
                     //   .setImpact(OptionImpact.LOW)
                        .setFlags(OptionFlag.REQUIRES_RENDERER_RELOAD)
                        .build())
                .build());
        for(int i = 0 ; i < SystemAndGLInfo.getInstance().memoryInfoList.size() ; i++){
            groups.add(OptionGroup.createBuilder()
                    .add(OptionImpl.createBuilder(boolean.class, lsdcOpts)
                            .setName(Component.translatable(SystemAndGLInfo.getInstance().memoryInfoList.get(i).getName()) )
                            .setTooltip(Component.translatable("sodium.memoryInfo.name"))
                            .setControl(TickBoxControl::new)
                            .setBinding((opts, value) -> LSDCClientMod.caiDan(), opts -> true)
                        //    .setImpact(OptionImpact.LOW)
                            .setFlags(OptionFlag.REQUIRES_RENDERER_RELOAD)
                            .build())
                    .add(OptionImpl.createBuilder(boolean.class, lsdcOpts)
                            .setName(Component.translatable(SystemAndGLInfo.getInstance().memoryInfoList.get(i).getVendor()))
                            .setTooltip(Component.translatable("sodium.hardware.vendor"))
                            .setControl(TickBoxControl::new)
                            .setBinding((opts, value) -> LSDCClientMod.caiDan(), opts -> true)
                        //    .setImpact(OptionImpact.LOW)
                            .setFlags(OptionFlag.REQUIRES_RENDERER_RELOAD)
                            .build())
                    .add(OptionImpl.createBuilder(boolean.class, lsdcOpts)
                            .setName(Component.translatable(String.format("%.2f",SystemAndGLInfo.getInstance().memoryInfoList.get(i).getSize()) +"MB"))
                            .setTooltip(Component.translatable("sodium.memoryInfo.size"))
                            .setControl(TickBoxControl::new)
                            .setBinding((opts, value) -> LSDCClientMod.caiDan(), opts -> true)
                        //    .setImpact(OptionImpact.LOW)
                            .setFlags(OptionFlag.REQUIRES_RENDERER_RELOAD)
                            .build())
                    .add(OptionImpl.createBuilder(boolean.class, lsdcOpts)
                            .setName(Component.translatable(String.format("%.2f",SystemAndGLInfo.getInstance().memoryInfoList.get(i).getClockSpeed())+"GHz"))
                            .setTooltip(Component.translatable("sodium.memoryInfo.clockSpeed"))
                            .setControl(TickBoxControl::new)
                            .setBinding((opts, value) -> LSDCClientMod.caiDan(), opts -> true)
                           // .setImpact(OptionImpact.LOW)
                            .setFlags(OptionFlag.REQUIRES_RENDERER_RELOAD)
                            .build())
                    .build());
        }
        return new OptionPage(Component.translatable("sodium.options.pages.memoryInfo"), ImmutableList.copyOf(groups));
    }
    public static OptionPage softInfo()
    {
        List<OptionGroup> groups = new ArrayList<>();
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
                        .setName(Component.translatable(SystemAndGLInfo.getInstance().getOSInfo()))
                        .setTooltip(Component.translatable("sodium.options.pages.sysname"))
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
                        .setName(Component.translatable(SystemAndGLInfo.getInstance().getJDKVersion()))
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
                        .setName(Component.translatable(SystemAndGLInfo.getInstance().getGLVersion()))
                        .setTooltip(Component.translatable("sodium.options.pages.glversion"))
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> LSDCClientMod.caiDan(), opts -> true)
                        // .setImpact(OptionImpact.LOW)
                        .setFlags(OptionFlag.REQUIRES_RENDERER_RELOAD)
                        .build())
                .build());
        return new OptionPage(Component.translatable("Other"), ImmutableList.copyOf(groups));
    }git
}

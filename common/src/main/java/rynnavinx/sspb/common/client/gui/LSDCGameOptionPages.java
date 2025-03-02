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


public class LSDCGameOptionPages {

    private static final LSDCOptionsStorage sspbOpts = new LSDCOptionsStorage();


    public static OptionPage cpuInfo()
    {
        List<OptionGroup> groups = new ArrayList<>();
        groups.add(OptionGroup.createBuilder()
                .add(OptionImpl.createBuilder(boolean.class, sspbOpts)
                        .setName(Component.translatable(SystemAndGLInfo.getInstance().cpuInfo.getName()))
                        .setTooltip(Component.translatable("sodium.cpuInfo.name"))
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> System.out.println(), opts -> true)
                       // .setImpact(OptionImpact.LOW)
                        .setFlags(OptionFlag.REQUIRES_RENDERER_RELOAD)
                        .build())
                .add(OptionImpl.createBuilder(boolean.class, sspbOpts)
                        .setName(Component.translatable(SystemAndGLInfo.getInstance().cpuInfo.getVendor()))
                        .setTooltip(Component.translatable("sodium.hardware.vendor"))
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> System.out.println(), opts -> true)
                       // .setImpact(OptionImpact.LOW)
                        .setFlags(OptionFlag.REQUIRES_RENDERER_RELOAD)
                        .build())
                .add(OptionImpl.createBuilder(boolean.class, sspbOpts)
                        .setName(Component.translatable(String.valueOf(SystemAndGLInfo.getInstance().cpuInfo.getCores())))
                        .setTooltip(Component.translatable("sodium.cpuInfo.cores"))
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> System.out.println(), opts -> true)
                     //   .setImpact(OptionImpact.LOW)
                        .setFlags(OptionFlag.REQUIRES_RENDERER_RELOAD)
                        .build())
                .add(OptionImpl.createBuilder(boolean.class, sspbOpts)
                        .setName(Component.translatable(String.valueOf(SystemAndGLInfo.getInstance().cpuInfo.getThreads())))
                        .setTooltip(Component.translatable("sodium.cpuInfo.threads"))
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> System.out.println(), opts -> true)
                      // .setImpact(OptionImpact.LOW)
                        .setFlags(OptionFlag.REQUIRES_RENDERER_RELOAD)
                        .build())
                .add(OptionImpl.createBuilder(boolean.class, sspbOpts)
                        .setName(Component.translatable(String.valueOf(SystemAndGLInfo.getInstance().cpuInfo.getFrequency()) + "GHz"))
                        .setTooltip(Component.translatable("sodium.cpuInfo.frequency"))
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> System.out.println(), opts -> true)
                     //   .setImpact(OptionImpact.LOW)
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
                    .add(OptionImpl.createBuilder(boolean.class, sspbOpts)
                            .setName(Component.translatable(SystemAndGLInfo.getInstance().gpuInfoList.get(i).getName()))
                            .setTooltip(Component.translatable("sodium.gpuInfo.name"))
                            .setControl(TickBoxControl::new)
                            .setBinding((opts, value) -> System.out.println(), opts -> true)
                          //  .setImpact(OptionImpact.LOW)
                            .setFlags(OptionFlag.REQUIRES_RENDERER_RELOAD)
                            .build())
                    .add(OptionImpl.createBuilder(boolean.class, sspbOpts)
                            .setName(Component.translatable(SystemAndGLInfo.getInstance().gpuInfoList.get(i).getVendor()) )
                            .setTooltip(Component.translatable("sodium.hardware.vendor"))
                            .setControl(TickBoxControl::new)
                            .setBinding((opts, value) -> System.out.println(), opts -> true)
                          //  .setImpact(OptionImpact.LOW)
                            .setFlags(OptionFlag.REQUIRES_RENDERER_RELOAD)
                            .build())
                    .add(OptionImpl.createBuilder(boolean.class, sspbOpts)
                            .setName(Component.translatable(String.format("%.2f",SystemAndGLInfo.getInstance().gpuInfoList.get(i).getVRam())+"GB"))
                            .setTooltip(Component.translatable("sodium.gpuInfo.vram"))
                            .setControl(TickBoxControl::new)
                            .setBinding((opts, value) -> System.out.println(), opts -> true)
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
                .add(OptionImpl.createBuilder(boolean.class, sspbOpts)
                        .setName(Component.translatable("sodium.memoryInfo.jvmTol"))
                        .setTooltip(Component.translatable("sodium.memoryInfo.name"))
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> System.out.println(), opts -> true)
                    //    .setImpact(OptionImpact.LOW)
                        .setFlags(OptionFlag.REQUIRES_RENDERER_RELOAD)
                        .build())
                .add(OptionImpl.createBuilder(boolean.class, sspbOpts)
                        .setName(Component.translatable(String.format("%.2f",SystemAndGLInfo.getInstance().getJVMTotalMemory()) +"MB"))
                        .setTooltip(Component.translatable("sodium.memoryInfo.size"))
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> System.out.println(), opts -> true)
                    //    .setImpact(OptionImpact.LOW)
                        .setFlags(OptionFlag.REQUIRES_RENDERER_RELOAD)
                        .build())
                .build());
        for(int i = 0 ; i < SystemAndGLInfo.getInstance().memoryInfoList.size() ; i++){
            groups.add(OptionGroup.createBuilder()
                    .add(OptionImpl.createBuilder(boolean.class, sspbOpts)
                            .setName(Component.translatable(SystemAndGLInfo.getInstance().memoryInfoList.get(i).getName()) )
                            .setTooltip(Component.translatable("sodium.memoryInfo.name"))
                            .setControl(TickBoxControl::new)
                            .setBinding((opts, value) -> System.out.println(), opts -> true)
                        //    .setImpact(OptionImpact.LOW)
                            .setFlags(OptionFlag.REQUIRES_RENDERER_RELOAD)
                            .build())
                    .add(OptionImpl.createBuilder(boolean.class, sspbOpts)
                            .setName(Component.translatable(SystemAndGLInfo.getInstance().memoryInfoList.get(i).getVendor()))
                            .setTooltip(Component.translatable("sodium.hardware.vendor"))
                            .setControl(TickBoxControl::new)
                            .setBinding((opts, value) -> System.out.println(), opts -> true)
                        //    .setImpact(OptionImpact.LOW)
                            .setFlags(OptionFlag.REQUIRES_RENDERER_RELOAD)
                            .build())
                    .add(OptionImpl.createBuilder(boolean.class, sspbOpts)
                            .setName(Component.translatable(String.format("%.2f",SystemAndGLInfo.getInstance().memoryInfoList.get(i).getSize()) +"MB"))
                            .setTooltip(Component.translatable("sodium.memoryInfo.size"))
                            .setControl(TickBoxControl::new)
                            .setBinding((opts, value) -> System.out.println(), opts -> true)
                         //   .setImpact(OptionImpact.LOW)
                            .setFlags(OptionFlag.REQUIRES_RENDERER_RELOAD)
                            .build())
                    .add(OptionImpl.createBuilder(boolean.class, sspbOpts)
                            .setName(Component.translatable(String.format("%.2f",SystemAndGLInfo.getInstance().memoryInfoList.get(i).getClockSpeed())+"GHz"))
                            .setTooltip(Component.translatable("sodium.memoryInfo.clockSpeed"))
                            .setControl(TickBoxControl::new)
                            .setBinding((opts, value) -> System.out.println(), opts -> true)
                         //   .setImpact(OptionImpact.LOW)
                            .setFlags(OptionFlag.REQUIRES_RENDERER_RELOAD)
                            .build())
                    .build());
        }
        return new OptionPage(Component.translatable("sodium.options.pages.memoryInfo"), ImmutableList.copyOf(groups));
    }
}

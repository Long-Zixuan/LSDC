package me.loongly.mods.lsdc.common.client.options;

import net.caffeinemc.mods.sodium.api.config.ConfigEntryPoint;
import net.caffeinemc.mods.sodium.api.config.option.OptionFlag;
import net.caffeinemc.mods.sodium.api.config.structure.ConfigBuilder;
import net.caffeinemc.mods.sodium.api.config.structure.OptionPageBuilder;
import net.caffeinemc.mods.sodium.client.config.structure.OptionPage;
import net.caffeinemc.mods.sodium.client.gui.options.control.ControlValueFormatterImpls;
import net.caffeinemc.mods.sodium.client.gui.options.control.TickBoxControl;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import me.loongly.mods.lsdc.common.api.system.SystemAndGLInfo;
import me.loongly.mods.lsdc.common.client.LSDCClientMod;


public class LSDCConfigBuilder implements ConfigEntryPoint 
{
    private static final LSDCOptions lsdcOpts = LSDCClientMod.options();

    static Component buildInfoComponent(String infoNameKey,String infoValue)
    {
        return Component.translatable(infoNameKey).
                append(Component.literal(":"+infoValue));
    }

    @Override
    public void registerConfigLate(ConfigBuilder configBuilder) 
    {
        
        configBuilder.registerOwnModOptions()
                .setColorTheme(configBuilder.createColorTheme()
                        .setBaseThemeRGB(0xed65ff)
                )
                .setIcon(Identifier.parse("lsdc:icon.png"))
                .setVersion("5.0.2")
                .addPage(configBuilder.createOptionPage()
                        .setName(Component.translatable("sodium.options.pages.lsdc"))
                        .addOption(configBuilder.createBooleanOption(Identifier.parse("lsdc:sys_info"))
                                .setName(Component.translatable("sodium.options.pages.sysinfo"))
                                .setTooltip(Component.translatable("sodium.options.pages.sysinfo"))
                                .setBinding((value) -> LSDCClientMod.caiDan(value), () -> true)
                                .setFlags(OptionFlag.REQUIRES_RENDERER_RELOAD)
                                .setStorageHandler(lsdcOpts::save)
                                .setDefaultValue(true))
                        .addOption(configBuilder.createBooleanOption(Identifier.parse("lsdc:sys_name"))
                                .setName(buildInfoComponent("sodium.options.pages.sysname",
                                        SystemAndGLInfo.getInstance().getOSName()))
                                .setTooltip(Component.translatable("sodium.options.pages.sysname"))
                                .setBinding((value) -> LSDCClientMod.caiDan(value), () -> true)
                                .setFlags(OptionFlag.REQUIRES_RENDERER_RELOAD)
                                .setStorageHandler(lsdcOpts::save)
                                .setDefaultValue(true))
                        .addOption(configBuilder.createBooleanOption(Identifier.parse("lsdc:sys_version"))
                                .setName(buildInfoComponent("sodium.options.pages.sysversion",
                                        SystemAndGLInfo.getInstance().getOSVersion()))
                                .setTooltip(Component.translatable("sodium.options.pages.sysversion"))
                                .setBinding((value) -> LSDCClientMod.caiDan(value), () -> true)
                                .setFlags(OptionFlag.REQUIRES_RENDERER_RELOAD)
                                .setStorageHandler(lsdcOpts::save)
                                .setDefaultValue(true))
                        .addOption(configBuilder.createBooleanOption(Identifier.parse("lsdc:jdk_info"))
                                .setName(Component.translatable("sodium.options.pages.jdkinfo"))
                                .setTooltip(Component.translatable("sodium.options.pages.jdkinfo"))
                                .setBinding((value) -> LSDCClientMod.caiDan(value), () -> true)
                                .setFlags(OptionFlag.REQUIRES_RENDERER_RELOAD)
                                .setStorageHandler(lsdcOpts::save)
                                .setDefaultValue(true))
                        .addOption(configBuilder.createBooleanOption(Identifier.parse("lsdc:jdk_version"))
                                .setName(buildInfoComponent("sodium.options.pages.jdkversion",
                                        SystemAndGLInfo.getInstance().getJDKVersion()))
                                .setTooltip(Component.translatable("sodium.options.pages.jdkversion"))
                                .setBinding(value -> LSDCClientMod.caiDan(value), () -> true)
                                .setFlags(OptionFlag.REQUIRES_RENDERER_RELOAD)
                                .setStorageHandler(lsdcOpts::save)
                                .setDefaultValue(true))
                        .addOption(configBuilder.createBooleanOption(Identifier.parse("lsdc:gl_info"))
                                .setName(Component.translatable("sodium.options.pages.glinfo"))
                                .setTooltip(Component.translatable("sodium.options.pages.glinfo"))                                
                                .setBinding((value) -> LSDCClientMod.caiDan(value), () -> true)
                                .setFlags(OptionFlag.REQUIRES_RENDERER_RELOAD)
                                .setStorageHandler(lsdcOpts::save)
                                .setDefaultValue(true))
                        .addOption(configBuilder.createBooleanOption(Identifier.parse("lsdc:gl_version"))
                                .setName(buildInfoComponent("sodium.options.pages.glversion",
                                        SystemAndGLInfo.getInstance().getGLVersion()))
                                .setTooltip(Component.translatable("sodium.options.pages.glversion"))
                                .setBinding((value) -> LSDCClientMod.caiDan(value), () -> true)
                                .setFlags(OptionFlag.REQUIRES_RENDERER_RELOAD)
                                .setStorageHandler(lsdcOpts::save)
                                .setDefaultValue(true))
                )
                .addPage(
                        configBuilder.createOptionPage()
                        .setName(Component.translatable("sodium.options.pages.cpuinfo"))
                        .addOption(configBuilder.createBooleanOption(Identifier.parse("lsdc:cpu_name"))
                                .setName(Component.translatable(SystemAndGLInfo.getInstance().getCpuInfo().getName()))
                                .setTooltip(Component.translatable("sodium.cpuInfo.name"))
                                .setBinding((value) -> LSDCClientMod.caiDan(value), () -> true)
                                // .setImpact(OptionImpact.LOW)
                                .setFlags(OptionFlag.REQUIRES_RENDERER_RELOAD)
                                .setStorageHandler(lsdcOpts::save)
                                .setDefaultValue(true))
                        .addOption(configBuilder.createBooleanOption(Identifier.parse("lsdc:cpu_vendor"))
                                .setName(buildInfoComponent("sodium.hardware.vendor",
                                        SystemAndGLInfo.getInstance().getCpuInfo().getVendor()))
                                .setTooltip(Component.translatable("sodium.hardware.vendor"))
                                .setBinding((value) -> LSDCClientMod.caiDan(value), () -> true)
                                //   .setImpact(OptionImpact.LOW)
                                .setFlags(OptionFlag.REQUIRES_RENDERER_RELOAD)
                                .setStorageHandler(lsdcOpts::save)
                                .setDefaultValue(true))
                        .addOption(configBuilder.createBooleanOption(Identifier.parse("lsdc:cpu_cores"))
                                .setName(buildInfoComponent("sodium.cpuInfo.cores",
                                        String.valueOf(SystemAndGLInfo.getInstance().getCpuInfo().getCores())))
                                .setTooltip(Component.translatable("sodium.cpuInfo.cores"))
                                .setBinding((value) -> LSDCClientMod.caiDan(value), () -> true)
                                .setFlags(OptionFlag.REQUIRES_RENDERER_RELOAD)
                                .setStorageHandler(lsdcOpts::save)
                                .setDefaultValue(true))
                         .addOption(configBuilder.createBooleanOption(Identifier.parse("lsdc:cpu_threads"))
                                .setName(buildInfoComponent("sodium.cpuInfo.threads",
                                        String.valueOf(SystemAndGLInfo.getInstance().getCpuInfo().getThreads())))
                                .setTooltip(Component.translatable("sodium.cpuInfo.threads"))
                                .setBinding((value) -> LSDCClientMod.caiDan(value), () -> true)
                                //     .setImpact(OptionImpact.LOW)
                                .setFlags(OptionFlag.REQUIRES_RENDERER_RELOAD)
                                .setStorageHandler(lsdcOpts::save)
                                .setDefaultValue(true))
                        .addOption(configBuilder.createBooleanOption(Identifier.parse("lsdc:cpu_frequency"))
                                .setName(buildInfoComponent("sodium.cpuInfo.frequency",String.
                                        format(String.format( "%.2f",
                                                (float)SystemAndGLInfo.getInstance().getCpuInfo().getFrequency() / 1000000000.0f) + "GHz")))
                                .setTooltip(Component.translatable("sodium.cpuInfo.frequency"))
                                .setBinding((value) -> LSDCClientMod.caiDan(value), () -> true)
                                //    .setImpact(OptionImpact.LOW)
                                .setFlags(OptionFlag.REQUIRES_RENDERER_RELOAD)
                                .setStorageHandler(lsdcOpts::save)
                                .setDefaultValue(true))
                )
                .addPage(
                        initGPUPages(configBuilder)
                )
                .addPage(
                        initMemoryPages(configBuilder)
                );
    }

    OptionPageBuilder initGPUPages(ConfigBuilder configBuilder)
    {
        var gpuInfoGroup = configBuilder.createOptionPage()
                        .setName(Component.translatable("sodium.options.pages.gpuinfo"));
        for(Integer i = 0 ; i < SystemAndGLInfo.getInstance().getGpuInfoList().size() ; i++)
        {
                var optGroup = configBuilder.createOptionGroup();
                optGroup.addOption(configBuilder.createBooleanOption(Identifier.parse("lsdc:gpu_info" + i.toString()))
                        .setName(Component.translatable("sodium.gpu")
                        .append(Component.literal(" "+Integer.toString(i + 1))))
                        .setTooltip(Component.translatable("sodium.options.pages.gpuinfo"))
                        .setBinding((value) -> LSDCClientMod.caiDan(value), () -> true)
                        //   .setImpact(OptionImpact.LOW)
                        .setFlags(OptionFlag.REQUIRES_RENDERER_RELOAD)
                        .setStorageHandler(lsdcOpts::save)
                        .setDefaultValue(true));
                optGroup.addOption(configBuilder.createBooleanOption(Identifier.parse("lsdc:gpu_name" + i.toString()))
                        .setName(Component.translatable(SystemAndGLInfo.getInstance().getGpuInfoList().get(i).getName()))
                        .setTooltip(Component.translatable("sodium.gpuInfo.name"))
                        .setBinding((value) -> LSDCClientMod.caiDan(value), () -> true)
                        //   .setImpact(OptionImpact.LOW)
                        .setFlags(OptionFlag.REQUIRES_RENDERER_RELOAD)
                        .setStorageHandler(lsdcOpts::save)
                        .setDefaultValue(true));
                optGroup.addOption(configBuilder.createBooleanOption(Identifier.parse("lsdc:gpu_vendor" + i.toString()))
                        .setName(buildInfoComponent("sodium.hardware.vendor",
                                    SystemAndGLInfo.getInstance().getGpuInfoList().get(i).getVendor()))
                        .setTooltip(Component.translatable("sodium.hardware.vendor"))
                        .setBinding((value) -> LSDCClientMod.caiDan(value), ()-> true)
                        //     .setImpact(OptionImpact.LOW)
                        .setFlags(OptionFlag.REQUIRES_RENDERER_RELOAD)
                        .setStorageHandler(lsdcOpts::save)
                        .setDefaultValue(true));
                optGroup.addOption(configBuilder.createBooleanOption(Identifier.parse("lsdc:gpu_vram" + i.toString()))
                        .setName(buildInfoComponent("sodium.gpuInfo.vram",String.format("%.2f",
                                            SystemAndGLInfo.getInstance().getGpuInfoList().get(i).getVRam())+"GB"))
                        .setTooltip(Component.translatable("sodium.gpuInfo.vram"))
                        .setBinding((value) -> LSDCClientMod.caiDan(value), () -> true)
                        //    .setImpact(OptionImpact.LOW)
                        .setFlags(OptionFlag.REQUIRES_RENDERER_RELOAD)
                        .setStorageHandler(lsdcOpts::save)
                        .setDefaultValue(true));
                gpuInfoGroup.addOptionGroup(optGroup);
        }
        return gpuInfoGroup;
    }

    OptionPageBuilder initMemoryPages(ConfigBuilder configBuilder)
    {
        var memoryInfoGroup = configBuilder.createOptionPage()
                        .setName(Component.translatable("sodium.options.pages.memoryInfo"));
        memoryInfoGroup.addOption(configBuilder.createBooleanOption(Identifier.parse("lsdc:memory_name"))
                .setName(Component.translatable("sodium.memoryInfo.jvmTol"))
                .setTooltip(Component.translatable("sodium.memoryInfo.name"))
                .setBinding((value) -> LSDCClientMod.caiDan(value), () -> true)
                .setFlags(OptionFlag.REQUIRES_RENDERER_RELOAD)
                .setStorageHandler(lsdcOpts::save)
                .setDefaultValue(true));
        memoryInfoGroup.addOption(configBuilder.createBooleanOption(Identifier.parse("lsdc:memory_size"))
                .setName(buildInfoComponent("sodium.memoryInfo.size",
                                String.format("%.2f",SystemAndGLInfo.getInstance().getJVMTotalMemory()) +"MB"))
                .setTooltip(Component.translatable("sodium.memoryInfo.size"))
                .setBinding((value) -> LSDCClientMod.caiDan(value), () -> true)
                .setFlags(OptionFlag.REQUIRES_RENDERER_RELOAD)
                .setStorageHandler(lsdcOpts::save)
                .setDefaultValue(true));
         for(Integer i = 0 ; i < SystemAndGLInfo.getInstance().getMemoryInfoList().size() ; i++)
        {
                var optGroup = configBuilder.createOptionGroup();
                optGroup.addOption(configBuilder.createBooleanOption(Identifier.parse("lsdc:memory" + i.toString()))
                        .setName(Component.translatable("sodium.memnory")
                                    .append(Component.literal(" "+Integer.toString(i + 1))))
                        .setTooltip(Component.translatable("sodium.options.pages.memoryInfo"))
                        .setBinding((value) -> LSDCClientMod.caiDan(value), () -> true)
                        .setFlags(OptionFlag.REQUIRES_RENDERER_RELOAD)
                        .setStorageHandler(lsdcOpts::save)
                        .setDefaultValue(true));
                optGroup.addOption(configBuilder.createBooleanOption(Identifier.parse("lsdc:memory_name" + i.toString()))
                        .setName(Component.translatable(SystemAndGLInfo.getInstance().getMemoryInfoList().get(i).getName()) )
                        .setTooltip(Component.translatable("sodium.memoryInfo.name"))
                        .setBinding((value) -> LSDCClientMod.caiDan(value), () -> true)
                        //    .setImpact(OptionImpact.LOW)
                        .setFlags(OptionFlag.REQUIRES_RENDERER_RELOAD)
                        .setStorageHandler(lsdcOpts::save)
                        .setDefaultValue(true));
                optGroup.addOption(configBuilder.createBooleanOption(Identifier.parse("lsdc:memory_vendor" + i.toString()))
                        .setName(buildInfoComponent("sodium.hardware.vendor",
                                    SystemAndGLInfo.getInstance().getMemoryInfoList().get(i).getVendor()))
                        .setTooltip(Component.translatable("sodium.hardware.vendor"))
                        .setBinding((value) -> LSDCClientMod.caiDan(value), () -> true)
                        .setFlags(OptionFlag.REQUIRES_RENDERER_RELOAD)
                        .setStorageHandler(lsdcOpts::save)
                        .setDefaultValue(true));
                optGroup.addOption(configBuilder.createBooleanOption(Identifier.parse("lsdc:memory_size" + i.toString()))
                        .setName(buildInfoComponent("sodium.memoryInfo.size",
                                    String.format("%.2f", SystemAndGLInfo.getInstance().getMemoryInfoList().get(i).getSize()) +"MB"))
                        .setTooltip(Component.translatable("sodium.memoryInfo.size"))
                        .setBinding((value) -> LSDCClientMod.caiDan(value), () -> true)
                        .setFlags(OptionFlag.REQUIRES_RENDERER_RELOAD)
                        .setStorageHandler(lsdcOpts::save)
                        .setDefaultValue(true));
                 optGroup.addOption(configBuilder.createBooleanOption(Identifier.parse("lsdc:memory_clock_speed" + i.toString()))
                        .setName(buildInfoComponent("sodium.memoryInfo.clockSpeed",
                                    String.format("%.2f", SystemAndGLInfo.getInstance().getMemoryInfoList().get(i).getClockSpeed())+"GHz"))
                        .setTooltip(Component.translatable("sodium.memoryInfo.clockSpeed"))
                        .setBinding((value) -> LSDCClientMod.caiDan(value),() -> true)
                        .setFlags(OptionFlag.REQUIRES_RENDERER_RELOAD)
                        .setStorageHandler(lsdcOpts::save)
                        .setDefaultValue(true));
                memoryInfoGroup.addOptionGroup(optGroup);
        }
        
        return memoryInfoGroup;
    }
}

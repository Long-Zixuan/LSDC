package me.loongly.mods.lsdc.common.client.options;

import net.caffeinemc.mods.sodium.api.config.ConfigEntryPoint;
import net.caffeinemc.mods.sodium.api.config.option.OptionFlag;
import net.caffeinemc.mods.sodium.api.config.structure.ConfigBuilder;
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
                .setVersion("5.0.0")
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
        );
    }
}

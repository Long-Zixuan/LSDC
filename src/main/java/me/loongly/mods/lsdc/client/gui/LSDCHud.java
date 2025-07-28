package me.loongly.mods.lsdc.client.gui;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import me.loongly.mods.lsdc.EmbeddiumDeviceCheckMod;
import me.loongly.mods.lsdc.client.ClientTickHandler;
import me.loongly.mods.lsdc.client.LSDCClientMod;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.text.Text;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderGuiEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT, modid = EmbeddiumDeviceCheckMod.MOD_ID)
public class LSDCHud {

    private static final List<Text> TEXT_LIST = new ObjectArrayList<>();

    private static final MinecraftClient CLIENT = MinecraftClient.getInstance();

    @SubscribeEvent
    public static void onStartTick(TickEvent.ClientTickEvent client) {

    }
    @SubscribeEvent
    public static void onHudRender(RenderGuiEvent.Post event)
    {

    }
}

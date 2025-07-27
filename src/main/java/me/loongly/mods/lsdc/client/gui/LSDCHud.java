package me.loongly.mods.lsdc.client.gui;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.text.Text;
import net.minecraft.util.math.Vec3d;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import net.neoforged.neoforge.client.event.RenderGuiEvent;
import net.neoforged.bus.api.SubscribeEvent;

import java.util.List;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.GAME, value = Dist.CLIENT, modid = lsdcClientMod.MOD_ID)
public class LSDCHud {

    private static final List<Text> TEXT_LIST = new ObjectArrayList<>();

    private static final MinecraftClient CLIENT = MinecraftClient.getInstance();

    @SubscribeEvent
    public static void onStartTick(ClientTickEvent.Post event)
    {
    }
    @SubscribeEvent
    public static void onHudRender(RenderGuiEvent.Post event)
    {
    }

}

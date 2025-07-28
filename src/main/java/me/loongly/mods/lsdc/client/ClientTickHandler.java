package me.loongly.mods.lsdc.client;

import me.loongly.mods.lsdc.EmbeddiumDeviceCheckMod;
import com.google.common.collect.EvictingQueue;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Queue;
import java.util.stream.IntStream;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT, modid = EmbeddiumDeviceCheckMod.MOD_ID)
public class ClientTickHandler {

    @SubscribeEvent
    public static void onTick(final TickEvent.ClientTickEvent event)
    {

    }

}

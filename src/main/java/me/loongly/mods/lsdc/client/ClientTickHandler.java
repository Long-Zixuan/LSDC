package me.loongly.mods.lsdc.client;

import com.google.common.collect.EvictingQueue;
import me.loongly.mods.lsdc.mixin.gui.MinecraftClientAccessor;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.client.event.ClientTickEvent;

import java.util.Queue;
import java.util.stream.IntStream;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.GAME, value = Dist.CLIENT, modid = lsdcClientMod.MOD_ID)
public class ClientTickHandler
{
    @SubscribeEvent
    public static void onTick(final ClientTickEvent.Post event)
    {

    }

}

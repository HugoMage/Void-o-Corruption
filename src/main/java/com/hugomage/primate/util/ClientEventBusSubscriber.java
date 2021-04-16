package com.hugomage.primate.util;

import com.hugomage.primate.Primate;
import com.hugomage.primate.client.render.*;
import com.hugomage.primate.init.ModEntityTypes;
import com.hugomage.primate.items.ModSpawnEggItem;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = Primate.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEventBusSubscriber {

    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.ORANGUTAN.get(), OrangutanRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.UAKARI.get(), UakariRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.PROBOSCIS.get(), ProboscisRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.BONOBO.get(), BonoboRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.ZOMBIEAPE.get(), ZombieApeRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.MANDRILL.get(), MandrillRenderer::new);
    }

    @SubscribeEvent
    public static void onRegisterEntities(final RegistryEvent.Register<EntityType<?>> event) {
        ModSpawnEggItem.initSpawnEggs();
    }


}

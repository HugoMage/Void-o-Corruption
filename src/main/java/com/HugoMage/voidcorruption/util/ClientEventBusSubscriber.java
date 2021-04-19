package com.HugoMage.voidcorruption.util;

import com.HugoMage.voidcorruption.VoidCorruption;
import com.HugoMage.voidcorruption.client.render.HungerRenderer;
import com.HugoMage.voidcorruption.client.render.ParamedoRenderer;
import com.HugoMage.voidcorruption.client.render.ParamedyRenderer;
import com.HugoMage.voidcorruption.client.render.VoidApeRenderer;
import com.HugoMage.voidcorruption.init.ModEntityTypes;
import com.HugoMage.voidcorruption.items.ModSpawnEggItem;
import net.minecraft.entity.EntityType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = VoidCorruption.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEventBusSubscriber {

    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.HUNGER.get(), HungerRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.PARAMEDO.get(), ParamedoRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.PARAMEDY.get(), ParamedyRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.VOIDAPE.get(), VoidApeRenderer::new);

    }

    @SubscribeEvent
    public static void onRegisterEntities(final RegistryEvent.Register<EntityType<?>> event) {
        ModSpawnEggItem.initSpawnEggs();
    }


}

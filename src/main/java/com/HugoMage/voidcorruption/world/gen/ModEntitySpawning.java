package com.HugoMage.voidcorruption.world.gen;

import com.HugoMage.voidcorruption.entities.HungerEntity;
import com.HugoMage.voidcorruption.entities.ParamedoEntity;
import com.HugoMage.voidcorruption.entities.ParamedyEntity;
import com.HugoMage.voidcorruption.entities.VoidApeEntity;
import com.HugoMage.voidcorruption.init.ModEntityTypes;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraft.world.gen.Heightmap;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

public class ModEntitySpawning {
    @SubscribeEvent
    public static void onBiomesLoad(BiomeLoadingEvent event) {
        if (event.getCategory() == Biome.Category.THEEND)
            event.getSpawns().getSpawner(EntityClassification.MONSTER).add(new MobSpawnInfo.Spawners(ModEntityTypes.VOIDAPE.get(), 20, 1, 4));
        if (event.getCategory() == Biome.Category.THEEND)
            event.getSpawns().getSpawner(EntityClassification.CREATURE).add(new MobSpawnInfo.Spawners(ModEntityTypes.PARAMEDY.get(), 8, 1, 4));
        if (event.getCategory() == Biome.Category.THEEND)
            event.getSpawns().getSpawner(EntityClassification.CREATURE).add(new MobSpawnInfo.Spawners(ModEntityTypes.PARAMEDO.get(), 10, 1, 4));
        if (event.getCategory() == Biome.Category.THEEND)
            event.getSpawns().getSpawner(EntityClassification.MONSTER).add(new MobSpawnInfo.Spawners(ModEntityTypes.HUNGER.get(), 10, 1, 4));


        EntitySpawnPlacementRegistry.register(ModEntityTypes.VOIDAPE.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, VoidApeEntity::canSpawnOn);
        EntitySpawnPlacementRegistry.register(ModEntityTypes.PARAMEDY.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, ParamedyEntity::canSpawnOn);
        EntitySpawnPlacementRegistry.register(ModEntityTypes.PARAMEDO.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, ParamedoEntity::canSpawnOn);
        EntitySpawnPlacementRegistry.register(ModEntityTypes.HUNGER.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HungerEntity::canSpawnOn);





    }







}

package com.hugomage.primate.world.gen;

import com.hugomage.primate.init.ModEntityTypes;
import net.minecraft.entity.EntityClassification;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeRegistry;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraft.world.gen.Heightmap;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import javax.lang.model.util.Types;

public class ModEntitySpawning {
    @SubscribeEvent
    public static void onBiomesLoad(BiomeLoadingEvent event) {
        if (event.getCategory() == Biome.Category.JUNGLE)
            event.getSpawns().getSpawner(EntityClassification.CREATURE).add(new MobSpawnInfo.Spawners(ModEntityTypes.ORANGUTAN.get(), 8, 1, 4));

        if (event.getCategory() == Biome.Category.JUNGLE)
            event.getSpawns().getSpawner(EntityClassification.CREATURE).add(new MobSpawnInfo.Spawners(ModEntityTypes.PROBOSCIS.get(), 7, 1, 5));

        if (event.getCategory() == Biome.Category.JUNGLE || event.getCategory() == Biome.Category.FOREST)
            event.getSpawns().getSpawner(EntityClassification.CREATURE).add(new MobSpawnInfo.Spawners(ModEntityTypes.UAKARI.get(), 6, 1, 2));
        if (event.getCategory() == Biome.Category.JUNGLE)
            event.getSpawns().getSpawner(EntityClassification.MONSTER).add(new MobSpawnInfo.Spawners(ModEntityTypes.ZOMBIEAPE.get(), 10, 1, 2));
        if (event.getCategory() == Biome.Category.SAVANNA || event.getCategory() == Biome.Category.FOREST)
            event.getSpawns().getSpawner(EntityClassification.CREATURE).add(new MobSpawnInfo.Spawners(ModEntityTypes.MANDRILL.get(), 7, 1, 4));


    }
}

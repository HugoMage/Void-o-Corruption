package com.hugomage.primate.init;

import com.hugomage.primate.Primate;
import com.hugomage.primate.entities.OrangutanEntity;
import com.hugomage.primate.entities.ProboscisEntity;
import com.hugomage.primate.entities.UakariEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModEntityTypes {
    public static DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES, Primate.MOD_ID);

    // Monkeys
    public static final RegistryObject<EntityType<OrangutanEntity>> ORANGUTAN = ENTITY_TYPES.register("orangutan", ()->
            EntityType.Builder.create(OrangutanEntity::new, EntityClassification.CREATURE)
            .size(1.0f,1.5f)
            .build(new ResourceLocation(Primate.MOD_ID, "orangutan").toString()));

    public static final RegistryObject<EntityType<UakariEntity>> UAKARI = ENTITY_TYPES.register("uakari", ()->
            EntityType.Builder.create(UakariEntity::new, EntityClassification.CREATURE)
                    .size(1.0f,1.0f)
                    .build(new ResourceLocation(Primate.MOD_ID, "uakari").toString()));
    public static final RegistryObject<EntityType<ProboscisEntity>> PROBOSCIS = ENTITY_TYPES.register("proboscis", ()->
            EntityType.Builder.create(ProboscisEntity::new, EntityClassification.CREATURE)
                    .size(1.0f,1.5f)
                    .build(new ResourceLocation(Primate.MOD_ID, "proboscis").toString()));
}

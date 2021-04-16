package com.hugomage.primate.init;

import com.hugomage.primate.Primate;
import com.hugomage.primate.entities.*;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.projectile.ProjectileItemEntity;
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
                    .size(1.0f,1.0f)
                    .build(new ResourceLocation(Primate.MOD_ID, "proboscis").toString()));
    public static final RegistryObject<EntityType<BonoboEntity>> BONOBO = ENTITY_TYPES.register("bonobo", ()->
            EntityType.Builder.create(BonoboEntity::new, EntityClassification.CREATURE)
                    .size(1.0f,1.0f)
                    .build(new ResourceLocation(Primate.MOD_ID, "bonobo").toString()));
    public static final RegistryObject<EntityType<ZombieApeEntity>> ZOMBIEAPE = ENTITY_TYPES.register("zombieape", ()->
            EntityType.Builder.create(ZombieApeEntity::new, EntityClassification.MONSTER)
                    .size(1.0f,1.3f)
                    .build(new ResourceLocation(Primate.MOD_ID, "zombieape").toString()));
    public static final RegistryObject<EntityType<MandrillEntity>> MANDRILL = ENTITY_TYPES.register("mandrill", ()->
            EntityType.Builder.create(MandrillEntity::new, EntityClassification.CREATURE)
                    .size(1.0f,1.3f)
                    .build(new ResourceLocation(Primate.MOD_ID, "mandrill").toString()));

}


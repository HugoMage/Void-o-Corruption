package com.HugoMage.voidcorruption.init;

import com.HugoMage.voidcorruption.VoidCorruption;
import com.HugoMage.voidcorruption.entities.HungerEntity;
import com.HugoMage.voidcorruption.entities.ParamedoEntity;
import com.HugoMage.voidcorruption.entities.ParamedyEntity;
import com.HugoMage.voidcorruption.entities.VoidApeEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModEntityTypes {
    public static DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES, VoidCorruption.MOD_ID);

    //Void Mobs
    public static final RegistryObject<EntityType<VoidApeEntity>> VOIDAPE = ENTITY_TYPES.register("voidape", ()->
            EntityType.Builder.create(VoidApeEntity::new, EntityClassification.MONSTER)
                    .size(1.0f,1.3f)
                    .build(new ResourceLocation(VoidCorruption.MOD_ID, "voidape").toString()));
    public static final RegistryObject<EntityType<HungerEntity>> HUNGER = ENTITY_TYPES.register("hunger", ()->
            EntityType.Builder.create(HungerEntity::new, EntityClassification.MONSTER)
                    .size(1.0f,1.3f)
                    .build(new ResourceLocation(VoidCorruption.MOD_ID, "hunger").toString()));
    public static final RegistryObject<EntityType<ParamedoEntity>> PARAMEDO = ENTITY_TYPES.register("paramedo", ()->
            EntityType.Builder.create(ParamedoEntity::new, EntityClassification.CREATURE)
                    .size(2.0f,0.7f)
                    .build(new ResourceLocation(VoidCorruption.MOD_ID, "paramedo").toString()));
    public static final RegistryObject<EntityType<ParamedyEntity>> PARAMEDY = ENTITY_TYPES.register("paramedy", ()->
            EntityType.Builder.create(ParamedyEntity::new, EntityClassification.CREATURE)
                    .size(1.0f,1.3f)
                    .build(new ResourceLocation(VoidCorruption.MOD_ID, "paramedy").toString()));


}

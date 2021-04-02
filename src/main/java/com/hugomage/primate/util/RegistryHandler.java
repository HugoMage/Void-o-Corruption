package com.hugomage.primate.util;


import com.hugomage.primate.Primate;
import com.hugomage.primate.blocks.DecorationBase;
import com.hugomage.primate.blocks.ThermalBedrock;
import com.hugomage.primate.blocks.ThermalVent;
import com.hugomage.primate.init.ModEntityTypes;
import com.hugomage.primate.items.*;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RegistryHandler {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Primate.MOD_ID);
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Primate.MOD_ID);


    public static void init() {
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());

    }



    // Items
    public static final RegistryObject<Item> ORANGUTAN_FUR = ITEMS.register("orangutan_fur", ItemBase::new);
    public static final RegistryObject<Item> ORANGUTAN_CHEEK = ITEMS.register("orangutan_cheek", ItemBase::new);
    public static final RegistryObject<Item> UAKARI_FOREHEAD = ITEMS.register("uakari_forehead", ItemBase::new);
    public static final RegistryObject<Item> PROBOSCIS_NOSE = ITEMS.register("proboscis_nose", ItemBase::new);
    public static final RegistryObject<Item> GIFT_CARD = ITEMS.register("gift_card", SecretBase::new);
    public static final RegistryObject<Item> PRIMATE_FOOT = ITEMS.register("primate_foot", BrewingBase::new);
    public static final RegistryObject<PoisonFoodBase> PRIMATE_BRAIN = ITEMS.register("primate_brain", PoisonFoodBase::new);

    // SpawnEgg
    public static final RegistryObject<ModSpawnEggItem> ORANGUTAN_SPAWN_EGG = ITEMS.register("orangutan_spawn_egg",() -> new ModSpawnEggItem(ModEntityTypes.ORANGUTAN, 0xE77C2F, 0x7B7A79, new Item.Properties().group(ItemGroup.MISC)));
    public static final RegistryObject<ModSpawnEggItem> UAKARI_SPAWN_EGG = ITEMS.register("uakari_spawn_egg",() -> new ModSpawnEggItem(ModEntityTypes.UAKARI, 0x4a2210, 0xa8323a, new Item.Properties().group(ItemGroup.MISC)));
    public static final RegistryObject<ModSpawnEggItem> PROBOSCIS_SPAWN_EGG = ITEMS.register("proboscis_spawn_egg",() -> new ModSpawnEggItem(ModEntityTypes.PROBOSCIS, 0x3d2c24, 0xf5c3ab, new Item.Properties().group(ItemGroup.MISC)));


    // Armor



    // Blocks
    public static final RegistryObject<Block> THERMAL_VENT = BLOCKS.register("thermal_vent", ThermalVent::new);
    public static final RegistryObject<Block> THERMAL_BEDROCK = BLOCKS.register("thermal_bedrock", ThermalBedrock::new);

    // Block Items
    public static final RegistryObject<Item> THERMAL_VENT_ITEM = ITEMS.register("thermal_vent", () -> new DecorationBase(THERMAL_VENT.get()));
    public static final RegistryObject<Item> THERMAL_BEDROCK_ITEM = ITEMS.register("thermal_bedrock", () -> new DecorationBase(THERMAL_BEDROCK.get()));


}
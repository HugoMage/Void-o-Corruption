package com.HugoMage.voidcorruption.util;

import com.HugoMage.voidcorruption.VoidCorruption;
import com.HugoMage.voidcorruption.init.ModEntityTypes;
import com.HugoMage.voidcorruption.items.ItemBase;
import com.HugoMage.voidcorruption.items.ModSpawnEggItem;
import com.HugoMage.voidcorruption.items.VoidBrainBase;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RegistryHandler {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, VoidCorruption.MOD_ID);
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, VoidCorruption.MOD_ID);


    public static void init() {
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());

    }

    // Items
    public static final RegistryObject<Item> VOID_BRAIN = ITEMS.register("void_brain", VoidBrainBase::new);
    public static final RegistryObject<Item> HUNGER_TOOTH = ITEMS.register("hunger_tooth", ItemBase::new);
    // Spawn Egg
    public static final RegistryObject<ModSpawnEggItem> VOIDAPE_SPAWN_EGG = ITEMS.register("voidape_spawn_egg",() -> new ModSpawnEggItem(ModEntityTypes.VOIDAPE, 0x37b828, 0x8a64b5, new Item.Properties().group(ItemGroup.MISC)));
    public static final RegistryObject<ModSpawnEggItem> HUNGER_SPAWN_EGG = ITEMS.register("hunger_spawn_egg",() -> new ModSpawnEggItem(ModEntityTypes.HUNGER, 0x9250ad, 0x71318c, new Item.Properties().group(ItemGroup.MISC)));
    public static final RegistryObject<ModSpawnEggItem> PARAMEDO_SPAWN_EGG = ITEMS.register("paramedo_spawn_egg",() -> new ModSpawnEggItem(ModEntityTypes.PARAMEDO, 0x5f167d, 0x544759, new Item.Properties().group(ItemGroup.MISC)));
    public static final RegistryObject<ModSpawnEggItem> PARAMEDY_SPAWN_EGG = ITEMS.register("paramedy_spawn_egg",() -> new ModSpawnEggItem(ModEntityTypes.PARAMEDY, 0xebc994, 0xd9a85b, new Item.Properties().group(ItemGroup.MISC)));

    // Music Disc

    // Block

    // Block Item













}

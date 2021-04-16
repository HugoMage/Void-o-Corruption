package com.hugomage.primate.items;

import net.minecraft.data.loot.ChestLootTables;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class PoisonFoodBase extends Item {

    public PoisonFoodBase() {
        super(new Item.Properties()
                .group(ItemGroup.BREWING)
                .isImmuneToFire()
                .food(new Food.Builder()
                                .hunger(8)
                                .effect(new EffectInstance(Effects.POISON,300, 3), 1.0f).build()
        )


        );
    }
}

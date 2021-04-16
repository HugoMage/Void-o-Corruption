package com.hugomage.primate.items;

import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class YummyBase extends Item {

    public YummyBase() {
        super(new Properties()
                .group(ItemGroup.FOOD)
                .isImmuneToFire()
                .food(new Food.Builder()
                                .hunger(8).build()
        )


        );
    }
}

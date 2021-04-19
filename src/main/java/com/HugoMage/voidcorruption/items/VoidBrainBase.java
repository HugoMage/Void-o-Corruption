package com.HugoMage.voidcorruption.items;

import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class VoidBrainBase extends Item {

    public VoidBrainBase() {
        super(new Properties()
                .group(ItemGroup.BREWING)
                .isImmuneToFire()
                .food(new Food.Builder()
                                .hunger(8)
                                .effect(new EffectInstance(Effects.NIGHT_VISION,300, 3), 1.0f)
                                .effect(new EffectInstance(Effects.WEAKNESS,300, 3), 1.0f)
                                .effect(new EffectInstance(Effects.POISON,300, 3), 1.0f)

                        .build()


        )


        );
    }
}

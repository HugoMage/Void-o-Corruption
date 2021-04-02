package com.hugomage.primate.blocks;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

public class DecorationBase extends BlockItem {
    public DecorationBase(Block block) {
        super(block, new Properties().group(ItemGroup.DECORATIONS));
    }
}

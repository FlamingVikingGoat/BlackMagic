package com.fvg.blackmagic.handlers;

import com.fvg.blackmagic.blocks.ModBlocks;
import com.fvg.blackmagic.items.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockStone;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class RecipeHandler {

    public static void registerCraftingRecipes(){
        GameRegistry.addRecipe(new ItemStack(ModBlocks.spawnBlock),
                new Object[]{"SSS", "SIS", "SSS", 'I', ModItems.infernus, 'S', Blocks.stone});
    }

    public static void registerFurnaceRecipes(){}

    public static void registerArmorRecipe(){}

    public static void registerToolRecipe(){}

}

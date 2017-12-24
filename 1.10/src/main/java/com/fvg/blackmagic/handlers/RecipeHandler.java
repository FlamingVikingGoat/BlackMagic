package com.fvg.blackmagic.handlers;

import com.fvg.blackmagic.blocks.ModBlocks;
import com.fvg.blackmagic.items.ModItems;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class RecipeHandler {

    public static void registerCraftingRecipes(){
        GameRegistry.addRecipe(new ItemStack(ModBlocks.spawnBlock),
                new Object[]{"SSS", "SIS", "SSS", 'I', ModItems.unrefinedInfernus, 'S', Blocks.STONE});
        GameRegistry.addRecipe(new ItemStack(ModItems.blackStaff),
                new Object[]{" SI", " SS", "S  ", 'S', Items.STICK, 'I', ModItems.unrefinedInfernus});

    }
    public static void registerFurnaceRecipes(){
        GameRegistry.addSmelting(ModBlocks.infernusInfusedStone, new ItemStack(ModItems.unrefinedInfernus), 6.66F);
    }
    public static void registerArmorRecipe(){}

    public static void registerToolRecipe(){}

}

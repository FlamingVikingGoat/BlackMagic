package com.fvg.blackmagic.handlers;

import com.fvg.blackmagic.blocks.ModBlocks;
import com.fvg.blackmagic.items.ModItems;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.util.Random;

public class RecipeHandler {

    public static void registerCraftingRecipes(){
        GameRegistry.addRecipe(new ItemStack(ModBlocks.spawnBlock),
                new Object[]{"SSS", "SIS", "SSS", 'I', ModItems.unrefinedInfernus, 'S', Blocks.STONE});
        GameRegistry.addRecipe(new ItemStack(ModItems.blackStaff),
                new Object[]{" SI", " SS", "S  ", 'S', Items.STICK, 'I', ModItems.unrefinedInfernus});

    }
    public static void registerFurnaceRecipes(){
        GameRegistry.addSmelting(ModBlocks.infernusInfusedStone, new ItemStack(ModItems.unrefinedInfernus), 6.66F);
        GameRegistry.addSmelting(ModItems.unrefinedInfernus, generateOneOfThreeItems(ModItems.black_infernus, ModItems.red_infernus, ModItems.purple_infernus), 6.66F);

    }
    public static void registerArmorRecipe(){}

    public static void registerToolRecipe(){}

    public static ItemStack generateOneOfThreeItems(Item possibleItem1, Item possibleItem2, Item possibleItem3){
        ItemStack returnedItem = new ItemStack(Items.STICK);
        Random rn = new Random();
        int rgn = rn.nextInt(3);
        switch (rgn){
            case 0: returnedItem = new ItemStack(possibleItem1); break;
            case 1: returnedItem = new ItemStack(possibleItem2); break;
            case 2: returnedItem = new ItemStack(possibleItem3); break;
        }
        System.out.println(returnedItem);
        return returnedItem;
    }
}

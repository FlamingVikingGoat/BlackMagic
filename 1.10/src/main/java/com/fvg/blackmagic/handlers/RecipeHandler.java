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
                "BRB", "RPR", "BRB",
                    'P', ModItems.purple_infernus,
                    'R', ModItems.red_infernus,
                    'B', ModItems.black_infernus);

        GameRegistry.addRecipe(new ItemStack(ModItems.blackStaff),
                " SI", " SS", "S  ",
                    'S', Items.STICK,
                    'I', ModItems.black_infernus);

        GameRegistry.addRecipe(new ItemStack(ModItems.redStaff),
                 " SI", " SS", "S  ",
                    'S', Items.STICK,
                    'I', ModItems.red_infernus);

        GameRegistry.addRecipe(new ItemStack(ModItems.purpleStaff),
                " SI", " SS", "S  ",
                    'S', Items.STICK,
                    'I', ModItems.purple_infernus);

        GameRegistry.addRecipe(new ItemStack(ModItems.magicBook),
                "LGW", "SB ", "TEA",
                    'L', Items.LEATHER,
                    'G', Items.GUNPOWDER,
                    'W', Blocks.WOOL,
                    'S', Items.STRING,
                    'B', Items.BOOK,
                    'T', Items.STICK,
                    'E', Items.WHEAT_SEEDS,
                    'A', new ItemStack(Items.DYE, 1, 4));
        GameRegistry.addRecipe(new ItemStack(ModItems.magicBook),
                "LGW", " BS", "TEA",
                    'L', Items.LEATHER,
                    'G', Items.GUNPOWDER,
                    'W', Blocks.WOOL,
                    'S', Items.STRING,
                    'B', Items.BOOK,
                    'T', Items.STICK,
                    'E', Items.WHEAT_SEEDS,
                    'A', new ItemStack(Items.DYE, 1, 4));
        GameRegistry.addRecipe(new ItemStack(ModItems.magicBook),
                "LGW", "BS ", "TEA",
                    'L', Items.LEATHER,
                    'G', Items.GUNPOWDER,
                    'W', Blocks.WOOL,
                    'S', Items.STRING,
                    'B', Items.BOOK,
                    'T', Items.STICK,
                    'E', Items.WHEAT_SEEDS,
                    'A', new ItemStack(Items.DYE, 1, 4));
        GameRegistry.addRecipe(new ItemStack(ModItems.magicBook),
                "LGW", "B S", "TEA",
                    'L', Items.LEATHER,
                    'G', Items.GUNPOWDER,
                    'W', Blocks.WOOL,
                    'S', Items.STRING,
                    'B', Items.BOOK,
                    'T', Items.STICK,
                    'E', Items.WHEAT_SEEDS,
                    'A', new ItemStack(Items.DYE, 1, 4));
        GameRegistry.addRecipe(new ItemStack(ModItems.magicBook),
                "LGW", "S B", "TEA",
                    'L', Items.LEATHER,
                    'G', Items.GUNPOWDER,
                    'W', Blocks.WOOL,
                    'S', Items.STRING,
                    'B', Items.BOOK,
                    'T', Items.STICK,
                    'E', Items.WHEAT_SEEDS,
                    'A', new ItemStack(Items.DYE, 1, 4));
        GameRegistry.addRecipe(new ItemStack(ModItems.magicBook),
                "LGW", " SB", "TEA",
                    'L', Items.LEATHER,
                    'G', Items.GUNPOWDER,
                    'W', Blocks.WOOL,
                    'S', Items.STRING,
                    'B', Items.BOOK,
                    'T', Items.STICK,
                    'E', Items.WHEAT_SEEDS,
                    'A', new ItemStack(Items.DYE, 1, 4));

    }
    public static void registerFurnaceRecipes(){
        GameRegistry.addSmelting(ModBlocks.infernusInfusedStone, new ItemStack(ModItems.unrefinedInfernus), 6.66F);
        GameRegistry.addSmelting(ModItems.unrefinedInfernus, new ItemStack(ModItems.purple_infernus), 6.66F);

    }
    public static void registerArmorRecipe(){}

    public static void registerToolRecipe(){}

}

package com.flamingvikinggoat.blackmagic.handlers;

import com.flamingvikinggoat.blackmagic.blocks.BlockInfernusInfusedStone;
import com.flamingvikinggoat.blackmagic.blocks.BlockSpawn;
import com.flamingvikinggoat.blackmagic.blocks.ModBlocks;
import com.flamingvikinggoat.blackmagic.items.*;
import com.flamingvikinggoat.blackmagic.items.gear.ItemStaffBlack;
import com.flamingvikinggoat.blackmagic.items.gear.ItemStaffPurple;
import com.flamingvikinggoat.blackmagic.items.gear.ItemStaffRed;
import com.flamingvikinggoat.blackmagic.items.magic.MagicBook;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class RecipeHandler {

    public static void registerCraftingRecipes(){
        GameRegistry.addRecipe(new ItemStack(ModBlocks.BLOCKS[BlockSpawn.getIndex()]),
                "BRB", "RPR", "BRB",
                    'P', ModItems.ITEMS[ItemInfernusPurple.getIndex()],
                    'R', ModItems.ITEMS[ItemInfernusRed.getIndex()],
                    'B', ModItems.ITEMS[ItemInfernusBlack.getIndex()]);

        GameRegistry.addRecipe(new ItemStack(ModItems.ITEMS[ItemStaffBlack.getIndex()]),
                " SI", " SS", "S  ",
                    'S', Items.STICK,
                    'I', ModItems.ITEMS[ItemInfernusBlack.getIndex()]);

        GameRegistry.addRecipe(new ItemStack(ModItems.ITEMS[ItemStaffRed.getIndex()]),
                 " SI", " SS", "S  ",
                    'S', Items.STICK,
                    'I', ModItems.ITEMS[ItemInfernusRed.getIndex()]);

        GameRegistry.addRecipe(new ItemStack(ModItems.ITEMS[ItemStaffPurple.getIndex()]),
                " SI", " SS", "S  ",
                    'S', Items.STICK,
                    'I', ModItems.ITEMS[ItemInfernusPurple.getIndex()]);

        GameRegistry.addRecipe(new ItemStack(ModItems.ITEMS[MagicBook.getIndex()]),
                "LGW", "SB ", "TEA",
                    'L', Items.LEATHER,
                    'G', Items.GUNPOWDER,
                    'W', Blocks.WOOL,
                    'S', Items.STRING,
                    'B', Items.BOOK,
                    'T', Items.STICK,
                    'E', Items.WHEAT_SEEDS,
                    'A', new ItemStack(Items.DYE, 1, 4));
        GameRegistry.addRecipe(new ItemStack(ModItems.ITEMS[MagicBook.getIndex()]),
                "LGW", " BS", "TEA",
                    'L', Items.LEATHER,
                    'G', Items.GUNPOWDER,
                    'W', Blocks.WOOL,
                    'S', Items.STRING,
                    'B', Items.BOOK,
                    'T', Items.STICK,
                    'E', Items.WHEAT_SEEDS,
                    'A', new ItemStack(Items.DYE, 1, 4));
        GameRegistry.addRecipe(new ItemStack(ModItems.ITEMS[MagicBook.getIndex()]),
                "LGW", "BS ", "TEA",
                    'L', Items.LEATHER,
                    'G', Items.GUNPOWDER,
                    'W', Blocks.WOOL,
                    'S', Items.STRING,
                    'B', Items.BOOK,
                    'T', Items.STICK,
                    'E', Items.WHEAT_SEEDS,
                    'A', new ItemStack(Items.DYE, 1, 4));
        GameRegistry.addRecipe(new ItemStack(ModItems.ITEMS[MagicBook.getIndex()]),
                "LGW", "B S", "TEA",
                    'L', Items.LEATHER,
                    'G', Items.GUNPOWDER,
                    'W', Blocks.WOOL,
                    'S', Items.STRING,
                    'B', Items.BOOK,
                    'T', Items.STICK,
                    'E', Items.WHEAT_SEEDS,
                    'A', new ItemStack(Items.DYE, 1, 4));
        GameRegistry.addRecipe(new ItemStack(ModItems.ITEMS[MagicBook.getIndex()]),
                "LGW", "S B", "TEA",
                    'L', Items.LEATHER,
                    'G', Items.GUNPOWDER,
                    'W', Blocks.WOOL,
                    'S', Items.STRING,
                    'B', Items.BOOK,
                    'T', Items.STICK,
                    'E', Items.WHEAT_SEEDS,
                    'A', new ItemStack(Items.DYE, 1, 4));
        GameRegistry.addRecipe(new ItemStack(ModItems.ITEMS[MagicBook.getIndex()]),
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
        GameRegistry.addSmelting(ModBlocks.BLOCKS[BlockInfernusInfusedStone.getIndex()], new ItemStack(ModItems.ITEMS[ItemInfernusUnrefined.getIndex()]), 6.66F);
        GameRegistry.addSmelting(ModItems.ITEMS[ItemInfernusUnrefined.getIndex()], new ItemStack(ModItems.ITEMS[ItemInfernusPurple.getIndex()]), 6.66F);

    }
    public static void registerArmorRecipe(){}

    public static void registerToolRecipe(){}

}

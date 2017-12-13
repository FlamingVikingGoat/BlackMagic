package com.fvg.blackmagic.blocks;

import com.fvg.blackmagic.blocks.item.ItemSpawnBlock;
import com.fvg.blackmagic.core.Reference;
import com.fvg.blackmagic.handlers.BlackEnums;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;


public class ModBlocks {

    public static Block spawnBlock;
    public static Block infernusInfusedStone;


    public static void init(){
        spawnBlock = new SpawnBlock("spawnBlock");
        infernusInfusedStone = new InfernusInfusedStone("infernusInfusedStone");
    }

    public static void register(){
        registerBlock(infernusInfusedStone);
        registerBlock(spawnBlock, new ItemSpawnBlock(spawnBlock));

    }

    public static void registerRenders(){
        registerRender(infernusInfusedStone);
        for(int i = 0; i < BlackEnums.SacrificialStatus.values().length; i++){
            registerRender(spawnBlock, i, "spawnBlock_" + BlackEnums.SacrificialStatus.values()[i].getName());
        }
    }

    public static void registerBlock(Block block){
        GameRegistry.register(block);
        GameRegistry.register(new ItemBlock(block).setRegistryName(block.getRegistryName()));
    }

    public static void registerBlock(Block block, ItemBlock itemBlock){
        GameRegistry.register(block);
        GameRegistry.register(itemBlock.setRegistryName(block.getRegistryName()));
    }

    public static void registerRender(Block block){
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation(new ResourceLocation(Reference.MODID, block.getUnlocalizedName().substring(5)), "inventory"));
    }

    public static void registerRender(Block block, int meta, String fileName){
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), meta,
                new ModelResourceLocation(new ResourceLocation(Reference.MODID, fileName), "inventory"));
    }

}

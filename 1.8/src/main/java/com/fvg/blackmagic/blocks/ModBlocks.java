package com.fvg.blackmagic.blocks;

import com.fvg.blackmagic.core.Reference;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModBlocks {

    public static Block spawnBlock;
    public static Block infernusInfusedStone;


    public static void init(){
        spawnBlock = new SpawnBlock("spawnBlock");
        infernusInfusedStone = new InfernusInfusedStone("infernusInfusedStone");
    }

    public static void register(){
        registerBlock(spawnBlock);
        registerBlock(infernusInfusedStone);
    }

    public static void registerRenders(){
        registerRender(spawnBlock);
        registerRender(infernusInfusedStone);
    }

    public static void registerBlock(Block block){
        GameRegistry.registerBlock(block, block.getUnlocalizedName().substring(5));
    }

    public static void registerRender(Block block){
        Item item = Item.getItemFromBlock(block);
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0,
               new ModelResourceLocation(
                       Reference.MODID + ":" + item.getUnlocalizedName().substring(5), "inventory"
               ));
    }

}

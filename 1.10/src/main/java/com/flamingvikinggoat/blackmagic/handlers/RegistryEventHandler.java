package com.flamingvikinggoat.blackmagic.handlers;


import com.flamingvikinggoat.blackmagic.blocks.AMagicActivated;
import com.flamingvikinggoat.blackmagic.blocks.BlockSpawn;
import com.flamingvikinggoat.blackmagic.blocks.ModBlocks;
import com.flamingvikinggoat.blackmagic.core.BlackMagic;
import com.flamingvikinggoat.blackmagic.core.Reference;
import com.flamingvikinggoat.blackmagic.items.ModItems;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class RegistryEventHandler {
    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event){
        event.getRegistry().registerAll(ModBlocks.BLOCKS);

        for(Block block : ModBlocks.BLOCKS){
            block.setCreativeTab(BlackMagic.TabBlackMagicCore);
        }

        System.out.println("This Works!");
    }


    @SubscribeEvent public static void registerItems(RegistryEvent.Register<Item> event){
        event.getRegistry().registerAll(ModItems.ITEMS);

        for(Item item : ModItems.ITEMS){
            item.setCreativeTab(BlackMagic.TabBlackMagicCore);
        }

        for(Block block : ModBlocks.BLOCKS){
            event.getRegistry().register(new ItemBlock(block).setRegistryName(block.getRegistryName()));

        }
    }

    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent event){
        for(Block block : ModBlocks.BLOCKS){
            if(!(block instanceof AMagicActivated)) {
                ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0,
                        new ModelResourceLocation(block.getRegistryName(), "inventory"));
            }
            else {
                for(int i =0 ; i < BlackEnums.SacrificialStatus.values().length; i++){
                    ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), i,
                            new ModelResourceLocation(new ResourceLocation(Reference.MODID,"spawn_block_" + BlackEnums.SacrificialStatus.values()[i].getName()), "inventory"));
                }
            }
        }

        for(Item item : ModItems.ITEMS){
            ModelLoader.setCustomModelResourceLocation(item, 0,
                    new ModelResourceLocation(item.getRegistryName(), "inventory"));
        }
    }


}

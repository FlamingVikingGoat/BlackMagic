package com.fvg.blackmagic.core;


import com.fvg.blackmagic.blocks.ModBlocks;
import com.fvg.blackmagic.creativetab.TabBlackMagicCore;
import com.fvg.blackmagic.handlers.RecipeHandler;
import com.fvg.blackmagic.items.ModItems;
import com.fvg.blackmagic.proxy.CommonProxy;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;


@Mod(modid = Reference.MODID, version = Reference.VERSION)
public class BlackMagic {

    @SidedProxy(serverSide = Reference.SERVER_PROXY_CLASS, clientSide = Reference.CLIENT_PROXY_CLASS)
    public static CommonProxy proxy;

    @Mod.Instance("blackamgic")
    public static BlackMagic instance;

    public static CreativeTabs TabBlackMagicCore = new TabBlackMagicCore("tabBlackMagicCore");

    @EventHandler
    public  static void preInit(FMLPreInitializationEvent event){
        ModItems.init();
        ModItems.register();
        ModBlocks.init();
        ModBlocks.register();
    }

    @EventHandler
    public static void init(FMLInitializationEvent event){
       proxy.registerRenders();
        RecipeHandler.registerCraftingRecipes();
    }

    @EventHandler
    public static void postInit(FMLPostInitializationEvent event){

    }
}

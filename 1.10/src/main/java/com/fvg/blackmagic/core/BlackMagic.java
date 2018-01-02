package com.fvg.blackmagic.core;


import com.fvg.blackmagic.blocks.ModBlocks;
import com.fvg.blackmagic.capabilities.CapabilityHandler;
import com.fvg.blackmagic.capabilities.IMana;
import com.fvg.blackmagic.capabilities.Mana;
import com.fvg.blackmagic.capabilities.ManaStorage;
import com.fvg.blackmagic.commands.CommandMagicStatus;
import com.fvg.blackmagic.commands.CommandSetMagicical;
import com.fvg.blackmagic.commands.CommandSetMaxMana;
import com.fvg.blackmagic.creativetab.TabBlackMagicCore;
import com.fvg.blackmagic.entitites.ModEntities;
import com.fvg.blackmagic.handlers.BlackEvents;
import com.fvg.blackmagic.handlers.RecipeHandler;
import com.fvg.blackmagic.items.ModItems;
import com.fvg.blackmagic.network.GuiHandler;
import com.fvg.blackmagic.proxy.CommonProxy;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;


@Mod(modid = Reference.MODID, name = Reference.NAME, version = Reference.VERSION)
public class BlackMagic {

    @SidedProxy(serverSide = Reference.SERVER_PROXY_CLASS, clientSide = Reference.CLIENT_PROXY_CLASS)
    public static CommonProxy proxy;

    @Mod.Instance("blackmagic")
    public static BlackMagic instance;

    public static CreativeTabs TabBlackMagicCore = new TabBlackMagicCore("tabBlackMagicCore");

    @Mod.EventHandler
    public  static void preInit(FMLPreInitializationEvent event){
        ModItems.init();
        ModItems.register();
        ModBlocks.init();
        ModBlocks.register();
        ModEntities.registerEntities();
        CapabilityManager.INSTANCE.register(IMana.class, new ManaStorage(), Mana.class);
        proxy.registerRenders();

    }

    @Mod.EventHandler
    public static void init(FMLInitializationEvent event){
       proxy.registerEntityRenders();
       proxy.registerWorldGenerator();
       RecipeHandler.registerCraftingRecipes();
       RecipeHandler.registerFurnaceRecipes();
       NetworkRegistry.INSTANCE.registerGuiHandler(BlackMagic.instance, new GuiHandler());
    }

    @Mod.EventHandler
    public static void postInit(FMLPostInitializationEvent event){
        MinecraftForge.EVENT_BUS.register(new BlackEvents());
        MinecraftForge.EVENT_BUS.register(new CapabilityHandler());
    }

    @Mod.EventHandler
    public static void serverLoad(FMLServerStartingEvent event){
        event.registerServerCommand(new CommandSetMaxMana());
        event.registerServerCommand(new CommandMagicStatus());
        event.registerServerCommand(new CommandSetMagicical());
    }

}

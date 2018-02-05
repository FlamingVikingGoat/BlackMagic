package com.flamingvikinggoat.blackmagic.core;


import com.flamingvikinggoat.blackmagic.blocks.ModBlocks;
import com.flamingvikinggoat.blackmagic.capabilities.Mana;
import com.flamingvikinggoat.blackmagic.commands.CommandSetMaxMana;
import com.flamingvikinggoat.blackmagic.handlers.RecipeHandler;
import com.flamingvikinggoat.blackmagic.items.ModItems;
import com.flamingvikinggoat.blackmagic.network.GuiHandler;
import com.flamingvikinggoat.blackmagic.capabilities.CapabilityHandler;
import com.flamingvikinggoat.blackmagic.capabilities.IMana;
import com.flamingvikinggoat.blackmagic.capabilities.ManaStorage;
import com.flamingvikinggoat.blackmagic.capabilities.knownpages.IPagesKnown;
import com.flamingvikinggoat.blackmagic.capabilities.knownpages.PagesKnown;
import com.flamingvikinggoat.blackmagic.capabilities.knownpages.PagesKnownStorage;
import com.flamingvikinggoat.blackmagic.commands.CommandMagicStatus;
import com.flamingvikinggoat.blackmagic.commands.CommandSetMagicical;
import com.flamingvikinggoat.blackmagic.creativetab.TabBlackMagicCore;
import com.flamingvikinggoat.blackmagic.entitites.ModEntities;
import com.flamingvikinggoat.blackmagic.handlers.BlackEvents;
import com.flamingvikinggoat.blackmagic.handlers.BookEvents;
import com.flamingvikinggoat.blackmagic.proxy.CommonProxy;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;


@Mod(modid = Reference.MODID, name = Reference.NAME, version = Reference.VERSION, acceptedMinecraftVersions = Reference.ACCEPTED_MINECRAFT_VERSIONS)
public class BlackMagic {

    @SidedProxy(serverSide = "com.flamingvikinggoat.blackmagic.proxy.ServerProxy", clientSide = "com.flamingvikinggoat.blackmagic.proxy.ClientProxy")
    public static CommonProxy proxy;

    @Mod.Instance("blackmagic")
    public static BlackMagic instance;

    public static CreativeTabs TabBlackMagicCore = new TabBlackMagicCore("tabBlackMagicCore");

    @Mod.EventHandler
    public  static void preInit(FMLPreInitializationEvent event){
        ModEntities.registerEntities();
        CapabilityManager.INSTANCE.register(IMana.class, new ManaStorage(), Mana.class);
        CapabilityManager.INSTANCE.register(IPagesKnown.class, new PagesKnownStorage(), PagesKnown.class);
        proxy.preInit();
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
        MinecraftForge.EVENT_BUS.register(new BookEvents());
        MinecraftForge.EVENT_BUS.register(new CapabilityHandler());
    }

    @Mod.EventHandler
    public static void serverLoad(FMLServerStartingEvent event){
        event.registerServerCommand(new CommandSetMaxMana());
        event.registerServerCommand(new CommandMagicStatus());
        event.registerServerCommand(new CommandSetMagicical());
    }

}

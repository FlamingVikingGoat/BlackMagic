package com.fvg.blackmagic.core;

import com.fvg.blackmagic.BootsOfSpeed;
import com.fvg.blackmagic.SpawnBlock;
import com.fvg.blackmagic.items.ModItems;
import com.fvg.blackmagic.proxy.CommonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

import static com.fvg.blackmagic.BootsOfSpeed.bootsOfSpeed;
import static com.fvg.blackmagic.BootsOfSpeed.demonArmor;

@Mod(modid = Reference.MODID, version = Reference.VERSION)
public class BlackMagic {

    @SidedProxy(serverSide = Reference.SERVER_PROXY_CLASS, clientSide = Reference.CLIENT_PROXY_CLASS)
    public static CommonProxy proxy;

    @Mod.Instance("blackamgic")
    public static BlackMagic instance;

    @EventHandler
    public  static void preInit(FMLPreInitializationEvent event){
        ModItems.init();
        ModItems.register();
    }

    @EventHandler
    public static void init(FMLInitializationEvent event){
        SpawnBlock spawnBlock = new SpawnBlock();
        GameRegistry.registerBlock(spawnBlock, "spawnBlock");
        bootsOfSpeed = new BootsOfSpeed(demonArmor, 0, 3);
        GameRegistry.registerItem(bootsOfSpeed, "bootsOfSpeed");

    }

    @EventHandler
    public static void postInit(FMLPostInitializationEvent event){

    }
}

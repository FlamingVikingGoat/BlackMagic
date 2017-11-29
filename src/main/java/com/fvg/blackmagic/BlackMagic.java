package com.fvg.blackmagic;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

import static com.fvg.blackmagic.BootsOfSpeed.bootsOfSpeed;
import static com.fvg.blackmagic.BootsOfSpeed.demonArmor;

@Mod(modid = BlackMagic.MODID, version = BlackMagic.VERSION)
public class BlackMagic {
    public static final String MODID = "blackMagic";
    public static final String VERSION = "1.0.0";

    @EventHandler
    public  static void preInit(FMLPreInitializationEvent event){

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

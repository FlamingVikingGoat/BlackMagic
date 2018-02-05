package com.flamingvikinggoat.blackmagic.proxy;

import com.flamingvikinggoat.blackmagic.network.BlackPackets;
import com.flamingvikinggoat.blackmagic.worldgen.OreGen;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CommonProxy {

    public void preInit(){
        BlackPackets.registerMessages();
    }


    public void registerWorldGenerator(){
        GameRegistry.registerWorldGenerator(new OreGen(), 0);
    }

    public void registerModelBakeryVariants(){}

    public void registerEntityRenders(){}

}


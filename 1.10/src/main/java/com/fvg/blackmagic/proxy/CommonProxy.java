package com.fvg.blackmagic.proxy;

import com.fvg.blackmagic.worldgen.OreGen;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CommonProxy {
    public void registerRenders() {

    }

    public void registerWorldGenerator(){
        GameRegistry.registerWorldGenerator(new OreGen(), 0);
    }

    public void registerModelBakeryVariants(){}

    public void registerEntityRenders(){}
}


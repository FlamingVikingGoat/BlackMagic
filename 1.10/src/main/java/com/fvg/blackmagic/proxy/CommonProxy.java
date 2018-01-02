package com.fvg.blackmagic.proxy;

import com.fvg.blackmagic.blocks.ModBlocks;
import com.fvg.blackmagic.capabilities.IMana;
import com.fvg.blackmagic.capabilities.Mana;
import com.fvg.blackmagic.capabilities.ManaStorage;
import com.fvg.blackmagic.entitites.ModEntities;
import com.fvg.blackmagic.items.ModItems;
import com.fvg.blackmagic.worldgen.OreGen;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CommonProxy {

    public void registerRenders() {}

    public void registerWorldGenerator(){
        GameRegistry.registerWorldGenerator(new OreGen(), 0);
    }

    public void registerModelBakeryVariants(){}

    public void registerEntityRenders(){}

    public void openMyGui(){}
}


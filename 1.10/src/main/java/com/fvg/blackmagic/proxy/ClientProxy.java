package com.fvg.blackmagic.proxy;

import com.fvg.blackmagic.blocks.ModBlocks;
import com.fvg.blackmagic.core.Reference;
import com.fvg.blackmagic.items.ModItems;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

public class ClientProxy extends CommonProxy {
    @Override
    public void registerRenders() {
        ModItems.registerRenders();
        ModBlocks.registerRenders();
    }

    @Override
    public void registerModelBakeryVariants() {
        ModelBakery.registerItemVariants(Item.getItemFromBlock(ModBlocks.spawnBlock),
                new ResourceLocation(Reference.MODID, "spawnBlock_yes_sacrifice"),
                new ResourceLocation(Reference.MODID, "spawnBlock_no_sacrifice"));
    }
}

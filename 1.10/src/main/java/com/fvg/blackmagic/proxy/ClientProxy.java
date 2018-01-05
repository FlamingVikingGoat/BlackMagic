package com.fvg.blackmagic.proxy;

import com.fvg.blackmagic.blocks.ModBlocks;
import com.fvg.blackmagic.client.entity.RenderDemon;
import com.fvg.blackmagic.client.gui.GuiMagicBook;
import com.fvg.blackmagic.client.model.ModelDemon;
import com.fvg.blackmagic.core.Reference;
import com.fvg.blackmagic.entitites.EntityDemon;
import com.fvg.blackmagic.items.ModItems;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

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

    @Override
    public void registerEntityRenders() {
        RenderingRegistry.registerEntityRenderingHandler(EntityDemon.class,
                new RenderDemon(Minecraft.getMinecraft().getRenderManager(),
                        new ModelDemon(1), 0.7f));
    }

}

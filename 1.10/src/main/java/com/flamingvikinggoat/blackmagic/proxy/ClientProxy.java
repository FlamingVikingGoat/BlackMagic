package com.flamingvikinggoat.blackmagic.proxy;

import com.flamingvikinggoat.blackmagic.blocks.BlockSpawn;
import com.flamingvikinggoat.blackmagic.blocks.ModBlocks;
import com.flamingvikinggoat.blackmagic.client.entity.RenderDemon;
import com.flamingvikinggoat.blackmagic.client.model.ModelDemon;
import com.flamingvikinggoat.blackmagic.core.Reference;
import com.flamingvikinggoat.blackmagic.entitites.EntityDemon;
import com.flamingvikinggoat.blackmagic.items.ModItems;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy {

    @Override
    public void preInit() {
        super.preInit();
    }



    @Override
    public void registerModelBakeryVariants() {
        ModelBakery.registerItemVariants(Item.getItemFromBlock(ModBlocks.BLOCKS[BlockSpawn.getIndex()]),
                new ResourceLocation(Reference.MODID, "spawn_block_yes_sacrifice"),
                new ResourceLocation(Reference.MODID, "spawn_block_no_sacrifice"));
    }

    @Override
    public void registerEntityRenders() {
        RenderingRegistry.registerEntityRenderingHandler(EntityDemon.class,
                new RenderDemon(Minecraft.getMinecraft().getRenderManager(),
                        new ModelDemon(1), 0.7f));
    }

}

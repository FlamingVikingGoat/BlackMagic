package com.fvg.blackmagic.client.entity;

import com.fvg.blackmagic.core.Reference;
import com.fvg.blackmagic.entitites.EntityDemon;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderDemon extends RenderLiving<EntityDemon>{

    private static final ResourceLocation demonTexture = new ResourceLocation(Reference.MODID + ":textures/entity/demon.png");

    public RenderDemon(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, modelbaseIn, shadowsizeIn);

    }


    @Override
    protected ResourceLocation getEntityTexture(EntityDemon entity) {
        return this.demonTexture == null ? new ResourceLocation(Reference.MODID + ":textures/entity/ghost") : this.demonTexture;
    }
}

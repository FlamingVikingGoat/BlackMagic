package com.fvg.blackmagic.capabilities;

import com.fvg.blackmagic.core.Reference;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class CapabilityHandler {
    public static final ResourceLocation MANA_CAP = new ResourceLocation(Reference.MODID, "mana");
    public static final ResourceLocation SACRIFICE = new ResourceLocation(Reference.MODID, "sacrifice");

    @SubscribeEvent
    public void attachCapabilityEntity(AttachCapabilitiesEvent<Entity> event){
        if(!(event.getObject() instanceof EntityPlayer)) return;

        event.addCapability(MANA_CAP, new ManaProvider());
    }

    @SubscribeEvent
    public void attachCapabilityItemStack(AttachCapabilitiesEvent<ItemStack> event){
        event.addCapability(SACRIFICE, new SacrificeProvider());
    }
}

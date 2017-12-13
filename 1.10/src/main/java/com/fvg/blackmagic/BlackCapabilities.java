package com.fvg.blackmagic;

import com.fvg.blackmagic.core.Reference;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class BlackCapabilities {
    public static final ResourceLocation HAS_SACRIFICE = new ResourceLocation(Reference.MODID, "hasSacrifice");

    @SubscribeEvent
    public void attachCapability(AttachCapabilitiesEvent<ItemStack> event){
        event.addCapability(HAS_SACRIFICE, new HasSacrificeProvider());
    }
}

package com.flamingvikinggoat.blackmagic.handlers;

import com.flamingvikinggoat.blackmagic.blocks.BlockSpawn;
import com.flamingvikinggoat.blackmagic.capabilities.knownpages.IPagesKnown;
import com.flamingvikinggoat.blackmagic.capabilities.knownpages.PagesKnownProvider;
import com.flamingvikinggoat.blackmagic.items.magic.MagicBookLoader;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

public class BookEvents {

    @SubscribeEvent
    public void onSummonBlockCrafted(PlayerEvent.ItemCraftedEvent event){
        ItemStack itemCrafted = event.crafting;
        EntityPlayer player = event.player;
        IPagesKnown pagesKnown = player.getCapability(PagesKnownProvider.KNOWN_PAGES, null);
        pagesKnown.getKnownPages();

        if(Block.getBlockFromItem(itemCrafted.getItem()) instanceof BlockSpawn && !player.getEntityWorld().isRemote){
            pagesKnown.makePageKnown(MagicBookLoader.summonRitual, player);
        }
    }
}

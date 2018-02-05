package com.flamingvikinggoat.blackmagic.items.magic;

import com.flamingvikinggoat.blackmagic.items.ItemBase;
import com.flamingvikinggoat.blackmagic.network.BlackPackets;
import com.flamingvikinggoat.blackmagic.network.PacketServerResponseWithKnownPagesOfPlayer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class MagicBook extends ItemBase {
    public MagicBook(String unlocalizedName, int index){
        super(unlocalizedName, index);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn, EnumHand hand) {
        BlackPackets.INSTANCE.sendToServer(
                new PacketServerResponseWithKnownPagesOfPlayer(playerIn.getName(), "GuiMagicBook", "knownPages")
        );
        return super.onItemRightClick(itemStackIn, worldIn, playerIn, hand);
    }

}

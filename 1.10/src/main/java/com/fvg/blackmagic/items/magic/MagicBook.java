package com.fvg.blackmagic.items.magic;

import com.fvg.blackmagic.core.BlackMagic;
import com.fvg.blackmagic.lib.LibGuiIDs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class MagicBook extends Item{
    public MagicBook(String unlocalizedName){
        this.setUnlocalizedName(unlocalizedName);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn, EnumHand hand) {
        playerIn.openGui(BlackMagic.instance, LibGuiIDs.MagicBook, worldIn, 0, 0, 0);
        return super.onItemRightClick(itemStackIn, worldIn, playerIn, hand);
    }
}

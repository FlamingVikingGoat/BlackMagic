package com.fvg.blackmagic.items.gear;

import com.fvg.blackmagic.MagicEffects.ASpells;
import com.fvg.blackmagic.core.BlackMagic;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class ItemModSword extends ItemSword{
    public ItemModSword(ToolMaterial material, String unlocalizedName){
        super(material);
        this.setUnlocalizedName(unlocalizedName);
        this.setCreativeTab(BlackMagic.TabBlackMagicCore);
    }

    @Override
    public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity){
        ASpells.summonLightningOnEntity(entity);
        return false;
    }

    @Override
    public boolean onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ) {
        ASpells.summonLightningOnBlock(worldIn, pos);
        return false;
    }

}

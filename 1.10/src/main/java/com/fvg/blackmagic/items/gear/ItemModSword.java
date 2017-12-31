package com.fvg.blackmagic.items.gear;

import com.fvg.blackmagic.galdr.ASpells;
import com.fvg.blackmagic.blocks.AMagicActivated;
import com.fvg.blackmagic.core.BlackMagic;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
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
    public EnumActionResult onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        //ASpells.summonLightningOnBlock(worldIn, pos);
        if(worldIn.getBlockState(pos).getBlock() instanceof AMagicActivated)
            System.out.println(worldIn.getBlockState(pos));
        return EnumActionResult.PASS;

    }



}

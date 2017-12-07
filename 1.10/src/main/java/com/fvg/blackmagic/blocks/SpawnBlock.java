package com.fvg.blackmagic.blocks;

import com.fvg.blackmagic.MagicEffects.ASpells;
import com.fvg.blackmagic.core.BlackMagic;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class SpawnBlock extends AMagicActivated{
    public SpawnBlock(String unlocalizedName){
        super(Material.IRON);
        this.setUnlocalizedName(unlocalizedName);
        this.setCreativeTab(BlackMagic.TabBlackMagicCore);
        this.setLightLevel(1.0F);
        this.setHardness(10.0F);
        this.setResistance(5.0F);
    }


    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, @Nullable ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ){
        if(this.isActivated) {
            ASpells.rituallySummonDemonOnBlock(playerIn, pos);
            this.setActivated(false);
        }
        return  false;
    }

    @Override
    public void onBlockClicked(World worldIn, BlockPos pos, EntityPlayer playerIn) {
        printActivationStatusToDebug();
    }
}

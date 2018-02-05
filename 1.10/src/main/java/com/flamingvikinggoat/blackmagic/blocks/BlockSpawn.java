package com.flamingvikinggoat.blackmagic.blocks;

import com.flamingvikinggoat.blackmagic.core.BlackMagic;
import com.flamingvikinggoat.blackmagic.handlers.BlackEnums;
import com.flamingvikinggoat.blackmagic.galdr.ASpells;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class BlockSpawn extends AMagicActivated{


    public BlockSpawn(String name, Material material, int index){
        super(name, material, index);
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, @Nullable ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ){
        System.out.println(worldIn.getBlockState(pos).getValue(TYPE));
        if(this.isActivated && worldIn.getBlockState(pos).getValue(TYPE).equals(BlackEnums.SacrificialStatus.YES_SACRIFICE)) {
            ASpells.rituallySummonDemonOnBlock(playerIn, pos);
        }
        else if(this.isActivated){
            this.setActivated(false);
            System.out.println("No Sacrifice!");
        }
        return  false;
    }

    @Override
    public void onBlockClicked(World worldIn, BlockPos pos, EntityPlayer playerIn) {
        printActivationStatusToDebug();
    }
}

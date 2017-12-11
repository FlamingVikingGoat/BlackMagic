package com.fvg.blackmagic.blocks;

import com.fvg.blackmagic.MagicEffects.ASpells;
import com.fvg.blackmagic.core.BlackMagic;
import com.fvg.blackmagic.handlers.BlackEnums;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockStateContainer;
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
        this.setRegistryName(unlocalizedName);
        this.setCreativeTab(BlackMagic.TabBlackMagicCore);
        this.setLightLevel(1.0F);
        this.setHardness(10.0F);
        this.setResistance(5.0F);
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, @Nullable ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ){
        System.out.println(worldIn.getBlockState(pos).getValue(TYPE));
        if(this.isActivated && worldIn.getBlockState(pos).getValue(TYPE).equals(BlackEnums.SacrificialStatus.YES_SACRIFICE)) {
            ASpells.rituallySummonDemonOnBlock(playerIn, pos);
            this.setActivated(false);
            worldIn.setBlockState(pos, state.withProperty(TYPE, BlackEnums.SacrificialStatus.NO_SACRIFICE));
            return false;
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

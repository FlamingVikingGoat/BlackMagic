package com.fvg.blackmagic.blocks;

import com.fvg.blackmagic.handlers.BlackEnums;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public abstract class AMagicActivated extends net.minecraft.block.Block{
    public static final PropertyEnum TYPE = PropertyEnum.create("type", BlackEnums.SacrificialStatus.class);

    public AMagicActivated(Material material){
        super(material);
        this.setDefaultState(this.blockState.getBaseState()
                .withProperty(TYPE, BlackEnums.SacrificialStatus.NO_SACRIFICE));
    }

    @Override
    protected BlockStateContainer createBlockState(){
        return new BlockStateContainer(this, new IProperty[]{TYPE});
    }


    @Override
    public IBlockState getStateForPlacement(World world, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer, ItemStack stack) {
        return this.getDefaultState()
                .withProperty(TYPE, BlackEnums.SacrificialStatus.NO_SACRIFICE);
    }

    @Override
    public int getMetaFromState(IBlockState state) {
       return ((BlackEnums.SacrificialStatus)state.getValue(TYPE)).getID();
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        return this.getDefaultState().withProperty(TYPE, BlackEnums.SacrificialStatus.values()[meta]);

    }

    public boolean isActivated = false;




    public void setActivated(boolean activated) {
        this.isActivated = activated;
    }

    public boolean isActivated() {
        return isActivated;
    }

    public void printActivationStatusToDebug(){
        System.out.println(this.isActivated);
    }
}
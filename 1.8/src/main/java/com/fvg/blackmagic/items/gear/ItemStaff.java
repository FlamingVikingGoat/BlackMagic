package com.fvg.blackmagic.items.gear;



import com.fvg.blackmagic.blocks.AMagicActivated;
import com.fvg.blackmagic.blocks.ModBlocks;
import com.fvg.blackmagic.core.BlackMagic;
import com.google.common.collect.Sets;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class ItemStaff extends ItemTool{
    public ItemStaff(ToolMaterial material, String unlocalizedName){
        super(2, material, Sets.newHashSet(new Block[]{}));
        this.setUnlocalizedName(unlocalizedName);
        this.setCreativeTab(BlackMagic.TabBlackMagicCore);
    }

    @Override
    public boolean onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ) {

        Block block = worldIn.getBlockState(pos).getBlock();

        if(block instanceof AMagicActivated);{
            ((AMagicActivated) block).setActivated(true);
        }

        return false;
    }
}

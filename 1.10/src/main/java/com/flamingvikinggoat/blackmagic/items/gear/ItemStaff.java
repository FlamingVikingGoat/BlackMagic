package com.flamingvikinggoat.blackmagic.items.gear;

import com.flamingvikinggoat.blackmagic.galdr.ASpells;
import com.flamingvikinggoat.blackmagic.core.BlackMagic;
import com.google.common.collect.Sets;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import java.util.Set;

public class ItemStaff extends ItemTool{
    private static final Set<Block> EFFECTIVE_ON = Sets.newHashSet(new Block[] {});
    private static int index;

    public ItemStaff(ToolMaterial material, String unlocalizedName, int index){
        super(2, 2, material, EFFECTIVE_ON);
        this.setRegistryName(unlocalizedName);
        this.setUnlocalizedName(unlocalizedName);
        this.setCreativeTab(BlackMagic.TabBlackMagicCore);

        ItemStaff.index = index;
    }

    @Override
    public EnumActionResult onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ) {
        if(!worldIn.isRemote) {
            ASpells.activateMagicBlock(worldIn, pos);
        }
        return EnumActionResult.PASS;
    }

    public static int getIndex(){
        return index;
    }
}

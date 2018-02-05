package com.flamingvikinggoat.blackmagic.items.gear;

import com.flamingvikinggoat.blackmagic.blocks.AMagicActivated;
import com.flamingvikinggoat.blackmagic.galdr.ASpells;
import com.flamingvikinggoat.blackmagic.core.BlackMagic;
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
    private static int index;

    public ItemModSword(ToolMaterial material, String unlocalizedName, int index){
        super(material);
        this.setRegistryName(unlocalizedName);
        this.setUnlocalizedName(unlocalizedName);
        this.setCreativeTab(BlackMagic.TabBlackMagicCore);
        ItemModSword.index = index;
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

    public static int getIndex() {
        return index;
    }
}

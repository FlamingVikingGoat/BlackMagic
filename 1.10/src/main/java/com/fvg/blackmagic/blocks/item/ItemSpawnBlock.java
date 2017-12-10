package com.fvg.blackmagic.blocks.item;

import com.fvg.blackmagic.HasSacrificeProvider;
import com.fvg.blackmagic.blocks.AMagicActivated;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemSpawnBlock extends ItemBlock{

    private boolean hasSacrifice = false;
    int hasSacrificeIntValue = 0;

    public void setHasSacrifice(boolean hasSacrifice){
        this.hasSacrifice = hasSacrifice;
        if(hasSacrifice){
            this.hasSacrificeIntValue = 1;
        }
        else {
            this.hasSacrificeIntValue = 0;
        }
    }

    public int getHasSacrificeIntValue() {
        return hasSacrificeIntValue;
    }

    public ItemSpawnBlock(Block block) {
        super(block);
        if(!(block instanceof  IMetaBlockName)){
            throw new IllegalArgumentException(String.format("The given Block %s is not an instance of IMetaBlockName!", block.getUnlocalizedName()));
        }
        this.setHasSubtypes(true);
        this.setMaxDamage(0);
    }



    @Override
    public String getUnlocalizedName(ItemStack stack) {
        return super.getUnlocalizedName() + "." + ((IMetaBlockName)this.block).getSpecialName(stack);
    }
}

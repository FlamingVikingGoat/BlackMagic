package com.fvg.blackmagic.creativetab;

import com.fvg.blackmagic.items.ModItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class TabBlackMagicCore extends CreativeTabs{

    public TabBlackMagicCore(String label){
        super(label);
        this.setBackgroundImageName("items.png");
    }

    @Override
    public Item getTabIconItem(){
        return ModItems.unrefinedInfernus;
    }

}

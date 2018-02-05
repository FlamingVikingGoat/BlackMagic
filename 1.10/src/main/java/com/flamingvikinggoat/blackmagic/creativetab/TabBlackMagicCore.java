package com.flamingvikinggoat.blackmagic.creativetab;

import com.flamingvikinggoat.blackmagic.items.ModItems;
import com.flamingvikinggoat.blackmagic.items.gear.ItemModSword;
import com.flamingvikinggoat.blackmagic.items.magic.MagicBook;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class TabBlackMagicCore extends CreativeTabs{

    public TabBlackMagicCore(String label){
        super(label);
        this.setBackgroundImageName("items.png");
    }

    @Override
    public Item getTabIconItem(){
        return ModItems.ITEMS[MagicBook.getIndex()];
    }

}

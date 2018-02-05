package com.flamingvikinggoat.blackmagic.items;

import net.minecraft.item.Item;

public class ItemBase extends Item{
    private static int index ;

    public ItemBase(String name, int index){
        this.setRegistryName(name);
        this.setUnlocalizedName(name);
        ItemBase.index = index;
    }

    public static int getIndex(){
        return ItemBase.index;
    }
}

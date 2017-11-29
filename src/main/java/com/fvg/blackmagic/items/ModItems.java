package com.fvg.blackmagic.items;

import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModItems {

    public static Item infernus;

    public static void init() {
        infernus = new Item().setUnlocalizedName("infernus");
    }

    public static void register() {
        registerItem(infernus);
    }

    public static void registerItem(Item item){
        GameRegistry.registerItem(item, item.getUnlocalizedName().substring(5));
        System.out.println("Registered Item: " + item.getUnlocalizedName().substring(5));
    }
}

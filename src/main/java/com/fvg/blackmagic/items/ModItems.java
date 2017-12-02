package com.fvg.blackmagic.items;

import com.fvg.blackmagic.core.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
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

    public static void registerRenders(){
        registerRender(infernus);
    }

    public static void registerItem(Item item){
        GameRegistry.registerItem(item, item.getUnlocalizedName().substring(5));
        System.out.println("Registered Item: " + item.getUnlocalizedName().substring(5));
    }

    public static void registerRender(Item item){
       Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0,
               new ModelResourceLocation(
                       Reference.MODID + ":" + item.getUnlocalizedName().substring(5), "inventory"
               ));
    }
}

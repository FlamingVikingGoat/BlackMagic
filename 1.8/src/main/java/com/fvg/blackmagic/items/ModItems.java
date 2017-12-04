package com.fvg.blackmagic.items;

import com.fvg.blackmagic.core.BlackMagic;
import com.fvg.blackmagic.core.Reference;
import com.fvg.blackmagic.items.gear.ItemModSword;
import com.fvg.blackmagic.items.gear.ItemStaff;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSword;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModItems {

    //Tool Materials
    public static Item.ToolMaterial satanicMaterial = EnumHelper.addToolMaterial("satanicMaterial",3, 9999999, 35.0F, 20.0F, 999);

    //Tools
    public static ItemSword deathbringer;
    public static ItemStaff basicStaff;

    //Generic Items
    public static Item infernus;

    public static void init() {

        //Tools
        deathbringer = new ItemModSword(satanicMaterial, "deathbringer");
        basicStaff = new ItemStaff(Item.ToolMaterial.WOOD, "basicStaff");

        //Generic Items
        infernus = new Item().setUnlocalizedName("infernus");
        infernus.setCreativeTab(BlackMagic.TabBlackMagicCore);

    }

    public static void register() {

        //Tools
        registerItem(deathbringer);
        registerItem(basicStaff);

        //Generic Items
        registerItem(infernus);

    }

    public static void registerRenders(){

        //Tools
        registerRender(deathbringer);
        registerRender(basicStaff);

        //Generic Items
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

package com.fvg.blackmagic.items;

import com.fvg.blackmagic.core.BlackMagic;
import com.fvg.blackmagic.core.Reference;
import com.fvg.blackmagic.items.gear.ItemModSword;
import com.fvg.blackmagic.items.gear.ItemStaff;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSword;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModItems {

    public static Item.ToolMaterial satanicMaterial = EnumHelper.addToolMaterial("satanicMaterial",3, 9999999, 35.0F, 20.0F, 999);
    public static Item.ToolMaterial blackInfernus = EnumHelper.addToolMaterial("blackInfernus", 3, 66666, 0.45F, 0.45F, 7);
    public static Item.ToolMaterial redInfernus = EnumHelper.addToolMaterial("redInfernus", 2, 6666, 0.25F, 0.25F, 6);
    public static Item.ToolMaterial purpleInfernus = EnumHelper.addToolMaterial("purpleInfernus", 1, 666, 0.10F, 0.10F, 5);

    public static ItemSword deathbringer;
    public static ItemStaff blackStaff;
    public static ItemStaff redStaff;
    public static ItemStaff purpleStaff;


    public static Item infernus;

    public static void init() {
        deathbringer = new ItemModSword(satanicMaterial, "deathbringer");
        blackStaff = new ItemStaff(blackInfernus, "blackStaff");
        redStaff = new ItemStaff(redInfernus, "redStaff");
        purpleStaff = new ItemStaff(purpleInfernus, "purpleStaff");

        infernus = new Item().setUnlocalizedName("infernus");
        infernus.setCreativeTab(BlackMagic.TabBlackMagicCore);
    }

    public static void register() {
        registerItem(deathbringer);
        registerItem(blackStaff);
        registerItem(redStaff);
        registerItem(purpleStaff);

        registerItem(infernus);
    }

    public static void registerRenders(){
        registerRender(deathbringer);
        registerRender(blackStaff);
        registerRender(redStaff);
        registerRender(purpleStaff);

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

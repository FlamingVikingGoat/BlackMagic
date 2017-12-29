package com.fvg.blackmagic.items;

import com.fvg.blackmagic.core.BlackMagic;
import com.fvg.blackmagic.core.Reference;
import com.fvg.blackmagic.items.gear.ItemModSword;
import com.fvg.blackmagic.items.gear.ItemStaff;
import com.fvg.blackmagic.items.magic.MagicBook;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSword;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
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


    public static Item unrefinedInfernus;
    public static Item purple_infernus;
    public static Item red_infernus;
    public static Item black_infernus;
    public static MagicBook magicBook;


    public static void init() {
        deathbringer = new ItemModSword(satanicMaterial, "deathbringer");
        blackStaff = new ItemStaff(blackInfernus, "blackStaff");
        redStaff = new ItemStaff(redInfernus, "redStaff");
        purpleStaff = new ItemStaff(purpleInfernus, "purpleStaff");

        unrefinedInfernus = new Item().setUnlocalizedName("unrefinedInfernus");
        purple_infernus = new Item().setUnlocalizedName("purple_infernus");
        red_infernus = new Item().setUnlocalizedName("red_infernus");
        black_infernus = new Item().setUnlocalizedName("black_infernus");
        magicBook = new MagicBook("magicBook");

        unrefinedInfernus.setCreativeTab(BlackMagic.TabBlackMagicCore);
        purple_infernus.setCreativeTab(BlackMagic.TabBlackMagicCore);
        red_infernus.setCreativeTab(BlackMagic.TabBlackMagicCore);
        black_infernus.setCreativeTab(BlackMagic.TabBlackMagicCore);
        magicBook.setCreativeTab(BlackMagic.TabBlackMagicCore);

    }

    public static void register() {
        registerItem(deathbringer);
        registerItem(blackStaff);
        registerItem(redStaff);
        registerItem(purpleStaff);
        registerItem(unrefinedInfernus);
        registerItem(purple_infernus);
        registerItem(red_infernus);
        registerItem(black_infernus);
        registerItem(magicBook);

    }

    public static void registerRenders(){
        registerRender(deathbringer);
        registerRender(blackStaff);
        registerRender(redStaff);
        registerRender(purpleStaff);
        registerRender(unrefinedInfernus);
        registerRender(purple_infernus);
        registerRender(red_infernus);
        registerRender(black_infernus);
        registerRender(magicBook);

    }

    public static void registerItem(Item item){
        GameRegistry.registerItem(item, item.getUnlocalizedName().substring(5));
        System.out.println("Registered Item: " + item.getUnlocalizedName().substring(5));
    }

    public static void registerRender(Item item){
        ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(
                new ResourceLocation(Reference.MODID, item.getUnlocalizedName().substring(5)), "inventory"
        ));
    }
}

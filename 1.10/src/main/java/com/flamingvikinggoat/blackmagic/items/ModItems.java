package com.flamingvikinggoat.blackmagic.items;

import com.flamingvikinggoat.blackmagic.core.BlackMagic;
import com.flamingvikinggoat.blackmagic.core.Reference;
import com.flamingvikinggoat.blackmagic.items.gear.*;
import com.flamingvikinggoat.blackmagic.items.magic.MagicBook;
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
    private static int ID = 0;

    private static int nextID(){
        return ID++;
    }

    public static final Item[] ITEMS =  {
        new ItemModSword(satanicMaterial, "deathbringer", nextID()),
        new ItemStaffBlack(blackInfernus, "black_staff", nextID()),
        new ItemStaffRed(redInfernus, "red_staff", nextID()),
        new ItemStaffPurple(purpleInfernus, "purple_staff", nextID()),

        new ItemInfernusUnrefined("unrefined_infernus", nextID()),
        new ItemInfernusPurple("purple_infernus", nextID()),
        new ItemInfernusRed("red_infernus", nextID()),
        new ItemInfernusBlack("black_infernus", nextID()),
        new MagicBook("magic_book", nextID())
    };
}

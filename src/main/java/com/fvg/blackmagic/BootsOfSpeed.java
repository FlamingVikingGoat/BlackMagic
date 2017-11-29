package com.fvg.blackmagic;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraftforge.common.util.EnumHelper;


public class BootsOfSpeed extends ItemArmor implements IDemonicArmor{
    public BootsOfSpeed(ArmorMaterial material, int renderIndex, int armorType){
        super(material, renderIndex, armorType);
    }
    public static ArmorMaterial demonArmor = EnumHelper.addArmorMaterial("Demonite", "blackmagic:demon_armor", 100, new int[]{100, 100, 100, 100}, 100);
    public static ItemArmor bootsOfSpeed;

    @Override
    public void addPositiveEffect(EntityPlayer player) {
        player.jumpMovementFactor = 1000000F;
    }
}

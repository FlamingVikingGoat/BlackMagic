package com.fvg.blackmagic.items.gear;

import com.fvg.blackmagic.core.BlackMagic;
import net.minecraft.item.ItemSword;

public class ItemModSword extends ItemSword{
    public ItemModSword(ToolMaterial material, String unlocalizedName){
        super(material);
        this.setUnlocalizedName(unlocalizedName);
        this.setCreativeTab(BlackMagic.TabBlackMagicCore);
    }
}

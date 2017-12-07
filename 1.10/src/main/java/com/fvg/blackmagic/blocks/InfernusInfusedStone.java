package com.fvg.blackmagic.blocks;


import com.fvg.blackmagic.core.BlackMagic;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class InfernusInfusedStone extends Block{
    public InfernusInfusedStone(String unlocalizedName){
        super(Material.ROCK);
        this.setUnlocalizedName(unlocalizedName);
        this.setCreativeTab(BlackMagic.TabBlackMagicCore);
    }
}

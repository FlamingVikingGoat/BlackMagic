package com.flamingvikinggoat.blackmagic.blocks;

import com.flamingvikinggoat.blackmagic.core.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockBase extends Block{
    private static int index;

    public BlockBase(String name, Material materialIn, int index) {
        super(materialIn);

        BlockBase.index = index;
        this.setRegistryName(name);
        this.setUnlocalizedName(name);
    }

    public static int getIndex() {
        return index;
    }
}

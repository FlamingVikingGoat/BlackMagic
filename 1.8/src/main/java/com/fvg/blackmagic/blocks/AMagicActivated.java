package com.fvg.blackmagic.blocks;

import net.minecraft.block.material.Material;

public abstract class AMagicActivated extends net.minecraft.block.Block{
    public AMagicActivated(Material material){
        super(material);
    }

    public boolean isActivated = false;

    public void setActivated(boolean activated) {
        isActivated = activated;
    }

    public boolean isActivated() {
        return isActivated;
    }

    public void printActivationStatusToDebug(){
        System.out.println(this.isActivated);
    }
}

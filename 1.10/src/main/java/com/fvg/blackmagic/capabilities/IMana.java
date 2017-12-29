package com.fvg.blackmagic.capabilities;

import net.minecraft.entity.player.EntityPlayer;

public interface IMana {
    void takeFromManaPool(float points, EntityPlayer playerIn);
    void addToManaPool(float points);
    void increaseMaxMana(float points);
    void decreaseMaxMana(float points);
    void set(float points);
    void setMaxMana(float points);
    void isMagical(boolean isMagical);

    float getMaxMana();
    float getMana();
    boolean getMagical();

}

package com.flamingvikinggoat.blackmagic.capabilities;

import net.minecraft.entity.player.EntityPlayer;

public interface IMana {
    boolean takeFromManaPool(float points, EntityPlayer playerIn); //Returns bool based on whether or not caster has sufficient mana; Needs player to give message.
    void addToManaPool(float points);
    void increaseMaxMana(float points);
    void decreaseMaxMana(float points);
    void set(float points);
    void setMaxMana(float points);
    void setMagical(boolean isMagical);

    float getMaxMana();
    float getMana();
    boolean isMagical();

}

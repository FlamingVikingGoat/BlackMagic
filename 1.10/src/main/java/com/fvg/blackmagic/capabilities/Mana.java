package com.fvg.blackmagic.capabilities;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.text.TextComponentString;

public class Mana implements IMana{
    private float mana = 0.0F;
    private float maxMana = 0.0F;
    private boolean isMagical = false;

    @Override
    public void set(float points){
        this.mana = points;
    }

    @Override
    public boolean takeFromManaPool(float points, EntityPlayer playerIn) {
        if(points > this.mana){
            String message = "Not enough Mana!";
            playerIn.addChatMessage(new TextComponentString(message));
            this.mana = 0;
            return false;
        }
        this.mana -= points;
        String message = String.format("Mana consumed: %d \nMana left: %d", (int) points, (int) this.mana);
        return true;
    }

    @Override
    public void addToManaPool(float points) {
        if(this.mana+points < this.maxMana){
            this.mana += points;
        } else {
            this.mana = this.maxMana;
        }
    }

    @Override
    public void increaseMaxMana(float points) {
        this.maxMana += this.maxMana*points;

    }

    @Override
    public void decreaseMaxMana(float points) {
        this.maxMana -= this.maxMana*points;
    }

    @Override
    public void setMaxMana(float points) {
        this.maxMana = points;
    }

    @Override
    public void setMagical(boolean isMagical) {
        this.isMagical = isMagical;
        if (isMagical) {
            setMaxMana((this.maxMana == 0 ? 50.0F : this.getMaxMana()));
        }else {
            setMaxMana(0);
        }
    }
    @Override
    public float getMaxMana() {
        return this.maxMana;
    }

    @Override
    public float getMana() {
        return this.mana;
    }

    @Override
    public boolean isMagical() {
        return this.isMagical;
    }
}

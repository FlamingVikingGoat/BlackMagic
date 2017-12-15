package com.fvg.blackmagic.capabilities;

public class Mana implements IMana{
    private float mana = 250.0F;


    @Override
    public void consume(float points) {
        this.mana -= points;
    }

    @Override
    public void fill(float points) {
        this.mana += points;
    }

    @Override
    public void set(float points) {
        this.mana = points;
    }

    @Override
    public float getMana() {
        return this.mana;
    }
}

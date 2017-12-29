package com.fvg.blackmagic.capabilities;

public class Mana implements IMana{
    private float mana = 250.0F;
    private boolean isMagical = false;
    private byte isMagicalByte = 0;


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
    public void isMagical(boolean isMagical) {
        this.isMagical = isMagical;
        if(isMagical){
            setMagicalByteStorage(((byte)1));
        } else {
            setMagicalByteStorage(((byte)0));
        }
    }

    @Override
    public void setMagicalByteStorage(byte isMagicalByte) {
        this.isMagicalByte = isMagicalByte;
        if(isMagicalByte == ((byte)1)){
            this.isMagical = true;
        } else if(isMagicalByte == ((byte)0)){
            this.isMagical = false;
        }
    }

    @Override
    public float getMana() {
        return this.mana;
    }

    @Override
    public boolean getMagical() {
        return this.isMagical;
    }

    @Override
    public byte getMagicalByteStorage() {
        return isMagicalByte;
    }
}

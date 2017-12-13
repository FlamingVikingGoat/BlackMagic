package com.fvg.blackmagic;

public class HasSacrifice implements IHasSacrifice {

    private boolean hasSacrifice = false;
    private int hasSacrificeIntValue = 0;

    @Override
    public boolean hasSacrifice() {
        return this.hasSacrifice;
    }

    @Override
    public void setHasSacrifice(Boolean hasSacrifice) {
        this.hasSacrifice = hasSacrifice;
        if(hasSacrifice){
            this.hasSacrificeIntValue = 1;
        }
        else {
            this.hasSacrificeIntValue = 0;
        }
    }

    @Override
    public int getHasSacrificeIntValue() {
        return this.hasSacrificeIntValue;
    }

    @Override
    public void setHasSacrificeIntValue(int hasSacrificeIntValue) {
        this.hasSacrificeIntValue = hasSacrificeIntValue;
        if(hasSacrificeIntValue == 0){
            this.hasSacrifice = false;
        }
        else {
            this.hasSacrifice = true;
        }
    }
}



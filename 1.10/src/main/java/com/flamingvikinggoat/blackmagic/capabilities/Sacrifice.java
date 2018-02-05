package com.flamingvikinggoat.blackmagic.capabilities;

public class Sacrifice implements ISacrifice{

    private int sacrifice = 0;

    @Override
    public void setSacrifice(int sacrifice) {
        this.sacrifice = sacrifice;
    }

    @Override
    public int getSacrifice() {
        return this.sacrifice;
    }
}

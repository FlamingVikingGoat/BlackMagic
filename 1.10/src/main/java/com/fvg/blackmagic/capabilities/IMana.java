package com.fvg.blackmagic.capabilities;

public interface IMana {
    void consume(float points);
    void fill(float points);
    void set(float points);
    void isMagical(boolean isMagical);
    void setMagicalByteStorage(byte isMagicalByte);

    float getMana();
    boolean getMagical();
    byte getMagicalByteStorage();
}

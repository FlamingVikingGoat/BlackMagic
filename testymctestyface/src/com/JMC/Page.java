package com.JMC;

public class Page {
    public String str = "Page String";
    public int[] ints = new int[]{0, 1};

    public void setInts(int... args){
        System.arraycopy(args, 0, ints, 0, args.length);
    }
}

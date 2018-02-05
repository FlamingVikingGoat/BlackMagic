package com.fvg.blackmagic.client.gui;
//Dummy Class- Since I fail at reflection, I need to use this class instead
public class DummyClass {

    static private int[] dummyArr;

    public static void setDummyArr(int[] dummyArr) {
        DummyClass.dummyArr = dummyArr;
    }

    public static int[] getDummyArr(){
        return DummyClass.dummyArr;
    }

}

package com.fvg.blackmagic.items.magic;

import com.fvg.blackmagic.core.Reference;
import net.minecraft.util.ResourceLocation;

public class MagicBookPage {
    private Integer index;
    private String pageName = "";
    private String firstPageText = "";
    private String secondPageText = "";
    private ResourceLocation texture = new ResourceLocation(Reference.MODID+":textures/gui/book_base.png");
    private boolean isKnown = false;
    private int[] stringPosOffset = new int[]{36, 40};

    MagicBookPage(){
        this(null, "", "book_base.png", false);
    }

    MagicBookPage(Integer index, String pageName){
        this(index, pageName, "book_base.png", false);
    }


    MagicBookPage(Integer index, String pageName, boolean known){
        this(index, pageName, "book_base.png", known);
    }


    MagicBookPage(Integer index, String pageName, String texturePath, boolean known){
        this.index = index;
        this.pageName = pageName;
        this.texture = new ResourceLocation(Reference.MODID+":textures/gui/"+texturePath);
        this.isKnown = known;
        if(!pageName.equals("")){
            MagicBookLoader.pages.add(index, this);
        }
    }

    public Integer getIndex() {
        return index;
    }

    public String getPageName() {
        return pageName;
    }

    public String getFirstPageText() {
        return firstPageText;
    }

    public String getSecondPageText() {
        return secondPageText;
    }

    public ResourceLocation getTexture() {
        return texture;
    }

    public boolean isKnown() {
        return isKnown;
    }

    public void setStringPosOffset(int... args) {
        System.arraycopy(args, 0, stringPosOffset, 0, args.length);
    }

    public void setFirstPageText(String firstPageText) {
        this.firstPageText = firstPageText;
    }

    public void setSecondPageText(String secondPageText) {
        this.secondPageText = secondPageText;
    }

    public void setKnown(boolean known) {
        isKnown = known;
    }

    public int[] getStringPosOffset() {
        return stringPosOffset;
    }
}

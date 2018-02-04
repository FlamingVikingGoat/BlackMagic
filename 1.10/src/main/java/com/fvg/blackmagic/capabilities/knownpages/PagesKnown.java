package com.fvg.blackmagic.capabilities.knownpages;

import com.fvg.blackmagic.items.magic.MagicBookPage;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.text.TextComponentString;

public class PagesKnown implements IPagesKnown{
    private int[] knownPages = new int[]{1,1,1,1,1,1,1,0};

    @Override
    public void loadKnownPages(int[] loadedPages) {
        this.knownPages = loadedPages;
    }

    @Override
    public int[] getKnownPages() {
        return this.knownPages;
    }

    @Override
    public int[] saveKnownPages() {
       return this.knownPages;
    }

    @Override
    public void makePageKnown(MagicBookPage pageLearned, EntityPlayer playerIn) {
        int index = pageLearned.getIndex();
        getKnownPages()[index] = 1;
        String message = String.format("Congratulations! Page %s added!", pageLearned.getPageName());
        playerIn.addChatMessage(new TextComponentString(message));
    }
}

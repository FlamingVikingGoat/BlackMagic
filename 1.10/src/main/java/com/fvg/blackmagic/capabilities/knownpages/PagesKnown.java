package com.fvg.blackmagic.capabilities.knownpages;

import com.fvg.blackmagic.items.magic.MagicBookLoader;
import com.fvg.blackmagic.items.magic.MagicBookPage;
import net.minecraft.nbt.NBTTagCompound;

import java.util.ArrayList;
import java.util.List;

public class PagesKnown implements IPagesKnown{
    private List<MagicBookPage> knownPages = new ArrayList<MagicBookPage>();

    @Override
    public void loadKnownPages(boolean known, int index) {
        if(known){
            knownPages.add(index, MagicBookLoader.pages.get(index));
        } else {
            knownPages.add(index, MagicBookLoader.emptyPage);
        }
    }

    @Override
    public List<MagicBookPage> getKnownPages() {
        for(MagicBookPage page: MagicBookLoader.pages){
            if(page.isKnown()){
                knownPages.add(page.getIndex(), page);
            } else {
                knownPages.add(page.getIndex(), MagicBookLoader.emptyPage);
            }
        }
        return this.knownPages;
    }

    @Override
    public MagicBookPage getPageFromIndex(int index) {
        return knownPages.get(index);
    }

    @Override
    public int getIndexFromPage(MagicBookPage page) {
        return knownPages.indexOf(page);
    }

    @Override
    public NBTTagCompound saveKnownPages() {
        NBTTagCompound tag = new NBTTagCompound();
        for(MagicBookPage page: MagicBookLoader.pages){
            tag.setBoolean(page.getPageName(), page.isKnown());
        }
        return tag;
    }

    @Override
    public void makePageKnown(MagicBookPage pageLearned) {
        knownPages.add(pageLearned.getIndex(), pageLearned);
        pageLearned.setKnown(true);
    }
}

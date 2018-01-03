package com.fvg.blackmagic.capabilities.knownpages;

import com.fvg.blackmagic.items.magic.MagicBookPage;
import net.minecraft.nbt.NBTTagCompound;

import java.util.List;

public interface IPagesKnown {
    NBTTagCompound saveKnownPages();
    List<MagicBookPage> getKnownPages();
    MagicBookPage getPageFromIndex(int index);
    int getIndexFromPage(MagicBookPage page);

    void loadKnownPages(boolean known, int index);
    void makePageKnown(MagicBookPage pageLearned);
}

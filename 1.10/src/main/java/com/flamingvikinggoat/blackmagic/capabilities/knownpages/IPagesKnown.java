package com.flamingvikinggoat.blackmagic.capabilities.knownpages;

import com.flamingvikinggoat.blackmagic.items.magic.MagicBookPage;
import net.minecraft.entity.player.EntityPlayer;

public interface IPagesKnown {
    int[] saveKnownPages();
    int[] getKnownPages();

    void loadKnownPages(int[] loadedPages);
    void makePageKnown(MagicBookPage pageLearned, EntityPlayer playerIn);
}

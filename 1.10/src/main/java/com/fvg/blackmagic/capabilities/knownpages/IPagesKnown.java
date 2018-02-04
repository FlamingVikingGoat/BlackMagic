package com.fvg.blackmagic.capabilities.knownpages;

import com.fvg.blackmagic.items.magic.MagicBookPage;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;

import java.util.List;

public interface IPagesKnown {
    int[] saveKnownPages();
    int[] getKnownPages();

    void loadKnownPages(int[] loadedPages);
    void makePageKnown(MagicBookPage pageLearned, EntityPlayer playerIn);
}

package com.fvg.blackmagic.capabilities.knownpages;

import com.fvg.blackmagic.items.magic.MagicBookLoader;
import com.fvg.blackmagic.items.magic.MagicBookPage;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;

public class PagesKnownStorage implements Capability.IStorage<IPagesKnown>{
    @Override
    public NBTBase writeNBT(Capability<IPagesKnown> capability, IPagesKnown instance, EnumFacing side) {
        return instance.saveKnownPages();
    }

    @Override
    public void readNBT(Capability<IPagesKnown> capability, IPagesKnown instance, EnumFacing side, NBTBase nbt) {
       for(MagicBookPage page : MagicBookLoader.pages){
           instance.loadKnownPages(((NBTTagCompound)nbt).getBoolean(page.getPageName()), page.getIndex());
       }
    }
}

package com.fvg.blackmagic.capabilities.knownpages;

import com.fvg.blackmagic.items.magic.MagicBookLoader;
import com.fvg.blackmagic.items.magic.MagicBookPage;
import net.minecraft.nbt.*;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.Constants;

public class PagesKnownStorage implements Capability.IStorage<IPagesKnown>{
    @Override
    public NBTBase writeNBT(Capability<IPagesKnown> capability, IPagesKnown instance, EnumFacing side) {
        NBTTagCompound tag = new NBTTagCompound();
        tag.setIntArray("known pages", instance.saveKnownPages());
        return tag;
    }

    @Override
    public void readNBT(Capability<IPagesKnown> capability, IPagesKnown instance, EnumFacing side, NBTBase nbt) {
        instance.loadKnownPages(((NBTTagCompound)nbt).getIntArray("known pages"));
    }
}

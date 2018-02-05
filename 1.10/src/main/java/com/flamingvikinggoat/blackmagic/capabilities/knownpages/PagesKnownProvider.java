package com.flamingvikinggoat.blackmagic.capabilities.knownpages;

import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

import javax.annotation.Nullable;

public class PagesKnownProvider implements ICapabilitySerializable<NBTBase>{

    @CapabilityInject(IPagesKnown.class)
    public static final Capability<IPagesKnown> KNOWN_PAGES = null;

    private IPagesKnown instance = KNOWN_PAGES.getDefaultInstance();

    @Override
    public boolean hasCapability(Capability<?> capability, @Nullable EnumFacing facing) {
        return capability == KNOWN_PAGES;
    }

    @Override
    public <T> T getCapability(Capability<T> capability, @Nullable EnumFacing facing) {
        return capability == KNOWN_PAGES ? KNOWN_PAGES.<T> cast(this.instance) : null;
    }

    @Override
    public NBTBase serializeNBT() {
        return KNOWN_PAGES.getStorage().writeNBT(KNOWN_PAGES, this.instance, null);
    }

    @Override
    public void deserializeNBT(NBTBase nbt) {
        KNOWN_PAGES.getStorage().readNBT(KNOWN_PAGES, this.instance, null, nbt);
    }
}

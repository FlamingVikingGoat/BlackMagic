package com.fvg.blackmagic;

import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

import javax.annotation.Nullable;

public class HasSacrificeProvider implements ICapabilitySerializable<NBTBase>{

    @CapabilityInject(IHasSacrifice.class)
    public static final Capability<IHasSacrifice> HAS_SACRIFICE = null;

    private IHasSacrifice instance = HAS_SACRIFICE.getDefaultInstance();

    @Override
    public boolean hasCapability(Capability<?> capability, @Nullable EnumFacing facing) {
        return capability == HAS_SACRIFICE;
    }

    @Override
    public <T> T getCapability(Capability<T> capability, @Nullable EnumFacing facing) {
        return null == HAS_SACRIFICE ? HAS_SACRIFICE.<T> cast(this.instance) : null;
    }

    @Override
    public NBTBase serializeNBT() {
        return HAS_SACRIFICE.getStorage().writeNBT(HAS_SACRIFICE, this.instance, null);
    }

    @Override
    public void deserializeNBT(NBTBase nbt) {
        HAS_SACRIFICE.getStorage().readNBT(HAS_SACRIFICE, this.instance, null, nbt);
    }
}

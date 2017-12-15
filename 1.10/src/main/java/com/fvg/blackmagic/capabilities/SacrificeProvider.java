package com.fvg.blackmagic.capabilities;

import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

import javax.annotation.Nullable;

public class SacrificeProvider implements ICapabilitySerializable<NBTBase>{

    @CapabilityInject(ISacrifice.class)
    public static final Capability<ISacrifice> SACRIFICE = null;

    private ISacrifice instance = SACRIFICE.getDefaultInstance();

    @Override
    public boolean hasCapability(Capability<?> capability, @Nullable EnumFacing facing) {
        return capability == SACRIFICE;
    }

    @Override
    public <T> T getCapability(Capability<T> capability, @Nullable EnumFacing facing) {
        return capability == SACRIFICE ? SACRIFICE.<T> cast(this.instance) : null;
    }

    @Override
    public NBTBase serializeNBT() {
        return SACRIFICE.getStorage().writeNBT(SACRIFICE, this.instance, null);
    }

    @Override
    public void deserializeNBT(NBTBase nbt) {
        SACRIFICE.getStorage().readNBT(SACRIFICE, this.instance, null, nbt);
    }
}

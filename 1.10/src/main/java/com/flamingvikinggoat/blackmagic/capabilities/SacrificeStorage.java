package com.flamingvikinggoat.blackmagic.capabilities;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTPrimitive;
import net.minecraft.nbt.NBTTagInt;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;

public class SacrificeStorage implements Capability.IStorage<ISacrifice> {

    @Override
    public NBTBase writeNBT(Capability<ISacrifice> capability, ISacrifice instance, EnumFacing side) {
        return new NBTTagInt(instance.getSacrifice());
    }

    @Override
    public void readNBT(Capability<ISacrifice> capability, ISacrifice instance, EnumFacing side, NBTBase nbt) {
        instance.setSacrifice(((NBTPrimitive) nbt).getInt());
    }
}

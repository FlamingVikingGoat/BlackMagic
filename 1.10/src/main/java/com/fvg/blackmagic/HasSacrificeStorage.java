package com.fvg.blackmagic;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTPrimitive;
import net.minecraft.nbt.NBTTagInt;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;

public class HasSacrificeStorage implements Capability.IStorage<IHasSacrifice> {

    @Override
    public NBTBase writeNBT(Capability<IHasSacrifice> capability, IHasSacrifice instance, EnumFacing side) {
        return new NBTTagInt(instance.getHasSacrificeIntValue());
    }

    @Override
    public void readNBT(Capability<IHasSacrifice> capability, IHasSacrifice instance, EnumFacing side, NBTBase nbt) {
        instance.setHasSacrificeIntValue(((NBTPrimitive) nbt).getInt());
    }
}

package com.flamingvikinggoat.blackmagic.capabilities;

import net.minecraft.nbt.*;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;

public class ManaStorage implements Capability.IStorage<IMana> {
    @Override
    public NBTBase writeNBT(Capability<IMana> capability, IMana instance, EnumFacing side) {
        NBTTagCompound tag = new NBTTagCompound();
        tag.setBoolean("Is Magical", instance.isMagical());
        tag.setFloat("Mana", instance.getMana());
        tag.setFloat("Max Mana", instance.getMaxMana());
        return tag;
    }

    @Override
    public void readNBT(Capability<IMana> capability, IMana instance, EnumFacing side, NBTBase nbt) {
        instance.setMaxMana(((NBTTagCompound)nbt).getFloat("Max Mana"));
        instance.set(((NBTTagCompound)nbt).getFloat("Mana"));
        instance.setMagical(((NBTTagCompound)nbt).getBoolean("Is Magical"));
    }
}

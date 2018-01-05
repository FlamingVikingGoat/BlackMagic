package com.fvg.blackmagic.network;

import com.fvg.blackmagic.capabilities.knownpages.IPagesKnown;
import com.fvg.blackmagic.capabilities.knownpages.PagesKnownProvider;
import com.fvg.blackmagic.client.gui.GuiMagicBook;
import com.fvg.blackmagic.lib.LibGuiIDs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {
    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        IPagesKnown pagesKnown = player.getCapability(PagesKnownProvider.KNOWN_PAGES, null);

        switch(ID){
            case LibGuiIDs.MagicBook:
                return new GuiMagicBook(pagesKnown.getKnownPages());

        }

        return null;
    }
}

package com.flamingvikinggoat.blackmagic.client.gui.GaldrButtons;

import com.flamingvikinggoat.blackmagic.items.magic.MagicBookLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiButtonSummonBlock extends GuiButtonMagicBook{
    public GuiButtonSummonBlock (int buttonId, int leftOffset, int topOffset) {
        super(buttonId, leftOffset, topOffset, 3, MagicBookLoader.summonBlockInfo, MagicBookLoader.modContents);
    }

}

package com.fvg.blackmagic.client.gui.GaldrButtons;

import com.fvg.blackmagic.items.magic.MagicBookLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiButtonStaff extends GuiButtonMagicBook{
    public GuiButtonStaff(int buttonId, int leftOffset, int topOffset) {
        super(buttonId, leftOffset, topOffset, 1, MagicBookLoader.staffInfo, MagicBookLoader.modContents);
    }

}

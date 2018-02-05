package com.flamingvikinggoat.blackmagic.client.gui.GaldrButtons;

import com.flamingvikinggoat.blackmagic.items.magic.MagicBookLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiButtonInfernus extends GuiButtonMagicBook{
    public GuiButtonInfernus(int buttonId, int leftOffset, int topOffset) {
        super(buttonId, leftOffset, topOffset, 2, MagicBookLoader.infernusInfo, MagicBookLoader.modContents);
    }

}

package com.fvg.blackmagic.client.gui.GaldrButtons;

import com.fvg.blackmagic.items.magic.MagicBookLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiButtonSummonRitual extends GuiButtonMagicBook{
    public GuiButtonSummonRitual(int buttonId, int leftOffset, int topOffset){
        super(buttonId, leftOffset, topOffset, 3, MagicBookLoader.summonRitual, MagicBookLoader.contentTable);
    }
}

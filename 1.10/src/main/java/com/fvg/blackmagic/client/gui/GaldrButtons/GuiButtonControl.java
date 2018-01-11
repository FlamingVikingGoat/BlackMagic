package com.fvg.blackmagic.client.gui.GaldrButtons;

import com.fvg.blackmagic.core.Reference;
import com.fvg.blackmagic.items.magic.MagicBookLoader;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class GuiButtonControl extends GuiButtonMagicBook{
    public GuiButtonControl(int buttonId, int leftOffset, int topOffset){
        super(buttonId, leftOffset, topOffset, 2, MagicBookLoader.controlIntro, MagicBookLoader.contentTable);
    }
}

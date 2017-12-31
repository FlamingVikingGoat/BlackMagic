package com.fvg.blackmagic.client.gui.GaldrButtons;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import org.lwjgl.opengl.GL11;

import static com.fvg.blackmagic.client.gui.GuiMagicBook.bookPageTextures;

public class GuiButtonControl extends GuiButton{
    public GuiButtonControl(int buttonId, int x, int y) {
        super(buttonId, x, y, 20, 20, "");
    }

    @Override
    public void drawButton(Minecraft mc, int mouseX, int mouseY) {
        if(visible){
            GL11.glColor4f(1F, 1F, 1F, 1F);
            mc.renderEngine.bindTexture(bookPageTextures[1]);
            int textureX = 192;
            int textureY = 0;

            drawTexturedModalRect(xPosition, yPosition, textureX, textureY, 20, 20);
        }
    }

}

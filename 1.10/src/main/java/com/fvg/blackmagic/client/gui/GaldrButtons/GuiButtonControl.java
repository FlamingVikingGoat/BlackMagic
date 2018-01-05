package com.fvg.blackmagic.client.gui.GaldrButtons;

import com.fvg.blackmagic.core.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class GuiButtonControl extends GuiButton{
    public GuiButtonControl(int buttonId, int x, int y) {
        super(buttonId, x, y, 40, 40, "");
    }

    @Override
    public void drawButton(Minecraft mc, int mouseX, int mouseY) {
        if(visible){
            GL11.glColor4f(1F, 1F, 1F, 1F);
            mc.renderEngine.bindTexture(new ResourceLocation(Reference.MODID+":textures/gui/book.png"));
            int textureX = 384;
            int textureY = 0;

            drawModalRectWithCustomSizedTexture(xPosition, yPosition, textureX, textureY, 40, 40, 512, 512);
        }
    }

}

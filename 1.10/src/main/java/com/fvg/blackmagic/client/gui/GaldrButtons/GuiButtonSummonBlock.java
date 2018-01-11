package com.fvg.blackmagic.client.gui.GaldrButtons;

import com.fvg.blackmagic.core.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class GuiButtonSummonBlock extends GuiButton{
    public GuiButtonSummonBlock (int buttonId, int leftOffset, int topOffset) {
        super(buttonId, leftOffset+45, topOffset+59, 16, 16, "");
    }

    @Override
    public void drawButton(Minecraft mc, int mouseX, int mouseY) {
        if(visible){
            GL11.glColor4f(1f, 1f, 1f, 1f);
            mc.renderEngine.bindTexture(new ResourceLocation(Reference.MODID, "textures/gui/buttons.png"));
            int textureX = 0;
            int textureY = 68;
            drawModalRectWithCustomSizedTexture(xPosition, yPosition, textureX, textureY, 16, 16, 512, 512);
        }
    }
}

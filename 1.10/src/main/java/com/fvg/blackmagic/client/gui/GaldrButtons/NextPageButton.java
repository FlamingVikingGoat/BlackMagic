package com.fvg.blackmagic.client.gui.GaldrButtons;

import com.fvg.blackmagic.core.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class NextPageButton extends GuiButton {

    private final boolean isNextButton;

    public NextPageButton(int buttonId, int x, int y, boolean isNextButton) {
        super(buttonId, x, y, 23, 13, "");
        this.isNextButton = isNextButton;
    }

    @Override
    public void drawButton(Minecraft mc, int mouseX, int mouseY) {
        if (visible){
            boolean isButtonPressed = (
                    mouseX >= xPosition &&
                    mouseY >= yPosition &&
                    mouseX < xPosition + width &&
                    mouseY < yPosition + height);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            mc.getTextureManager().bindTexture(new ResourceLocation(Reference.MODID+":textures/gui/book_buttons.png"));
            int textureX = 0;
            int textureY = 192;

            if(isButtonPressed){
                textureX += 23;
            }
            if(!isNextButton){
                textureY += 13;
            }

            drawTexturedModalRect(xPosition, yPosition, textureX, textureY, 23, 13);
        }
    }
}

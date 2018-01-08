package com.fvg.blackmagic.client.gui.GaldrButtons;

import com.fvg.blackmagic.core.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class GuiButtonBasic extends GuiButton{
    public GuiButtonBasic(int buttonId, int leftOffset, int topOffset) {
        super(buttonId, leftOffset+45, topOffset+25, 16, 16, "");
    }

    @Override
    public void drawButton(Minecraft mc, int mouseX, int mouseY){
        if (visible){
            boolean isButtonPressed = (
                    mouseX >= xPosition &&
                    mouseY >= yPosition &&
                    mouseX < xPosition + width &&
                    mouseY < yPosition + height);
            GL11.glColor4f(1F, 1F, 1F, 1F);
            mc.renderEngine.bindTexture(new ResourceLocation(Reference.MODID,"textures/gui/buttons.png"));
            int textureX = 0;
            int textureY = 0;
            if(isButtonPressed){
                textureX += 17;
            }

            drawModalRectWithCustomSizedTexture(xPosition, yPosition, textureX, textureY, 16, 16, 512, 512);
        }
    }
}

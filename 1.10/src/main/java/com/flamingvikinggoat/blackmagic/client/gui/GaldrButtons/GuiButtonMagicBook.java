package com.flamingvikinggoat.blackmagic.client.gui.GaldrButtons;

import com.flamingvikinggoat.blackmagic.client.gui.DummyClass;
import com.flamingvikinggoat.blackmagic.core.Reference;
import com.flamingvikinggoat.blackmagic.items.magic.MagicBookPage;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.opengl.GL11;

import java.util.List;

@SideOnly(Side.CLIENT)
public class GuiButtonMagicBook extends GuiButton{
    private int textureYOffset;
    private int textureXOffset = 0;
    private MagicBookPage jumpPage;
    private MagicBookPage originPage;



    public GuiButtonMagicBook(int buttonId, int leftOffset, int topOffset, int numberInList, MagicBookPage jumpPageIn, MagicBookPage originPageIn){
        super(buttonId, leftOffset+45, topOffset+(25+(17*(numberInList-1))), 16, 16, "");
        this.textureYOffset = 17*(buttonId-2);
        this.jumpPage = jumpPageIn;
        this.originPage = originPageIn;
    }

    @Override
    public void drawButton(Minecraft mc, int mouseX, int mouseY) {
        if(visible){
            boolean isButtonPressed = (
                    mouseX >= xPosition &&
                            mouseY >= yPosition &&
                            mouseX < xPosition + width &&
                            mouseY < yPosition + height);
            GL11.glColor4f(1F, 1F, 1F, 1F);
            mc.renderEngine.bindTexture(new ResourceLocation(Reference.MODID,"textures/gui/buttons.png"));
            int textureX = 0;
            if(isButtonPressed){
                textureX += 17;
            }

            drawModalRectWithCustomSizedTexture(xPosition, yPosition, textureX, textureYOffset, 16, 16, 512, 512);

        }
    }

    public int getJumpPageIndex() {
        return jumpPage.getIndex();
    }

    public MagicBookPage getJumpPage() {
        return jumpPage;
    }

    public void checkVisible(int currentPage, List<MagicBookPage> pageListIn){
        boolean pageIsKnown = (DummyClass.getDummyArr()[jumpPage.getIndex()] == 1);
        this.visible = (pageListIn.get(currentPage) == originPage && pageIsKnown);

    }
}

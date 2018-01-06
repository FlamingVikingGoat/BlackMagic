package com.fvg.blackmagic.client.gui;

import com.fvg.blackmagic.client.gui.GaldrButtons.GuiButtonControl;
import com.fvg.blackmagic.core.Reference;
import com.fvg.blackmagic.items.magic.MagicBookLoader;
import com.fvg.blackmagic.items.magic.MagicBookPage;
import com.fvg.blackmagic.lib.LibGaldrContentLabels;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.opengl.GL11;

import java.io.IOException;
import java.util.List;

public class GuiMagicBook extends GuiScreen {
    private final int BOOK_IMAGE_HEIGHT = 300;
    private final int BOOK_IMAGE_WIDTH = 500;
    private final int TEXTURE_HEIGHT = 512;
    private final int TEXTURE_WIDTH = 512;
    private int currentPage = 0;
    private int bookTotalPages = 0;
    private List<MagicBookPage> availablePages;

    private NextPageButton buttonNextValidPage;
    private NextPageButton buttonPreviousValidPage;
    private GuiButtonControl buttonControlJump;

    int left, top;


    public GuiMagicBook(List<MagicBookPage> pageList){
        this.availablePages = pageList;
        for(MagicBookPage page: availablePages){
            if(!page.getPageName().equals("")){
                bookTotalPages++;
            }
        }
        MagicBookLoader.setPages();
    }

    @Override
    public void initGui() {
        buttonList.clear();

        left = width / 2 - BOOK_IMAGE_WIDTH / 2;
        top = height / 2 - BOOK_IMAGE_HEIGHT / 2;

        int offsetFromScreenLeft = (width - BOOK_IMAGE_WIDTH) / 2;
        buttonList.add(buttonNextValidPage = new NextPageButton(0,
                offsetFromScreenLeft + 120, top + 20, true));
        buttonList.add(buttonPreviousValidPage = new NextPageButton(1,
                offsetFromScreenLeft + 38, top + 20, false));
        buttonList.add(buttonControlJump = new GuiButtonControl(2,
                offsetFromScreenLeft + 35, top + 20));
    }

    @Override
    public void updateScreen() {
        buttonNextValidPage.visible = (currentPage < bookTotalPages-1);
        buttonPreviousValidPage.visible = (currentPage > availablePages.indexOf(MagicBookLoader.contentTable));
        buttonControlJump.visible = (currentPage == availablePages.indexOf(MagicBookLoader.contentTable));
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {

        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        mc.renderEngine.bindTexture(availablePages.get(currentPage).getTexture());

        int offsetFromScreenLeft = (width - BOOK_IMAGE_WIDTH) / 2;
        drawModalRectWithCustomSizedTexture(left, top, 0, 0, BOOK_IMAGE_WIDTH, BOOK_IMAGE_HEIGHT, TEXTURE_WIDTH, TEXTURE_HEIGHT);
        String stringPageIndicator = I18n.format("book.pageIndicator",
                Integer.valueOf(currentPage+1), bookTotalPages);
        int widthOfString = fontRendererObj.getStringWidth(stringPageIndicator);
        int xValueForFontRender = offsetFromScreenLeft - widthOfString + BOOK_IMAGE_WIDTH - 44;

        fontRendererObj.drawString(stringPageIndicator, xValueForFontRender,
                18, 0);

        fontRendererObj.drawSplitString(availablePages.get(currentPage).getFirstPageText(),
                offsetFromScreenLeft + 36, top + 30, 200, 0);
        fontRendererObj.drawSplitString(availablePages.get(currentPage).getSecondPageText(),
                offsetFromScreenLeft + BOOK_IMAGE_WIDTH/2 + 36, top + 30, 200, 0);

        super.drawScreen(mouseX, mouseY, partialTicks);
    }
    
    @Override
    protected void mouseClickMove(int mouseX, int mouseY, int clickedMouseButton, long timeSinceLastClick) {
        super.mouseClickMove(mouseX, mouseY, clickedMouseButton, timeSinceLastClick);
    }

    @Override
    protected void actionPerformed(GuiButton button) throws IOException {
        if (button == buttonNextValidPage){

            for(int i = 0; i < availablePages.size(); i++){
                if(i <= currentPage){
                    continue;
                }
                if(!availablePages.get(i).getPageName().equals("")){
                    currentPage = i;
                    break;
                }
            }

        } else if (button == buttonPreviousValidPage){
            for(int i = bookTotalPages; i >= 0; i--){
                if(i >= currentPage){
                    continue;
                }
                if(!availablePages.get(i).getPageName().equals("")){
                    currentPage = i;
                    break;
                }
            }
        } else if (button == buttonControlJump){
            currentPage = 2; /*availablePages.indexOf(MagicBookLoader.controlIntro )*/
        }
    }

    @Override
    public void onGuiClosed() {
        super.onGuiClosed();
    }

    @Override
    public boolean doesGuiPauseGame() {
        return false;
    }
}

@SideOnly(Side.CLIENT)
class NextPageButton extends GuiButton{

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
            mc.getTextureManager().bindTexture(new ResourceLocation(Reference.MODID+":textures/gui/book.png"));
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
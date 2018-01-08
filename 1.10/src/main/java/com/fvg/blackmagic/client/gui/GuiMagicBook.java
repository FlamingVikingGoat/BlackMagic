package com.fvg.blackmagic.client.gui;

import com.fvg.blackmagic.client.gui.GaldrButtons.GuiButtonBasic;
import com.fvg.blackmagic.client.gui.GaldrButtons.GuiButtonControl;
import com.fvg.blackmagic.client.gui.GaldrButtons.NextPageButton;
import com.fvg.blackmagic.items.magic.MagicBookLoader;
import com.fvg.blackmagic.items.magic.MagicBookPage;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.resources.I18n;
import org.lwjgl.opengl.GL11;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GuiMagicBook extends GuiScreen {
    private final int BOOK_IMAGE_HEIGHT = 300;
    private final int BOOK_IMAGE_WIDTH = 500;
    private final int TEXTURE_HEIGHT = 512;
    private final int TEXTURE_WIDTH = 512;
    private int currentPage = 0;
    private int bookTotalPages = 0;
    private List<MagicBookPage> availablePages = new ArrayList<MagicBookPage>();
    private List<MagicBookPage> pageList = new ArrayList<MagicBookPage>();
    int availablePageNumber = 0;

    private NextPageButton buttonNextValidPage;
    private NextPageButton buttonPreviousValidPage;
    private GuiButtonBasic buttonBasicJump;
    private GuiButtonControl buttonControlJump;

    int left, top;

    public GuiMagicBook(List<MagicBookPage> pageList){
        this.pageList.clear();
        this.pageList = pageList;
        MagicBookLoader.setPages();
    }

    @Override
    public void initGui() {
        buttonList.clear();

        for(MagicBookPage page : pageList){
            if(!page.getPageName().equals("")){
                availablePages.add(availablePageNumber, page);
                availablePageNumber++;
                bookTotalPages++;
            }
        }
        availablePageNumber = 0;
        this.pageList.clear();

        left = width / 2 - BOOK_IMAGE_WIDTH / 2;
        top = height / 2 - BOOK_IMAGE_HEIGHT / 2;
        int offsetFromScreenLeft = (width - BOOK_IMAGE_WIDTH) / 2;

        buttonList.add(buttonNextValidPage = new NextPageButton(0,
                offsetFromScreenLeft + 120, top + 20, true));
        buttonList.add(buttonPreviousValidPage = new NextPageButton(1,
                offsetFromScreenLeft + 38, top + 20, false));
        buttonList.add(buttonBasicJump = new GuiButtonBasic(2,
                offsetFromScreenLeft, top));
        buttonList.add(buttonControlJump = new GuiButtonControl(3,
                offsetFromScreenLeft, top));
    }

    @Override
    public void updateScreen() {
        buttonNextValidPage.visible = (currentPage < bookTotalPages-1);
        buttonPreviousValidPage.visible = (currentPage > availablePages.indexOf(MagicBookLoader.contentTable));
        buttonBasicJump.visible = (currentPage == availablePages.indexOf(MagicBookLoader.contentTable));
        buttonControlJump.visible = (currentPage == availablePages.indexOf(MagicBookLoader.contentTable));
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        int offsetFromScreenLeft = (width - BOOK_IMAGE_WIDTH) / 2;

        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        mc.renderEngine.bindTexture(availablePages.get(currentPage).getTexture());
        drawModalRectWithCustomSizedTexture(left, top, 0, 0, BOOK_IMAGE_WIDTH, BOOK_IMAGE_HEIGHT, TEXTURE_WIDTH, TEXTURE_HEIGHT);

        fontRendererObj.drawSplitString(availablePages.get(currentPage).getFirstPageText(),
                offsetFromScreenLeft + 36, top + 30, 200, 0);
        fontRendererObj.drawSplitString(availablePages.get(currentPage).getSecondPageText(),
                offsetFromScreenLeft + BOOK_IMAGE_WIDTH/2 + 36, top + 30, 200, 0);

        //Draws "Page X of Y"
        String stringPageIndicator = I18n.format("book.pageIndicator", currentPage+1, bookTotalPages);
        int widthOfString = fontRendererObj.getStringWidth(stringPageIndicator);
        int xValueForFontRender = offsetFromScreenLeft - widthOfString + BOOK_IMAGE_WIDTH - 44;
        fontRendererObj.drawString(stringPageIndicator, xValueForFontRender, 18, 0);

        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    public void drawPage(MagicBookPage page){
        GL11.glColor4f(1F, 1F, 1F, 1F);
        mc.renderEngine.bindTexture(page.getTexture());
        drawModalRectWithCustomSizedTexture(left, top, 0, 0, BOOK_IMAGE_WIDTH, BOOK_IMAGE_HEIGHT, TEXTURE_WIDTH, TEXTURE_HEIGHT);
        drawPageString(page);
    }

    public void drawPageString(MagicBookPage page){
        int offsetFromScreenLeft = (width - BOOK_IMAGE_WIDTH) / 2;
        fontRendererObj.drawSplitString(page.getFirstPageText(),
                offsetFromScreenLeft + page.getStringPosOffset()[0], top + page.getStringPosOffset()[1], 200, 0);
    }

    @Override
    protected void mouseClickMove(int mouseX, int mouseY, int clickedMouseButton, long timeSinceLastClick) {
        super.mouseClickMove(mouseX, mouseY, clickedMouseButton, timeSinceLastClick);
    }

    @Override
    protected void actionPerformed(GuiButton button) throws IOException {
        if (button == buttonNextValidPage){
            ++currentPage;
        } else if (button == buttonPreviousValidPage) {
            --currentPage;
        } else if (button == buttonBasicJump){
            currentPage = availablePages.indexOf(MagicBookLoader.basicInfo);
        } else if (button == buttonControlJump){
            currentPage = availablePages.indexOf(MagicBookLoader.controlIntro);
        }
    }

    @Override
    public void onGuiClosed() {
        pageList.clear();
        super.onGuiClosed();
    }

    @Override
    public boolean doesGuiPauseGame() {
        return false;
    }

}


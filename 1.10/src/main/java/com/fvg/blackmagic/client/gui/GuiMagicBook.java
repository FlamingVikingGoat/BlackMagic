package com.fvg.blackmagic.client.gui;

import com.fvg.blackmagic.client.gui.GaldrButtons.*;
import com.fvg.blackmagic.items.magic.MagicBook;
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

    public static NextPageButton buttonNextValidPage;
    public static NextPageButton buttonPreviousValidPage;
    public static GuiButtonBasic buttonBasicJump;
    public static GuiButtonControl buttonControlJump;
    public static GuiButtonStaff buttonStaffJump;
    public static GuiButtonInfernus buttonInfernusJump;
    public static GuiButtonSummonBlock buttonSummonBlockJump;
    public static GuiButtonSummonRitual buttonSummonRitualJump;

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
        buttonList.add(buttonStaffJump = new GuiButtonStaff(4,
                offsetFromScreenLeft + BOOK_IMAGE_WIDTH/2, top));
        buttonList.add(buttonInfernusJump = new GuiButtonInfernus(5, offsetFromScreenLeft + BOOK_IMAGE_WIDTH/2, top));
        buttonList.add(buttonSummonBlockJump = new GuiButtonSummonBlock(6, offsetFromScreenLeft + BOOK_IMAGE_WIDTH/2, top));
        buttonList.add(buttonSummonRitualJump = new GuiButtonSummonRitual(7, offsetFromScreenLeft, top));

        for(GuiButton button : buttonList){
            button.visible = false;
        }
    }

    @Override
    public void updateScreen() {
        buttonNextValidPage.visible = (currentPage < bookTotalPages-1);
        buttonPreviousValidPage.visible = (currentPage > availablePages.indexOf(MagicBookLoader.contentTable));
        buttonBasicJump.checkVisible(currentPage, availablePages);
        buttonControlJump.checkVisible(currentPage, availablePages);
        buttonStaffJump.checkVisible(currentPage, availablePages);
        buttonInfernusJump.checkVisible(currentPage, availablePages);
        buttonSummonBlockJump.checkVisible(currentPage, availablePages);
        buttonSummonRitualJump.checkVisible(currentPage, availablePages);
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        int offsetFromScreenLeft = (width - BOOK_IMAGE_WIDTH) / 2;

        drawPage(availablePages.get(currentPage));

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
                offsetFromScreenLeft + page.getFirstPageStringPosOffset()[0], top + page.getFirstPageStringPosOffset()[1], 200, page.getFirstPageStringPosOffset()[2]);
        fontRendererObj.drawSplitString(page.getSecondPageText(),
                offsetFromScreenLeft + BOOK_IMAGE_WIDTH / 2 + page.getSecondPageStringPosOffset()[0], top + page.getSecondPageStringPosOffset()[1], 200, page.getSecondPageStringPosOffset()[2]);
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
            currentPage = buttonBasicJump.getJumpPageIndex();
        } else if (button == buttonControlJump){
            currentPage = availablePages.indexOf(MagicBookLoader.controlIntro);
        } else if (button == buttonStaffJump){
            currentPage = availablePages.indexOf(MagicBookLoader.staffInfo);
        } else if (button == buttonInfernusJump) {
            currentPage = availablePages.indexOf(MagicBookLoader.infernusInfo);
        } else if (button == buttonSummonBlockJump){
            currentPage = availablePages.indexOf(MagicBookLoader.summonBlockInfo);
        } else if (button == buttonSummonRitualJump){
            currentPage = availablePages.indexOf(MagicBookLoader.summonRitual);
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


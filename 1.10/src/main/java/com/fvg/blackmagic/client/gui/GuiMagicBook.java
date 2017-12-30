package com.fvg.blackmagic.client.gui;

import com.fvg.blackmagic.core.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.opengl.GL11;

import java.io.IOException;

import static com.fvg.blackmagic.client.gui.GuiMagicBook.bookPageTextures;

public class GuiMagicBook extends GuiScreen {
    private final int BOOK_IMAGE_HIEGHT = 192;
    private final int BOOK_IMAGE_WIDTH = 192;
    private int currentPage = 0;
    private static int bookTotalPages = 4;
    protected static ResourceLocation[] bookPageTextures = new ResourceLocation[bookTotalPages];
    private static String[] stringPageText = new String[bookTotalPages];
    private GuiButton buttonDone;
    private NextPageButton buttonNextValidPage;
    private NextPageButton buttonPreviousValidPage;

    public GuiMagicBook(){
        bookPageTextures[0] = new ResourceLocation(
                Reference.MODID+":textures/gui/book_cover.png");
        bookPageTextures[1] = new ResourceLocation(
                Reference.MODID + ":textures/gui/book.png");
        bookPageTextures[2] = new ResourceLocation(
                Reference.MODID+":textures/gui/book.png");
        bookPageTextures[3] = new ResourceLocation(
                Reference.MODID+":textures/gui/book.png");

        stringPageText[0] = "";
        stringPageText[1] = "The Mysterious Stranger admired your family cow and asked if it was for sale." +
                "\n\nWhen you nodded, he offered to trade some Magic Beans, that (if planted in tilled dirt) would lead to more wealth than you could imagine.";
        stringPageText[2]="So you handed him your cow, and grabbed the Magic Beans." +
                "\n\nPleased with yourself, you hurried away, looking for tilled dirt in which to plant the Magic Beans." +
                "\n\nYou couldn't wait to see how proud your mother would be for";
        stringPageText[3]="being so shrewd!  Untold wealth in return for an old, milkless cow; what a good deal you made!" +
                "\n\nSo off you went, looking for a place to plant the Magic Beans with room to grow...";

    }

    @Override
    public void initGui() {
        buttonList.clear();

        buttonDone = new GuiButton(0, width / 2 + 2, 4 + BOOK_IMAGE_HIEGHT,
                98, 20, I18n.format("gui.done"));

        buttonList.add(buttonDone);
        int offsetFromScreenLeft = (width - BOOK_IMAGE_WIDTH) / 2;
        buttonList.add(buttonNextValidPage = new NextPageButton(1,
                offsetFromScreenLeft + 120, 156, true));
        buttonList.add(buttonPreviousValidPage = new NextPageButton(2,
                offsetFromScreenLeft + 38, 156, false));
    }

    @Override
    public void updateScreen() {
        buttonDone.visible = (currentPage == 3);
        buttonNextValidPage.visible = (currentPage < bookTotalPages -1);
        buttonPreviousValidPage.visible = (currentPage > 0);
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        mc.renderEngine.bindTexture(bookPageTextures[1]);
        int offsetFromScreenLeft = (width - BOOK_IMAGE_WIDTH) / 2;
        drawTexturedModalRect(offsetFromScreenLeft, 2, 0, 0, BOOK_IMAGE_WIDTH, BOOK_IMAGE_HIEGHT);
        String stringPageIndicator = I18n.format("book.pageIndicator",
                Integer.valueOf(currentPage+1), bookTotalPages);
        int widthOfString = fontRendererObj.getStringWidth(stringPageIndicator);
        fontRendererObj.drawString(stringPageIndicator, offsetFromScreenLeft - widthOfString + BOOK_IMAGE_WIDTH - 44,
                18, 0);
        fontRendererObj.drawSplitString(stringPageText[currentPage],
                offsetFromScreenLeft + 36, 34, 116, 0);
        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    @Override
    protected void mouseClickMove(int mouseX, int mouseY, int clickedMouseButton, long timeSinceLastClick) {
        super.mouseClickMove(mouseX, mouseY, clickedMouseButton, timeSinceLastClick);
    }

    @Override
    protected void actionPerformed(GuiButton button) throws IOException {
        if(button == buttonDone){
            mc.displayGuiScreen(null);
        } else if (button == buttonNextValidPage){
            ++currentPage;
        } else if (button == buttonPreviousValidPage){
            --currentPage;
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
            mc.getTextureManager().bindTexture(bookPageTextures[1]);
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
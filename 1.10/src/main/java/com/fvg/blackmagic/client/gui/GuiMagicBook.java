package com.fvg.blackmagic.client.gui;

import com.fvg.blackmagic.client.gui.GaldrButtons.GuiButtonControl;
import com.fvg.blackmagic.core.Reference;
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

import static com.fvg.blackmagic.client.gui.GuiMagicBook.bookPageTextures;

public class GuiMagicBook extends GuiScreen {
    private final int BOOK_IMAGE_HEIGHT = 300;
    private final int BOOK_IMAGE_WIDTH = 500;
    private final int TEXTURE_HEIGHT = 512;
    private final int TEXTURE_WIDTH = 512;
    private int currentPage = 0;
    private static int bookTotalPages = 4;
    public static ResourceLocation[] bookPageTextures = new ResourceLocation[bookTotalPages];
    private static String[] stringPageText = new String[bookTotalPages];

    private NextPageButton buttonNextValidPage;
    private NextPageButton buttonPreviousValidPage;
    private GuiButtonControl buttonControlJump;

    int left, top;


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
        stringPageText[1] =
                "Control: The seed of all magic, Control only contains one (self-named) domain; control is represented by a spider's\n" +
                        "web. While this group is not stronger or weaker against any other types of magic, control magic takes precedent\n" +
                        "over other types.\n" +
                        "\n" +
                        "\tThe Control Domain is focused on effects that make or change rules; this magic restricts, imprisons,\n" +
                        "\tand manipulates. Control Mages are refered to as Nobles (a reference to their magic's rule-setting abilities),\n" +
                        "\tand it's main item is a piece of string.\n" +
                        "\t\tRestricting: Control Magic can be used to create areas that have different rules than outside\n" +
                        "\t\tthat area. Control magic can enchant tracks of land that limit magic usage, change costs and\n" +
                        "\t\teffectiveness of spells, and high level Nobles are even able to change the life-forces of entities\n" +
                        "\t\tin enchanted areas.\n" +
                        "\t\t\n" +
                        "\t\tImprisoning: Control Magic is perhaps most infamous batle-wise for its ability to remove abilities\n" +
                        "\t\tfrom others as if the target were imprisoned(note that Imprisoning is different from Restricting\n" +
                        "\t\tbased on target- Restricting targets and area, while Imprisoning targets entities). This includes\n" +
                        "\t\tstopping movement and limiting actions- including spellcasting. A powerful Noble can even stop an\n" +
                        "\t\tentity from breathing, slowly killing the victim.\n" +
                        "\n" +
                        "\t\tManiplation: Control Magic in its most powerful form is the ability to manipulate both the concrete\n" +
                        "\t\tand the abstract. At early stages, Nobles practicing manipulation can only move objects around; At \n" +
                        "\t\thigher stages, Nobles manipulate the fabric of reality itself. They can change the growth stage of \n" +
                        "\t\tan object, and even change the rate of time!";
        stringPageText[2]="So you handed him your cow, and grabbed the Magic Beans." +
                "\n\nPleased with yourself, you hurried away, looking for tilled dirt in which to plant the Magic Beans." +
                "\n\nYou couldn't wait to see how proud your mother would be for";
        stringPageText[3]="being so shrewd!  Untold wealth in return for an old, milkless cow; what a good deal you made!" +
                "\n\nSo off you went, looking for a place to plant the Magic Beans with room to grow...";

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
        buttonNextValidPage.visible = (currentPage < bookTotalPages -1);
        buttonPreviousValidPage.visible = (currentPage > 0);
        buttonControlJump.visible = (currentPage == 0);
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        mc.renderEngine.bindTexture(bookPageTextures[0]);
        int offsetFromScreenLeft = (width - BOOK_IMAGE_WIDTH) / 2;
        drawModalRectWithCustomSizedTexture(left, top, 0, 0, BOOK_IMAGE_WIDTH, BOOK_IMAGE_HEIGHT, TEXTURE_WIDTH, TEXTURE_HEIGHT);
        String stringPageIndicator = I18n.format("book.pageIndicator",
                Integer.valueOf(currentPage+1), bookTotalPages);
        int widthOfString = fontRendererObj.getStringWidth(stringPageIndicator);
        int xValueForFontRender = offsetFromScreenLeft - widthOfString + BOOK_IMAGE_WIDTH - 44;

        drawTableOfContentStrings();
        fontRendererObj.drawString(stringPageIndicator, xValueForFontRender,
                18, 0);
        fontRendererObj.drawSplitString(stringPageText[currentPage],
                offsetFromScreenLeft + 36, top + 30, offsetFromScreenLeft + 240, 0);
        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    public void drawTableOfContentStrings(){
        int offsetFromScreenLeft = (width - BOOK_IMAGE_WIDTH) / 2;

        if(currentPage == 0) {
            fontRendererObj.drawSplitString(GaldrContentTableLabelStrings.getLabel(LibGaldrContentLabels.CONTROL),
                    offsetFromScreenLeft + 60, top, offsetFromScreenLeft + 240, 0);
        }
    }

    @Override
    protected void mouseClickMove(int mouseX, int mouseY, int clickedMouseButton, long timeSinceLastClick) {
        super.mouseClickMove(mouseX, mouseY, clickedMouseButton, timeSinceLastClick);
    }

    @Override
    protected void actionPerformed(GuiButton button) throws IOException {
        if (button == buttonNextValidPage){
            ++currentPage;
        } else if (button == buttonPreviousValidPage){
            --currentPage;
        } else if (button == buttonControlJump){
            currentPage = 1;
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
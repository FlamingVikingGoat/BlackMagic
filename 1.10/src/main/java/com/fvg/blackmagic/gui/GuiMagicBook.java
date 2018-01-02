package com.fvg.blackmagic.gui;

import com.fvg.blackmagic.core.Reference;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ResourceLocation;

import java.util.*;

public class GuiMagicBook extends GuiScreen {
    private final int BOOK_IMAGE_HEIGHT = 192;
    private final int BOOK_IMAGE_WIDTH = 192;
    private LinkedList<ResourceLocation> magicBookPage = new LinkedList<ResourceLocation>();
    private LinkedList<String> stringPageContent = new LinkedList<String>();

    public GuiMagicBook() {
        magicBookPage.add(0, new ResourceLocation(Reference.MODID+":textures/gui/table_of_contents"));
        magicBookPage.add(1, new ResourceLocation(Reference.MODID+":textures/gui/description_page_one"));

        stringPageContent.add(0, "");
        stringPageContent.add(1, "There are 7 Magic domains: \nControl \nPain \nObliteration \nDeconstruction \nDomination \nCreation \nEnchantment");
    }

    @Override
    public void initGui() {
        buttonList.clear();
    }
}
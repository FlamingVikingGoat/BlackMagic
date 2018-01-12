package com.fvg.blackmagic.items.magic;

import com.fvg.blackmagic.client.gui.GuiMagicBook;

import java.util.ArrayList;
import java.util.List;

public final class MagicBookLoader {
    public static List<MagicBookPage> pages = new ArrayList<MagicBookPage>();
    public static MagicBookPage emptyPage = new MagicBookPage();

    public static MagicBookPage contentTable = new MagicBookPage(0, "Content Table", true);
    public static MagicBookPage basicInfo = new MagicBookPage(1, "Basic Information", true);
    public static MagicBookPage modContents = new MagicBookPage(2, "Mod Contents", true);
    public static MagicBookPage controlIntro = new MagicBookPage(3, "Control Introduction", true);
    public static MagicBookPage staffInfo = new MagicBookPage(4, "Staff Information", true);
    public static MagicBookPage infernusInfo = new MagicBookPage(5, "Infernus Information", true);
    public static MagicBookPage summonBlockInfo = new MagicBookPage(6, "Summon Block Information", true);
    public static MagicBookPage summonRitual = new MagicBookPage(7, "How to Summon a Demon", false);

    public static void setPages(){
        contentTable.setFirstPageText(
                contentTable.buttonStrings(basicInfo, controlIntro, summonRitual));
        contentTable.setFirstPageStringPosOffset(65, 30, 0x0000FF);


        basicInfo.setFirstPageText("" +
                "Welcome, young spellcaster, to the tome that will guide you through your magical journey.\n\n" +
                "This tome comes with several features for your convenience, the main two being jumping and expanding.\n\n" +
                "\"Jumping\" allows the reader to jump to certain locations in this tome. It is enabled by pressing " +
                "on a symbol followed by blue text; the blue text describes where the jump will go.\n\n" +
                "\"Expanding\" allows for the dynamic size of this tome; rather than containing all that can be known," +
                "information is made ready for the reader when they are prepared to handle it. Magic can be very dangerous;" +
                "a slight error on an advanced-level spell can wipe out a whole city.\n\n" +
                "Now that you know how this book works, visit the sections on the right to start learning.");

        modContents.setFirstPageText(
                "Currently, this mod only contains few objects, including a few staves, some ore, minerals, a book, and a block." +
                "The book is defined on the \"Basic Information\" page, but the rest are defined on the right.");
        modContents.setSecondPageText("" +
                "Staves\n\n" +
                "Infernus\n\n" +
                "Summoning Block");
        modContents.setSecondPageStringPosOffset(65, 30, 0x0000FF);

        controlIntro.setFirstPageText("");

        staffInfo.setFirstPageText("" +
                "Staves are a basic tool for the fledgling magician. They can be used to store spells and mana," +
                " as well as interface with other magical elements. Note that while more advanced magicians do not need" +
                " staves as much, they still need them to perform magic that would normally be above their level.\n\n" +
                "Staves can be made with three different types of infernal gem: purple, red, and black. The power of the staff depends on the material" +
                "used; purple is the weakest, and black the strongest.");

        infernusInfo.setFirstPageText("" +
                "Infernus is a type of material generated from hellish magic perforating the overworld. It appears in an ore," +
                " and comes in four types: unrefined, purple, red, and black\n\n" +
                "Unrefined Infernus is what you get from Infernus ore after the normal smelting process; it is mostly useless." +
                "Purple Infernus can be obtained either by advanced smelting methods of Infernus ore, or by normally smelting " +
                "unrefined Infernus. The other forms of Infernus can only be obtained using advanced smelting methods.");

        summonBlockInfo.setFirstPageText("" +
                "The summoning block is a special block used for certain rites and rituals too advanced for the beginning magician.");
        summonRitual.setFirstPageText("dummy text");
    }


}

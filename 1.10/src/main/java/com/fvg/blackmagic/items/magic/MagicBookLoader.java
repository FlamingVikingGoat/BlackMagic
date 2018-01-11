package com.fvg.blackmagic.items.magic;

import java.util.ArrayList;
import java.util.List;

public final class MagicBookLoader {
    public static List<MagicBookPage> pages = new ArrayList<MagicBookPage>();
    public static MagicBookPage emptyPage = new MagicBookPage();

    public static MagicBookPage contentTable = new MagicBookPage(0, "Content Table", true);
    public static MagicBookPage basicInfo = new MagicBookPage(1, "Basic Information", true);
    public static MagicBookPage modContents = new MagicBookPage(2, "Mod Contents", true);
    public static MagicBookPage controlIntro = new MagicBookPage(3, "Control Introduction", true);

    public static void setPages(){
        contentTable.setFirstPageText(
                "Basic Information(Start Here)\n\n"+
                "Control Magic Information");
        contentTable.setSecondPageText("");
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
        basicInfo.setSecondPageText("");

        modContents.setFirstPageText(
                "Currently, this mod only contains few objects, including a few staves, some ore, minerals, a book, and a block." +
                "The book is defined on the \"Basic Information\" page, but the rest are defined on the right.");
        modContents.setSecondPageText("" +
                "Staves\n\n" +
                "Infernus\n\n" +
                "Summoning Block");
        modContents.setSecondPageStringPosOffset(65, 30, 0x0000FF);

        controlIntro.setFirstPageText("");
        controlIntro.setSecondPageText("");


    }
}

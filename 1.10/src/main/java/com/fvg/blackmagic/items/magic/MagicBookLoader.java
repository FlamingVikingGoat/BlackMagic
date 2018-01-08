package com.fvg.blackmagic.items.magic;

import java.util.ArrayList;
import java.util.List;

public final class MagicBookLoader {
    public static List<MagicBookPage> pages = new ArrayList<MagicBookPage>();
    public static MagicBookPage emptyPage = new MagicBookPage();

    public static MagicBookPage contentTable = new MagicBookPage(0, "Content Table", true);
    public static MagicBookPage basicInfo = new MagicBookPage(1, "Basic Information", true);
    public static MagicBookPage controlIntro = new MagicBookPage(2, "Control Introduction", true);

    public static void setPages(){
        contentTable.setFirstPageText(
                "Basic Information(Start Here)\n\n"+
                "Control Magic Information");
        contentTable.setSecondPageText("text");
        contentTable.setStringPosOffset(65, 30, 0x0000FF);

        basicInfo.setFirstPageText(
                "Welcome, young spellcaster, to the tome that will guide you through your magical journey.\n\n" +
                        "This tome comes with several features for your convenience, the main two being jumping and expanding.\n\n" +
                        "\"Jumping\" allows the reader to jump to certain locations in this tome. It is enabled by pressing " +
                        "on a symbol followed by blue text; the blue text describes where the jump will go.\n\n" +
                        "\"Expanding\" allows for the dynamic size of this tome; rather than containing all that can be known," +
                        "information is made ready for the reader when they are prepared to handle it. Magic can be very dangerous;" +
                        "a slight error on an advanced-level spell can wipe out a whole city.\n\n" +
                        "Now that you know how this book works, visit the sections on the right to start learning.");

        controlIntro.setFirstPageText(
                "Control: The seed of all magic, Control only contains one (self-named) domain; control is represented " +
                        "by a spider's web. While this group is not stronger or weaker against any other types of magic, " +
                        "control magic takes precedent over other types." +
                        "\n\n" +
                        "The Control Domain is focused on effects that make or change rules; this magic restricts, " +
                        "imprisons, and manipulates. Control Mages are referred to as Nobles (a reference to their " +
                        "magic's rule-setting abilities), and it's main item is a piece of string. Restricting: " +
                        "Control Magic can be used to create areas that have different rules than outside that area. " +
                        "Control magic can enchant tracks of land that limit magic usage, change costs and " +
                        "effectiveness of spells, and high level Nobles are even able to change the life-forces of " +
                        "entities in enchanted areas." +
                        "\n\n" +
                        "Imprisoning: Control Magic is perhaps most infamous batle-wise for its ability to remove " +
                        "abilities from others as if the target were imprisoned(note that Imprisoning is different from " +
                        "Restricting based on target- Restricting targets and area, while Imprisoning targets entities)." +
                        " This includes stopping movement and limiting actions- including spellcasting. A powerful Noble " +
                        "can even stop an entity from breathing, slowly killing the victim." +
                        "\n\n" +
                        "Manipulation: Control Magic in its most powerful form is the ability to manipulate both the concrete" +
                        "and the abstract. At early stages, Nobles practicing manipulation can only move objects around; " +
                        "At higher stages, Nobles manipulate the fabric of reality itself. They can change the growth stage " +
                        "of tan object, and even change the rate of time!");
        controlIntro.setSecondPageText("text");


    }
}

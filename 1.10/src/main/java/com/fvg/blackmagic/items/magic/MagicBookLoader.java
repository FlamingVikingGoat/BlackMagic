package com.fvg.blackmagic.items.magic;

import java.util.ArrayList;
import java.util.List;

public final class MagicBookLoader {
    public static List<MagicBookPage> pages = new ArrayList<MagicBookPage>();
    public static MagicBookPage emptyPage = new MagicBookPage();

    public static MagicBookPage contentTable = new MagicBookPage(0, "Content Table", true);
    public static MagicBookPage controlIntro = new MagicBookPage(1, "Control Introduction", true);

    public static void setPages(){
        contentTable.setFirstPageText(
                "");
        contentTable.setSecondPageText("text");

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

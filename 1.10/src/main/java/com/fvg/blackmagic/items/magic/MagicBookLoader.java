package com.fvg.blackmagic.items.magic;

import java.util.ArrayList;
import java.util.List;

public final class MagicBookLoader {
    public static List<MagicBookPage> pages = new ArrayList<MagicBookPage>();
    public static MagicBookPage emptyPage = new MagicBookPage();

    public static MagicBookPage contentTable = new MagicBookPage(
        0, "Content Table", true);
    public static MagicBookPage controlIntro = new MagicBookPage(
        1, "Control Introduction", true);
}

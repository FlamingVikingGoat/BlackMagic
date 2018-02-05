package com.flamingvikinggoat.blackmagic.handlers;

import net.minecraft.util.IStringSerializable;
import scala.tools.nsc.doc.model.Public;

public class BlackEnums {
    public static enum SacrificialStatus implements IStringSerializable {

    NO_SACRIFICE("no_sacrifice",0),
    YES_SACRIFICE("yes_sacrifice",1);

    private int ID;
    private String name;

    SacrificialStatus(String name, int ID) {
        this.ID = ID;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getID() {
        return this.ID;
    }

    @Override
    public String toString() {
        return getName();
    }
}

}

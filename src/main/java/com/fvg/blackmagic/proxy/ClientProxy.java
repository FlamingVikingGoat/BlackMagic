package com.fvg.blackmagic.proxy;

import com.fvg.blackmagic.items.ModItems;

public class ClientProxy extends CommonProxy {
    @Override
    public void registerRenders() {
        ModItems.registerRenders();
    }
}

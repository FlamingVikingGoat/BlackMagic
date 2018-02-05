package com.flamingvikinggoat.blackmagic.network;

import com.flamingvikinggoat.blackmagic.core.Reference;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

public class BlackPackets {

    public static SimpleNetworkWrapper INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel(Reference.MODID);

    public static int ID = 0;
    public static int nextInt() {
        return ID++;
    }

    public static void registerMessages(){
        INSTANCE.registerMessage(PacketServerResponseWithKnownPagesOfPlayer.ServerPagesHandler.class, PacketServerResponseWithKnownPagesOfPlayer.class, nextInt(), Side.SERVER);

        INSTANCE.registerMessage(PacketClientRequestForKnownPagesOfPlayer.ClientPagesHandler.class, PacketClientRequestForKnownPagesOfPlayer.class, nextInt(), Side.CLIENT);
    }
}

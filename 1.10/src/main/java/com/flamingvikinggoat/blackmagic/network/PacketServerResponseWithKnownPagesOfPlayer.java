package com.flamingvikinggoat.blackmagic.network;

import com.flamingvikinggoat.blackmagic.capabilities.knownpages.IPagesKnown;
import com.flamingvikinggoat.blackmagic.capabilities.knownpages.PagesKnownProvider;
import com.flamingvikinggoat.blackmagic.client.gui.DummyClass;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;

public class PacketServerResponseWithKnownPagesOfPlayer implements IMessage{

    public PacketServerResponseWithKnownPagesOfPlayer(){ /*Default Constructor*/ }

    private String playerName;

    private String guiClassName;
    private String knownPagesFieldName;

    public PacketServerResponseWithKnownPagesOfPlayer(String playerName, String pagesKnownClass, String knownPagesFieldName){
        this.playerName = playerName;
        this.guiClassName = pagesKnownClass;
        this.knownPagesFieldName = knownPagesFieldName;
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        this.playerName = ByteBufUtils.readUTF8String(buf);
        this.guiClassName = ByteBufUtils.readUTF8String(buf);
        this.knownPagesFieldName = ByteBufUtils.readUTF8String(buf);
    }

    @Override
    public void toBytes(ByteBuf buf) {
        ByteBufUtils.writeUTF8String(buf, playerName);
        ByteBufUtils.writeUTF8String(buf, guiClassName);
        ByteBufUtils.writeUTF8String(buf, knownPagesFieldName);
    }

    public static class ServerPagesHandler implements IMessageHandler<PacketServerResponseWithKnownPagesOfPlayer, IMessage>{

        @Override
        public IMessage onMessage(final PacketServerResponseWithKnownPagesOfPlayer message, final MessageContext ctx) {
            if (ctx.side != Side.SERVER){
                return null;
            }

            ctx.getServerHandler().playerEntity.getServerWorld().addScheduledTask(() -> processMessage(message, ctx));

            return null;
        }

        void processMessage(PacketServerResponseWithKnownPagesOfPlayer message, MessageContext ctx){
            EntityPlayerMP player = ctx.getServerHandler().playerEntity;
            IPagesKnown pagesKnown = player.getCapability(PagesKnownProvider.KNOWN_PAGES, null);

            if(player == null){System.out.println("!!!Network!!!");return;}
            if(!player.hasCapability(PagesKnownProvider.KNOWN_PAGES, null)){System.out.println("!!!Network!!!");return;}

            int[] knownPages = pagesKnown.getKnownPages();

            DummyClass.setDummyArr(knownPages);

            BlackPackets.INSTANCE.sendTo(
                    new PacketClientRequestForKnownPagesOfPlayer(knownPages, message.guiClassName, message.knownPagesFieldName),
                    player
            );
        }
    }
}

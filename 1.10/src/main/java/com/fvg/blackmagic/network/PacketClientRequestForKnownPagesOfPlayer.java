package com.fvg.blackmagic.network;

import com.fvg.blackmagic.core.BlackMagic;
import com.fvg.blackmagic.lib.LibGuiIDs;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;

import java.lang.reflect.Field;

public class PacketClientRequestForKnownPagesOfPlayer implements IMessage{

    public PacketClientRequestForKnownPagesOfPlayer(){ /*Default Constructor*/ }

    private int[] knownPages;
    private int pageSize;

    private String guiClassName;
    private String knownPagesFieldName;

    PacketClientRequestForKnownPagesOfPlayer(int[] knownPages, String guiClassName, String knownPagesFieldName){
        this.knownPages = knownPages;
        this.pageSize = knownPages.length;
        this.guiClassName = guiClassName;
        this.knownPagesFieldName = knownPagesFieldName;
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        this.knownPages = new int[8];
        for (int i = 0; i < 8; i++){
            this.knownPages[i] = buf.readInt();
        }
        this.guiClassName = ByteBufUtils.readUTF8String(buf);
        this.knownPagesFieldName = ByteBufUtils.readUTF8String(buf);
    }

    @Override
    public void toBytes(ByteBuf buf) {
        for(int i : knownPages){
            buf.writeInt(i);
        }
        ByteBufUtils.writeUTF8String(buf, this.guiClassName);
        ByteBufUtils.writeUTF8String(buf, this.knownPagesFieldName);
    }

    public static class ClientPagesHandler implements IMessageHandler<PacketClientRequestForKnownPagesOfPlayer, IMessage>{

        @Override
        public IMessage onMessage(PacketClientRequestForKnownPagesOfPlayer message, MessageContext ctx) {
            if(ctx.side != Side.CLIENT){
                return null;
            }

            Minecraft.getMinecraft().addScheduledTask(() -> {
                Minecraft.getMinecraft().thePlayer.openGui(BlackMagic.instance, 0, Minecraft.getMinecraft().thePlayer.getEntityWorld(), 0, 0, 0);
            });

            return null;
        }

        /*void processMessage(PacketClientRequestForKnownPagesOfPlayer message){
            try {
                Class guiClassName = Class.forName(message.guiClassName);
                Field knownPagesField = guiClassName.getDeclaredField(message.knownPagesFieldName);
                knownPagesField.set(guiClassName, message.knownPages);
                Integer[] tempArr = new Integer[message.knownPages.size()];
                tempArr = message.knownPages.toArray(tempArr);
                for (int i = 0; i < message.knownPages.size(); i++){
                    Array.setInt(knownPagesField, i, tempArr[i]);
                }
            } catch (Exception e){
                System.out.println("Yes I know");
            }

        }*/
    }
}

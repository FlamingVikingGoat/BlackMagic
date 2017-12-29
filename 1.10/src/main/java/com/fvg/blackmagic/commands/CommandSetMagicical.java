package com.fvg.blackmagic.commands;

import com.fvg.blackmagic.capabilities.IMana;
import com.fvg.blackmagic.capabilities.ManaProvider;
import com.fvg.blackmagic.core.Reference;
import com.google.common.collect.Lists;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;

import javax.annotation.Nullable;
import java.util.Collections;
import java.util.List;

public class CommandSetMagicical extends CommandBase{
    private final List<String> aliases;

    public CommandSetMagicical() {
        aliases = Lists.newArrayList(Reference.MODID, "csm");
    }

    @Override
    public String getCommandName() {
        return "setMagical";
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return "setMagical <bool>";
    }

    @Override
    public List<String> getCommandAliases() {
        return aliases;
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
        EntityPlayer player = sender.getEntityWorld().getPlayerEntityByName(sender.getName());
        IMana mana = player.getCapability(ManaProvider.MANA_CAP, null);
        Boolean boolIn = Boolean.valueOf(args[0]);
        mana.setMagical(boolIn);
        String message = String.format("Magical Status: %b",
            mana.isMagical());
        player.addChatMessage(new TextComponentString(message));
    }

    @Override
    public boolean checkPermission(MinecraftServer server, ICommandSender sender) {
        return true;
    }

    @Override
    public List<String> getTabCompletionOptions(MinecraftServer server, ICommandSender sender, String[] args, @Nullable BlockPos pos) {
        return Collections.emptyList();
    }
}

package com.flamingvikinggoat.blackmagic.commands;

import com.flamingvikinggoat.blackmagic.capabilities.IMana;
import com.flamingvikinggoat.blackmagic.capabilities.ManaProvider;
import com.flamingvikinggoat.blackmagic.core.Reference;
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

public class CommandSetMaxMana extends CommandBase {

    private final List<String> aliases;

    public CommandSetMaxMana() {
        aliases = Lists.newArrayList(Reference.MODID, "csmm");
    }

    @Override
    public String getCommandName() {
        return "setMaxMana";
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return "setMaxMana <amount of mana>";
    }

    @Override
    public List<String> getCommandAliases() {
        return aliases;
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
        EntityPlayer player = sender.getEntityWorld().getPlayerEntityByName(sender.getName());
        IMana mana = player.getCapability(ManaProvider.MANA_CAP, null);
        Float amount = Float.valueOf(args[0]);
        mana.setMaxMana(amount);
        if (mana.getMana() > amount) {
            mana.set(amount);
        }
        String message = String.format("Max mana is %d \ncurrent mana is %d",
            (int) mana.getMaxMana(),
            (int) mana.getMana());
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


package com.fvg.blackmagic.handlers;

import com.fvg.blackmagic.blocks.AMagicActivated;
import com.fvg.blackmagic.capabilities.IMana;
import com.fvg.blackmagic.capabilities.ManaProvider;
import com.fvg.blackmagic.items.magic.MagicBook;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.event.entity.player.PlayerSleepInBedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

import static com.fvg.blackmagic.blocks.AMagicActivated.TYPE;


public class BlackEvents {

    @SubscribeEvent
    public void addTributeToAlter(LivingDeathEvent event){
        BlockPos blockTheEntityIsOn = new BlockPos(event.getEntity());

        double upperRightCornerXCord = blockTheEntityIsOn.getX()+3.0D;
        double upperRightCornerYCord = blockTheEntityIsOn.getY()+3.0D;
        double upperRightCornerZCord = blockTheEntityIsOn.getZ()+3.0D;
        BlockPos upperRightCornerPos = new BlockPos(upperRightCornerXCord, upperRightCornerYCord, upperRightCornerZCord);

        double underRightCornerXCord = blockTheEntityIsOn.getX()-3.0D;
        double underRightCornerYCord = blockTheEntityIsOn.getY()-3.0D;
        double underRightCornerZCord = blockTheEntityIsOn.getZ()-3.0D;
        BlockPos underRightCornerPos = new BlockPos(underRightCornerXCord, underRightCornerYCord, underRightCornerZCord);

        Iterable<BlockPos> sacrificeRangeBlock = BlockPos.getAllInBox(upperRightCornerPos, underRightCornerPos);
        for (BlockPos possibleAlter : sacrificeRangeBlock) {
            if(event.getEntity().getEntityWorld().getBlockState(possibleAlter).getBlock() instanceof AMagicActivated){
                IBlockState state = event.getEntity().getEntityWorld().getBlockState(possibleAlter);
                event.getEntity().getEntityWorld().setBlockState(possibleAlter, state.withProperty(TYPE, BlackEnums.SacrificialStatus.YES_SACRIFICE));
                System.out.println(state.getValue(TYPE));
                break;
            }
        }



    }

    @SubscribeEvent
    public void onPlayerLogsIn(PlayerEvent.PlayerLoggedInEvent event){
        EntityPlayer player = event.player;
        IMana mana = player.getCapability(ManaProvider.MANA_CAP, null);

        String message = String.format("Hello there, you have %d mana left.", (int) mana.getMana());
        player.addChatMessage(new TextComponentString(message));
    }

    @SubscribeEvent
    public void onMagicBookCrafted(PlayerEvent.ItemCraftedEvent event){
        ItemStack itemCrafted = event.crafting;
        EntityPlayer player = event.player;
        if(itemCrafted.getItem() instanceof MagicBook) {
            player.getCapability(ManaProvider.MANA_CAP, null).isMagical(true);
        }
    }


}

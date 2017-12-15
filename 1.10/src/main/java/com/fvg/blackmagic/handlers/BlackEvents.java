package com.fvg.blackmagic.handlers;

import com.fvg.blackmagic.blocks.AMagicActivated;
import com.fvg.blackmagic.capabilities.IMana;
import com.fvg.blackmagic.capabilities.ManaProvider;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
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
    public void onPlayerSleep(PlayerSleepInBedEvent event){
        EntityPlayer player = event.getEntityPlayer();

        if(player.worldObj.isRemote) return;

        IMana mana = player.getCapability(ManaProvider.MANA_CAP, null);

        if(mana.getMana() == 0){
            mana.set(50);
        }
        else {
            mana.fill(50);
        }
    }

    @SubscribeEvent
    public void onPlayerFalls(LivingFallEvent event){
        Entity entity = event.getEntity();

        if(entity.worldObj.isRemote || !(entity instanceof EntityPlayerMP) || event.getDistance() < 3) return;

        EntityPlayer player = (EntityPlayer) entity;

        IMana mana = player.getCapability(ManaProvider.MANA_CAP, null);

        float points = mana.getMana();
        float cost = event.getDistance() * 2;

        if(points > cost){
            mana.consume(cost);

            String message = String.format("You absorbed fall damage. It costed %d", (int)cost);
            player.addChatMessage(new TextComponentString(message));

            event.setCanceled(true);
        }
    }

}

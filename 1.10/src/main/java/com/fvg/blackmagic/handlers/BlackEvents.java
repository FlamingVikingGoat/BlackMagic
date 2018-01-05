package com.fvg.blackmagic.handlers;

import com.fvg.blackmagic.blocks.AMagicActivated;
import com.fvg.blackmagic.capabilities.IMana;
import com.fvg.blackmagic.capabilities.ManaProvider;
import com.fvg.blackmagic.entitites.EntityDemon;
import com.fvg.blackmagic.items.magic.MagicBook;
import com.sun.istack.internal.NotNull;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingSpawnEvent;
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
        if(mana.isMagical()){
            player.addChatMessage(new TextComponentString(message));
        }
    }

    @SubscribeEvent
    public void onMagicBookCrafted(PlayerEvent.ItemCraftedEvent event){
        ItemStack itemCrafted = event.crafting;
        EntityPlayer player = event.player;
        IMana mana = player.getCapability(ManaProvider.MANA_CAP, null);
        if(itemCrafted.getItem() instanceof MagicBook && !event.player.getEntityWorld().isRemote) {
            player.getCapability(ManaProvider.MANA_CAP, null).setMagical(true);
            String message = String.format("Max mana is %d \ncurrent mana is %d",
            (int) mana.getMaxMana(),
            (int) mana.getMana());
        player.addChatMessage(new TextComponentString(message));
        }
    }

    @SubscribeEvent
    public void onDemonSpawn(EntityJoinWorldEvent event){
        Entity entity = event.getEntity();
        EntityPlayer player = event.getWorld().getClosestPlayerToEntity(entity, 20.0D);
        String message = "You have summoned me, Charles, the Demon of Deals!";
        if(entity instanceof EntityDemon && !event.getWorld().isRemote && player != null){
            System.out.println("Entity is a demon");
            player.addChatMessage(new TextComponentString(message));
        }
    }
}

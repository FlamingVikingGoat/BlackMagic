package com.fvg.blackmagic.handlers;

import com.fvg.blackmagic.blocks.AMagicActivated;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

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

        /*if (event.getEntity().getEntityWorld().getBlockState(blockTheEntityIsOn.down()) instanceof AMagicActivated){
            ((AMagicActivated)event.getEntity().getEntityWorld().getBlockState(blockTheEntityIsOn).getBlock()).setSacrifice(true);
            System.out.println("Method 1: Sacrifice Accepted");
        }*/

        Iterable<BlockPos> sacrificeRangeBlock = BlockPos.getAllInBox(upperRightCornerPos, underRightCornerPos);
        for (BlockPos possibleAlter : sacrificeRangeBlock) {
            if(event.getEntity().getEntityWorld().getBlockState(possibleAlter).getBlock() instanceof AMagicActivated){
                IBlockState state = event.getEntity().getEntityWorld().getBlockState(possibleAlter);
                event.getEntity().getEntityWorld().setBlockState(possibleAlter, state.withProperty(TYPE, BlackEnums.SacrificialStatus.YES_SACRIFICE));
                System.out.println(state.getValue(TYPE));
                break;
            }
            //else
                //System.out.println("Sacrifice Rejected!");
        }



    }

}

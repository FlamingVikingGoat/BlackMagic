package com.flamingvikinggoat.blackmagic.galdr;

import com.flamingvikinggoat.blackmagic.capabilities.IMana;
import com.flamingvikinggoat.blackmagic.entitites.EntityDemon;
import com.flamingvikinggoat.blackmagic.handlers.BlackEnums;
import com.flamingvikinggoat.blackmagic.blocks.AMagicActivated;
import com.flamingvikinggoat.blackmagic.capabilities.ManaProvider;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ASpells {

    public static void activateMagicBlock(World worldIn, BlockPos pos){
        Block possibleMagicBlock = worldIn.getBlockState(pos).getBlock();
        if(possibleMagicBlock instanceof AMagicActivated){
            ((AMagicActivated) possibleMagicBlock).setActivated(true);
        }
    }

    public static void summonLightningOnEntity(Entity target){
        World targetWorld = target.getEntityWorld();
        targetWorld.addWeatherEffect(new EntityLightningBolt(targetWorld, target.posX, target.posY, target.posZ, false));
    }

    public static void summonLightningOnBlock(World worldIn, BlockPos pos){
        worldIn.addWeatherEffect(new EntityLightningBolt(worldIn, pos.getX(), pos.getY(), pos.getZ(), false));
    }

    public static void rituallySummonDemonOnBlock(EntityPlayer playerIn, BlockPos pos){
        World worldIn = playerIn.getEntityWorld();
        IBlockState state = worldIn.getBlockState(pos);
        Block block = state.getBlock();
        IMana mana = playerIn.getCapability(ManaProvider.MANA_CAP, null);
        if (worldIn.getWorldTime() > 14000 && worldIn.getWorldTime() < 22000) {
            if(mana.takeFromManaPool(40F, playerIn)){
                ASpells.instantlySummonDemonOnBlock(worldIn, pos);
            }
        }else {
            ASpells.summonLightningOnEntity(playerIn);
        }
        if(block instanceof AMagicActivated){
            ((AMagicActivated) block).setActivated(false);
            worldIn.setBlockState(pos, state.withProperty(AMagicActivated.TYPE, BlackEnums.SacrificialStatus.NO_SACRIFICE));
        }
    }

    public static void instantlySummonDemonOnBlock(World worldIn, BlockPos pos){

        EntityDemon demon = new EntityDemon(worldIn);
        demon.setPosition(pos.getX() + 0.5, pos.getY() + 1, pos.getZ() + 0.5);
        if (!worldIn.isRemote) {
            worldIn.spawnEntityInWorld(demon);
        }
    }

}

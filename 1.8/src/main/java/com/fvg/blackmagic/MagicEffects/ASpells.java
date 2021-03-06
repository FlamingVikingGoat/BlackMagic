package com.fvg.blackmagic.MagicEffects;

import com.fvg.blackmagic.blocks.AMagicActivated;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

public class ASpells {

    public static void activateMagicBlock(World worldIn, BlockPos pos){
        Block block = worldIn.getBlockState(pos).getBlock();
        if(block instanceof AMagicActivated);{
            ((AMagicActivated) block).setActivated(true);
        }
    }

    public static void summonLightningOnEntity(Entity target){
        World targetWorld = target.getEntityWorld();
        targetWorld.addWeatherEffect(new EntityLightningBolt(targetWorld, target.posX, target.posY, target.posZ));
    }

    public static void summonLightningOnBlock(World worldIn, BlockPos pos){
        worldIn.addWeatherEffect(new EntityLightningBolt(worldIn, pos.getX(), pos.getY(), pos.getZ()));
    }

    public static void rituallySummonDemonOnBlock(EntityPlayer playerIn, BlockPos pos){
        World worldIn = playerIn.getEntityWorld();
        if (worldIn.getWorldTime() > 17000 && worldIn.getWorldTime() < 19000) {
                ASpells.instantlySummonDemonOnBlock(worldIn, pos);
         } else {
                ASpells.summonLightningOnEntity(playerIn);
         }

    }

    public static void instantlySummonDemonOnBlock(World worldIn, BlockPos pos){

        EntityZombie demon = new EntityZombie(worldIn);
        demon.setPosition(pos.getX() + 0.5, pos.getY() + 1, pos.getZ() + 0.5);
        if (!worldIn.isRemote) {
            worldIn.spawnEntityInWorld(demon);
        }
    }

}

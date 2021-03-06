package com.fvg.blackmagic.blocks;

import com.fvg.blackmagic.core.BlackMagic;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class SpawnBlock extends Block{
    public SpawnBlock(String unlocalizedName){
        super(Material.iron);
        this.setUnlocalizedName(unlocalizedName);
        this.setCreativeTab(BlackMagic.TabBlackMagicCore);
        this.setLightLevel(1.0F);
        this.setHardness(10.0F);
        this.setResistance(5.0F);
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side, float hitX, float hitY, float hitZ){




        if(worldIn.getWorldTime() > 17000 && worldIn.getWorldTime() < 19000){

            EntityZombie demon = new EntityZombie(worldIn);

            demon.setPosition(pos.getX()+0.5, pos.getY()+1, pos.getZ()+0.5);

            if(!worldIn.isRemote) {
                worldIn.spawnEntityInWorld(demon);
            }
            return false;
        }

        else {
            worldIn.addWeatherEffect(
                new EntityLightningBolt(worldIn, playerIn.posX, playerIn.posY, playerIn.posZ)
            );
            return false;
        }
    }
}

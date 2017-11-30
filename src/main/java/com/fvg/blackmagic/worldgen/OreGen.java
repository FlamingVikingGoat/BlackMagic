package com.fvg.blackmagic.worldgen;

import com.fvg.blackmagic.blocks.ModBlocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

import java.util.Random;

public class OreGen implements IWorldGenerator{

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
        switch(world.provider.getDimensionId()){
            //0: Overworld ||| 1: End ||| -1: Nether
            case 0:
                break;
            case 1:
                break;
            case -1:
                break;
        }

    }

    public WorldGenerator infernusGenerator;

    public OreGen(){
        infernusGenerator = new WorldGenMinable(ModBlocks.spawnBlock.getDefaultState(), 9);
    }

}

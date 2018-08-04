package com.TRGamer28.coppermod.world.gen;

import java.util.Random;

import com.TRGamer28.coppermod.blocks.BlockOres;
import com.TRGamer28.coppermod.init.ModBlocks;
import com.TRGamer28.coppermod.util.handlers.EnumHandler;

import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;


public class WorldGenCustomOres implements IWorldGenerator
{
	private WorldGenerator  copper_ore;
	private WorldGenerator  tin_ore ;
	private WorldGenerator  silver_ore ;
	private WorldGenerator  limestone ;
	private WorldGenerator  carbon_ore;

	
	public WorldGenCustomOres() 
	{
		
		copper_ore = new WorldGenMinable(ModBlocks.COPPER_ORE.getDefaultState().withProperty(BlockOres.VARIANT, EnumHandler.EnumType.NORMAL), 9, BlockMatcher.forBlock(Blocks.STONE));
		tin_ore = new WorldGenMinable(ModBlocks.TIN_ORE.getDefaultState().withProperty(BlockOres.VARIANT, EnumHandler.EnumType.NORMAL), 9, BlockMatcher.forBlock(Blocks.STONE));
		silver_ore = new WorldGenMinable(ModBlocks.SILVER_ORE.getDefaultState().withProperty(BlockOres.VARIANT, EnumHandler.EnumType.NORMAL), 9, BlockMatcher.forBlock(Blocks.STONE));
		limestone = new WorldGenMinable(ModBlocks.LIMESTONE.getDefaultState().withProperty(BlockOres.VARIANT, EnumHandler.EnumType.NORMAL), 9, BlockMatcher.forBlock(Blocks.STONE));
		carbon_ore = new WorldGenMinable(ModBlocks.CARBON_ORE.getDefaultState().withProperty(BlockOres.VARIANT, EnumHandler.EnumType.NORMAL), 9, BlockMatcher.forBlock(Blocks.STONE));

	}
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) 
	{
		switch(world.provider.getDimension())
		{
   case -1:
			
			runGenerator(carbon_ore, world, random, chunkX, chunkZ, 10, 0, 100);
			
			
			break;
			
		case 0:
			
			runGenerator(copper_ore, world, random, chunkX, chunkZ, 80, 10, 100);
			runGenerator(tin_ore, world, random, chunkX, chunkZ, 100, 6, 200);
			runGenerator(silver_ore, world, random, chunkX, chunkZ, 150, 20, 100);
			runGenerator(limestone, world, random, chunkX, chunkZ, 20, 20, 100);


			break;
			
		
		}
	}
	
	private void runGenerator(WorldGenerator gen, World world, Random rand, int chunkX, int chunkZ, int chance, int minHeight, int maxHeight)
	{
		if(minHeight > maxHeight || minHeight < 0 || maxHeight > 256) throw new IllegalArgumentException("Ore generated out of bounds");
		
		int heightDiff = maxHeight - minHeight + 1;
		for(int i = 0; i < chance; i++)
		{
			int x = chunkX * 16 + rand.nextInt(16);
			int y = minHeight + rand.nextInt(heightDiff);
			int z = chunkZ * 16 + rand.nextInt(16);
			
			gen.generate(world, rand, new BlockPos(x,y,z));
		}
	}
}
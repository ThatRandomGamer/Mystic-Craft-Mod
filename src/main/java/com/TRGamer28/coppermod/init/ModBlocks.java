package com.TRGamer28.coppermod.init;

import java.util.ArrayList;
import java.util.List;

import com.TRGamer28.coppermod.blocks.BlockBase;
import com.TRGamer28.coppermod.blocks.BlockMetal;
import com.TRGamer28.coppermod.blocks.BlockOres;
import com.TRGamer28.coppermod.blocks.BlockRicePlant;
import com.TRGamer28.coppermod.blocks.BlockStone;
import com.TRGamer28.coppermod.blocks.DualFurnace.BlockDualFurnace;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;


public class ModBlocks {

	public static final  List<Block> BLOCKS = new ArrayList<Block>();
	
	//Blocks
	public static final Block COPPER_BLOCK = new BlockMetal("copper_block", Material.IRON);
	public static final Block BRONZE_BLOCK = new BlockMetal("bronze_block", Material.IRON);
	public static final Block STEEL_BLOCK = new BlockMetal("steel_block", Material.IRON);
	public static final Block TIN_BLOCK = new BlockMetal("tin_block", Material.IRON);
	public static final Block SILVER_BLOCK = new BlockMetal("silver_block", Material.IRON);
	public static final Block CHISELED_LIMESTONE = new BlockStone("chiseled_limestone", Material.ROCK);
	public static final Block MARBLE = new BlockStone("marble_block", Material.ROCK);
	//Ores
	public static final Block CARBON_ORE = new BlockOres("carbon_ore","nether");
	public static final Block LIMESTONE = new BlockOres("limestone", "overworld");
	public static final Block COPPER_ORE = new BlockOres("copper_ore", "overworld");
	public static final Block TIN_ORE = new BlockOres("tin_ore", "overworld");
	public static final Block SILVER_ORE = new BlockOres("silver_ore", "overworld");

//Plants
	 public static final Block RICE_PLANT = new BlockRicePlant("rice_plant");
	 
	 //Custome Machines
		public static final Block DUAL_FURNACE = new BlockDualFurnace("dual_furnace");

	 
}


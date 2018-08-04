package com.TRGamer28.coppermod.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BlockStone extends BlockBase {

	public BlockStone(String name, Material material) {
		super(name, material);
		setSoundType(SoundType.STONE);
		setHardness(2.0F);
		setResistance(15.0F);
		setHarvestLevel("pickaxe", 1);
		setLightOpacity(1);
	}
}

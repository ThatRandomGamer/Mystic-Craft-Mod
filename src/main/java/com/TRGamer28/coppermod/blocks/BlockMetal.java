package com.TRGamer28.coppermod.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BlockMetal extends BlockBase {

	public BlockMetal(String name, Material material) {
		super(name, material);
		setSoundType(SoundType.METAL);
		setHardness(5.0F);
		setResistance(15.0F);
		setHarvestLevel("pickaxe", 2);
		setLightOpacity(1);
	}
}

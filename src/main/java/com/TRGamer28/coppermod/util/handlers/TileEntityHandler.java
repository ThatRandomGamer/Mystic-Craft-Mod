package com.TRGamer28.coppermod.util.handlers;

import com.TRGamer28.coppermod.blocks.DualFurnace.TileEntityDualFurnace;
import net.minecraftforge.fml.common.registry.GameRegistry;


public class TileEntityHandler 
{
	public static void registerTileEntities()
	{
		GameRegistry.registerTileEntity(TileEntityDualFurnace.class, "dual_furnace");
	
	}
}
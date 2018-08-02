package com.TRGamer28.coppermod.util.handlers;

import com.TRGamer28.coppermod.blocks.DualFurnace.GuiDualFurnace;
import com.TRGamer28.coppermod.blocks.DualFurnace.TileEntityDualFurnace;
import com.TRGamer28.coppermod.blocks.DualFurnace.ContainerDualFurnace;
import com.TRGamer28.coppermod.util.Reference;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;


public class GuiHandler implements IGuiHandler
 
{
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
		if(ID == Reference.GUI_DUAL_FURNACE) return new ContainerDualFurnace(player.inventory, (TileEntityDualFurnace)world.getTileEntity(new BlockPos(x,y,z)));
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) 
	{
		if(ID == Reference.GUI_DUAL_FURNACE) return new GuiDualFurnace(player.inventory, (TileEntityDualFurnace)world.getTileEntity(new BlockPos(x,y,z)));
		return null;
	}

}


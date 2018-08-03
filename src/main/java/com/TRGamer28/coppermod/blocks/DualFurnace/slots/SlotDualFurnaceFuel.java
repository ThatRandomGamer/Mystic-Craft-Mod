package com.TRGamer28.coppermod.blocks.DualFurnace.slots;
import com.TRGamer28.coppermod.blocks.DualFurnace.TileEntityDualFurnace;
import com.TRGamer28.coppermod.blocks.DualFurnace.slots.*;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotDualFurnaceFuel extends Slot
{
	public SlotDualFurnaceFuel(IInventory inventory, int index, int x, int y) 
	{
		super(inventory, index, x, y);
	}
	
	@Override
	public boolean isItemValid(ItemStack stack)
	{
		return TileEntityDualFurnace.isItemFuel(stack);
	}
	
	@Override
	public int getItemStackLimit(ItemStack stack) 
	{
		return super.getItemStackLimit(stack);
	}
}

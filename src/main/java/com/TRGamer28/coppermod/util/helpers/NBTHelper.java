package com.TRGamer28.coppermod.util.helpers;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.*;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class NBTHelper {

	public static NBTTagCompound toNBT(Object o) {
		if(o instanceof ItemStack)
			return writeItemStack((ItemStack)o);
		return null;
	}
	
	private static NBTTagCompound writeItemStack(ItemStack i) {
		NBTTagCompound nbt = new NBTTagCompound();
		nbt.setInteger("count", i.getCount());
		nbt.setString("item", i.getItem().getRegistryName().toString());
		nbt.setByte("type", (byte) 0);
		return nbt;
	}
	
	@Nullable
	public static Object fromNBT(@Nonnull NBTTagCompound compound) {
		switch (compound.getByte("type")) {
		case 0:
			return readItemStack(compound);

		default:
			return null;
		}
	}
	
	private static ItemStack readItemStack(NBTTagCompound compound) {
		Item item = ForgeRegistries.ITEMS.getValue(new ResourceLocation(compound.getString("item")));
		int count = compound.getInteger("count");
		return new ItemStack(item, count);
	}

}
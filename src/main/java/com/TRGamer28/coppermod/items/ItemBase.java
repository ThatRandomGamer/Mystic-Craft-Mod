package com.TRGamer28.coppermod.items;

import com.TRGamer28.coppermod.init.ModItems;
import com.TRGamer28.coppermod.util.IHasModel;
import com.TRGamer28.coppermod.Main;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemBase extends Item implements IHasModel {

 public ItemBase (String name)
 {
	setUnlocalizedName(name);
	setRegistryName(name);
	setCreativeTab(CreativeTabs.MATERIALS);
	
	ModItems.ITEMS.add(this);
	 
	 
 }
	
	@Override
	public void registerModels() 
	{
		Main.proxy.registerItemRenderer(this, 0, "inventory");
	}

}

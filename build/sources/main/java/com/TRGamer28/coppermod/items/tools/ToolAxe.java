package com.TRGamer28.coppermod.items.tools;

import com.TRGamer28.coppermod.init.ModItems;
import com.TRGamer28.coppermod.util.IHasModel;
import com.TRGamer28.mysticcraft.Main;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemAxe;

public class ToolAxe extends ItemAxe implements IHasModel {

 public ToolAxe (String name, ToolMaterial material)
 {
	 super(material,6.0F,-3.2F);
	 setUnlocalizedName(name);
	setRegistryName(name);
	setCreativeTab(CreativeTabs.TOOLS);
	
	ModItems.ITEMS.add(this);
	 
	 
 }
	
	@Override
	public void registerModels() 
	{
		Main.proxy.registerItemRenderer(this, 0, "inventory");
	}

}
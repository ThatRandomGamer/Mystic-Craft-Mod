package com.TRGamer28.coppermod.items.tools;

import com.TRGamer28.coppermod.init.ModItems;
import com.TRGamer28.coppermod.util.IHasModel;
import com.TRGamer28.coppermod.Main;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSpade;

public class ToolSpade extends ItemSpade implements IHasModel {

 public ToolSpade (String name, ToolMaterial material)
 {
	 super(material);
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

package com.TRGamer28.coppermod.init;

import java.util.ArrayList;
import java.util.List;

import com.TRGamer28.coppermod.items.food.FoodBase;
import com.TRGamer28.coppermod.items.food.ItemRice;
import com.TRGamer28.coppermod.items.ItemBase;
import com.TRGamer28.coppermod.items.armor.ArmorBase;
import com.TRGamer28.coppermod.items.tools.ToolArrow;
import com.TRGamer28.coppermod.items.tools.ToolAxe;
import com.TRGamer28.coppermod.items.tools.ToolBow;
import com.TRGamer28.coppermod.items.tools.ToolHoe;
import com.TRGamer28.coppermod.items.tools.ToolMace;
import com.TRGamer28.coppermod.items.tools.ToolPickaxe;
import com.TRGamer28.coppermod.items.tools.ToolSai;
import com.TRGamer28.coppermod.items.tools.ToolSpade;
import com.TRGamer28.coppermod.items.tools.ToolSword;
import com.TRGamer28.coppermod.util.Reference;

import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemSword;
import net.minecraftforge.common.util.EnumHelper;
import scala.tools.nsc.settings.Final;

public class ModItems {
	
	public static final List<Item> ITEMS = new ArrayList<Item>();
	
     //Materials
	public static final ToolMaterial MATERIAL_COPPER = EnumHelper.addToolMaterial("material_copper", 1, 190, 6.0F, 2.0F, 10);
	public static final ToolMaterial MATERIAL_BRONZE = EnumHelper.addToolMaterial("material_bronze", 1, 220, 6.0F, 2.0F, 12);
	public static final ToolMaterial MATERIAL_IRON = EnumHelper.addToolMaterial("material_iron", 2, 250, 6.0F, 2.0F, 14);
	public static final ToolMaterial MATERIAL_STEEL = EnumHelper.addToolMaterial("material_steel", 1, 1361, 7.0F, 5.0F, 10);
	public static final ToolMaterial MATERIAL_GOLD = EnumHelper.addToolMaterial("material_gold", 0, 32, 12.0F, 0.0F, 22);
	public static final ToolMaterial MATERIAL_DIAMOND = EnumHelper.addToolMaterial("material_diamond", 3, 1561, 8.0F, 3.0F, 10);

	
	
	
	public static final ArmorMaterial ARMOR_MATERIAL_BRONZE = EnumHelper.addArmorMaterial("armor_material_bronze", Reference.MOD_ID + ":bronze", 14, 
			new int[] {2, 5, 5, 2}, 10, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 0.0F);
	public static final ArmorMaterial ARMOR_MATERIAL_GOLD = EnumHelper.addArmorMaterial("armor_material_gold", Reference.MOD_ID + ":gold", 14, 
			new int[] {2, 5, 5, 2}, 10, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 0.0F);
	public static final ArmorMaterial ARMOR_MATERIAL_SILVER = EnumHelper.addArmorMaterial("armor_material_silver", Reference.MOD_ID + ":silver", 14, 
			new int[] {2, 5, 5, 2}, 10, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 0.0F);
	public static final ArmorMaterial ARMOR_MATERIAL_STEEL = EnumHelper.addArmorMaterial("armor_material_steel", Reference.MOD_ID + ":steel", 14, 
			new int[] {2, 5, 5, 2}, 10, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 0.0F);

	
	//Items
	public static final Item COPPER_INGOT = new ItemBase("copper_ingot");
	public static final Item STEEL_INGOT = new ItemBase("steel_ingot");
	public static final Item CARBON_CRYSTAL= new ItemBase("carbon_crystal");
	public static final Item BRONZE_INGOT = new ItemBase("bronze_ingot");
	public static final Item SILVER_INGOT = new ItemBase("silver_ingot");
	public static final Item TIN_INGOT = new ItemBase("tin_ingot");
	public static final Item COPPER_NUGGET = new ItemBase("copper_nugget");
	public static final Item SILVER_NUGGET = new ItemBase("silver_nugget");
	public static final Item BRONZE_NUGGET = new ItemBase("bronze_nugget");
	public static final Item TIN_NUGGET = new ItemBase("tin_nugget");
	public static final Item STEEL_NUGGET = new ItemBase("steel_nugget");
    public static final Item BOILED_WATER = new ItemBase ("boiled_water");
	//Tools
	 public static final ItemSword COPPER_INGOT_SWORD = new ToolSword("copper_ingot_sword", MATERIAL_COPPER);
	 public static final ToolMace COPPER_INGOT_MACE = new ToolMace(MATERIAL_COPPER, "copper_mace");
	 public static final ToolSai COPPER_INGOT_SAI = new ToolSai(MATERIAL_COPPER, "copper_sai");

	 public static final ToolMace BRONZE_MACE = new ToolMace(MATERIAL_BRONZE, "bronze_mace");
	 public static final ToolSai BRONZE_SAI = new ToolSai(MATERIAL_BRONZE, "bronze_sai");

	 public static final ToolMace GOLD_MACE = new ToolMace(MATERIAL_GOLD, "gold_mace");
	 public static final ToolSai GOLD_SAI = new ToolSai(MATERIAL_GOLD, "gold_sai");

	 public static final ToolMace IRON_MACE = new ToolMace(MATERIAL_IRON, "iron_mace");
	 public static final ToolSai IRON_SAI = new ToolSai(MATERIAL_IRON, "iron_sai");

	 public static final ToolMace STEEL_MACE = new ToolMace(MATERIAL_STEEL, "steel_mace");
	 public static final ToolSai STEEL_SAI = new ToolSai(MATERIAL_STEEL, "steel_sai");
	 public static final ItemSword STEEL_SWORD = new ToolSword("steel_sword", MATERIAL_STEEL);

	 public static final ToolMace DIAMOND_MACE = new ToolMace(MATERIAL_DIAMOND, "diamond_mace");
	 public static final ToolSai DIAMOND_SAI = new ToolSai(MATERIAL_DIAMOND, "diamond_sai");

	 
	 public static final ItemSpade COPPER_INGOT_SHOVEL = new ToolSpade("copper_ingot_shovel", MATERIAL_COPPER);
	 public static final ItemPickaxe COPPER_PICKAXE = new ToolPickaxe("copper_pickaxe", MATERIAL_COPPER);
	 public static final ItemAxe COPPER_INGOT_AXE = new ToolAxe("copper_ingot_axe", MATERIAL_COPPER);
	 public static final ItemHoe COPPER_INGOT_HOE = new ToolHoe("copper_ingot_hoe", MATERIAL_COPPER);
	 public static final ToolBow COPPERBOW = new ToolBow("copperbow");



	//Armor
		public static final Item BRONZE_HELMET = new ArmorBase("bronze_helmet", ARMOR_MATERIAL_BRONZE, 1, EntityEquipmentSlot.HEAD);
		
		public static final Item BRONZE_CHESTPLATE = new ArmorBase("bronze_chestplate", ARMOR_MATERIAL_BRONZE, 1, EntityEquipmentSlot.CHEST);
		public static final Item BRONZE_LEGGINGS = new ArmorBase("bronze_leggings", ARMOR_MATERIAL_BRONZE, 2, EntityEquipmentSlot.LEGS);
		public static final Item BRONZE_BOOTS = new ArmorBase("bronze_boots", ARMOR_MATERIAL_BRONZE, 1, EntityEquipmentSlot.FEET);
	 
	//Food
		public static final Item RICE_BOWL = new FoodBase("rice_bowl", 3, false);
		public static final Item FRIED_RICE = new FoodBase("fried_rice", 5, false);
		public static final Item FRIED_CHICKEN_RICE = new FoodBase("fried_chicken_rice", 7, false);
		public static final Item BOILED_CHICKEN = new FoodBase("boiled_chicken", 3, false);
		public static final Item FRIED_CHICKEN = new FoodBase("fried_chicken", 6, false);

		
		public static final Item RICE = new ItemRice("rice", 1, false);

}

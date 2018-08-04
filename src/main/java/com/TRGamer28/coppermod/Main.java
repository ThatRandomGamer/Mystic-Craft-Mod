package com.TRGamer28.coppermod;

import com.TRGamer28.coppermod.init.ModRecipies;
import com.TRGamer28.coppermod.proxy.CommonProxy;
import com.TRGamer28.coppermod.util.Reference;
import com.TRGamer28.coppermod.util.handlers.RegistryHandler;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Reference.MOD_ID, name = Reference.NAME, version = Reference.VERSION)
public class Main {

	@Instance
	public static Main instance;
	
	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS,serverSide = Reference.COMMON_PROXY_CLASS)
	public static CommonProxy proxy;
	
	@EventHandler
	public static void PreInit(FMLPreInitializationEvent event){RegistryHandler.preInitRegistries();}
	{
		
	}
	
	@EventHandler
	public static void init(FMLInitializationEvent event)
	{
		ModRecipies.init();
		RegistryHandler.initRegistries();
	}
	
	@EventHandler
	public static void PostInit(FMLPostInitializationEvent event)
	{
		RegistryHandler.postInitRegistries();
	}
}
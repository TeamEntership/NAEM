package com.entership.naem;

import com.entership.naem.network.CommonProxy;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(	modid = Data.MODID,
		version = Data.VERSION,
		name = Data.NAME,
		acceptedMinecraftVersions = Data.MCVERSIONS)
public class naemMain {
	
	@SidedProxy(clientSide = Data.clientproxy, serverSide = Data.commonproxy)
	public static CommonProxy proxy;
	
	@Instance(Data.MODID)
	public static naemMain instance;
	
	@EventHandler
    public void preinit(FMLPreInitializationEvent event)
    {
		
    }
	
	@EventHandler
    public void init(FMLInitializationEvent event)
    {
		
    }
	
	@EventHandler
    public void postinit(FMLPostInitializationEvent event)
    {
    }

}

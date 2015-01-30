package com.entership.naem;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import com.entership.naem.blocks.naemBlocks;
import com.entership.naem.handler.naemCreativeTab;
import com.entership.naem.items.naemItems;
import com.entership.naem.network.CommonProxy;

@Mod(	modid = Data.MODID,
		version = Data.VERSION,
		name = Data.NAME,
		acceptedMinecraftVersions = Data.MCVERSIONS)
public class naemMain {
	
	// CreativeTab
	public static CreativeTabs naemtabitems = new naemCreativeTab(CreativeTabs.getNextID(), "naemtabitems", 1);
	public static CreativeTabs naemtabblocks = new naemCreativeTab(CreativeTabs.getNextID(), "naemtabblocks", 0);
	
	@SidedProxy(clientSide = Data.CLIENTPROXY, serverSide = Data.COMMONPROXY)
	public static CommonProxy proxy;
	
	@Instance(Data.MODID)
	public static naemMain instance;
	
	@EventHandler
    public void preinit(FMLPreInitializationEvent event)
    {
		//PacketHandler
		//reg Fluids
		//init blocks
		naemBlocks.init();
		naemItems.init();
		//init items
    }
	
	@EventHandler
    public void init(FMLInitializationEvent event)
    {
		//reg item render
		naemBlocks.initItemModel();
		naemItems.initItemModel();
		//recipes
    }
	
	@EventHandler
    public void postinit(FMLPostInitializationEvent event)
    {
    }

}

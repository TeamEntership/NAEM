package com.entership.naem.blocks;

import net.minecraft.block.material.Material;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import com.entership.naem.Data;
import com.entership.naem.naemMain;
import com.entership.naem.handler.naemContent;
import com.entership.naem.lib.naemLib;

public class naemBlocks{

	public static void init() {

		naemContent.dark_brick = new BlockDarkBrick(Material.rock).setUnlocalizedName("dark_brick").setCreativeTab(naemMain.naemtabblocks);

		registerBlocks();
		setFireInfo();
		oreDictRegister();
	}	

    public static void initItemModel()
    {
		naemLib.registerInventoryItem(naemContent.dark_brick, Data.MODID);
		naemLib.registerInventoryItem(naemContent.dark_brick, Data.MODID, 1);
	}

	private static void registerBlocks() {
		naemLib.register(naemContent.dark_brick);
	}

	private static void setFireInfo() {
	}

	private static void oreDictRegister() {
	}
	
}

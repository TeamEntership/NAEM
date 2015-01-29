package com.entership.naem.blocks;

import net.minecraft.block.material.Material;

import com.entership.naem.Data;
import com.entership.naem.naemMain;
import com.entership.naem.handler.naemContent;
import com.entership.naem.lib.naemLib;

public class naemBlocks {

	public static void init() {

		naemContent.broken_rock = new BlockRuinRock(Material.rock).setUnlocalizedName(Data.MODID + ":broken_rock").setCreativeTab(naemMain.naemtabblocks);

		registerBlocks();
		setFireInfo();
		oreDictRegister();
	}

	private static void registerBlocks() {
		naemLib.register(naemContent.broken_rock);
	}

	private static void setFireInfo() {
	}

	private static void oreDictRegister() {
	}
}

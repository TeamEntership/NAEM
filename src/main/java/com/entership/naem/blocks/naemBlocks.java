package com.entership.naem.blocks;

import net.minecraft.block.material.Material;

import com.entership.naem.handler.naemContent;
import com.entership.naem.items.ItemBlockMeta;
import com.entership.naem.lib.naemLib;

public class naemBlocks {

	public static void init() {

		naemContent.dark_brick = new BlockDarkbrick(Material.rock).setUnlocalizedName("dark_brick");
		naemContent.stone_tile = new BlockStoneTile(Material.rock).setUnlocalizedName("stone_tile");

		registerBlocks();
		setFireInfo();
		oreDictRegister();
	}

	public static void initItemModel() {

		naemLib.registerVariant(naemContent.dark_brick, 1);
		naemLib.registerVariant(naemContent.stone_tile, 3);

	}
	
	private static void registerBlocks() {
		naemLib.register(naemContent.dark_brick, ItemBlockMeta.class);
		naemLib.register(naemContent.stone_tile, ItemBlockMeta.class);
	}

	private static void setFireInfo() {
	}

	private static void oreDictRegister() {
	}

}

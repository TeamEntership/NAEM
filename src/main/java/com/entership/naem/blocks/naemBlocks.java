package com.entership.naem.blocks;

import net.minecraft.block.material.Material;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.entership.naem.Data;
import com.entership.naem.naemContent;
import com.entership.naem.naemMain;

public class naemBlocks {

	public static void init() {

		naemContent.ruin_rock = new BlockRuinRock(Material.rock).setUnlocalizedName(Data.MODID + ":ruin_rock").setCreativeTab(naemMain.naemtabblocks);

		registerBlocks();
		setFireInfo();
		oreDictRegister();
	}

	private static void registerBlocks() {
		GameRegistry.registerBlock(naemContent.ruin_rock, "ruin_rock");
	}

	private static void setFireInfo() {
	}

	private static void oreDictRegister() {
	}
}

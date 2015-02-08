package com.entership.naem.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.entership.naem.Data;
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

		for (int i = 0; i < 2; i++) {

			Item item = Item.getItemFromBlock(naemContent.dark_brick);
			ItemStack it = new ItemStack(item, 1, i);
			String name = it.getUnlocalizedName().substring(5);

			ModelBakery.addVariantName(item, Data.MODID + ":" + name);
			Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
					.register(it.getItem(), it.getItemDamage(), new ModelResourceLocation(Data.MODID + ":" + name, "inventory"));
		}
		for (int i = 0; i < 4; i++) {

			Item item = Item.getItemFromBlock(naemContent.stone_tile);
			ItemStack it = new ItemStack(item, 1, i);
			String name = it.getUnlocalizedName().substring(5);

			ModelBakery.addVariantName(item, Data.MODID + ":" + name);
			Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
					.register(it.getItem(), it.getItemDamage(), new ModelResourceLocation(Data.MODID + ":" + name, "inventory"));
		}

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

package com.entership.naem.items;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.entership.naem.Data;
import com.entership.naem.handler.naemContent;
import com.entership.naem.lib.naemLib;

public class naemItems {

	public static void init() {

		naemContent.robot_part = new ItemRobotpart().setUnlocalizedName("robot_part");

		registerItems();
		oreDictRegister();
	}

	public static void initItemModel() {
		
		for (int i = 0; i < 4; i++) {

			Item item = naemContent.robot_part;
			ItemStack it = new ItemStack(item, 1, i);
			String name = it.getUnlocalizedName().substring(5);

			ModelBakery.addVariantName(item, Data.MODID + ":" + name);
			Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
					.register(it.getItem(), it.getItemDamage(), new ModelResourceLocation(Data.MODID + ":" + name, "inventory"));
		}

	}

	private static void registerItems() {
		naemLib.register(naemContent.robot_part);

	}

	private static void oreDictRegister() {
	}
}

package com.entership.naem.handler;

import com.entership.naem.Data;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;

public class naemModelMesher {

	public static void init() {

		// Blocks
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
				.register(Item.getItemFromBlock(naemContent.broken_rock), 0, new ModelResourceLocation(Data.MODID + ":broken_rock", "inventory"));

		// Items

	}

}

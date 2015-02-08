package com.entership.naem.items;

import com.entership.naem.handler.naemContent;
import com.entership.naem.lib.naemLib;

public class naemItems {

	public static void init() {

		naemContent.robot_part = new ItemRobotpart().setUnlocalizedName("robot_part");

		registerItems();
		oreDictRegister();
	}

	public static void initItemModel() {
		naemLib.registerVariant(naemContent.robot_part, 3);

	}

	private static void registerItems() {
		naemLib.register(naemContent.robot_part);

	}

	private static void oreDictRegister() {
	}
}

package com.entership.naem.handler;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class naemCreativeTab extends CreativeTabs {

	private int tab;

	public naemCreativeTab(int par1, String par2Str, int par3) {
		super(par1, par2Str);
		tab = par3;
	}

	@Override
	public Item getTabIconItem() {

		if (tab >= 1) {
			return Item.getItemFromBlock(naemContent.dark_brick); //Itemtab
		} else {
			return Item.getItemFromBlock(naemContent.dark_brick);
		}

	}

}

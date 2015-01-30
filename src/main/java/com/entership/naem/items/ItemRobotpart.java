package com.entership.naem.items;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.entership.naem.naemMain;

public class ItemRobotpart extends Item {

	int robot_max = 4;

	public ItemRobotpart() {
		this.setHasSubtypes(true);
		this.setMaxDamage(0);
		this.setCreativeTab(naemMain.naemtabitems);
	}

	public String getUnlocalizedName(ItemStack stack) {
		int i = stack.getMetadata();
		return super.getUnlocalizedName() + "_" + EnumRobotParts.byDyeDamage(i).getUnlocalizedName();
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@SideOnly(Side.CLIENT)
	public void getSubItems(Item itemIn, CreativeTabs tab, List subItems) {
		for (int i = 0; i < this.robot_max; ++i) {
			subItems.add(new ItemStack(itemIn, 1, i));
		}
	}
}

package com.entership.naem.items;

import net.minecraft.block.Block;
import net.minecraft.item.ItemMultiTexture;
import net.minecraft.item.ItemStack;

import com.google.common.base.Function;

public class ItemBlockMeta extends ItemMultiTexture {

	public ItemBlockMeta(final Block b) {
		super(b, b, new Function<ItemStack, String>() {
			@Override
			public String apply(ItemStack input) {
				return input.getItemDamage() + "";// b.getUnlocalizedName();
			}
		});
	}

	public String getUnlocalizedName(ItemStack stack) {
		return super.getUnlocalizedName() + "_" + (String) this.nameFunction.apply(stack);
	}
}
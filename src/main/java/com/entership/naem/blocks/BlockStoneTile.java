package com.entership.naem.blocks;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.entership.naem.naemMain;

public class BlockStoneTile extends Block {

	protected BlockStoneTile(Material p_i45394_1_) {
		super(p_i45394_1_);
		setCreativeTab(naemMain.naemtabblocks);
		this.setDefaultState(this.blockState.getBaseState().withProperty(META, 0));
	}
	
	public static final PropertyInteger META = PropertyInteger.create("metadata", 0, 3);

	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(META, meta);
	}

	public int getMetaFromState(IBlockState state) {
		return (Integer) state.getValue(META);
	}

	protected BlockState createBlockState() {
		return new BlockState(this, new IProperty[] { META });
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void getSubBlocks(Item it, CreativeTabs t, List l) {
		for (int i = 0; i <= 3; i++) {
			l.add(new ItemStack(it, 1, i));
		}
	}

	@Override
	public int damageDropped(IBlockState i) {
		return (Integer) i.getValue(META);
	}

	public int getRenderType() {
		return 3;
	}
}
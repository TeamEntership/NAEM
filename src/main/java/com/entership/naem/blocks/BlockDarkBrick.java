package com.entership.naem.blocks;

import java.awt.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockDarkBrick extends Block {

	//private IProperty VARIANT = PropertyEnum.create("variant",BlockDarkBrick.DarkBrickType.class.getClass());


	protected BlockDarkBrick(Material materialIn) {
		super(materialIn);
		
		//this.setDefaultState(this.blockState.getBaseState().withProperty(VARIANT, BlockDarkBrick.DarkBrickType.DEFAULT));
		// TODO Auto-generated constructor stub
	}
	
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item item, CreativeTabs tab, List list)
	{
		BlockDarkBrick.DarkBrickType[] types = BlockDarkBrick.DarkBrickType.values();
		for(int i = 0; i< types.length; ++i){
			BlockDarkBrick.DarkBrickType type = types[i];
			//list.add(new ItemStack(item, 1, type.getMetadata()));
		}
	}
	
//	protected BlockState createBlockState()
//	{
//		System.out.println(BlockDarkBrick.DarkBrickType.BUILD.getName());
//		return new BlockState(this, VARIANT);
//	}
//	
//	public IBlockState getStatefromMeta(int meta)
//	{
//		return this.getDefaultState().withProperty(VARIANT, BlockDarkBrick.DarkBrickType.byMetadata(meta));
//	}
//	
//	public int getMetafromState(IBlockState state)
//	{
//		return ((BlockDarkBrick.DarkBrickType) state.getValue(VARIANT)).getMetadata();
//	}
//	
//	public int damageDropped(IBlockState state)
//	{
//		return ((BlockDarkBrick.DarkBrickType) state.getValue(VARIANT)).getMetadata();
//	}
	
	
	public static enum DarkBrickType implements IStringSerializable
	{
		DEFAULT(0, "broken_rock", "broken_rock"),
		BUILD(1, "dark_brick", "dark_brick");
		
		private static final BlockDarkBrick.DarkBrickType[] META_LOOKUP = new BlockDarkBrick.DarkBrickType[values().length];
       	private final int meta;
        private final String name;
        private final String unlocalizedName;
        
        private DarkBrickType(int meta, String name, String unlocalizedName){
        	this.meta = meta;
        	this.name = name;
        	this.unlocalizedName = unlocalizedName;
        }
        
		@Override
		public String toString() {
			return name;
		}
		
		public String getName() {
			return name;
		}
		
		public int getMetadata() {
			return meta;
		}

		public String getUnlocalizedName() {
			return unlocalizedName;
		}
		
		public static BlockDarkBrick.DarkBrickType byMetadata(int meta)
        {
            if (meta < 0 || meta >= META_LOOKUP.length)
            {
                meta = 0;
            }

            return META_LOOKUP[meta];
        }
		
		static
        {
			BlockDarkBrick.DarkBrickType[] types = values();
            int length = types.length;

            for (int i = 0; i < types.length; ++i)
            {
                DarkBrickType var3 = types[i];
                META_LOOKUP[var3.getMetadata()] = var3;
            }
        }
		
		
	}

}

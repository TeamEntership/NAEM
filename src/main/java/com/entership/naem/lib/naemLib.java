package com.entership.naem.lib;

import java.util.Arrays;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.entership.naem.Data;

public class naemLib {

	/**
	 * Registers an item with unlocalized name
	 */
	public static void register(Item item) {
		GameRegistry.registerItem(item, item.getUnlocalizedName().substring(5));
	}

	/**
	 * Registers a block with unlocalized name
	 */
	public static void register(Block block) {
		GameRegistry.registerBlock(block, block.getUnlocalizedName().substring(5));
	}

	/**
	 * Registers a block including ItemBlock with unlocalized name
	 */
	public static void register(Block block, Class<? extends ItemBlock> class1) {
		GameRegistry.registerBlock(block, class1, block.getUnlocalizedName().substring(5));
	}

	// ------------------------------------------------------------

	/**
	 * Drops an itemstack
	 * 
	 * @param itemstack
	 *            the itemstack to be dropped
	 * @param world
	 *            the world
	 * @param x
	 *            coordinate (west<east)
	 * @param y
	 *            coordinate (up>down)
	 * @param z
	 *            coordinate (north<south)
	 * @param delay
	 *            delay, before the dropped item can be picked up
	 */
	public static void dropItemStack(ItemStack itemstack, World world, double x, double y, double z, int delay) {
		EntityItem entityitem = new EntityItem(world, x, y, z, itemstack);
		entityitem.posX = x;
		entityitem.posY = y;
		entityitem.posZ = z;
		entityitem.setPickupDelay(delay);
		if (itemstack.hasTagCompound()) {
			entityitem.getEntityItem().setTagCompound((NBTTagCompound) itemstack.getTagCompound().copy());
		}
		world.spawnEntityInWorld(entityitem);
	}

	/**
	 * Drops an Itemstack with default pickup delay Args: itemstack, world,
	 * coords
	 * 
	 * @param itemstack
	 *            itemstack to be dropped
	 */
	public static void dropItemStack(ItemStack itemstack, World world, int x, int y, int z) {
		dropItemStack(itemstack, world, x, y, z, 10);
	}

	/**
	 * Drops Itemstack in x/z radius of the coords Args: itemstack, world,
	 * coords
	 * 
	 * @param itemstack
	 *            itemstack, wants to be dropped
	 */
	public static void dropItemStackAround(ItemStack itemstack, World world, int x, int y, int z, int radius) {
		x = x + MathHelper.getRandomIntegerInRange(new Random(), 0, radius);
		z = z + MathHelper.getRandomIntegerInRange(new Random(), 0, radius);
		dropItemStack(itemstack, world, x, y, z, 10);
	}

	/**
	 * Drops an itemstack
	 * 
	 * @param itemstack
	 *            the itemstack to be dropped
	 * @param world
	 *            the world
	 * @param pos
	 *            coordinates as Block Position (BlockPos)
	 * @param delay
	 *            delay, before the dropped item can be picked up
	 */
	public static void dropItemStack(ItemStack itemstack, World world, BlockPos pos, int delay) {
		dropItemStack(itemstack, world, pos.getX(), pos.getY(), pos.getZ(), delay);
	}

	/**
	 * Drops an Itemstack with default pickup delay Args: itemstack, world,
	 * BlockPos
	 * 
	 * @param itemstack
	 *            itemstack to be dropped
	 */
	public static void dropItemStack(ItemStack itemstack, World world, BlockPos pos) {
		dropItemStack(itemstack, world, pos.getX(), pos.getY(), pos.getZ(), 10);
	}

	/**
	 * Drops Itemstack in x/z radius of the coords Args: itemstack, world,
	 * BlockPos
	 * 
	 * @param itemstack
	 *            itemstack, wants to be dropped
	 */
	public static void dropItemStackAround(ItemStack itemstack, World world, BlockPos pos, int radius) {
		dropItemStackAround(itemstack, world, pos.getX(), pos.getY(), pos.getZ(), radius);
	}

	// --------------------------------------------------------------------

	/**
	 * registers the Variant and itemModel for the block
	 * 
	 * @param item
	 *            the item that gets registered
	 * @param meta
	 *            the meta of the block
	 */
	public static void registerVariant(Block block, int meta) {
		registerVariant(Item.getItemFromBlock(block), meta);
	}

	/**
	 * registers the Variant and itemModel for the item
	 * 
	 * @param item
	 *            the item that gets registered
	 * @param meta
	 *            the meta of the item
	 */
	public static void registerVariant(Item item, int meta) {
		
		for (int i = 0; i < meta + 1; i++) {
			ItemStack it = new ItemStack(item, 1, i);
			String name = it.getUnlocalizedName().substring(5);

			ModelBakery.addVariantName(item, Data.MODID + ":" + name);
			Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
					.register(it.getItem(), it.getItemDamage(), new ModelResourceLocation(Data.MODID + ":" + name, "inventory"));
		}

	}

	/**
	 * registers the inventory model using the given block meta = 0; modelname =
	 * unlocalized name of block must be used in init
	 * 
	 * @param block
	 *            the block using the model
	 * @param modid
	 *            the modid of the block
	 */
	public static void registerInventoryItem(Block block, String modid) {
		registerInventoryItem(block, modid, block.getUnlocalizedName().substring(5), 0);
	}

	/**
	 * registers the inventory model using the given item meta = 0; modelname =
	 * unlocalized name of item must be used in init
	 * 
	 * @param item
	 *            the item using the model
	 * @param modid
	 *            the modid of the item
	 */
	public static void registerInventoryItem(Item item, String modid) {
		registerInventoryItem(item, modid, item.getUnlocalizedName().substring(5), 0);
	}

	/**
	 * registers the inventory model using the given block modelname =
	 * unlocalized name of item must be used in init
	 * 
	 * @param block
	 *            the block using the model
	 * @param modid
	 *            the modid of the block
	 * @param modelname
	 *            the model file name (the json item-model)
	 */
	public static void registerInventoryItem(Block block, String modid, int meta) {
		registerInventoryItem(block, modid, block.getUnlocalizedName().substring(5), meta);
	}

	/**
	 * registers the inventory model using the given item modelname =
	 * unlocalized name of item must be used in init
	 * 
	 * @param item
	 *            the item using the model
	 * @param modid
	 *            the modid of the item
	 * @param modelname
	 *            the model file name (the json item-model)
	 */
	public static void registerInventoryItem(Item item, String modid, int meta) {
		registerInventoryItem(item, modid, item.getUnlocalizedName().substring(5), meta);
	}

	/**
	 * registers the inventory model using the given block meta = 0 must be used
	 * in init
	 * 
	 * @param block
	 *            the block using the model
	 * @param modid
	 *            the modid of the block
	 * @param modelname
	 *            the model file name (the json item-model)
	 */
	public static void registerInventoryItem(Block block, String modid, String modelname) {
		registerInventoryItem(block, modid, modelname, 0);
	}

	/**
	 * registers the inventory model using the given item meta = 0 must be used
	 * in init
	 * 
	 * @param item
	 *            the block using the model
	 * @param modid
	 *            the modid of the item
	 * @param modelname
	 *            the model file name (the json item-model)
	 */
	public static void registerInventoryItem(Item item, String modid, String modelname) {
		registerInventoryItem(item, modid, modelname, 0);
	}

	/**
	 * registers the inventory model using the given block must be used in init
	 * 
	 * @param block
	 *            the block using the model
	 * @param modid
	 *            the modid of the block
	 * @param modelname
	 *            the model file name (the json item-model)
	 * @param meta
	 *            the meta of the block
	 */
	public static void registerInventoryItem(Block block, String modid, String modelname, int meta) {
		registerInventoryItem(Item.getItemFromBlock(block), modid, modelname, meta);
	}

	/**
	 * registers the inventory model using the given item must be used in init
	 * 
	 * @param item
	 *            the item using the model
	 * @param modid
	 *            the modid of the item
	 * @param modelname
	 *            the model file name (the json item-model)
	 * @param meta
	 *            the meta of the item
	 */
	@SideOnly(Side.CLIENT)
	public static void registerInventoryItem(Item item, String modid, String modelname, int meta) {
		System.out.println(item.getUnlocalizedName() + "  " + modid + "  " + modelname + "  " + meta);
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, meta, new ModelResourceLocation(modid + ":" + modelname, "inventory"));
	}

	// ---------------------------

	/**
	 * Checks if key is element of array
	 */
	public static <T> boolean contains(final T[] array, final T key) {
		return Arrays.asList(array).contains(key);
	}

}

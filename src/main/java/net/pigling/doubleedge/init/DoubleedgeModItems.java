
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.pigling.doubleedge.init;

import net.pigling.doubleedge.item.CraftingsawItem;
import net.pigling.doubleedge.DoubleedgeMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;

public class DoubleedgeModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, DoubleedgeMod.MODID);
	public static final RegistryObject<Item> SPLITTER = block(DoubleedgeModBlocks.SPLITTER);
	public static final RegistryObject<Item> CRAFTINGSAW = REGISTRY.register("craftingsaw", () -> new CraftingsawItem());
	public static final RegistryObject<Item> NETHER_FURNACE = block(DoubleedgeModBlocks.NETHER_FURNACE);

	// Start of user code block custom items
	// End of user code block custom items
	private static RegistryObject<Item> block(RegistryObject<Block> block) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties()));
	}
}

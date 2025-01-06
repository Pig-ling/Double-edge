
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.pigling.doubleedge.init;

import net.pigling.doubleedge.block.SplitterBlock;
import net.pigling.doubleedge.block.NetherFurnaceBlock;
import net.pigling.doubleedge.DoubleedgeMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;

public class DoubleedgeModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, DoubleedgeMod.MODID);
	public static final RegistryObject<Block> SPLITTER = REGISTRY.register("splitter", () -> new SplitterBlock());
	public static final RegistryObject<Block> NETHER_FURNACE = REGISTRY.register("nether_furnace", () -> new NetherFurnaceBlock());
	// Start of user code block custom blocks
	// End of user code block custom blocks
}

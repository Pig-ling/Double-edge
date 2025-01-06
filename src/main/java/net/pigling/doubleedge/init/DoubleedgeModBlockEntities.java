
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.pigling.doubleedge.init;

import net.pigling.doubleedge.block.entity.NetherFurnaceBlockEntity;
import net.pigling.doubleedge.DoubleedgeMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.Block;

public class DoubleedgeModBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, DoubleedgeMod.MODID);
	public static final RegistryObject<BlockEntityType<?>> NETHER_FURNACE = register("nether_furnace", DoubleedgeModBlocks.NETHER_FURNACE, NetherFurnaceBlockEntity::new);

	private static RegistryObject<BlockEntityType<?>> register(String registryname, RegistryObject<Block> block, BlockEntityType.BlockEntitySupplier<?> supplier) {
		return REGISTRY.register(registryname, () -> BlockEntityType.Builder.of(supplier, block.get()).build(null));
	}
}

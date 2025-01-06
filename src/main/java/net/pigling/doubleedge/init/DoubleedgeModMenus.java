
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.pigling.doubleedge.init;

import net.pigling.doubleedge.world.inventory.SplitterMenuMenu;
import net.pigling.doubleedge.world.inventory.NetherFurnaceMenuMenu;
import net.pigling.doubleedge.DoubleedgeMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.extensions.IForgeMenuType;

import net.minecraft.world.inventory.MenuType;

public class DoubleedgeModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.MENU_TYPES, DoubleedgeMod.MODID);
	public static final RegistryObject<MenuType<SplitterMenuMenu>> SPLITTER_MENU = REGISTRY.register("splitter_menu", () -> IForgeMenuType.create(SplitterMenuMenu::new));
	public static final RegistryObject<MenuType<NetherFurnaceMenuMenu>> NETHER_FURNACE_MENU = REGISTRY.register("nether_furnace_menu", () -> IForgeMenuType.create(NetherFurnaceMenuMenu::new));
}

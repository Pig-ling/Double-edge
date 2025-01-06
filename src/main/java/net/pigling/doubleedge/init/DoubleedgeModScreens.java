
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.pigling.doubleedge.init;

import net.pigling.doubleedge.client.gui.SplitterMenuScreen;
import net.pigling.doubleedge.client.gui.NetherFurnaceMenuScreen;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.gui.screens.MenuScreens;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class DoubleedgeModScreens {
	@SubscribeEvent
	public static void clientLoad(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			MenuScreens.register(DoubleedgeModMenus.SPLITTER_MENU.get(), SplitterMenuScreen::new);
			MenuScreens.register(DoubleedgeModMenus.NETHER_FURNACE_MENU.get(), NetherFurnaceMenuScreen::new);
		});
	}
}

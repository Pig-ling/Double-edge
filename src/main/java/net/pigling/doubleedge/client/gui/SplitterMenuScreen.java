package net.pigling.doubleedge.client.gui;

import net.pigling.doubleedge.world.inventory.SplitterMenuMenu;
import net.pigling.doubleedge.network.SplitterMenuButtonMessage;
import net.pigling.doubleedge.DoubleedgeMod;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Checkbox;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class SplitterMenuScreen extends AbstractContainerScreen<SplitterMenuMenu> {
	private final static HashMap<String, Object> guistate = SplitterMenuMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Checkbox Raw;
	Button button_split_weapon;

	public SplitterMenuScreen(SplitterMenuMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 191;
		this.imageHeight = 166;
	}

	@Override
	public boolean isPauseScreen() {
		return true;
	}

	private static final ResourceLocation texture = new ResourceLocation("doubleedge:textures/screens/splitter_menu.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
		if (mouseX > leftPos + 23 && mouseX < leftPos + 47 && mouseY > topPos + 34 && mouseY < topPos + 58)
			guiGraphics.renderTooltip(font, Component.translatable("gui.doubleedge.splitter_menu.tooltip_in_the_first_spot_place_a_tool"), mouseX, mouseY);
		if (mouseX > leftPos + 59 && mouseX < leftPos + 83 && mouseY > topPos + 34 && mouseY < topPos + 58)
			guiGraphics.renderTooltip(font, Component.translatable("gui.doubleedge.splitter_menu.tooltip_in_the_second_spot_place_an_ende"), mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, Component.translatable("gui.doubleedge.splitter_menu.label_splitter"), 77, 7, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.doubleedge.splitter_menu.label_empty"), 86, 34, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		button_split_weapon = Button.builder(Component.translatable("gui.doubleedge.splitter_menu.button_split_weapon"), e -> {
			if (true) {
				DoubleedgeMod.PACKET_HANDLER.sendToServer(new SplitterMenuButtonMessage(0, x, y, z));
				SplitterMenuButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 50, this.topPos + 61, 87, 20).build();
		guistate.put("button:button_split_weapon", button_split_weapon);
		this.addRenderableWidget(button_split_weapon);
		Raw = new Checkbox(this.leftPos + -76, this.topPos + 169, 20, 20, Component.translatable("gui.doubleedge.splitter_menu.Raw"), false);
		guistate.put("checkbox:Raw", Raw);
		this.addRenderableWidget(Raw);
	}
}

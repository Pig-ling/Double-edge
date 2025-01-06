package net.pigling.doubleedge.client.gui;

import net.pigling.doubleedge.world.inventory.NetherFurnaceMenuMenu;
import net.pigling.doubleedge.network.NetherFurnaceMenuButtonMessage;
import net.pigling.doubleedge.DoubleedgeMod;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.Minecraft;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class NetherFurnaceMenuScreen extends AbstractContainerScreen<NetherFurnaceMenuMenu> {
	private final static HashMap<String, Object> guistate = NetherFurnaceMenuMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	EditBox Tquery;
	ImageButton imagebutton_furnacescreen;

	public NetherFurnaceMenuScreen(NetherFurnaceMenuMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("doubleedge:textures/screens/nether_furnace_menu.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		Tquery.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
		if (mouseX > leftPos + 132 && mouseX < leftPos + 156 && mouseY > topPos + 7 && mouseY < topPos + 31)
			guiGraphics.renderTooltip(font, Component.translatable("gui.doubleedge.nether_furnace_menu.tooltip_you_can_rapidly_press_the_button"), mouseX, mouseY);
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
		if (Tquery.isFocused())
			return Tquery.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
		Tquery.tick();
	}

	@Override
	public void resize(Minecraft minecraft, int width, int height) {
		String TqueryValue = Tquery.getValue();
		super.resize(minecraft, width, height);
		Tquery.setValue(TqueryValue);
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, Component.translatable("gui.doubleedge.nether_furnace_menu.label_nether_furnace"), 51, 7, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		Tquery = new EditBox(this.font, this.leftPos + 34, this.topPos + 62, 118, 18, Component.translatable("gui.doubleedge.nether_furnace_menu.Tquery")) {
			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.doubleedge.nether_furnace_menu.Tquery").getString());
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos) {
				super.moveCursorTo(pos);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.doubleedge.nether_furnace_menu.Tquery").getString());
				else
					setSuggestion(null);
			}
		};
		Tquery.setSuggestion(Component.translatable("gui.doubleedge.nether_furnace_menu.Tquery").getString());
		Tquery.setMaxLength(32767);
		guistate.put("text:Tquery", Tquery);
		this.addWidget(this.Tquery);
		imagebutton_furnacescreen = new ImageButton(this.leftPos + 78, this.topPos + 43, 16, 16, 0, 0, 16, new ResourceLocation("doubleedge:textures/screens/atlas/imagebutton_furnacescreen.png"), 16, 32, e -> {
			if (true) {
				DoubleedgeMod.PACKET_HANDLER.sendToServer(new NetherFurnaceMenuButtonMessage(0, x, y, z));
				NetherFurnaceMenuButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:imagebutton_furnacescreen", imagebutton_furnacescreen);
		this.addRenderableWidget(imagebutton_furnacescreen);
	}
}

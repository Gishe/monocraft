package com.monocly.monocraft.client.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

import org.lwjgl.opengl.GL11;

import com.monocly.monocraft.constants.Strings;
import com.monocly.monocraft.constants.Textures;
import com.monocly.monocraft.inventory.ShadowCraftingContainer;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * monocraft
 * client.gui
 * CraftingGui.java
 * 
 * @author Monocly
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
@SideOnly(Side.CLIENT)
public class EnhancedCraftingGui extends GuiContainer {

    private static boolean isNEIActive;
    private ShadowCraftingContainer shadowCraftingContainer;

    public EnhancedCraftingGui(EntityPlayer player, World world, int x, int y, int z) {
        super(new ShadowCraftingContainer(player.inventory, world, x, y, z));

        shadowCraftingContainer = (ShadowCraftingContainer)inventorySlots;
        //shadowCraftingContainer.craftResult.onInventoryChanged();
    }

    /**
     * Draw the foreground layer for the GuiContainer (everything in front of
     * the items)
     */
    @Override
    protected void drawGuiContainerForegroundLayer(int par1, int par2) {

        fontRenderer.drawString(StatCollector.translateToLocal(Strings.CONTAINER_PORTABLE_CRAFTING), 28, 6, 4210752);
        fontRenderer.drawString(StatCollector.translateToLocal(Strings.CONTAINER_INVENTORY), 8, ySize - 96 + 2, 4210752);

    }

    /**
     * Draw the background layer for the GuiContainer (everything behind the
     * items)
     */
    @Override
    protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3) {

        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(Textures.GUI_PORTABLE_CRAFTING);
        int var5 = (width - xSize) / 2;
        int var6 = (height - ySize) / 2;
        this.drawTexturedModalRect(var5, var6, 0, 0, xSize, ySize);

        if (!shadowCraftingContainer.canPlayerCraft)
        {
            int outputX = var5 + 123, outputY = var6 + 34, slotSize=18;
            this.drawRect(outputX, outputY, outputX + slotSize, outputY + slotSize, -65536);
        }


    }

    @Override
    public void updateScreen()
    {

    }


    @Override
    public void onGuiClosed() {

        super.onGuiClosed();

        if (mc.thePlayer != null) {
            for (ItemStack itemStack : mc.thePlayer.inventory.mainInventory) {
                if (itemStack != null) {
//                    if (GeneralNBTHelper.hasTag(itemStack, Strings.NBT_ITEM_CRAFTING_GUI_OPEN)) {
//                        GeneralNBTHelper.removeTag(itemStack, Strings.NBT_ITEM_CRAFTING_GUI_OPEN);
//                    }
                }
            }
        }
    }

    public static void setIsNEIActive(boolean b) {
        isNEIActive = b;
    }
}

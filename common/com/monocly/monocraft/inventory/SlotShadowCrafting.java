package com.monocly.monocraft.inventory;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.SlotCrafting;
import net.minecraft.item.ItemStack;

/**
 * eclipse
 * com.monocly.monocraft.inventory
 * SlotShadowCrafting
 *
 * @author Monocly
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */

public class SlotShadowCrafting extends SlotCrafting {

    public boolean hasMaterials = true;
    protected IInventory craftMatrix;
    protected EntityPlayer player;

    public SlotShadowCrafting(EntityPlayer player, IInventory craftMatrix, IInventory craftResult, int par4, int par5, int par6) {
        super(player, craftMatrix, craftResult, par4, par5, par6);
        this.craftMatrix = craftMatrix;
        this.player = player;

    }

    @Override
    public boolean isItemValid(ItemStack par1ItemStack)
    {
        return hasMaterials;
    }

    @Override
    public void onPickupFromSlot(EntityPlayer par1EntityPlayer, ItemStack par2ItemStack)
    {
        if (hasMaterials)
        {
            GameRegistry.onItemCrafted(par1EntityPlayer, par2ItemStack, craftMatrix);
            this.onCrafting(par2ItemStack);
            for(int i = 0; i < this.craftMatrix.getSizeInventory(); i++)
            {
                ItemStack is = craftMatrix.getStackInSlot(i);

                if (is != null)
                {
                    player.inventory.consumeInventoryItem(is.itemID);
                }
            }
        }
    }
}

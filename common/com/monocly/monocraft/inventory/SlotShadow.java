package com.monocly.monocraft.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

/**
 * Monocraft
 * com.monocly.monocraft.inventory
 * SlotShadow
 *
 * @author Monocly
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */

public class SlotShadow extends Slot {

    public SlotShadow(IInventory par1IInventory, int par2, int par3, int par4) {
        super(par1IInventory, par2, par3, par4);
    }

    @Override
    public void onPickupFromSlot(EntityPlayer player, ItemStack itemStack)
    {
        super.onPickupFromSlot(player, itemStack);
    }

    @Override
    public ItemStack decrStackSize(int par1)
    {
        return super.decrStackSize(par1);
    }

    @Override
    public void onSlotChange(ItemStack par1ItemStack, ItemStack par2ItemStack)
    {
        super.onSlotChange(par1ItemStack, par2ItemStack);
    }

    @Override
    public void putStack(ItemStack par1ItemStack)
    {
        super.putStack(par1ItemStack);
    }



}

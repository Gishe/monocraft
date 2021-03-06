package com.monocly.monocraft.inventory;


import com.monocly.monocraft.item.PersonalCraftingTable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryCraftResult;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

import java.util.HashMap;


/**
 * monocraft
 * com.monocly.monocraft.inventory
 * ShadowCraftingContainer.java
 *
 * @author Monocly
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class ShadowCraftingContainer extends Container {
    /**
     * The crafting matrix inventory (3x3).
     */
    public InventoryCrafting craftMatrix = new InventoryCrafting(this, 3, 3);
    public IInventory craftResult = new InventoryCraftResult();
    public InventoryPlayer craftersInventory;
    private SlotShadowCrafting slotShadowCrafting;
    private World worldObj;
    private int posX;
    private int posY;
    private int posZ;
    public boolean canPlayerCraft = false;

//    public ShadowCraftingContainer()
//
//    public ShadowCraftingContainer(, InventoryPlayer par1InventoryPlayer, World par2World, int par3, int par4, int par5)
//    {
//
//    }

    public ShadowCraftingContainer(InventoryPlayer par1InventoryPlayer, World par2World, int par3, int par4, int par5) {
        this.worldObj = par2World;
        this.posX = par3;
        this.posY = par4;
        this.posZ = par5;
        craftersInventory = par1InventoryPlayer;
        // Result
        slotShadowCrafting = new SlotShadowCrafting(par1InventoryPlayer.player, this.craftMatrix, this.craftResult, this,  0, 124, 35);
        this.addSlotToContainer(slotShadowCrafting);
        int l;
        int i1;

        // 3x3 crafting grid
        for (l = 0; l < 3; ++l) {
            for (i1 = 0; i1 < 3; ++i1) {
                SlotShadow slotShadow = new SlotShadow(this.craftMatrix, i1 + l * 3, 30 + i1 * 18, 17 + l * 18);

                this.addSlotToContainer(slotShadow);
            }
        }

        // Players inventory
        for (l = 0; l < 3; ++l) {
            for (i1 = 0; i1 < 9; ++i1) {
                this.addSlotToContainer(new Slot(par1InventoryPlayer, i1 + l * 9 + 9, 8 + i1 * 18, 84 + l * 18));
            }
        }

        // Players hotbar
        for (l = 0; l < 9; ++l) {
            this.addSlotToContainer(new Slot(par1InventoryPlayer, l, 8 + l * 18, 142));
        }

        this.onCraftMatrixChanged(this.craftMatrix);
    }

    /**
     * Callback for when the crafting matrix is changed.
     */
    public void onCraftMatrixChanged(IInventory par1IInventory) {
        this.craftResult.setInventorySlotContents(0, CraftingManager.getInstance().findMatchingRecipe(this.craftMatrix, this.worldObj));
        setCanPlayerCraft();
        slotShadowCrafting.hasMaterials = canPlayerCraft;
    }



    public void setCanPlayerCraft() {
        HashMap<Integer, Integer> itemsForRecipe = new HashMap<Integer,Integer>();

        for (int i = 0; i < craftMatrix.getSizeInventory(); i++) {
            ItemStack item = craftMatrix.getStackInSlot(i);
            if (item != null)
            {
                if (itemsForRecipe.containsKey(item.itemID))
                {
                    Integer count = itemsForRecipe.get(item.itemID);
                    count++;
                    itemsForRecipe.put(item.itemID, count);
                }
                else
                {
                    itemsForRecipe.put(item.itemID, 1);
                }
            }
        }
        for (int i =0; i < craftersInventory.getSizeInventory(); i++)
        {
            ItemStack is = craftersInventory.getStackInSlot(i);

            if (is != null)
            {
                updateHashMapBasedOnItemStack(itemsForRecipe, is);
            }
        }
        ItemStack heldItem = craftersInventory.getItemStack();
        if (heldItem != null)
        {
            updateHashMapBasedOnItemStack(itemsForRecipe, heldItem);
        }

        canPlayerCraft = itemsForRecipe.size() == 0;
    }

    private void updateHashMapBasedOnItemStack(HashMap<Integer, Integer> itemsForRecipe, ItemStack is) {
        if (itemsForRecipe.containsKey(is.itemID))
        {
            Integer count = itemsForRecipe.get(is.itemID);
            if (is.stackSize >= count)
            {
                itemsForRecipe.remove(is.itemID);
            }
            else
            {
                count = count - is.stackSize;
            }
        }
    }


    /**
     * Called when the container is closed.
     */
    public void onContainerClosed(EntityPlayer par1EntityPlayer) {
        super.onContainerClosed(par1EntityPlayer);

        if (!this.worldObj.isRemote) {
            ItemStack heldItem = par1EntityPlayer.getHeldItem();
            if (heldItem.stackTagCompound == null)
            {
                heldItem.stackTagCompound = new NBTTagCompound();
            }

            if (heldItem.getItem() instanceof PersonalCraftingTable)
            {
                for (int i = 0; i < 9; ++i) {
                    ItemStack itemstack = this.craftMatrix.getStackInSlotOnClosing(i);

                    if (itemstack != null) {
                        heldItem.stackTagCompound.setInteger("Matrix_" + i, itemstack.itemID);
                    }
                }
            }

        }
    }

    public boolean canInteractWith(EntityPlayer player) {
        return true;
//        ItemStack item = player.getCurrentEquippedItem();
//        if (item != null &&
//                item.itemID == ItemInfo.PERSONAL_CRAFTING_TABLE_ID)
//        {
//            return true;
//        }
//        else
//        {
//            return this.worldObj.getBlockId(this.posX, this.posY, this.posZ) != ModBlocks.ect.blockID ? false : player.getDistanceSq((double)this.posX + 0.5D, (double)this.posY + 0.5D, (double)this.posZ + 0.5D) <= 64.0D;
//        }
    }

    /**
     * Called when a player shift-clicks on a slot. You must override this or you will crash when someone does that.
     */
    public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int par2) {
        ItemStack itemstack = null;
        Slot slot = (Slot) this.inventorySlots.get(par2);

        if (slot != null && slot.getHasStack()) {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            if (par2 == 0) {
                if (!this.mergeItemStack(itemstack1, 10, 46, true)) {
                    return null;
                }

                slot.onSlotChange(itemstack1, itemstack);
            } else if (par2 >= 10 && par2 < 37) {
                if (!this.mergeItemStack(itemstack1, 37, 46, false)) {
                    return null;
                }
            } else if (par2 >= 37 && par2 < 46) {
                if (!this.mergeItemStack(itemstack1, 10, 37, false)) {
                    return null;
                }
            } else if (!this.mergeItemStack(itemstack1, 10, 46, false)) {
                return null;
            }

            if (itemstack1.stackSize == 0) {
                slot.putStack((ItemStack) null);
            } else {
                slot.onSlotChanged();
            }

            if (itemstack1.stackSize == itemstack.stackSize) {
                return null;
            }

            slot.onPickupFromSlot(par1EntityPlayer, itemstack1);
        }

        return itemstack;
    }

    public boolean func_94530_a(ItemStack par1ItemStack, Slot par2Slot) {
        return par2Slot.inventory != this.craftResult && super.func_94530_a(par1ItemStack, par2Slot);
    }

    @Override
    public ItemStack slotClick(int par1, int par2, int par3, EntityPlayer player) {

        Slot s = null;

        if (par1 > 0) {
            s = (Slot) this.inventorySlots.get(par1);
        }

        if (s != null && s instanceof SlotShadow) {
            SlotShadow slotShadow = (SlotShadow) s;
            ItemStack currentItem = player.inventory.getItemStack();
            if (currentItem != null) {
                slotShadow.putStack(new ItemStack(currentItem.getItem(), 1));
            } else {
                slotShadow.putStack(null);
            }
            return currentItem;
        } else {
            return super.slotClick(par1, par2, par3, player);
        }
    }

}

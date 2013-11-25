package com.monocly.monocraft.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.ContainerWorkbench;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

/**
 * monocraft
 * inventory
 * ContainerPortableCrafting.java
 * 
 * @author Monocly
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class ContainerPortableCrafting extends ContainerWorkbench {

    public ContainerPortableCrafting(InventoryPlayer inventoryPlayer, World world, int x, int y, int z) {

        super(inventoryPlayer, world, x, y, z);
    }

    @Override
    public boolean canInteractWith(EntityPlayer var1) {

        return true;
    }

    @Override
    public void onContainerClosed(EntityPlayer player) {

        super.onContainerClosed(player);

        if (!player.worldObj.isRemote) {
            InventoryPlayer invPlayer = player.inventory;
            for (ItemStack itemStack : invPlayer.mainInventory) {
                if (itemStack != null) {
//                    if (GeneralNBTHelper.hasTag(itemStack, Strings.NBT_ITEM_CRAFTING_GUI_OPEN)) {
//                        GeneralNBTHelper.removeTag(itemStack, Strings.NBT_ITEM_CRAFTING_GUI_OPEN);
//                    }
                }
            }
        }
    }

}

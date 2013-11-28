package com.monocly.monocraft.item;


import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.network.packet.Packet100OpenWindow;
import net.minecraft.world.World;

import com.monocly.monocraft.Monocraft;
import com.monocly.monocraft.constants.GuiIds;
import com.monocly.monocraft.constants.Strings;

import cpw.mods.fml.common.registry.LanguageRegistry;

/**
 * monocraft
 * com.monocly.monocraft.item
 * PersonalCraftingTable.java
 * 
 * @author Monocly
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class PersonalCraftingTable extends MonocraftItem
{
    /**
     * @param ID
     */
    public PersonalCraftingTable(int ID)
    {
        super(ID);
        // TODO Auto-generated constructor stub
    }

       
    /* (non-Javadoc)
     * @see com.monocly.monocraft.item.BaseItem#getULName()
     */
    @Override
    public String getULName()
    {
        return Strings.PERSONAL_CRAFTING_TABLE;
    }

    /* (non-Javadoc)
     * @see com.monocly.monocraft.item.BaseItem#registerNames()
     */
    @Override
    public void registerNames()
    {
        LanguageRegistry.addName(this, Strings.PERSONAL_CRAFTING_TABLE_NAME);
    }
    
    @Override
    public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ)
    {
        if (!player.isSneaking())
        {
            player.openGui(Monocraft.instance, 0, world, x, y, z);
            return true;
        }
        return false;
//        if (!world.isRemote && !player.isSneaking())
//        {
//            EntityPlayerMP playerMP = (EntityPlayerMP) player;
//            playerMP.incrementWindowID();
//            playerMP.playerNetServerHandler.sendPacketToPlayer(new Packet100OpenWindow(playerMP.currentWindowId, 1, "Crafting", 9, true));
//            playerMP.openContainer = new ContainerPortableCrafting(player.inventory, player.worldObj, x, y ,z);
//            playerMP.openContainer.windowId = playerMP.currentWindowId;
//            playerMP.openContainer.addCraftingToCrafters(playerMP);
//
//            player.openGui(Monocraft.instance, GuiIds.PORTABLE_CRAFTING, world, x, y, z);
//            return true;
//        }else
//        {
//            return false;
//        }
    }
        

}

package com.monocly.monocraft.core.proxy;

import com.monocly.monocraft.inventory.ShadowCraftingContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

import com.monocly.monocraft.client.gui.EnhancedCraftingGui;
import com.monocly.monocraft.constants.GuiIds;

import cpw.mods.fml.common.network.IGuiHandler;

/**
 * monocraft
 * core.proxy
 * CommonProxy.java
 * 
 * @author Monocly
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class CommonProxy implements IGuiHandler
{

    /* (non-Javadoc)
     * @see cpw.mods.fml.common.network.IGuiHandler#getServerGuiElement(int, net.minecraft.entity.player.EntityPlayer, net.minecraft.world.World, int, int, int)
     */
    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world,
            int x, int y, int z)
    {
        switch(ID)
        {
            case 0:
                return new ShadowCraftingContainer(player.inventory, world, x, y, z);
        }
                    
        return null;
    }

    /* (non-Javadoc)
     * @see cpw.mods.fml.common.network.IGuiHandler#getClientGuiElement(int, net.minecraft.entity.player.EntityPlayer, net.minecraft.world.World, int, int, int)
     */
    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world,
            int x, int y, int z)
    {
        switch(ID)
        {
            case GuiIds.PORTABLE_CRAFTING:
                return new EnhancedCraftingGui(player, world, x, y, z);
            default:
                return null;
        }
        
    }

}

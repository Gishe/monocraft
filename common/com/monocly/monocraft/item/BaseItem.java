package com.monocly.monocraft.item;

import java.util.logging.Level;

import com.monocly.monocraft.Reference;
import com.monocly.monocraft.constants.Strings;

import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;


/**
 * monocraft
 * com.monocly.monocraft.item
 * BaseItem.java
 * 
 * @author Monocly
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public abstract class BaseItem extends Item
{

      
    /*
     *  Gets the Unlocalized name of the item
     * @return
     */
    public abstract String getULName();
    // Gets the Icon
    //public abstract String getIcon();
    
    /*
     *  Gets the creative tab
     */
    public abstract CreativeTabs getCreativeTab();
    
    //public abstract String getTextureLocation();
    /*
     *  Registers the EN Names
     */
    public abstract void registerNames();
    /* 
     * Registers the recipes for the crafting
     */
    public void registerRecipes() {};    
    
    /*
     * @param par1
     */
    public BaseItem(int ID)
    {
        super(ID);
        setCreativeTab(getCreativeTab());
        setUnlocalizedName(Strings.RESOURCE_PREFIX + getULName());
    }
       
    /*
     *  Registers the icons based on the unlocalized name
     */
    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister iconRegister) {
        
        String val = this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1);
        itemIcon = iconRegister.registerIcon(val);
    }

}

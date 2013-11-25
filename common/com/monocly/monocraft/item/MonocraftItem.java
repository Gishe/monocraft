package com.monocly.monocraft.item;

import com.monocly.monocraft.Monocraft;

import net.minecraft.creativetab.CreativeTabs;

/**
 * monocraft
 * com.monocly.monocraft.item
 * MonocraftItem.java
 * 
 * @author Monocly
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public abstract class MonocraftItem extends BaseItem
{

    /**
     * @param ID
     */
    public MonocraftItem(int ID)
    {
        super(ID);
        // TODO Auto-generated constructor stub
    }

    /* (non-Javadoc)
     * @see com.monocly.monocraft.item.BaseItem#getCreativeTab()
     */
    @Override
    public CreativeTabs getCreativeTab()
    {
        // TODO Auto-generated method stub
        return Monocraft.creativeTab;
    }
   

}

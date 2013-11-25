package com.monocly.monocraft.config;

import java.io.File;
import java.util.logging.Level;

import net.minecraftforge.common.Configuration;

import com.monocly.monocraft.Reference;
import com.monocly.monocraft.item.ItemInfo;
import com.monocly.monocraft.item.PersonalCraftingTable;

import cpw.mods.fml.common.FMLLog;

/**
 * monocraft
 * com.monocly.monocraft.config
 * ItemConfiguration.java
 * 
 * @author Monocly
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class ItemConfiguration
{
    private static Configuration itemConfiguration; 
    /**
     * @param file
     */
    public static void init(File file)
    {
     // TODO Auto-generated method stub
        itemConfiguration = new Configuration(file);
        
        try 
        {
            itemConfiguration.load();
            
            /* Item configs */
            ItemInfo.PERSONAL_CRAFTING_TABLE_ID = itemConfiguration.getItem(ItemInfo.PERSONAL_CRAFTING_TABLE_KEY, ItemInfo.PERSONAL_CRAFTING_TABLE_DEFAULT).getInt();
        }
        catch (Exception e) 
        {
            FMLLog.log(Level.SEVERE, e, Reference.MOD_NAME + " has had a problem loading its item configuration");
        }
        finally 
        {
            itemConfiguration.save();
        }
        
    }

}

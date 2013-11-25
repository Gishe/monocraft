package com.monocly.monocraft.config;

import java.io.File;
import java.util.logging.Level;

import net.minecraftforge.common.Configuration;

import com.monocly.monocraft.Reference;

import cpw.mods.fml.common.FMLLog;

/**
 * monocraft
 * com.monocly.monocraft.config
 * GeneralConfiguration.java
 * 
 * @author Monocly
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class GeneralConfiguration
{
    private static Configuration generalConfiguration;
    /**
     * @param file
     */
    public static void init(File file)
    {
        // TODO Auto-generated method stub
        generalConfiguration = new Configuration(file);
        
        try 
        {
            generalConfiguration.load();
            
            /* Item configs */
            //ItemIds.MINIUM_SHARD = blockConfiguration.getItem(Strings.MINIUM_SHARD_NAME, ItemIds.MINIUM_SHARD_DEFAULT).getInt(ItemIds.MINIUM_SHARD_DEFAULT);
        }
        catch (Exception e) 
        {
            FMLLog.log(Level.SEVERE, e, Reference.MOD_NAME + " has had a problem loading its item configuration");
        }
        finally 
        {
            generalConfiguration.save();
        }
        
    }
}

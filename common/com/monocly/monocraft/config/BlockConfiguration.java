package com.monocly.monocraft.config;

import java.io.File;
import java.util.logging.Level;

import net.minecraftforge.common.Configuration;

import com.monocly.monocraft.Reference;
import com.monocly.monocraft.block.BlockInfo;

import cpw.mods.fml.common.FMLLog;

/**
 * monocraft
 * com.monocly.monocraft.config
 * BlockConfiguration.java
 * 
 * @author Monocly
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class BlockConfiguration
{
    private static Configuration blockConfiguration;
    /**
     * @param file
     */
    public static void init(File file)
    {
        // TODO Auto-generated method stub
        blockConfiguration = new Configuration(file);
        
        try 
        {
            blockConfiguration.load();
            
            /* Block configs */
            BlockInfo.ECT_ID = blockConfiguration.getBlock(BlockInfo.ECT_KEY, BlockInfo.ECT_DEFAULT).getInt();
        }
        catch (Exception e) 
        {
            FMLLog.log(Level.SEVERE, e, Reference.MOD_NAME + " has had a problem loading its item configuration");
        }
        finally 
        {
            blockConfiguration.save();
        }
        
    }
  
}

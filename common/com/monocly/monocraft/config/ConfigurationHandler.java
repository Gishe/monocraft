package com.monocly.monocraft.config;

import java.io.File;

import net.minecraftforge.common.Configuration;

/**
 * monocraft
 * com.monocly.monocraft.config
 * ConfigurationHandler.java
 * 
 * @author Monocly
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class ConfigurationHandler
{
    public static Configuration configuration;
    public static void init(String configPath) {

        //GeneralConfiguration.init(new File(configPath + "general.properties"));
        BlockConfiguration.init(new File(configPath + "block.properties"));
        ItemConfiguration.init(new File(configPath + "item.properties"));
        
    }
}

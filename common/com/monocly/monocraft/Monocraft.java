package com.monocly.monocraft;

import java.io.File;

import net.minecraft.creativetab.CreativeTabs;

import com.monocly.monocraft.block.ModBlocks;
import com.monocly.monocraft.config.ConfigurationHandler;
import com.monocly.monocraft.core.proxy.CommonProxy;
import com.monocly.monocraft.creativetab.CreativeTabMonocraft;
import com.monocly.monocraft.item.ModItems;
import com.monocly.monocraft.network.PacketHandler;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;


/**
 * monocraft
 * com.monocly.monocraft
 * Monocraft.java
 * 
 * @author Monocly
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION_NUMBER, dependencies = Reference.DEPENDENCIES)
@NetworkMod(channels = { Reference.CHANNEL_NAME }, clientSideRequired = true, serverSideRequired = false, packetHandler = PacketHandler.class)
public class Monocraft
{
    // singleton of mod
    @Instance(Reference.MOD_ID)
    public static Monocraft instance;
    
    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
    public static CommonProxy proxy;
    
    // Creative tab
    public static CreativeTabs creativeTab = new CreativeTabMonocraft(CreativeTabs.getNextID(), Reference.MOD_ID);
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
    
        ConfigurationHandler.init(event.getModConfigurationDirectory().getAbsolutePath() + File.separator + Reference.CHANNEL_NAME.toLowerCase() + File.separator);
        
        // Initialize mod blocks
        ModBlocks.init();

        // Initialize mod items
        ModItems.init();
    }
    
    @EventHandler
    public void load(FMLInitializationEvent event) {
        
        // Register the GUI Handler
        NetworkRegistry.instance().registerGuiHandler(instance, proxy);
        
        ModItems.addNames();
        ModBlocks.addNames();
        
      
        ModItems.registerRecipes();
        ModBlocks.registerRecipes();
        
        ModBlocks.registerTileEntities();
        //Entities.init();
    }
    
    @EventHandler
    public void modsLoaded(FMLPostInitializationEvent event) {
    
    }
    
}

package com.monocly.monocraft.block;


import net.minecraft.block.Block;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

/**
 * monocraft
 * com.monocly.monocraft.block
 * ModBlocks.java
 * 
 * @author Monocly
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class ModBlocks
{
    public static Block ect;
    public static void init()
    {
        ect = new EnhancedCraftingTable(BlockInfo.ECT_ID);
        GameRegistry.registerBlock(ect, BlockInfo.ECT_KEY);
        
        
    }
    
    public static void addNames()
    {
        LanguageRegistry.addName(ect, BlockInfo.ECT_NAME);
        //LanguageRegistry.addName(counting, BlockInfo.COUNTING_NAME);
    }
    
    public static void registerTileEntities()
    {
//        GameRegistry.registerTileEntity(TileEntityBomb.class, BlockInfo.BOMB_TE_KEY);
  //      GameRegistry.registerTileEntity(TileEntityCounting.class, BlockInfo.COUNTING_TE_KEY); 
    }

    /**
     * 
     */
    public static void registerRecipes()
    {
        // TODO Auto-generated method stub
        
    }
   

}

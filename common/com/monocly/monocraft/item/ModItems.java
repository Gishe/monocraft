package com.monocly.monocraft.item;

/**
 * monocraft
 * com.monocly.monocraft.item
 * ModItems.java
 * 
 * @author Monocly
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class ModItems
{

    private static BaseItem[] baseItems;
    /**
     * 
     */
    public static void init()
    {
        baseItems = new BaseItem[]
                {
                   new PersonalCraftingTable(ItemInfo.PERSONAL_CRAFTING_TABLE_ID),
                   new PhantomIngot(ItemInfo.PHANTOM_INGOT_ID)
                };
        
    }
    
    public static void addNames()
    {
        for(int i = 0; i < baseItems.length; i++)
        {
            baseItems[i].registerNames();
        }
    }
    
    public static void registerRecipes()
    {
        for(int i = 0; i < baseItems.length; i++)
        {
            baseItems[i].registerRecipes();
        }
    }

}

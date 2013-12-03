package com.monocly.monocraft.item;

import com.monocly.monocraft.constants.Strings;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.item.Item;

/**
 * monocraft
 * com.monocly.monocraft.item
 * PersonalCraftingTable.java
 *
 * @author Monocly
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class PhantomIngot extends MonocraftItem
{
    @Override
    public String getULName() {
        return ItemInfo.PHANTOM_INGOT_UNLOCALIZED_NAME;
    }

    @Override
    public void registerNames() {
        LanguageRegistry.addName(this, ItemInfo.PHANTOM_INGOT_NAME);
    }

    public PhantomIngot(int par1)
    {
        super(par1);
    }
}

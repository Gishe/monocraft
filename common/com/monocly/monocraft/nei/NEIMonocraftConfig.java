package com.monocly.monocraft.nei;

import codechicken.nei.api.API;
import codechicken.nei.api.IConfigureNEI;
import codechicken.nei.recipe.DefaultOverlayHandler;
import com.monocly.monocraft.client.gui.EnhancedCraftingGui;

/**
 * Monocraft
 * com.monocly.monocraft.nei
 * NEIMonocraftConfig.java
 *
 * @author Monocly
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */

public class NEIMonocraftConfig implements IConfigureNEI {
    @Override
    public void loadConfig() {
        API.registerGuiOverlay(EnhancedCraftingGui.class, "crafting", 5, 11);
        API.registerGuiOverlayHandler(EnhancedCraftingGui.class, new DefaultOverlayHandler(5,11), "crafting");
        //If NEI is active, we need to change the method called in the ProjectBenchGui!
        EnhancedCraftingGui.setIsNEIActive(true);
    }

    @Override
    public String getName() {
        return "Monocraft plugin";
    }

    @Override
    public String getVersion() {
        return "0.1";
    }
}

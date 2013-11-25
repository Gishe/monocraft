package com.monocly.monocraft;

/**
 * monocraft
 * com.monocly.monocraft
 * Reference.java
 * 
 * @author Monocly
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */

public class Reference
{
    /* Debug Mode On-Off */
    public static final boolean DEBUG_MODE = false;

    /* General Mod related constants */
    public static final String MOD_ID = "Monocraft";
    public static final String MOD_NAME = "Monocraft";
    public static final String VERSION_NUMBER = "@VERSION@ (build @BUILD_NUMBER@)";
    public static final String CHANNEL_NAME = MOD_ID;
    public static final String DEPENDENCIES = "required-after:Forge@[9.10.1.849,)";
    public static final int SECOND_IN_TICKS = 20;
    public static final int SHIFTED_ID_RANGE_CORRECTION = 256;
    public static final String SERVER_PROXY_CLASS = "com.monocly.monocraft.core.proxy.CommonProxy";
    public static final String CLIENT_PROXY_CLASS = "com.monocly.monocraft.core.proxy.ClientProxy";
    public static final int VERSION_CHECK_ATTEMPTS = 3;

    public static final int ORE_DICTIONARY_NOT_FOUND = -1;
}

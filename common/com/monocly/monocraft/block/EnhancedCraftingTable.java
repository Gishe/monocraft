package com.monocly.monocraft.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

import com.monocly.monocraft.Monocraft;
import com.monocly.monocraft.constants.Strings;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * monocraft
 * com.monocly.monocraft.block
 * EnhancedCraftingTable.java
 * 
 * @author Monocly
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class EnhancedCraftingTable extends Block
{

    /**
     * @param par1
     * @param par2Material
     */
    public EnhancedCraftingTable(int par1)
    {   
        super(par1, Material.wood);
        setCreativeTab(Monocraft.creativeTab);
        setUnlocalizedName(Strings.RESOURCE_PREFIX + BlockInfo.ECT_UNLOCALIZED_NAME);
        // TODO Auto-generated constructor stub
    }
    
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister register)
    {
        //blockIcon = register.registerIcon(BlockInfo.TEXTURE_LOCATION + ":" + BlockInfo.ECT_TEXTURE);
        String val = this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1);
        blockIcon = register.registerIcon(val);
    }
    
    public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
    {
        if (!par5EntityPlayer.isSneaking())
        {
            par5EntityPlayer.openGui(Monocraft.instance, 0, par1World, par2, par3, par4);
            return true;
        }else
        {
            return false;
        }
        
//        if (!par1World.isRemote)
//        {
//            return true;
//        }
//        else
//        {
//            par5EntityPlayer.displayGUIWorkbench(par2, par3, par4);
//            return true;
//        }
    }

}

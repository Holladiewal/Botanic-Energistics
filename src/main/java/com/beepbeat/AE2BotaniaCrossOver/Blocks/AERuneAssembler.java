package com.beepbeat.AE2BotaniaCrossOver.Blocks;

import appeng.api.AEApi;
import appeng.api.networking.IGridNode;
import appeng.block.AEBaseBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;


public class AERuneAssembler extends Block {

    public AERuneAssembler() {
        super(Material.iron);
        setBlockName("AE Rune Assembler");
        setCreativeTab(CreativeTabs.tabMisc);
    }

    @Override
    public TileEntity createTileEntity(World world, int metadata) {
        return new TileAERuneAssembler();
    }



    @Override
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack stack) {
        if (world.isRemote) {
            return;
        }
        TileEntity tile = world.getTileEntity(x, y, z);
        if (tile != null && tile instanceof TileAERuneAssembler) {
            TileAERuneAssembler tileC = (TileAERuneAssembler) tile;
            tileC.getProxy().onReady();
            IGridNode node = tileC.getGridNode(ForgeDirection.UNKNOWN);
            if (entity != null && entity instanceof EntityPlayer) {
                EntityPlayer player = (EntityPlayer) entity;
                node.setPlayerID(AEApi.instance().registries().players().getID(player));
            }
            node.updateState();
        }
    }

    @Override
    public void onBlockPreDestroy(World world, int x, int y, int z, int meta) {
        if (world.isRemote)
            return;
        TileEntity tile = world.getTileEntity(x, y, z);
        if (tile != null) {
            if (tile instanceof TileAERuneAssembler) {
                IGridNode node = ((TileAERuneAssembler) tile).getGridNode(ForgeDirection.UNKNOWN);
                if (node != null) {
                    node.destroy();
                }
            }
        }
    }

}

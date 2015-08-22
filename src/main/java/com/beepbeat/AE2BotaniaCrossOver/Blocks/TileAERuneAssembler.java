package com.beepbeat.AE2BotaniaCrossOver.Blocks;

import appeng.api.networking.crafting.ICraftingMedium;
import appeng.api.networking.crafting.ICraftingPatternDetails;
import appeng.api.networking.crafting.ICraftingProviderHelper;
import appeng.api.storage.data.IAEItemStack;
import appeng.tile.grid.AENetworkTile;
import vazkii.botania.api.BotaniaAPI;

import java.util.List;


public class TileAERuneAssembler extends AENetworkTile implements ICraftingProviderHelper {
    List RuneAltarRecipes = BotaniaAPI.runeAltarRecipes;


    public TileAERuneAssembler() {
        setName("runeassembler");
    }

    @Override
    public void addCraftingOption(ICraftingMedium iCraftingMedium, ICraftingPatternDetails iCraftingPatternDetails) {

    }

    @Override
    public void setEmitable(IAEItemStack iaeItemStack) {

    }
}

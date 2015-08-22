package com.beepbeat.AE2BotaniaCrossOver;

import com.beepbeat.AE2BotaniaCrossOver.Blocks.AERuneAssembler;
import com.beepbeat.AE2BotaniaCrossOver.Blocks.TileAERuneAssembler;
import com.beepbeat.AE2BotaniaCrossOver.Items.RuneAssemblerCraftingPattern;
import com.beepbeat.AE2BotaniaCrossOver.References.Reference;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

/**
 * Created by beebeat on 21.08.2015.
 */


@Mod(modid = Reference.MODID, name = Reference.MODNAME, version = "1.0")
public class AE2BotaniaCrossOver {

    @Mod.EventHandler
    public void onPreInit(FMLPreInitializationEvent event){
        GameRegistry.registerItem(new RuneAssemblerCraftingPattern(), "RuneAssemblerPattern", Reference.MODID);
        GameRegistry.registerTileEntity(TileAERuneAssembler.class, "tile.runeassembler");
        GameRegistry.registerBlock(new AERuneAssembler(), "AERuneAssembler");
    }
}

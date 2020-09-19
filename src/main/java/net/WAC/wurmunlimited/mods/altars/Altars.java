package net.WAC.wurmunlimited.mods.altars;

import org.gotti.wurmunlimited.modloader.interfaces.Configurable;
import org.gotti.wurmunlimited.modloader.interfaces.ItemTemplatesCreatedListener;
import org.gotti.wurmunlimited.modloader.interfaces.WurmServerMod;

import java.io.IOException;
import java.util.Properties;

public class Altars implements WurmServerMod, Configurable, ItemTemplatesCreatedListener {

    public String getVersion() {
        return "v3.0";
    }

    @Override
    public void configure(Properties properties) {
        AltarItems.marbleAltarSizeMultiplier = Float.parseFloat(properties.getProperty("Huge_Marble_Altar_Size_Multiplier", String.valueOf(AltarItems.marbleAltarSizeMultiplier)));
        AltarItems.sacrificialAltarSizeMultiplier = Float.parseFloat(properties.getProperty("Sacrificial_Altar_Size_Multiplier", String.valueOf(AltarItems.sacrificialAltarSizeMultiplier)));
    }

    @Override
    public void onItemTemplatesCreated() {
        try {
            AltarItems.registerItems();
            AltarItems.initCreationEntry();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

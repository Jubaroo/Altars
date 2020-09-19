package net.WAC.wurmunlimited.mods.altars;

import com.wurmonline.server.items.ItemList;
import com.wurmonline.server.items.ItemTemplate;
import org.gotti.wurmunlimited.modloader.interfaces.Configurable;
import org.gotti.wurmunlimited.modloader.interfaces.ItemTemplatesCreatedListener;
import org.gotti.wurmunlimited.modloader.interfaces.WurmServerMod;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Altars implements WurmServerMod, Configurable, ItemTemplatesCreatedListener {

    public static final Logger logger = Logger.getLogger(Altars.class.getName());

    public String getVersion() {
        return "v2.0";
    }

    @Override
    public void configure(Properties properties) {
        AltarItems.hugeMarbleAltarTemplateId = Integer.parseInt(properties.getProperty("Huge_Marble_Altar_templateId", String.valueOf(AltarItems.hugeMarbleAltarTemplateId)));
        AltarItems.marbleAltarSizeMultiplier = Float.parseFloat(properties.getProperty("Huge_Marble_Altar_Size_Multiplier", String.valueOf(AltarItems.marbleAltarSizeMultiplier)));
        AltarItems.sacrificialAltarTemplateId = Integer.parseInt(properties.getProperty("Sacrificial_Altar_templateId", String.valueOf(AltarItems.sacrificialAltarTemplateId)));
        AltarItems.sacrificialAltarSizeMultiplier = Float.parseFloat(properties.getProperty("Sacrificial_Altar_Size_Multiplier", String.valueOf(AltarItems.sacrificialAltarSizeMultiplier)));
    }

    @Override
    public void onItemTemplatesCreated() {
        new AltarItems();
        decorationItem(ItemList.temple, false);
    }

    public static Method _getItemTemplate = TweakApiPerms.getClassMeth(
            "com.wurmonline.server.items.CreationWindowMethods",
            "getItemTemplate",
            "int");

    public static ItemTemplate getItemTemplate(int id) {
        if (_getItemTemplate == null) {
            return null;
        }
        try {
            return (ItemTemplate) _getItemTemplate.invoke(null, id);
        } catch (InvocationTargetException | IllegalAccessException e) {
            logger.log(Level.SEVERE, "getItemTemplate: " + e.toString());
            return null;
        }
    }

    public static boolean decorationItem(int tempid, boolean b) {
        if (_getItemTemplate == null) {
            return true;
        }
        ItemTemplate tplat = getItemTemplate(tempid);
        if (tplat == null) {
            return true;
        }
        return TweakApiPerms.setItemField(tplat, "decoration", b);
    }

}

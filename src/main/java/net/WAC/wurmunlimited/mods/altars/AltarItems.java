package net.WAC.wurmunlimited.mods.altars;

import com.wurmonline.server.MiscConstants;
import com.wurmonline.server.TimeConstants;
import com.wurmonline.server.behaviours.BehaviourList;
import com.wurmonline.server.items.*;
import com.wurmonline.server.skills.SkillList;
import com.wurmonline.shared.constants.IconConstants;
import com.wurmonline.shared.constants.ItemMaterials;
import org.gotti.wurmunlimited.modloader.interfaces.WurmServerMod;
import org.gotti.wurmunlimited.modsupport.ItemTemplateBuilder;

import java.io.IOException;

public class AltarItems implements WurmServerMod, ItemTypes, MiscConstants {

    public static float marbleAltarSizeMultiplier = 1f;
    public static float sacrificialAltarSizeMultiplier = 1f;
    public static int HUGE_MARBLE_ALTAR_ID, SACRIFICIAL_ALTAR;

    public static void registerItems() throws IOException {
        registerHugeAltar();
        registerSacrificialAltar();
    }

    public static void registerHugeAltar() throws IOException {
        ItemTemplate temp = new ItemTemplateBuilder("WAC.structure.altar.marble")
                .name("Altar", "Altars", "A huge marble altar with beautiful hand carved designs all around it.")
                .descriptions("almost full", "somewhat occupied", "half-full", "emptyish")
                .modelName("model.decoration.altar.huge.marble.")
                .imageNumber((short) IconConstants.ICON_NONE)
                .weightGrams(460000)
                .value(5000)
                .size(ItemSizes.ITEM_SIZE_HUGE)
                .difficulty(50.0F)
                .dimensions(1000, 1000, 1000)
                .decayTime(TimeConstants.DECAYTIME_STONE)
                .material(ItemMaterials.MATERIAL_MARBLE)
                .behaviourType(BehaviourList.domainItemBehaviour)
                .itemTypes(new short[]{
                        ITEM_TYPE_NAMED,
                        ITEM_TYPE_HOLLOW,
                        ITEM_TYPE_NOTAKE,
                        ITEM_TYPE_STONE,
                        ITEM_TYPE_TURNABLE,
                        ITEM_TYPE_DECORATION,
                        ITEM_TYPE_REPAIRABLE,
                        ITEM_TYPE_HASDATA,
                        ITEM_TYPE_DOMAIN,
                        ITEM_TYPE_USE_GROUND_ONLY,
                        ITEM_TYPE_OWNER_DESTROYABLE,
                        ITEM_TYPE_HOLLOW_VIEWABLE
                })
                .containerSize((int) (500 * marbleAltarSizeMultiplier), (int) (500 * marbleAltarSizeMultiplier), (int) (500 * marbleAltarSizeMultiplier))
                .build();

        HUGE_MARBLE_ALTAR_ID = temp.getTemplateId();
    }

    public static void registerSacrificialAltar() throws IOException {
        ItemTemplate temp = new ItemTemplateBuilder("WAC.structure.altar.sacrificial")
                .name("Sacrificial Altar", "Sacrificial Altar", "A stone altar with foreign markings and dark energy. It is mainly used by cultists for rituals and sacrificing.")
                .descriptions("almost full", "somewhat occupied", "half-full", "emptyish")
                .modelName("model.decoration.altar.sacrificial.")
                .imageNumber((short) IconConstants.ICON_NONE)
                .weightGrams(290000)
                .value(3000)
                .difficulty(35.0F)
                .dimensions(1000, 1000, 1000)
                .decayTime(TimeConstants.DECAYTIME_STONE)
                .material(ItemMaterials.MATERIAL_STONE)
                .behaviourType(BehaviourList.domainItemBehaviour)
                .itemTypes(new short[]{
                        ITEM_TYPE_NAMED,
                        ITEM_TYPE_HOLLOW,
                        ITEM_TYPE_NOTAKE,
                        ITEM_TYPE_STONE,
                        ITEM_TYPE_TURNABLE,
                        ITEM_TYPE_DECORATION,
                        ITEM_TYPE_REPAIRABLE,
                        ITEM_TYPE_HASDATA,
                        ITEM_TYPE_DOMAIN,
                        ITEM_TYPE_USE_GROUND_ONLY,
                        ITEM_TYPE_OWNER_DESTROYABLE,
                        ITEM_TYPE_HOLLOW_VIEWABLE
                })
                .containerSize((int) (250 * sacrificialAltarSizeMultiplier), (int) (250 * sacrificialAltarSizeMultiplier), (int) (250 * sacrificialAltarSizeMultiplier))
                .build();

        SACRIFICIAL_ALTAR = temp.getTemplateId();
    }

    public static void initCreationEntry() {
        final AdvancedCreationEntry altarHuge = CreationEntryCreator.createAdvancedEntry(SkillList.MASONRY, ItemList.marbleSlab, ItemList.marbleBrick, HUGE_MARBLE_ALTAR_ID, false, false, 0.0f, true, true, CreationCategories.ALTAR);
        altarHuge.addRequirement(new CreationRequirement(1, ItemList.marbleSlab, 5, true));
        altarHuge.addRequirement(new CreationRequirement(2, ItemList.marbleBrick, 19, true));
        altarHuge.addRequirement(new CreationRequirement(3, ItemList.mortar, 10, true));
        altarHuge.addRequirement(new CreationRequirement(4, ItemList.woad, 5, true));
        altarHuge.addRequirement(new CreationRequirement(5, ItemList.cochineal, 5, true));
        altarHuge.addRequirement(new CreationRequirement(6, ItemList.plank, 4, true));
        altarHuge.addRequirement(new CreationRequirement(7, ItemList.sandstoneBrick, 10, true));
        final AdvancedCreationEntry altarSacrificial = CreationEntryCreator.createAdvancedEntry(SkillList.MASONRY, ItemList.stoneSlab, ItemList.stoneBrick, SACRIFICIAL_ALTAR, false, false, 0.0f, true, true, CreationCategories.ALTAR);
        altarSacrificial.addRequirement(new CreationRequirement(1, ItemList.stoneSlab, 4, true));
        altarSacrificial.addRequirement(new CreationRequirement(2, ItemList.stoneBrick, 9, true));
        altarSacrificial.addRequirement(new CreationRequirement(3, ItemList.mortar, 6, true));
        altarSacrificial.addRequirement(new CreationRequirement(4, ItemList.cochineal, 15, true));
        altarSacrificial.addRequirement(new CreationRequirement(5, ItemList.ironBar, 10, true));
    }

}

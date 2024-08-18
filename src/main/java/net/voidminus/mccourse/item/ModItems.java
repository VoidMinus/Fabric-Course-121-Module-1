package net.voidminus.mccourse.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.voidminus.mccourse.MCCourseMod;
import net.voidminus.mccourse.item.custom.ChainsawItem;

public class ModItems {
    public static final Item FLUORITE = registerItem("fluorite",
            new Item(new Item.Settings()));

    public static final Item RAW_FLUORITE = registerItem("raw_fluorite",
            new Item(new Item.Settings()));

    public static final Item CHAINSAW = registerItem("chainsaw",
            new ChainsawItem(new Item.Settings().maxDamage(32)));

    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, Identifier.of(MCCourseMod.MOD_ID, name), item);
    }

    private static void customIngredients(FabricItemGroupEntries entries){
        entries.add(FLUORITE);
        entries.add(RAW_FLUORITE);
    }
    public static void registerModItems(){
        MCCourseMod.LOGGER.info("Registering Mod Items for " + MCCourseMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::customIngredients);

    }
}

package net.awaronoob.testing.item;

import net.awaronoob.testing.TestMod;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item COSMIC_REALITY_CRYSTAL = registerItem("cosmic_reality_crystal", new Item(new Item.Settings()));
    public static final Item DEFAULT_ITEM = registerItem("default_item", new Item(new Item.Settings()));


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(TestMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        TestMod.LOGGER.info("Registering Mod Items for " + TestMod.MOD_ID);

        //Adds items to ingredients creative menu tab (ItemGroups.INGREDIENTS)
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(COSMIC_REALITY_CRYSTAL);
        });

        //Adds items to operator creative menu tab (ItemGroups.OPERATOR)
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.OPERATOR).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(DEFAULT_ITEM);
        });
    }
}

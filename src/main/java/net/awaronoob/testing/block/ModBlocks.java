package net.awaronoob.testing.block;

import net.awaronoob.testing.TestMod;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.MapColor;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;


public class ModBlocks {
    private static final String MID = TestMod.MOD_ID;

    public static final Block REALITY_CORE = registerBlock("reality_core",
            new Block(AbstractBlock.Settings.create().strength(6f).requiresTool().sounds(BlockSoundGroup.NETHER_BRICKS)
                    .allowsSpawning(Blocks::never).mapColor(MapColor.BLACK)));

    private  static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(MID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(MID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registeredModBlocks() {
        TestMod.LOGGER.info("Registering Mod Blocks for " + MID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(ModBlocks.REALITY_CORE);
        });
    }
}

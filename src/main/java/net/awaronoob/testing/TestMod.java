package net.awaronoob.testing;

import net.awaronoob.testing.block.ModBlocks;
import net.awaronoob.testing.item.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestMod implements ModInitializer {
	public static final String MOD_ID = "testmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
        //Calls all register functions
        ModItems.registerModItems();
        ModBlocks.registeredModBlocks();
	}
}
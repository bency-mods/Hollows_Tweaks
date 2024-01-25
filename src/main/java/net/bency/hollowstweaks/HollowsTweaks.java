package net.bency.hollowstweaks;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HollowsTweaks implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("hollowtweaks");

	@Override
	public void onInitialize() {
		Splodge.SplodgeInitialize();
		LOGGER.info("Splodge Initialized");
		BarkItems.BarkItemsInitialize();
		LOGGER.info("BarkItems initialized.");
		BetterApple.BetterAppleInitialize();
		LOGGER.info("BetterApple initialized.");
		LOGGER.info("Hollow's Tweaks is fully loaded!");

	}
}
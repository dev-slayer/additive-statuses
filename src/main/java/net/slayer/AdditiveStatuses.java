package net.slayer;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AdditiveStatuses implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("additive-statuses");

	@Override
	public void onInitialize() {
		AdditiveConfigs.init();
	}
}
package net.slayer;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import me.shedaniel.autoconfig.serializer.JanksonConfigSerializer;

@Config(
        name = "additive_statuses"
)
public class AdditiveConfigs implements ConfigData {
    @ConfigEntry.Gui.Excluded
    public static AdditiveConfigs INSTANCE;
    @ConfigEntry.Gui.Tooltip
    public boolean cycleAmplification = false;
    @ConfigEntry.Gui.Tooltip
    public boolean cycleBlacklist = true;
    @ConfigEntry.Gui.Tooltip
    public String blacklistedEffects = "minecraft:night_vision,minecraft:bad_omen,minecraft:trial_omen,minecraft:raid_omen,minecraft:darkness,minecraft:blindness,minecraft:water_breathing,minecraft:glowing,minecraft:hero_of_the_village,minecraft:oozing,minecraft:infested,minecraft:weaving,minecraft:wind_charged";
    @ConfigEntry.Gui.Tooltip
    public boolean durationLimitation = false;
    @ConfigEntry.Gui.Tooltip
    public int maxTime = 24000;
    @ConfigEntry.Gui.Tooltip
    public int startTime = 1200;

    public void ModConfig() {
    }

    public static void init() {
        AutoConfig.register(AdditiveConfigs.class, JanksonConfigSerializer::new);
        INSTANCE = (AdditiveConfigs)AutoConfig.getConfigHolder(AdditiveConfigs.class).getConfig();
    }
}


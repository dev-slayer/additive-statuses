package net.slayer.gui;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import me.shedaniel.autoconfig.AutoConfig;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.screen.Screen;
import net.slayer.AdditiveConfigs;

@Environment(EnvType.CLIENT)
public class ModMenuIntegration implements ModMenuApi {
    public ModMenuIntegration() {
    }

    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        return (parent) -> {
            return (Screen) AutoConfig.getConfigScreen(AdditiveConfigs.class, parent).get();
        };
    }
}

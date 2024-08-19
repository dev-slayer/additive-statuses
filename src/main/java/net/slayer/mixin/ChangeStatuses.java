package net.slayer.mixin;

import me.shedaniel.autoconfig.AutoConfig;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.registry.entry.RegistryEntry;
import net.slayer.AdditiveConfigs;
import org.slf4j.Logger;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Arrays;
import java.util.List;

@Mixin(value = StatusEffectInstance.class)
public abstract class ChangeStatuses {

	@Shadow private int duration;

	@Shadow private int amplifier;


	@Shadow @Final private RegistryEntry<StatusEffect> type;

	@Shadow @Final private static Logger LOGGER;

	@Inject(method = "upgrade", at = @At("HEAD"), cancellable = true)
	private void injected(StatusEffectInstance that, CallbackInfoReturnable<Boolean> cir) {
		List<String> effectsArray = Arrays.asList(AdditiveConfigs.INSTANCE.blacklistedEffects.split(","));
		this.duration += that.getDuration();
		LOGGER.info(this.type.getIdAsString());
		if (!effectsArray.contains(this.type.getIdAsString())) {
			if (this.duration > AdditiveConfigs.INSTANCE.maxTime && AdditiveConfigs.INSTANCE.cycleAmplification) {
				this.duration = AdditiveConfigs.INSTANCE.startTime;
				this.amplifier++;
			}
		}
		if (this.duration > AdditiveConfigs.INSTANCE.maxTime && AdditiveConfigs.INSTANCE.durationLimitation) {
			this.duration = AdditiveConfigs.INSTANCE.maxTime;
		}
		cir.setReturnValue(true);
	}
}
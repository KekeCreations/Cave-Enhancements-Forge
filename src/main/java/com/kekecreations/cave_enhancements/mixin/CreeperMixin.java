package com.kekecreations.cave_enhancements.mixin;

import com.kekecreations.cave_enhancements.entity.ai.goal.FleeTheFluteGoal;
import net.minecraft.world.entity.EntitySelector;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Creeper.class)
public abstract class CreeperMixin extends Monster {

    protected CreeperMixin(EntityType<? extends Monster> entityType, Level level) {
        super(entityType, level);
    }

    @Inject(method = "registerGoals", at = @At("HEAD"))
    protected void initGoals(CallbackInfo ci) {
        this.goalSelector.addGoal(1, new FleeTheFluteGoal<>(this, EntitySelector.NO_CREATIVE_OR_SPECTATOR, 8.0F, 1.25D, 1.25D));
    }
}

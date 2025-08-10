package com.sumobob567.balanced_automation.entity.goals;

import com.sumobob567.balanced_automation.entity.SlayerAutomatonEntity;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.util.DefaultRandomPos;

import java.util.EnumSet;

public class StationaryAttackGoal extends Goal {
    private final SlayerAutomatonEntity mob;
    private final double attackReach;
    private int attackCooldown;

    public StationaryAttackGoal(SlayerAutomatonEntity mob, double attackReach) {
        this.mob = mob;
        this.attackReach = attackReach;
        this.attackCooldown = 0;
        this.setFlags(EnumSet.of(Flag.TARGET, Flag.LOOK)); // only target + look at entity
    }

    @Override
    public boolean canUse() {
        LivingEntity target = mob.getTarget();
        return target != null && target.isAlive() && mob.distanceToSqr(target) <= attackReach * attackReach;
    }

    @Override
    public boolean canContinueToUse() {
        LivingEntity target = mob.getTarget();
        return target != null && target.isAlive() && mob.distanceToSqr(target) <= attackReach * attackReach;
    }

    @Override
    public void tick() {
        LivingEntity target = mob.getTarget();
        if (target != null) {
            mob.getLookControl().setLookAt(target, 30.0F, 30.0F);

            if (--attackCooldown <= 0) {
                mob.setAttackAnimationTick(10);
                attackCooldown = 20; // 1 second delay between hits
                mob.level().playSound(null, mob.blockPosition(), SoundEvents.IRON_GOLEM_ATTACK, SoundSource.HOSTILE, 1.0F, 1.0F);
                mob.swing(mob.getUsedItemHand());
                mob.doHurtTarget(target);
            }
        }
    }
}
package com.sumobob567.balanced_automation.entity;

import com.sumobob567.balanced_automation.entity.goals.StationaryAttackGoal;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.DefendVillageTargetGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.target.ResetUniversalAngerTargetGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.monster.Enemy;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;
import org.w3c.dom.Attr;

public class SlayerAutomatonEntity extends Animal {

    private static final EntityDataAccessor<Integer> ATTACK_ANIMATION_TICK =
            SynchedEntityData.defineId(SlayerAutomatonEntity.class, EntityDataSerializers.INT);

    protected SlayerAutomatonEntity(EntityType<? extends Animal> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(ATTACK_ANIMATION_TICK, 0);
    }

    @Override
    protected void registerGoals() {
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Mob.class, false,
                (mob) -> mob instanceof Enemy && !(mob instanceof Creeper)));
        this.goalSelector.addGoal(1, new StationaryAttackGoal(this, 4.0D));
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Animal.createLivingAttributes()
                .add(Attributes.FOLLOW_RANGE, 16.0D)
                .add(Attributes.ATTACK_DAMAGE, 6)
                .add(Attributes.ATTACK_KNOCKBACK, 0)
                .add(Attributes.MOVEMENT_SPEED, 0)
                .add(Attributes.MAX_HEALTH, 100)
                .add(Attributes.ATTACK_SPEED, 1)
                .add(Attributes.ARMOR, 10)
                .add(Attributes.ARMOR_TOUGHNESS, 0.5)
                .add(Attributes.KNOCKBACK_RESISTANCE, 20);
    }

    @Override
    public boolean isPushable() {
        return false;
    }

    @Override
    public boolean isAttackable() {
        return false;
    }

    @Override
    public boolean isDeadOrDying() {
        return false;
    }



    @Override
    public @Nullable AgeableMob getBreedOffspring(ServerLevel serverLevel, AgeableMob ageableMob) {
        return null;
    }

    @Override
    protected @Nullable SoundEvent getHurtSound(DamageSource pDamageSource) {
        return SoundEvents.IRON_GOLEM_HURT;
    }

    @Override
    public void customServerAiStep() {
        super.customServerAiStep();

        LivingEntity target = this.getTarget();

        double maxRange = 4.0D;
        if (target != null) {
            if (!target.isAlive() || this.distanceToSqr(target) > (maxRange * maxRange)) {
                this.setTarget(null);  // Switch target when current is too far
            }
        }

        if (this.getAttackAnimationTick() > 0) {
            this.setAttackAnimationTick(this.getAttackAnimationTick() - 1);
        }

    }

    public int getAttackAnimationTick() {
        return this.entityData.get(ATTACK_ANIMATION_TICK);
    }

    public void setAttackAnimationTick(int tick) {
        this.entityData.set(ATTACK_ANIMATION_TICK, tick);
    }


}

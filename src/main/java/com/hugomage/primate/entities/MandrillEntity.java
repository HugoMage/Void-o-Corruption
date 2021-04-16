package com.hugomage.primate.entities;

import com.hugomage.primate.init.ModSoundEventTypes;
import net.minecraft.block.BlockState;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import javax.annotation.Nullable;
import java.util.Random;

public class MandrillEntity extends AnimalEntity {

    public static final Ingredient TEMPTATION_ITEMS = Ingredient.fromItems(Items.SUGAR_CANE);

    public MandrillEntity(EntityType<? extends AnimalEntity> type, World worldIn) {
        super(type, worldIn);
    }


    public static AttributeModifierMap.MutableAttribute setCustomAttributes(){
        return MobEntity.func_233666_p_()
                .createMutableAttribute(Attributes.MAX_HEALTH, 40.0D)
                .createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.33D)
                .createMutableAttribute(Attributes.ATTACK_DAMAGE, 4D)
                .createMutableAttribute(Attributes.ATTACK_SPEED, 6D)
                .createMutableAttribute(Attributes.ATTACK_KNOCKBACK, 1D);
    }



    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(0, new SwimGoal(this));
        this.goalSelector.addGoal(1, new TemptGoal(this, 1.1D, TEMPTATION_ITEMS, false));
        this.targetSelector.addGoal(2, new HurtByTargetGoal(this));
        this.goalSelector.addGoal(3, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
        this.goalSelector.addGoal(4, new LookAtGoal(this, PlayerEntity.class, 6.0F));
        this.goalSelector.addGoal(5, new LookRandomlyGoal(this));
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.0D, true));
    }

    @Override
    protected int getExperiencePoints(PlayerEntity player) {
        return 1+ this.world.rand.nextInt(5);
    }

    @Nullable
    @Override
    public AgeableEntity func_241840_a(ServerWorld p_241840_1_, AgeableEntity p_241840_2_) {
        return null;
    }



    @Nullable
    @Override
    protected SoundEvent getAmbientSound ()
    {
        return ModSoundEventTypes.ORANGUTAN_AMBIENT.get();
    }

    @Override
    protected void playStepSound( BlockPos pos, BlockState blockIn )
    {
        if ( !blockIn.getMaterial().isLiquid() )
        {
            this.playSound( SoundEvents.ENTITY_COW_STEP, this.getSoundVolume() * 0.3F, this.getSoundPitch() );
        }
    }

    @Nullable
    @Override
    protected SoundEvent  getHurtSound (DamageSource damageSource ) {
        return ModSoundEventTypes.ORANGUTAN_HURT.get();
    }

    @Nullable
    @Override
    protected SoundEvent getDeathSound () { return ModSoundEventTypes.ORANGUTAN_DEATH.get(); }

    public static boolean canOrangutanSpawn(EntityType<? extends AnimalEntity> animal, IWorld worldIn, SpawnReason reason, BlockPos pos, Random random) {
        return true;
    }

    public void baseTick() {
        super.baseTick();
        this.world.getProfiler().startSection("mobBaseTick");
        if (this.isAlive() && this.rand.nextInt(1000) < this.livingSoundTime++) {
            this.playAmbientSound();
        }

        this.world.getProfiler().endSection();
    }

    private void func_241821_eG() {
        this.livingSoundTime = -this.getTalkInterval();
    }

    public int livingSoundTime() {
        return 0;
    }


}



package com.hugomage.primate.entities;

import com.hugomage.primate.init.ModSoundEventTypes;
import net.minecraft.block.BlockState;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.monster.BlazeEntity;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.SmallFireballEntity;
import net.minecraft.entity.projectile.SnowballEntity;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import javax.annotation.Nullable;
import java.util.EnumSet;
import java.util.Random;

public class ProboscisEntity extends AnimalEntity{

    public static final Ingredient TEMPTATION_ITEMS = Ingredient.fromItems(Items.APPLE, Items.MELON_SLICE);

    public ProboscisEntity(EntityType<? extends AnimalEntity> type, World worldIn) {
        super(type, worldIn);
    }

    public static AttributeModifierMap.MutableAttribute setCustomAttributes(){
        return MobEntity.func_233666_p_()
                .createMutableAttribute(Attributes.MAX_HEALTH, 25.0D)
                .createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.33D)
                .createMutableAttribute(Attributes.ATTACK_DAMAGE, 5D)
                .createMutableAttribute(Attributes.ATTACK_SPEED, 5D)
                .createMutableAttribute(Attributes.ATTACK_KNOCKBACK, 0.5D);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(0, new SwimGoal(this));
        this.goalSelector.addGoal(7, new TemptGoal(this, 1.1D, TEMPTATION_ITEMS, false));
        this.targetSelector.addGoal(2, new HurtByTargetGoal(this));
        this.goalSelector.addGoal(6, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
        this.goalSelector.addGoal(4, new LookAtGoal(this, PlayerEntity.class, 6.0F));
        this.goalSelector.addGoal(5, new LookRandomlyGoal(this));
        this.targetSelector.addGoal(1, (new HurtByTargetGoal(this)).setCallsForHelp());
        this.goalSelector.addGoal(3, new MeleeAttackGoal(this, 1.0D, true));
        }

    @Override
    protected void playStepSound( BlockPos pos, BlockState blockIn )
    {
        if ( !blockIn.getMaterial().isLiquid() )
        {
            this.playSound( SoundEvents.ENTITY_ZOMBIE_STEP, this.getSoundVolume() * 0.3F, this.getSoundPitch() );
        }
    }

    @Override
    protected int getExperiencePoints(PlayerEntity player) {
        return 1+ this.world.rand.nextInt(4);
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
        return ModSoundEventTypes.PROBOSCIS_AMBIENT.get();
    }

    @Nullable
    @Override
    protected SoundEvent  getHurtSound (DamageSource damageSource ) {
        return ModSoundEventTypes.PROBOSCIS_HURT.get();
    }

    @Nullable
    @Override
    protected SoundEvent getDeathSound () { return ModSoundEventTypes.PROBOSCIS_DEATH.get(); }

    public static boolean canProboscisSpawn(EntityType<? extends AnimalEntity> animal, IWorld worldIn, SpawnReason reason, BlockPos pos, Random random) {
        return true;
    }





    public void tick() {


            super.tick();
        }



}




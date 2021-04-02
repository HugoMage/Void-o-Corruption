package com.hugomage.primate.entities;

import com.hugomage.primate.init.ModSoundEventTypes;
import net.minecraft.block.BlockState;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import javax.annotation.Nullable;
import java.util.Random;

public class UakariEntity extends AnimalEntity {

    public static final Ingredient TEMPTATION_ITEMS = Ingredient.fromItems(Items.APPLE, Items.MELON_SLICE);

    public UakariEntity(EntityType<? extends AnimalEntity> type, World worldIn) {
        super(type, worldIn);
    }

    public static AttributeModifierMap.MutableAttribute setCustomAttributes(){
        return MobEntity.func_233666_p_()
                .createMutableAttribute(Attributes.MAX_HEALTH, 15.0D)
                .createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.40D)
                .createMutableAttribute(Attributes.ATTACK_DAMAGE, 1D)
                .createMutableAttribute(Attributes.ATTACK_SPEED, 6D)
                .createMutableAttribute(Attributes.ATTACK_KNOCKBACK, 0D);
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
        this.goalSelector.addGoal(6, new PanicGoal(this, 1.0D));
    }

    @Override
    protected void playStepSound( BlockPos pos, BlockState blockIn )
    {
        if ( !blockIn.getMaterial().isLiquid() )
        {
            this.playSound( SoundEvents.ENTITY_WOLF_STEP, this.getSoundVolume() * 0.3F, this.getSoundPitch() );
        }
    }
    @Nullable
    @Override
    protected SoundEvent getAmbientSound ()
    {
        return ModSoundEventTypes.UAKARI_AMBIENT.get();
    }

    @Nullable
    @Override
    protected SoundEvent  getHurtSound (DamageSource damageSource ) {
        return ModSoundEventTypes.UAKARI_HURT.get();
    }

    @Nullable
    @Override
    protected SoundEvent getDeathSound () { return ModSoundEventTypes.UAKARI_DEATH.get(); }


    @Override
    protected int getExperiencePoints(PlayerEntity player) {
        return 1+ this.world.rand.nextInt(5);
    }

    @Nullable
    @Override
    public AgeableEntity func_241840_a(ServerWorld p_241840_1_, AgeableEntity p_241840_2_) {
        return null;
    }
}


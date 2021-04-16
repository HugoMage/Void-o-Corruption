package com.hugomage.primate.entities;

import com.hugomage.primate.init.ModSoundEventTypes;
import net.minecraft.block.BlockState;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.merchant.villager.AbstractVillagerEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.passive.TurtleEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.particles.BlockParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.Random;
import java.util.function.Predicate;

public class ZombieApeEntity extends MonsterEntity {

    public static final Ingredient TEMPTATION_ITEMS = Ingredient.fromItems(Items.HONEYCOMB);
    public static final Predicate<LivingEntity> TARGET_ENTITIES = (p_213440_0_) -> {
        EntityType<?> entitytype = p_213440_0_.getType();
        return entitytype == EntityType.SHEEP || entitytype == EntityType.COW || entitytype == EntityType.FOX;
    };

    public ZombieApeEntity(EntityType<? extends MonsterEntity> type, World worldIn) {
        super(type, worldIn);
    }
    private int attackTimer;

    public static AttributeModifierMap.MutableAttribute setCustomAttributes(){
        return MobEntity.func_233666_p_()
                .createMutableAttribute(Attributes.MAX_HEALTH, 30.0D)
                .createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.25D)
                .createMutableAttribute(Attributes.ATTACK_DAMAGE, 3D)
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
        this.targetSelector.addGoal( 6, new NearestAttackableTargetGoal<>( this, AnimalEntity.class, true ) );
        this.targetSelector.addGoal(7, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));
        this.targetSelector.addGoal(8, new NearestAttackableTargetGoal<>(this, AbstractVillagerEntity.class, false));
        this.targetSelector.addGoal(9, new NearestAttackableTargetGoal<>(this, IronGolemEntity.class, true));
        this.targetSelector.addGoal(10, new NearestAttackableTargetGoal<>(this, TurtleEntity.class, 10, true, false, TurtleEntity.TARGET_DRY_BABY));
    }

    @Override
    protected int getExperiencePoints(PlayerEntity player) {
        return 1+ this.world.rand.nextInt(5);
    }



    public static boolean canOrangutanSpawn(EntityType<ZombieApeEntity> p_234418_0_, IWorld p_234418_1_, SpawnReason p_234418_2_, BlockPos p_234418_3_, Random p_234418_4_)
    {
        return true;
    }

    @Nullable
    @Override
    protected SoundEvent getAmbientSound ()
    {
        return ModSoundEventTypes.ZOMBIEAPE_AMBIENT.get();
    }

    @Override
    protected void playStepSound( BlockPos pos, BlockState blockIn )
    {
        if ( !blockIn.getMaterial().isLiquid() )
        {
            this.playSound( SoundEvents.ENTITY_ZOMBIE_STEP, this.getSoundVolume() * 0.3F, this.getSoundPitch() );
        }
    }

    @Nullable
    @Override
    protected SoundEvent  getHurtSound (DamageSource damageSource ) {
        return ModSoundEventTypes.ZOMBIEAPE_HURT.get();
    }

    @Nullable
    @Override
    protected SoundEvent getDeathSound () { return ModSoundEventTypes.ZOMBIEAPE_DEATH.get(); }

    public void livingTick() {
        if (this.isAlive()) {
            boolean flag = this.shouldBurnInDay() && this.isInDaylight();


                if (flag) {
                    this.setFire(8);
                }
            }
        super.livingTick();
        if (this.attackTimer > 0) {
            --this.attackTimer;
        }

    }


    protected boolean shouldBurnInDay() {
        return true;
    }

    @OnlyIn(Dist.CLIENT)
    public int getAttackTimer() {
        return this.attackTimer;
    }

    @OnlyIn(Dist.CLIENT)
    public void handleStatusUpdate(byte id) {
        if (id == 4) {
            this.attackTimer = 10;
            this.playSound(SoundEvents.ENTITY_IRON_GOLEM_ATTACK, 1.0F, 1.0F);
        } else {
            super.handleStatusUpdate(id);
        }

    }
    private float func_226511_et_() {
        return (float)this.getAttributeValue(Attributes.ATTACK_DAMAGE);
    }

    public boolean attackEntityAsMob(Entity entityIn) {
        this.attackTimer = 10;
        this.world.setEntityState(this, (byte)4);
        float f = this.func_226511_et_();
        float f1 = (int)f > 0 ? f / 2.0F + (float)this.rand.nextInt((int)f) : f;
        boolean flag = entityIn.attackEntityFrom(DamageSource.causeMobDamage(this), f1);

        this.playSound(SoundEvents.ENTITY_IRON_GOLEM_ATTACK, 1.0F, 1.0F);
        return flag;
    }

    public boolean isBili() {
        String s = TextFormatting.getTextWithoutFormattingCodes(this.getName().getString());
        return s != null && (s.toLowerCase().contains("bili") && s.toLowerCase().contains("ape"));
    }




}

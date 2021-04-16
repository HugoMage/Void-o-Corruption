package com.hugomage.primate.entities;

import com.hugomage.primate.init.ModEntityTypes;
import com.hugomage.primate.init.ModSoundEventTypes;
import net.minecraft.block.BlockState;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.ChickenEntity;
import net.minecraft.entity.passive.RabbitEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IServerWorld;
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
    private static final DataParameter<Integer> VARIANT = EntityDataManager.createKey(UakariEntity.class, DataSerializers.VARINT);
    public static AttributeModifierMap.MutableAttribute setCustomAttributes() {
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
    protected void playStepSound(BlockPos pos, BlockState blockIn) {
        if (!blockIn.getMaterial().isLiquid()) {
            this.playSound(SoundEvents.ENTITY_WOLF_STEP, this.getSoundVolume() * 0.3F, this.getSoundPitch());
        }
    }

    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return ModSoundEventTypes.UAKARI_AMBIENT.get();
    }

    @Nullable
    @Override
    protected SoundEvent getHurtSound(DamageSource damageSource) {
        return ModSoundEventTypes.UAKARI_HURT.get();
    }

    @Nullable
    @Override
    protected SoundEvent getDeathSound() {
        return ModSoundEventTypes.UAKARI_DEATH.get();
    }


    @Override
    protected int getExperiencePoints(PlayerEntity player) {
        return 1 + this.world.rand.nextInt(5);
    }

    @Nullable
    @Override
    public AgeableEntity func_241840_a(ServerWorld serverWorld, AgeableEntity ageableEntity) {
        UakariEntity uakari = ModEntityTypes.UAKARI.get().create(serverWorld);
        uakari.setVariant(this.getVariant());
        return uakari;
    }

    public ActionResultType func_230254_b_(PlayerEntity p_230254_1_, Hand p_230254_2_) {
        ItemStack itemstack = p_230254_1_.getHeldItem(p_230254_2_);
        Item item = itemstack.getItem();
        if (this.isBreedingItem(itemstack) && this.getHealth() < this.getMaxHealth()) {
            if (!p_230254_1_.abilities.isCreativeMode) {
                itemstack.shrink(1);
            }

            this.heal((float) item.getFood().getHealing());
            return ActionResultType.SUCCESS;
        }
        return super.func_230254_b_(p_230254_1_, p_230254_2_); }

    public boolean isBreedingItem(ItemStack stack) {
        Item item = stack.getItem();
        return item.isFood() && item.getFood().isMeat();
    }


    public int getVariant() {
        return this.dataManager.get(VARIANT);
    }

    public void setVariant(int variant) {
        this.dataManager.set(VARIANT, variant);
    }

    @Nullable
    public ILivingEntityData onInitialSpawn(IServerWorld worldIn, DifficultyInstance difficultyIn, SpawnReason reason, @Nullable ILivingEntityData spawnDataIn, @Nullable CompoundNBT dataTag) {
        if(this.rand.nextInt(100) == 0){
            this.setVariant(2);
        }else if(rand.nextInt(100) == 0){
            this.setVariant(1);
        }
        return super.onInitialSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
    }
    @Override
    protected void registerData() {
        super.registerData();
        this.dataManager.register(VARIANT, 0);
    }

    public void writeAdditional(CompoundNBT compound) {
        super.writeAdditional(compound);
        compound.putInt("variant", this.getVariant());

    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    public void readAdditional(CompoundNBT compound) {
        super.readAdditional(compound);
        this.setVariant(compound.getInt("variant"));

    }

}
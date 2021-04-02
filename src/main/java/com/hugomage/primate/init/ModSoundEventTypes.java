package com.hugomage.primate.init;

import com.hugomage.primate.Primate;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModSoundEventTypes
{
 public static DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, Primate.MOD_ID);

 public static final RegistryObject<SoundEvent> ORANGUTAN_AMBIENT = SOUND_EVENTS.register("entity.orangutan.ambient", () ->
         new SoundEvent(new ResourceLocation(Primate.MOD_ID, "entity.orangutan.ambient"))
 );

 public static final RegistryObject<SoundEvent> PROBOSCIS_AMBIENT = SOUND_EVENTS.register("entity.proboscis.ambient", () ->
         new SoundEvent(new ResourceLocation(Primate.MOD_ID, "entity.proboscis.ambient"))
 );
 public static final RegistryObject<SoundEvent> PROBOSCIS_HURT = SOUND_EVENTS.register("entity.proboscis.hurt", () ->
         new SoundEvent(new ResourceLocation(Primate.MOD_ID, "entity.proboscis.hurt"))
 );
 public static final RegistryObject<SoundEvent> PROBOSCIS_DEATH = SOUND_EVENTS.register("entity.proboscis.death", () ->
         new SoundEvent(new ResourceLocation(Primate.MOD_ID, "entity.proboscis.death"))
 );
 public static final RegistryObject<SoundEvent> ORANGUTAN_HURT = SOUND_EVENTS.register("entity.orangutan.hurt", () ->
         new SoundEvent(new ResourceLocation(Primate.MOD_ID, "entity.orangutan.hurt"))
 );
 public static final RegistryObject<SoundEvent> ORANGUTAN_DEATH = SOUND_EVENTS.register("entity.orangutan.death", () ->
         new SoundEvent(new ResourceLocation(Primate.MOD_ID, "entity.orangutan.death"))
 );
 public static final RegistryObject<SoundEvent> UAKARI_AMBIENT = SOUND_EVENTS.register("entity.uakari.ambient", () ->
         new SoundEvent(new ResourceLocation(Primate.MOD_ID, "entity.uakari.ambient"))
 );
 public static final RegistryObject<SoundEvent> UAKARI_HURT = SOUND_EVENTS.register("entity.uakari.hurt", () ->
         new SoundEvent(new ResourceLocation(Primate.MOD_ID, "entity.uakari.hurt"))
 );
 public static final RegistryObject<SoundEvent> UAKARI_DEATH = SOUND_EVENTS.register("entity.uakari.death", () ->
         new SoundEvent(new ResourceLocation(Primate.MOD_ID, "entity.uakari.death"))
 );
}

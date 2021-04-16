package com.hugomage.primate.client.render;

import com.hugomage.primate.Primate;
import com.hugomage.primate.client.model.ZombieApeModel;
import com.hugomage.primate.entities.ZombieApeEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class ZombieApeRenderer extends MobRenderer<ZombieApeEntity, ZombieApeModel<ZombieApeEntity>> {

    protected static final ResourceLocation TEXTURE = new ResourceLocation(Primate.MOD_ID, "textures/entity/zombieape.png");
    protected static final ResourceLocation TEXTURE_BILI = new ResourceLocation(Primate.MOD_ID, "textures/entity/bili.png");


    public ZombieApeRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new ZombieApeModel<>(), 0.8F);
    }

    @Override
    public ResourceLocation getEntityTexture(ZombieApeEntity entity) {
        return entity.isBili() ? TEXTURE_BILI : TEXTURE;
    }
}


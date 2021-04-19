package com.HugoMage.voidcorruption.client.render;

import com.HugoMage.voidcorruption.VoidCorruption;
import com.HugoMage.voidcorruption.client.model.HungerModel;
import com.HugoMage.voidcorruption.client.model.VoidApeModel;
import com.HugoMage.voidcorruption.entities.HungerEntity;
import com.HugoMage.voidcorruption.entities.VoidApeEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class HungerRenderer extends MobRenderer<HungerEntity, HungerModel<HungerEntity>> {

    protected static final ResourceLocation TEXTURE = new ResourceLocation(VoidCorruption.MOD_ID, "textures/entity/hunger.png");


    public HungerRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new HungerModel<>(), 0.8F);
    }

    @Override
    public ResourceLocation getEntityTexture(HungerEntity entity) {
        return TEXTURE;
    }
}

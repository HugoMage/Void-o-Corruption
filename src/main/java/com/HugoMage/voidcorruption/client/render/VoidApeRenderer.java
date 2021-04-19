package com.HugoMage.voidcorruption.client.render;

import com.HugoMage.voidcorruption.VoidCorruption;
import com.HugoMage.voidcorruption.client.model.VoidApeModel;
import com.HugoMage.voidcorruption.entities.VoidApeEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class VoidApeRenderer extends MobRenderer<VoidApeEntity, VoidApeModel<VoidApeEntity>> {

    protected static final ResourceLocation TEXTURE = new ResourceLocation(VoidCorruption.MOD_ID, "textures/entity/zombieape.png");


    public VoidApeRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new VoidApeModel<>(), 0.8F);
    }

    @Override
    public ResourceLocation getEntityTexture(VoidApeEntity entity) {
        return TEXTURE;
    }
}

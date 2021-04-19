package com.HugoMage.voidcorruption.client.render;

import com.HugoMage.voidcorruption.VoidCorruption;
import com.HugoMage.voidcorruption.client.model.HungerModel;
import com.HugoMage.voidcorruption.client.model.ParamedoModel;
import com.HugoMage.voidcorruption.entities.HungerEntity;
import com.HugoMage.voidcorruption.entities.ParamedoEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class ParamedoRenderer extends MobRenderer<ParamedoEntity, ParamedoModel<ParamedoEntity>> {

    protected static final ResourceLocation TEXTURE = new ResourceLocation(VoidCorruption.MOD_ID, "textures/entity/paramedo.png");


    public ParamedoRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new ParamedoModel<>(), 0.8F);
    }

    @Override
    public ResourceLocation getEntityTexture(ParamedoEntity entity) {
        return TEXTURE;
    }
}

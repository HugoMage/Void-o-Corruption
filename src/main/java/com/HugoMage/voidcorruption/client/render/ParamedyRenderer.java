package com.HugoMage.voidcorruption.client.render;

import com.HugoMage.voidcorruption.VoidCorruption;
import com.HugoMage.voidcorruption.client.model.ParamedoModel;
import com.HugoMage.voidcorruption.client.model.ParamedyModel;
import com.HugoMage.voidcorruption.entities.ParamedoEntity;
import com.HugoMage.voidcorruption.entities.ParamedyEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class ParamedyRenderer extends MobRenderer<ParamedyEntity, ParamedyModel<ParamedyEntity>> {

    protected static final ResourceLocation TEXTURE = new ResourceLocation(VoidCorruption.MOD_ID, "textures/entity/paramedy.png");


    public ParamedyRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new ParamedyModel<>(), 0.8F);
    }

    @Override
    public ResourceLocation getEntityTexture(ParamedyEntity entity) {
        return TEXTURE;
    }
}

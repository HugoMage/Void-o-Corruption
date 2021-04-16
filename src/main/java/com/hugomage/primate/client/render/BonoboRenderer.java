package com.hugomage.primate.client.render;

import com.hugomage.primate.Primate;
import com.hugomage.primate.client.model.BonoboModel;
import com.hugomage.primate.entities.BonoboEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class BonoboRenderer extends MobRenderer<BonoboEntity, BonoboModel<BonoboEntity>> {

    protected static final ResourceLocation TEXTURE = new ResourceLocation(Primate.MOD_ID, "textures/entity/bonobo.png");


    public BonoboRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new BonoboModel(), 0.8F);
    }

    @Override
    public ResourceLocation getEntityTexture(BonoboEntity entity) {
        return TEXTURE;
    }
}


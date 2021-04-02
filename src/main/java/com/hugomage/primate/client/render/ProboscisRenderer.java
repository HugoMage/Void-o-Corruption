package com.hugomage.primate.client.render;

import com.hugomage.primate.Primate;
import com.hugomage.primate.client.model.OrangutanModel;
import com.hugomage.primate.client.model.ProboscisModel;
import com.hugomage.primate.entities.OrangutanEntity;
import com.hugomage.primate.entities.ProboscisEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class ProboscisRenderer extends MobRenderer<ProboscisEntity, ProboscisModel<ProboscisEntity>> {

    protected static final ResourceLocation TEXTURE = new ResourceLocation(Primate.MOD_ID, "textures/entity/proboscis.png");


    public ProboscisRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new ProboscisModel<>(), 0.8F);
    }

    @Override
    public ResourceLocation getEntityTexture(ProboscisEntity entity) {
        return TEXTURE;
    }
}

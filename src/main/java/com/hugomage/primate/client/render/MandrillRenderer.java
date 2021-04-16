package com.hugomage.primate.client.render;

import com.hugomage.primate.Primate;
import com.hugomage.primate.client.model.MandrillModel;
import com.hugomage.primate.client.model.OrangutanModel;
import com.hugomage.primate.entities.MandrillEntity;
import com.hugomage.primate.entities.OrangutanEntity;
import com.hugomage.primate.entities.ProboscisEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class MandrillRenderer extends MobRenderer<MandrillEntity, MandrillModel<MandrillEntity>> {

    protected static final ResourceLocation TEXTURE = new ResourceLocation(Primate.MOD_ID, "textures/entity/mandrill.png");

    public MandrillRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new MandrillModel<>(), 0.8F);
    }

    @Override
    public ResourceLocation getEntityTexture(MandrillEntity entity) {
        return TEXTURE;
    }


}

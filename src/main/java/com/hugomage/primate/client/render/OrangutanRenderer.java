package com.hugomage.primate.client.render;

import com.hugomage.primate.Primate;
import com.hugomage.primate.client.model.OrangutanModel;
import com.hugomage.primate.entities.OrangutanEntity;
import com.hugomage.primate.entities.UakariEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class OrangutanRenderer extends MobRenderer<OrangutanEntity, OrangutanModel<OrangutanEntity>> {

    protected static final ResourceLocation TEXTURE = new ResourceLocation(Primate.MOD_ID, "textures/entity/orangutan.png");
    protected static final ResourceLocation TEXTURE_ALBN = new ResourceLocation(Primate.MOD_ID, "textures/entity/albino_orangutan.png");


    public OrangutanRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new OrangutanModel<>(), 0.8F);
    }


    @Override
    public ResourceLocation getEntityTexture(OrangutanEntity entity) {
        if(entity.getVariant() == 1){
            return TEXTURE_ALBN;
        }
        if(entity.getVariant() == 2) {
            return TEXTURE_ALBN;
        }
        return TEXTURE;
    }
}

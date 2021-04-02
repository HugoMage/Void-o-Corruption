package com.hugomage.primate.client.render;

import com.hugomage.primate.Primate;
import com.hugomage.primate.client.model.UakariModel;
import com.hugomage.primate.entities.UakariEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.util.ResourceLocation;

public class UakariRenderer extends MobRenderer<UakariEntity, UakariModel<UakariEntity>> {

    protected static final ResourceLocation TEXTURE = new ResourceLocation(Primate.MOD_ID, "textures/entity/uakari.png");


    public UakariRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new UakariModel<>(), 0.7F);
    }

    @Override
    public ResourceLocation getEntityTexture(UakariEntity entity) {
        return TEXTURE;
    }
}

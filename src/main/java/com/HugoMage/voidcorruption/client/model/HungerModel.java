package com.HugoMage.voidcorruption.client.model;

import com.HugoMage.voidcorruption.entities.HungerEntity;
import com.HugoMage.voidcorruption.entities.VoidApeEntity;
import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class HungerModel<T extends HungerEntity> extends EntityModel<T>{

    private final ModelRenderer head;
    private final ModelRenderer body;
    private final ModelRenderer leftleg;
    private final ModelRenderer rightleg;
    private final ModelRenderer rightarm;
    private final ModelRenderer leftarm;

    public HungerModel() {
        textureWidth = 128;
        textureHeight = 128;

        head = new ModelRenderer(this);
        head.setRotationPoint(0.0F, 11.0F, 0.0F);
        head.setTextureOffset(0, 0).addBox(-9.0F, -12.0F, -14.0F, 18.0F, 13.0F, 22.0F, 0.0F, false);

        body = new ModelRenderer(this);
        body.setRotationPoint(0.0F, 15.0F, 0.0F);
        body.setTextureOffset(0, 36).addBox(-6.0F, -3.0F, -6.0F, 12.0F, 5.0F, 12.0F, 0.0F, false);

        leftleg = new ModelRenderer(this);
        leftleg.setRotationPoint(5.0F, 17.0F, 5.0F);
        leftleg.setTextureOffset(0, 62).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 7.0F, 6.0F, 0.0F, false);

        rightleg = new ModelRenderer(this);
        rightleg.setRotationPoint(-5.0F, 17.0F, 6.0F);
        rightleg.setTextureOffset(27, 62).addBox(-3.0F, 0.0F, -4.0F, 6.0F, 7.0F, 6.0F, 0.0F, false);

        rightarm = new ModelRenderer(this);
        rightarm.setRotationPoint(-5.0F, 17.0F, -5.0F);
        rightarm.setTextureOffset(0, 0).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 7.0F, 6.0F, 0.0F, false);

        leftarm = new ModelRenderer(this);
        leftarm.setRotationPoint(6.0F, 17.0F, -5.0F);
        leftarm.setTextureOffset(0, 0).addBox(-4.0F, 0.0F, -3.0F, 6.0F, 7.0F, 6.0F, 0.0F, false);
    }

    @Override
    public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.head.rotateAngleX = headPitch * ((float)Math.PI / 180F);
        this.head.rotateAngleY = netHeadYaw * ((float)Math.PI / 180F);
        this.rightleg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.leftleg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
        this.rightarm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
        this.leftarm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
    }


    @Override
    public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
        head.render(matrixStack, buffer, packedLight, packedOverlay);
        body.render(matrixStack, buffer, packedLight, packedOverlay);
        leftleg.render(matrixStack, buffer, packedLight, packedOverlay);
        rightleg.render(matrixStack, buffer, packedLight, packedOverlay);
        rightarm.render(matrixStack, buffer, packedLight, packedOverlay);
        leftarm.render(matrixStack, buffer, packedLight, packedOverlay);
    }

}
package com.HugoMage.voidcorruption.client.model;

import com.HugoMage.voidcorruption.entities.ParamedoEntity;
import com.HugoMage.voidcorruption.entities.ParamedyEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class ParamedyModel<T extends ParamedyEntity> extends EntityModel<T>{
    private final ModelRenderer body;
    private final ModelRenderer tail;
    private final ModelRenderer leftleg;
    private final ModelRenderer rightleg;
    private final ModelRenderer head;
    private final ModelRenderer leftarm;
    private final ModelRenderer rightarm;

    public ParamedyModel() {
        textureWidth = 32;
        textureHeight = 32;

        body = new ModelRenderer(this);
        body.setRotationPoint(0.0F, 17.0F, -2.0F);
        setRotationAngle(body, 0.6109F, 0.0F, 0.0F);
        body.setTextureOffset(0, 7).addBox(-2.0F, -3.641F, -0.6897F, 4.0F, 7.0F, 2.0F, 0.0F, false);
        body.setTextureOffset(16, 15).addBox(0.0F, -4.0F, 1.0F, 0.0F, 7.0F, 2.0F, 0.0F, false);

        tail = new ModelRenderer(this);
        tail.setRotationPoint(0.0F, 6.8812F, -2.3767F);
        body.addChild(tail);
        tail.setTextureOffset(7, 11).addBox(-1.0F, -4.0F, 3.0F, 2.0F, 1.0F, 5.0F, 0.0F, false);

        leftleg = new ModelRenderer(this);
        leftleg.setRotationPoint(-1.0F, 19.0F, 0.0F);
        leftleg.setTextureOffset(8, 17).addBox(-2.0F, 0.0F, -1.0F, 2.0F, 5.0F, 2.0F, 0.0F, false);

        rightleg = new ModelRenderer(this);
        rightleg.setRotationPoint(2.0F, 19.0F, 0.0F);
        rightleg.setTextureOffset(0, 16).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 5.0F, 2.0F, 0.0F, false);

        head = new ModelRenderer(this);
        head.setRotationPoint(0.0F, 14.0F, -3.0F);
        head.setTextureOffset(0, 0).addBox(-2.0F, -1.0F, -5.0F, 4.0F, 2.0F, 5.0F, 0.0F, false);
        head.setTextureOffset(10, 1).addBox(0.0F, -2.0F, -5.0F, 0.0F, 1.0F, 6.0F, 0.0F, false);

        leftarm = new ModelRenderer(this);
        leftarm.setRotationPoint(2.0F, 15.0F, -3.0F);
        leftarm.setTextureOffset(13, 0).addBox(-9.0F, -1.0F, 0.0F, 5.0F, 2.0F, 1.0F, 0.0F, false);

        rightarm = new ModelRenderer(this);
        rightarm.setRotationPoint(-2.0F, 15.0F, -3.0F);
        rightarm.setTextureOffset(12, 8).addBox(4.0F, -1.0F, 0.0F, 5.0F, 2.0F, 1.0F, 0.0F, false);
    }

    @Override
    public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.head.rotateAngleX = headPitch * ((float)Math.PI / 180F);
        this.head.rotateAngleY = netHeadYaw * ((float)Math.PI / 180F);
        this.rightleg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.leftleg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
        this.rightarm.rotateAngleY = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 0.3F * limbSwingAmount;
        this.leftarm.rotateAngleY = MathHelper.cos(limbSwing * 0.6662F) * 0.3F * limbSwingAmount;
        this.tail.rotateAngleY = MathHelper.cos(limbSwing * 0.6662F) * 0.3F * limbSwingAmount;
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }


    @Override
    public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
        body.render(matrixStack, buffer, packedLight, packedOverlay);
        leftleg.render(matrixStack, buffer, packedLight, packedOverlay);
        rightleg.render(matrixStack, buffer, packedLight, packedOverlay);
        head.render(matrixStack, buffer, packedLight, packedOverlay);
        leftarm.render(matrixStack, buffer, packedLight, packedOverlay);
        rightarm.render(matrixStack, buffer, packedLight, packedOverlay);
    }

}
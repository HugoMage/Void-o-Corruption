package com.HugoMage.voidcorruption.client.model;

import com.HugoMage.voidcorruption.entities.ParamedoEntity;
import com.HugoMage.voidcorruption.entities.VoidApeEntity;
import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class ParamedoModel<T extends ParamedoEntity> extends EntityModel<T>{
    private final ModelRenderer Head;
    private final ModelRenderer Body;
    private final ModelRenderer rightarm;
    private final ModelRenderer leftarm;
    private final ModelRenderer rightleg;
    private final ModelRenderer leftleg;
    private final ModelRenderer tail;

    public ParamedoModel() {
        textureWidth = 128;
        textureHeight = 128;

        Head = new ModelRenderer(this);
        Head.setRotationPoint(0.0F, 20.0F, -15.0F);
        Head.setTextureOffset(45, 49).addBox(-5.0F, -4.0F, -14.0F, 10.0F, 8.0F, 14.0F, 0.0F, false);
        Head.setTextureOffset(0, 16).addBox(5.0F, 2.0F, -14.0F, 1.0F, 2.0F, 14.0F, 0.0F, false);
        Head.setTextureOffset(0, 8).addBox(5.0F, 0.0F, -14.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);
        Head.setTextureOffset(0, 4).addBox(-6.0F, 0.0F, -14.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);
        Head.setTextureOffset(0, 16).addBox(-3.0F, 0.0F, -15.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);
        Head.setTextureOffset(6, 10).addBox(1.0F, 0.0F, -15.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);
        Head.setTextureOffset(4, 2).addBox(5.0F, 0.0F, -10.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);
        Head.setTextureOffset(0, 0).addBox(-6.0F, 0.0F, -10.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);
        Head.setTextureOffset(4, 6).addBox(5.0F, 0.0F, -14.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);
        Head.setTextureOffset(0, 0).addBox(-6.0F, 2.0F, -14.0F, 1.0F, 2.0F, 14.0F, 0.0F, false);
        Head.setTextureOffset(0, 44).addBox(-6.0F, 2.0F, -15.0F, 12.0F, 2.0F, 1.0F, 0.0F, false);

        Body = new ModelRenderer(this);
        Body.setRotationPoint(0.0F, 20.0F, 0.0F);
        Body.setTextureOffset(0, 0).addBox(-7.0F, -6.0F, -15.0F, 14.0F, 10.0F, 34.0F, 0.0F, false);
        Body.setTextureOffset(45, 10).addBox(0.0F, -11.0F, -15.0F, 0.0F, 5.0F, 34.0F, 0.0F, false);

        rightarm = new ModelRenderer(this);
        rightarm.setRotationPoint(-7.0F, 24.0F, -10.0F);
        rightarm.setTextureOffset(62, 20).addBox(-11.0F, -4.0F, -3.0F, 11.0F, 4.0F, 6.0F, 0.0F, false);

        leftarm = new ModelRenderer(this);
        leftarm.setRotationPoint(7.0F, 24.0F, -10.0F);
        leftarm.setTextureOffset(74, 71).addBox(0.0F, -4.0F, -3.0F, 11.0F, 4.0F, 6.0F, 0.0F, false);

        rightleg = new ModelRenderer(this);
        rightleg.setRotationPoint(-7.0F, 24.0F, 14.0F);
        rightleg.setTextureOffset(62, 10).addBox(-11.0F, -4.0F, -3.0F, 11.0F, 4.0F, 6.0F, 0.0F, false);

        leftleg = new ModelRenderer(this);
        leftleg.setRotationPoint(7.0F, 24.0F, 14.0F);
        leftleg.setTextureOffset(62, 0).addBox(0.0F, -4.0F, -3.0F, 11.0F, 4.0F, 6.0F, 0.0F, false);

        tail = new ModelRenderer(this);
        tail.setRotationPoint(0.0F, 20.0F, 19.0F);
        tail.setTextureOffset(0, 44).addBox(-4.0F, -5.0F, 0.0F, 8.0F, 9.0F, 29.0F, 0.0F, false);
    }


    @Override
    public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.Head.rotateAngleX = headPitch * ((float)Math.PI / 180F);
        this.Head.rotateAngleY = netHeadYaw * ((float)Math.PI / 180F);
        this.rightleg.rotateAngleY = MathHelper.cos(limbSwing * 0.6662F) * -1.4F * limbSwingAmount;
        this.leftleg.rotateAngleY = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
        this.rightarm.rotateAngleY = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * -1.4F * limbSwingAmount;
        this.leftarm.rotateAngleY = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.tail.rotateAngleY = MathHelper.cos(limbSwing * 0.6662F) * 0.3F * limbSwingAmount;
    }


    @Override
    public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
        Head.render(matrixStack, buffer, packedLight, packedOverlay);
        Body.render(matrixStack, buffer, packedLight, packedOverlay);
        rightarm.render(matrixStack, buffer, packedLight, packedOverlay);
        leftarm.render(matrixStack, buffer, packedLight, packedOverlay);
        rightleg.render(matrixStack, buffer, packedLight, packedOverlay);
        leftleg.render(matrixStack, buffer, packedLight, packedOverlay);
        tail.render(matrixStack, buffer, packedLight, packedOverlay);
    }


}
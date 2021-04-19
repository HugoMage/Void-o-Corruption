package com.HugoMage.voidcorruption.client.model;

import com.HugoMage.voidcorruption.entities.VoidApeEntity;
import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class VoidApeModel<T extends VoidApeEntity> extends EntityModel<T>{
    private final ModelRenderer head;
    private final ModelRenderer leftleg;
    private final ModelRenderer leftarm;
    private final ModelRenderer rightleg;
    private final ModelRenderer rightarm;
    private final ModelRenderer body;

    public VoidApeModel() {
        textureWidth = 64;
        textureHeight = 64;

        body = new ModelRenderer(this);
        body.setRotationPoint(0.0F, 10.0F, -2.0F);
        setRotationAngle(body, 0.8727F, 0.0F, 0.0F);
        body.setTextureOffset(0, 0).addBox(-3.5F, -5.1622F, -3.059F, 7.0F, 12.0F, 5.0F, 0.0F, false);

        rightarm = new ModelRenderer(this);
        rightarm.setRotationPoint(-3.0F, 8.0F, -4.0F);
        rightarm.setTextureOffset(24, 0).addBox(-4.0F, -2.0F, -2.0F, 4.0F, 18.0F, 4.0F, 0.0F, false);

        rightleg = new ModelRenderer(this);
        rightleg.setRotationPoint(-2.0F, 13.0F, 3.0F);
        rightleg.setTextureOffset(0, 30).addBox(-2.0F, 0.0F, -2.0F, 3.0F, 11.0F, 4.0F, 0.0F, false);

        leftarm = new ModelRenderer(this);
        leftarm.setRotationPoint(4.0F, 8.0F, -4.0F);
        leftarm.setTextureOffset(22, 26).addBox(-1.0F, -2.0F, -2.0F, 4.0F, 18.0F, 4.0F, 0.0F, false);

        leftleg = new ModelRenderer(this);
        leftleg.setRotationPoint(2.0F, 13.0F, 3.0F);
        leftleg.setTextureOffset(38, 18).addBox(-1.0F, 0.0F, -2.0F, 3.0F, 11.0F, 4.0F, 0.0F, false);

        head = new ModelRenderer(this);
        head.setRotationPoint(0.0F, 8.0F, -6.0F);
        head.setTextureOffset(0, 17).addBox(-3.5F, -5.0F, -5.0F, 7.0F, 7.0F, 6.0F, 0.0F, false);
        head.setTextureOffset(40, 0).addBox(-2.0F, -2.0F, -6.0F, 4.0F, 4.0F, 1.0F, 0.0F, false);
        head.setTextureOffset(38, 38).addBox(-6.0F, -4.0F, -3.0F, 3.0F, 3.0F, 2.0F, 0.0F, false);
        head.setTextureOffset(38, 33).addBox(3.0F, -4.0F, -3.0F, 3.0F, 3.0F, 2.0F, 0.0F, false);
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
        leftleg.render(matrixStack, buffer, packedLight, packedOverlay);
        leftarm.render(matrixStack, buffer, packedLight, packedOverlay);
        rightleg.render(matrixStack, buffer, packedLight, packedOverlay);
        rightarm.render(matrixStack, buffer, packedLight, packedOverlay);
        body.render(matrixStack, buffer, packedLight, packedOverlay);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }


    public void setLivingAnimations(T entityIn, float limbSwing, float limbSwingAmount, float partialTick) {
        int i = entityIn.getAttackTimer();
        if (i > 0) {
            this.leftarm.rotateAngleX = -0.9F + 0.9F * MathHelper.func_233021_e_((float)i - partialTick, 10.0F);
            this.rightarm.rotateAngleX = -0.9F + 0.9F * MathHelper.func_233021_e_((float)i - partialTick, 10.0F);
        }
    }

    public Iterable<ModelRenderer> getParts() {
        return ImmutableList.of(this.body, this.head, this.leftarm, this.rightarm, this.leftleg, this.rightleg);
    }


}
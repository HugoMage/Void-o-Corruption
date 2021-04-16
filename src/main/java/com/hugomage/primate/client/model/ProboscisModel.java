package com.hugomage.primate.client.model;

import com.hugomage.primate.entities.OrangutanEntity;
import com.hugomage.primate.entities.ProboscisEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class ProboscisModel<T extends ProboscisEntity> extends EntityModel<T> {

    private final ModelRenderer body;
    private final ModelRenderer tail;
    private final ModelRenderer tail2;
    private final ModelRenderer head;
    private final ModelRenderer head_r1;
    private final ModelRenderer nose;
    private final ModelRenderer leftleg;
    private final ModelRenderer rightleg;
    private final ModelRenderer leftarm;
    private final ModelRenderer rightarm;

    public ProboscisModel() {
        textureWidth = 64;
        textureHeight = 64;

        body = new ModelRenderer(this);
        body.setRotationPoint(0.0F, 12.5F, 0.0F);
        body.setTextureOffset(17, 19).addBox(-4.5F, -4.75F, -8.0F, 9.0F, 7.0F, 5.0F, 0.0F, false);
        body.setTextureOffset(0, 0).addBox(-3.5F, -4.0F, -3.5F, 7.0F, 8.0F, 11.0F, 0.0F, false);

        tail = new ModelRenderer(this);
        tail.setRotationPoint(0.0F, 1.0F, -7.0F);
        body.addChild(tail);
        tail.setTextureOffset(0, 19).addBox(-1.0F, -4.5F, 13.5F, 2.0F, 2.0F, 4.0F, 0.1F, false);

        tail2 = new ModelRenderer(this);
        tail2.setRotationPoint(0.0F, -4.0F, 18.0F);
        tail.addChild(tail2);
        setRotationAngle(tail2, -0.829F, 0.0F, 0.0F);
        tail2.setTextureOffset(0, 19).addBox(-1.0F, 0.0F, -0.75F, 2.0F, 2.0F, 13.0F, 0.0F, false);

        head = new ModelRenderer(this);
        head.setRotationPoint(0.0F, 12.5F, -8.0F);


        head_r1 = new ModelRenderer(this);
        head_r1.setRotationPoint(0.0F, 11.5F, 8.0F);
        head.addChild(head_r1);
        setRotationAngle(head_r1, 0.0F, 3.1416F, 0.0F);
        head_r1.setTextureOffset(25, 0).addBox(-2.5F, -16.5F, 8.0F, 5.0F, 6.0F, 4.0F, 0.0F, false);

        nose = new ModelRenderer(this);
        nose.setRotationPoint(0.0F, -2.5F, -3.0F);
        head.addChild(nose);
        setRotationAngle(nose, -0.6109F, 0.0F, 0.0F);
        nose.setTextureOffset(0, 0).addBox(-1.0F, -0.25F, -1.25F, 2.0F, 4.0F, 2.0F, 0.0F, false);

        leftleg = new ModelRenderer(this);
        leftleg.setRotationPoint(3.0F, 15.0F, 5.0F);
        leftleg.setTextureOffset(26, 31).addBox(-1.0F, -2.0F, -2.25F, 2.0F, 11.0F, 4.0F, 0.0F, false);

        rightleg = new ModelRenderer(this);
        rightleg.setRotationPoint(-3.0F, 15.0F, 5.0F);
        rightleg.setTextureOffset(0, 34).addBox(-1.0F, -2.0F, -2.25F, 2.0F, 11.0F, 4.0F, 0.0F, false);

        leftarm = new ModelRenderer(this);
        leftarm.setRotationPoint(3.0F, 14.0F, -5.0F);
        leftarm.setTextureOffset(12, 34).addBox(-1.75F, -1.0F, -1.75F, 3.0F, 11.0F, 3.0F, 0.0F, false);

        rightarm = new ModelRenderer(this);
        rightarm.setRotationPoint(-3.0F, 14.0F, -5.0F);
        rightarm.setTextureOffset(38, 31).addBox(-1.25F, -1.0F, -1.75F, 3.0F, 11.0F, 3.0F, 0.0F, false);
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
        body.render(matrixStack, buffer, packedLight, packedOverlay);
        head.render(matrixStack, buffer, packedLight, packedOverlay);
        leftleg.render(matrixStack, buffer, packedLight, packedOverlay);
        rightleg.render(matrixStack, buffer, packedLight, packedOverlay);
        leftarm.render(matrixStack, buffer, packedLight, packedOverlay);
        rightarm.render(matrixStack, buffer, packedLight, packedOverlay);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
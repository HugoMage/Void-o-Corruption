package com.hugomage.primate.client.model;

import com.hugomage.primate.entities.MandrillEntity;
import com.hugomage.primate.entities.OrangutanEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class MandrillModel<T extends MandrillEntity> extends EntityModel<T> {
    private final ModelRenderer head;
    private final ModelRenderer cube_r1;
    private final ModelRenderer body;
    private final ModelRenderer tail;
    private final ModelRenderer leftarm;
    private final ModelRenderer leftleg;
    private final ModelRenderer rightarm;
    private final ModelRenderer rightleg;

    public MandrillModel() {
        textureWidth = 64;
        textureHeight = 64;

        head = new ModelRenderer(this);
        head.setRotationPoint(0.0F, 10.0F, -3.0F);
        head.setTextureOffset(0, 23).addBox(-4.0F, -7.0F, -5.0F, 8.0F, 8.0F, 6.0F, 0.0F, false);

        cube_r1 = new ModelRenderer(this);
        cube_r1.setRotationPoint(4.0F, -11.0F, -1.0F);
        head.addChild(cube_r1);
        setRotationAngle(cube_r1, -0.5236F, 0.0F, 0.0F);
        cube_r1.setTextureOffset(40, 18).addBox(-6.0F, 7.0F, 0.0F, 4.0F, 6.0F, 3.0F, 0.0F, false);

        body = new ModelRenderer(this);
        body.setRotationPoint(0.0F, 11.0F, 4.0F);
        setRotationAngle(body, 1.4399F, 0.0F, 0.0F);
        body.setTextureOffset(0, 0).addBox(-5.0F, -7.9057F, -2.6011F, 10.0F, 16.0F, 7.0F, 0.0F, false);

        tail = new ModelRenderer(this);
        tail.setRotationPoint(0.0F, 8.0943F, 3.3989F);
        body.addChild(tail);
        setRotationAngle(tail, 2.138F, 0.0F, 0.0F);
        tail.setTextureOffset(40, 37).addBox(-1.0F, -0.8187F, -2.9629F, 2.0F, 2.0F, 4.0F, 0.0F, false);

        leftarm = new ModelRenderer(this);
        leftarm.setRotationPoint(4.0F, 12.0F, 0.0F);
        leftarm.setTextureOffset(34, 0).addBox(-2.0F, -2.0F, -3.0F, 4.0F, 14.0F, 4.0F, 0.0F, false);

        leftleg = new ModelRenderer(this);
        leftleg.setRotationPoint(3.0F, 15.0F, 9.0F);
        leftleg.setTextureOffset(14, 37).addBox(-1.0F, -1.0F, -2.0F, 3.0F, 10.0F, 4.0F, 0.0F, false);

        rightarm = new ModelRenderer(this);
        rightarm.setRotationPoint(-4.0F, 12.0F, 0.0F);
        rightarm.setTextureOffset(28, 23).addBox(-2.0F, -2.0F, -3.0F, 4.0F, 14.0F, 4.0F, 0.0F, false);

        rightleg = new ModelRenderer(this);
        rightleg.setRotationPoint(-4.0F, 15.0F, 9.0F);
        rightleg.setTextureOffset(0, 37).addBox(-1.0F, -1.0F, -2.0F, 3.0F, 10.0F, 4.0F, 0.0F, false);
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

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }

    @Override
    public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
        head.render(matrixStack, buffer, packedLight, packedOverlay);
        body.render(matrixStack, buffer, packedLight, packedOverlay);
        leftarm.render(matrixStack, buffer, packedLight, packedOverlay);
        leftleg.render(matrixStack, buffer, packedLight, packedOverlay);
        rightarm.render(matrixStack, buffer, packedLight, packedOverlay);
        rightleg.render(matrixStack, buffer, packedLight, packedOverlay);
    }


}






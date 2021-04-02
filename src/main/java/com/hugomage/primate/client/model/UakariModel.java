package com.hugomage.primate.client.model;

import com.hugomage.primate.entities.OrangutanEntity;
import com.hugomage.primate.entities.UakariEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class UakariModel <T extends UakariEntity> extends EntityModel<T> {
    private final ModelRenderer body;
    private final ModelRenderer head;
    private final ModelRenderer leftleg;
    private final ModelRenderer rightleg;
    private final ModelRenderer leftarm;
    private final ModelRenderer rightarm;

    public UakariModel() {
        textureWidth = 64;
        textureHeight = 64;

        body = new ModelRenderer(this);
        body.setRotationPoint(0.0F, 15.0F, -2.0F);
        setRotationAngle(body, -0.0524F, 0.0F, 0.0F);
        body.setTextureOffset(0, 0).addBox(-3.0F, -4.117F, -5.5317F, 6.0F, 7.0F, 14.0F, 0.0F, false);
        body.setTextureOffset(0, 21).addBox(-4.0F, -4.917F, -6.5317F, 8.0F, 8.0F, 8.0F, 0.0F, false);
        body.setTextureOffset(24, 29).addBox(-1.5F, -3.717F, 7.4683F, 3.0F, 3.0F, 8.0F, 0.0F, false);

        head = new ModelRenderer(this);
        head.setRotationPoint(0.0F, 12.0F, -8.0F);
        head.setTextureOffset(26, 0).addBox(-3.0F, -4.0F, -5.0F, 6.0F, 6.0F, 6.0F, 0.0F, false);
        head.setTextureOffset(0, 10).addBox(-2.0F, -1.0F, -6.0F, 4.0F, 3.0F, 1.0F, 0.0F, false);

        leftleg = new ModelRenderer(this);
        leftleg.setRotationPoint(2.0F, 19.0F, 4.0F);
        leftleg.setTextureOffset(24, 21).addBox(-1.1F, -1.0F, -1.0F, 2.0F, 6.0F, 2.0F, 0.0F, false);

        rightleg = new ModelRenderer(this);
        rightleg.setRotationPoint(-2.0F, 19.0F, 4.0F);
        rightleg.setTextureOffset(0, 21).addBox(-0.9F, -1.0F, -1.0F, 2.0F, 6.0F, 2.0F, 0.0F, false);

        leftarm = new ModelRenderer(this);
        leftarm.setRotationPoint(3.0F, 18.0F, -5.0F);
        leftarm.setTextureOffset(0, 37).addBox(-1.2F, -1.0F, -2.0F, 2.0F, 7.0F, 3.0F, 0.0F, false);

        rightarm = new ModelRenderer(this);
        rightarm.setRotationPoint(-3.0F, 19.0F, -5.0F);
        rightarm.setTextureOffset(0, 0).addBox(-0.8F, -2.0F, -2.0F, 2.0F, 7.0F, 3.0F, 0.0F, false);
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

    @Override
    public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.head.rotateAngleX = headPitch * ((float)Math.PI / 180F);
        this.head.rotateAngleY = netHeadYaw * ((float)Math.PI / 180F);
        this.rightleg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.leftleg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
        this.rightarm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
        this.leftarm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
    }
}

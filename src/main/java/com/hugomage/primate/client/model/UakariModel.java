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
    private final ModelRenderer rightleg;
    private final ModelRenderer leftleg;
    private final ModelRenderer rightarm;
    private final ModelRenderer leftarm;
    private final ModelRenderer body;
    private final ModelRenderer cube_r1;
    private final ModelRenderer head;

    public UakariModel() {
        textureWidth = 32;
        textureHeight = 32;

        rightleg = new ModelRenderer(this);
        rightleg.setRotationPoint(-2.0F, 20.0F, 3.0F);
        rightleg.setTextureOffset(24, 22).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);

        leftleg = new ModelRenderer(this);
        leftleg.setRotationPoint(2.0F, 20.0F, 3.0F);
        leftleg.setTextureOffset(24, 22).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);

        rightarm = new ModelRenderer(this);
        rightarm.setRotationPoint(-2.0F, 20.0F, -3.0F);
        rightarm.setTextureOffset(24, 22).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);

        leftarm = new ModelRenderer(this);
        leftarm.setRotationPoint(2.0F, 20.0F, -3.0F);
        leftarm.setTextureOffset(24, 22).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);

        body = new ModelRenderer(this);
        body.setRotationPoint(0.0F, 18.0F, -1.0F);
        body.setTextureOffset(0, 18).addBox(-3.0F, -2.0F, -4.0F, 6.0F, 4.0F, 10.0F, 0.0F, false);

        cube_r1 = new ModelRenderer(this);
        cube_r1.setRotationPoint(0.0F, 6.0F, 1.0F);
        body.addChild(cube_r1);
        setRotationAngle(cube_r1, -0.2182F, 0.0F, 0.0F);
        cube_r1.setTextureOffset(8, 4).addBox(-1.0F, -8.0F, 2.0F, 2.0F, 2.0F, 10.0F, 0.0F, false);

        head = new ModelRenderer(this);
        head.setRotationPoint(0.0F, 18.0F, -6.0F);
        head.setTextureOffset(0, 0).addBox(-3.0F, -4.0F, -2.0F, 6.0F, 5.0F, 3.0F, 0.0F, false);
        head.setTextureOffset(18, 0).addBox(-2.0F, -2.0F, -3.0F, 4.0F, 3.0F, 1.0F, 0.0F, false);
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
        this.rightleg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * -1.4F * limbSwingAmount;
        this.leftleg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
        this.rightarm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * -1.4F * limbSwingAmount;
        this.leftarm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.cube_r1.rotateAngleY = MathHelper.cos(limbSwing * 0.6662F) * 0.3F * limbSwingAmount;

    }


}

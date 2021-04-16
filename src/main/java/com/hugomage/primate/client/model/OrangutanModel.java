package com.hugomage.primate.client.model;

import com.hugomage.primate.entities.OrangutanEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.QuadrupedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

import javax.swing.text.html.parser.Entity;

public class OrangutanModel<T extends OrangutanEntity> extends EntityModel<T> {
    private final ModelRenderer head;
    private final ModelRenderer cube_r1;
    private final ModelRenderer body;
    private final ModelRenderer leftarm;
    private final ModelRenderer rightarm;
    private final ModelRenderer leftleg;
    private final ModelRenderer rightleg;

    public OrangutanModel() {
        textureWidth = 64;
        textureHeight = 64;

        head = new ModelRenderer(this);
        head.setRotationPoint(0.0F, 5.0F, 0.0F);
        head.setTextureOffset(0, 0).addBox(-6.0F, -7.0F, -9.0F, 12.0F, 9.0F, 9.0F, 0.0F, false);
        head.setTextureOffset(0, 58).addBox(-4.0F, -3.0F, -10.0F, 8.0F, 5.0F, 1.0F, 0.0F, false);
        head.setTextureOffset(50, 36).addBox(6.0F, -6.0F, -9.0F, 2.0F, 8.0F, 2.0F, 0.0F, false);
        head.setTextureOffset(56, 59).addBox(-5.0F, -5.0F, -7.0F, 2.0F, 3.0F, 2.0F, 0.0F, false);
        head.setTextureOffset(0, 0).addBox(3.0F, -5.0F, -5.0F, 2.0F, 3.0F, 2.0F, 0.0F, false);
        head.setTextureOffset(51, 36).addBox(-8.0F, -6.0F, -9.0F, 2.0F, 8.0F, 2.0F, 0.0F, false);

        body = new ModelRenderer(this);
        body.setRotationPoint(0.0F, 5.0F, 4.0F);

        cube_r1 = new ModelRenderer(this);
        cube_r1.setRotationPoint(0.0F, -4.0F, 0.0F);
        body.addChild(cube_r1);
        setRotationAngle(cube_r1, -20F, 0.0F, 0.0F);
        cube_r1.setTextureOffset(0, 22).addBox(-7.0F, -1.0F, -3.0F, 14.0F, 13.0F, 7.0F, 0.0F, false);


        leftarm = new ModelRenderer(this);
        leftarm.setRotationPoint(9.0F, 8.0F, 0.0F);
        leftarm.setTextureOffset(35, 42).addBox(-20.0F, -2.0F, -2.0F, 4.0F, 18.0F, 4.0F, 0.0F, false);

        rightarm = new ModelRenderer(this);
        rightarm.setRotationPoint(-9.0F, 8.0F, 0.0F);
        rightarm.setTextureOffset(35, 42).addBox(16.0F, -2.0F, -2.0F, 4.0F, 18.0F, 4.0F, 0.0F, false);

        leftleg = new ModelRenderer(this);
        leftleg.setRotationPoint(3.0F, 16.0F, 5.0F);
        leftleg.setTextureOffset(0, 39).addBox(-1.0F, -1.0F, -2.0F, 4.0F, 9.0F, 4.0F, 0.0F, false);

        rightleg = new ModelRenderer(this);
        rightleg.setRotationPoint(-4.0F, 17.0F, 4.0F);
        rightleg.setTextureOffset(0, 39).addBox(-2.0F, -2.0F, -1.0F, 4.0F, 9.0F, 4.0F, 0.0F, false);
    }


    @Override
    public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.head.rotateAngleX = headPitch * ((float)Math.PI / 180F);
        this.head.rotateAngleY = netHeadYaw * ((float)Math.PI / 180F);
        this.body.rotateAngleX = ((float)Math.PI / 2F);
        this.rightleg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.leftleg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
        this.rightarm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
        this.leftarm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
    }




    @Override
    public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
        head.render(matrixStack, buffer, packedLight, packedOverlay);
        body.render(matrixStack, buffer, packedLight, packedOverlay);
        leftarm.render(matrixStack, buffer, packedLight, packedOverlay);
        rightarm.render(matrixStack, buffer, packedLight, packedOverlay);
        leftleg.render(matrixStack, buffer, packedLight, packedOverlay);
        rightleg.render(matrixStack, buffer, packedLight, packedOverlay);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }

    public void setLivingAnimations(T entityIn, float limbSwing, float limbSwingAmount, float partialTick) {
        if (entityIn.getAttackTarget() != null) {
            this.rightarm.rotateAngleX += Math.PI;
            this.leftarm.rotateAngleX += Math.PI;
        }
}

}






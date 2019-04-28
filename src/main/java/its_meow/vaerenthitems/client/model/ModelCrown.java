package its_meow.vaerenthitems.client.model;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * Crown - Coda
 * Created using Tabula 7.0.0
 */
public class ModelCrown extends ModelBiped {

    public static final ModelCrown INSTANCE = new ModelCrown();
    public ModelRenderer base;
    public ModelRenderer crownFront1;
    public ModelRenderer crownFrontLeft;
    public ModelRenderer crownFrontRight;
    public ModelRenderer crownMiddleRight1;
    public ModelRenderer crownMiddleRight2;
    public ModelRenderer crownBackRight_1;
    public ModelRenderer crownBackLeft;
    public ModelRenderer crownMiddleRight2_1;
    public ModelRenderer crownMiddleRight2_2;
    public ModelRenderer crownBackRight_2;
    public ModelRenderer crownBackRight_3;
    public ModelRenderer crownFront2;

    public ModelCrown() {
        super(0, 0, 64, 64);
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.crownFront1 = new ModelRenderer(this, 0, 32);
        this.crownFront1.setRotationPoint(0.0F, -7.0F, -4.0F);
        this.crownFront1.addBox(-2.0F, -2.0F, -0.5F, 4, 2, 1, 0.0F);
        this.base = new ModelRenderer(this, 0, 35);
        this.base.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.base.addBox(-4.5F, -7.0F, -4.5F, 9, 1, 9, 0.0F);
        this.crownMiddleRight2_1 = new ModelRenderer(this, 0, 0);
        this.crownMiddleRight2_1.setRotationPoint(-4.0F, -7.0F, 1.5F);
        this.crownMiddleRight2_1.addBox(-0.5F, -1.5F, -0.5F, 1, 2, 1, 0.0F);
        this.crownBackLeft = new ModelRenderer(this, 0, 0);
        this.crownBackLeft.setRotationPoint(-4.0F, -7.0F, 4.0F);
        this.crownBackLeft.addBox(-0.5F, -1.5F, -0.5F, 1, 2, 1, 0.0F);
        this.crownMiddleRight2_2 = new ModelRenderer(this, 0, 0);
        this.crownMiddleRight2_2.setRotationPoint(-4.0F, -7.0F, -1.5F);
        this.crownMiddleRight2_2.addBox(-0.5F, -1.5F, -0.5F, 1, 2, 1, 0.0F);
        this.crownFront2 = new ModelRenderer(this, 0, 3);
        this.crownFront2.setRotationPoint(0.0F, -2.0F, 0.0F);
        this.crownFront2.addBox(-1.0F, -1.0F, -0.5F, 2, 1, 1, 0.0F);
        this.crownFrontLeft = new ModelRenderer(this, 0, 0);
        this.crownFrontLeft.setRotationPoint(-4.0F, -7.0F, -4.0F);
        this.crownFrontLeft.addBox(-0.5F, -1.5F, -0.5F, 1, 2, 1, 0.0F);
        this.crownMiddleRight2 = new ModelRenderer(this, 0, 0);
        this.crownMiddleRight2.setRotationPoint(4.0F, -7.0F, 1.5F);
        this.crownMiddleRight2.addBox(-0.5F, -1.5F, -0.5F, 1, 2, 1, 0.0F);
        this.crownFrontRight = new ModelRenderer(this, 0, 0);
        this.crownFrontRight.setRotationPoint(4.0F, -7.0F, -4.0F);
        this.crownFrontRight.addBox(-0.5F, -1.5F, -0.5F, 1, 2, 1, 0.0F);
        this.crownMiddleRight1 = new ModelRenderer(this, 0, 0);
        this.crownMiddleRight1.setRotationPoint(4.0F, -7.0F, -1.5F);
        this.crownMiddleRight1.addBox(-0.5F, -1.5F, -0.5F, 1, 2, 1, 0.0F);
        this.crownBackRight_2 = new ModelRenderer(this, 0, 0);
        this.crownBackRight_2.setRotationPoint(1.5F, -7.0F, 4.0F);
        this.crownBackRight_2.addBox(-0.5F, -1.5F, -0.5F, 1, 2, 1, 0.0F);
        this.crownBackRight_3 = new ModelRenderer(this, 0, 0);
        this.crownBackRight_3.setRotationPoint(-1.5F, -7.0F, 4.0F);
        this.crownBackRight_3.addBox(-0.5F, -1.5F, -0.5F, 1, 2, 1, 0.0F);
        this.crownBackRight_1 = new ModelRenderer(this, 0, 0);
        this.crownBackRight_1.setRotationPoint(4.0F, -7.0F, 4.0F);
        this.crownBackRight_1.addBox(-0.5F, -1.5F, -0.5F, 1, 2, 1, 0.0F);
        this.base.addChild(this.crownFront1);
        this.bipedHead.addChild(this.base);
        this.base.addChild(this.crownMiddleRight2_1);
        this.base.addChild(this.crownBackLeft);
        this.base.addChild(this.crownMiddleRight2_2);
        this.crownFront1.addChild(this.crownFront2);
        this.base.addChild(this.crownFrontLeft);
        this.base.addChild(this.crownMiddleRight2);
        this.base.addChild(this.crownFrontRight);
        this.base.addChild(this.crownMiddleRight1);
        this.base.addChild(this.crownBackRight_2);
        this.base.addChild(this.crownBackRight_3);
        this.base.addChild(this.crownBackRight_1);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        super.render(entity, f, f1, f2, f3, f4, f5);
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}

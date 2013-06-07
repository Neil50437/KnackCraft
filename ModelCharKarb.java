import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelCharKarb extends ModelBase
{
    //fields
    ModelRenderer Legleft;
    ModelRenderer Legright;
    ModelRenderer Body;
    ModelRenderer Head;

    public ModelCharKarb()
    {
        textureWidth = 64;
        textureHeight = 32;

        Legleft = new ModelRenderer(this, 11, 21);
        Legleft.addBox(-1F, 0F, -1F, 2, 6, 2);
        Legleft.setRotationPoint(2F, 18F, 0F);
        Legleft.setTextureSize(64, 32);
        Legleft.mirror = true;
        setRotation(Legleft, -1F, 0F, 2F);
        Legright = new ModelRenderer(this, 29, 21);
        Legright.addBox(-1F, 0F, -1F, 2, 6, 2);
        Legright.setRotationPoint(-2F, 18F, 0F);
        Legright.setTextureSize(64, 32);
        Legright.mirror = true;
        setRotation(Legright, 0F, 0F, 0F);
        Body = new ModelRenderer(this, 14, 10);
        Body.addBox(-3.5F, -3F, -2F, 7, 6, 4);
        Body.setRotationPoint(0F, 15.16667F, 0F);
        Body.setTextureSize(64, 32);
        Body.mirror = true;
        setRotation(Body, 0F, 0F, 0F);
        Head = new ModelRenderer(this, 17, 3);
        Head.addBox(-1.5F, -3F, -1.5F, 3, 3, 3);
        Head.setRotationPoint(0F, 12F, 0F);
        Head.setTextureSize(64, 32);
        Head.mirror = true;
        setRotation(Head, 0F, 0F, 0F);
        Head.addBox(1F, -1F, 4F, 5, 3, 3);
    }

    public void render(Entity par1Entity, float par2, float par3, float par4, float par5, float par6, float par7)
    {
        super.render(par1Entity, par2, par3, par4, par5, par6, par7);
        setRotationAngles(par2, par3, par4, par5, par6, par7, par1Entity);
        Legleft.render(par7);
        Legright.render(par7);
        Body.render(par7);
        Head.render(par7);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z)
    {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }
}
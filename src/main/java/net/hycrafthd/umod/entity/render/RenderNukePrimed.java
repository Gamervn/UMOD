package net.hycrafthd.umod.entity.render;

import net.hycrafthd.umod.UBlocks;
import net.hycrafthd.umod.entity.EntityNukePrimed;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BlockRendererDispatcher;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderNukePrimed extends Render {
	
    public RenderNukePrimed()
    {
        super(Minecraft.getMinecraft().getRenderManager());
        this.shadowSize = 0.5F;
    }
    
    public void doRender(EntityNukePrimed entity, double x, double y, double z, float p_76986_8_, float partialTicks)
    {
        BlockRendererDispatcher blockrendererdispatcher = Minecraft.getMinecraft().getBlockRendererDispatcher();
        GlStateManager.pushMatrix();
        GlStateManager.translate((float)x, (float)y + 0.5F, (float)z);
        float f2;

        if (entity.fuse - partialTicks + 1.0F < 10.0F)
        {
            f2 = 1.0F - (entity.fuse - partialTicks + 1.0F) / 10.0F;
            f2 = MathHelper.clamp_float(f2, 0.0F, 1.0F);
            f2 *= f2;
            f2 *= f2;
            float f3 = 1.0F + f2 * 0.3F;
            GlStateManager.scale(f3, f3, f3);
        }

        f2 = (1.0F - (entity.fuse - partialTicks + 1.0F) / 100.0F) * 0.8F;
        this.bindEntityTexture(entity);
        GlStateManager.translate(-0.5F, -0.5F, 0.5F);
        blockrendererdispatcher.renderBlockBrightness(UBlocks.blockNuke.getDefaultState(), entity.getBrightness(partialTicks));
        GlStateManager.translate(0.0F, 0.0F, 1.0F);

        if (entity.fuse / 5 % 2 == 0)
        {
            GlStateManager.disableTexture2D();
            GlStateManager.disableLighting();
            GlStateManager.enableBlend();
            GlStateManager.blendFunc(770, 772);
            GlStateManager.color(1.0F, 1.0F, 1.0F, f2);
            GlStateManager.doPolygonOffset(-3.0F, -3.0F);
            GlStateManager.enablePolygonOffset();
            blockrendererdispatcher.renderBlockBrightness(UBlocks.blockNuke.getDefaultState(), 1.0F);
            GlStateManager.doPolygonOffset(0.0F, 0.0F);
            GlStateManager.disablePolygonOffset();
            GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
            GlStateManager.disableBlend();
            GlStateManager.enableLighting();
            GlStateManager.enableTexture2D();
        }

        GlStateManager.popMatrix();
        super.doRender(entity, x, y, z, p_76986_8_, partialTicks);
        System.out.println("Render");
    }

    protected ResourceLocation func_180563_a(EntityNukePrimed p_180563_1_)
    {
        return TextureMap.locationBlocksTexture;
    }

    @Override
	protected ResourceLocation getEntityTexture(Entity entity)
    {
        return this.func_180563_a((EntityNukePrimed)entity);
    }
    
    @Override
	public void doRender(Entity entity, double x, double y, double z, float p_76986_8_, float partialTicks)
    {
        this.doRender((EntityNukePrimed)entity, x, y, z, p_76986_8_, partialTicks);
    }
}

package common.legobmw99.allomancy.particle;

import net.minecraft.client.particle.Particle;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.PlaySoundAtEntityEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ParticleSound extends Particle {


	double entityX,entityY,entityZ;
	
	public ParticleSound(World world, double x, double y, double z,
			double motionX, double motionY, double motionZ, PlaySoundAtEntityEvent event) {
		
		super(world, x, y, z, motionX, motionY, motionZ);

		this.motionX = motionX;
		this.motionY = motionY + 0.009D;
		this.motionZ = motionZ;
		this.setParticleTextureIndex(64);
		this.particleScale *= 1.2F;
		this.particleMaxAge = 15;
		this.field_190017_n = false; //canCollide
		entityX = event.getEntity().posX;
		entityX = event.getEntity().posX;
		entityX = event.getEntity().posX;

		if( event.getSound().toString().contains("step")){
			//Blue
			this.particleGreen = 0;
			this.particleBlue = 1F;
			this.particleRed = 0;
		}

		if (event.getSound().toString().contains("pig") 
				|| event.getSound().toString().contains("rabbit")
				|| event.getSound().toString().contains("sheep")
				|| event.getSound().toString().contains("cow") 
				|| event.getSound().toString().contains("cat")
				|| event.getSound().toString().contains("bat") 
				|| event.getSound().toString().contains("horse")
				 || event.getSound().toString().contains("wolf")
				|| event.getSound().toString().contains("mooshroom")
				|| event.getSound().toString().contains("villager")
				|| event.getSound().toString().contains("golem") 
				|| event.getSound().toString().contains("chicken")) {
			//Green
			this.particleGreen = 1;
			this.particleBlue = 0.25F;
			this.particleRed = 0;
		}

		if (event.getSound().toString().contains("skeleton") 
				|| event.getSound().toString().contains("hostile")
				|| event.getSound().toString().contains("zombie")
				|| event.getSound().toString().contains("slime")
				|| event.getSound().toString().contains("silverfish")
				|| event.getSound().toString().contains("spider") 
				|| event.getSound().toString().contains("blaze") 
				|| event.getSound().toString().contains("witch")
				|| event.getSound().toString().contains("guardian")
				|| event.getSound().toString().contains("magmacube")
				|| event.getSound().toString().contains("endermen")
				|| event.getSound().toString().contains("enderdragon")
				|| event.getSound().toString().contains("ghast")
				|| event.getSound().toString().contains("spider") 
				|| event.getSound().toString().contains("silverfish")
				|| event.getSound().toString().contains("creeper")
				|| event.getSound().toString().contains("bow")) {
			//Red
			this.particleGreen = 0.15F;
			this.particleBlue = 0.15F;
			this.particleRed = 1;
		}


	}
	
	@Override
	public void onUpdate() {
		if (((this.posX - entityX) < 1.7) &&((this.posY - entityY) < 2.5) &&((this.posZ - entityZ) < 1.7)){
			this.setExpired();
	}
		
		this.prevPosX = this.posX;
		this.prevPosY = this.posY;
		this.prevPosZ = this.posZ;

		if (this.particleAge++ >= this.particleMaxAge) {
			this.setExpired();
		}

		this.moveEntity(this.motionX, this.motionY, this.motionZ);

	}
	/* Old, antequated code which allowed for custom textures. May come back one day
	 * 
	@Override
	public int getFXLayer() {
		return 3;
	}
	
	@Override
	public void func_180434_a(WorldRenderer wr, Entity e, float p3, float p4, float p5, float p6, float p7, float p8)
	{

		Minecraft.getMinecraft().getTextureManager().bindTexture(loc);

       	wr.startDrawingQuads();
       	super.func_180434_a(wr, e, p3, p4, p5, p6, p7, p8);
       	Tessellator.getInstance().draw();
       	GlStateManager.disableBlend();
       	GlStateManager.enableLighting();
	}*/

}

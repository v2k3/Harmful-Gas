/*   */ package vini2003.xyz.harmfulgas.registry.client;
/*   */ 
/*   */ import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
/*   */ import net.minecraft.class_2396;
/*   */ 
/*   */ public class HarmfulGasParticleFactories {
/*   */   public static void initialize() {
/* 8 */     ParticleFactoryRegistry.getInstance().register((class_2396)HarmfulGasParticleTypes.GAS, vini2003.xyz.harmfulgas.client.particle.GasCloudParticle.Factory::new);
/*   */   }
/*   */ }


/* Location:              /Users/alex/BAK/vini2003/Mods/Harmful Gas/1.0.4/harmfulgas-1.0.4+1.16.5.jar!/vini2003/xyz/harmfulgas/registry/client/HarmfulGasParticleFactories.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
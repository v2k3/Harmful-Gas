/*    */ package vini2003.xyz.harmfulgas;
/*    */ import net.fabricmc.api.ClientModInitializer;
/*    */ import net.fabricmc.api.EnvType;
/*    */ import net.fabricmc.api.Environment;
/*    */ import vini2003.xyz.harmfulgas.registry.client.HarmfulGasCallbacks;
/*    */ import vini2003.xyz.harmfulgas.registry.client.HarmfulGasNetworking;
/*    */ import vini2003.xyz.harmfulgas.registry.client.HarmfulGasParticleTypes;
/*    */ 
/*    */ @Environment(EnvType.CLIENT)
/*    */ public class HarmfulGasClient implements ClientModInitializer {
/*    */   public void onInitializeClient() {
/* 12 */     HarmfulGasCallbacks.initialize();
/* 13 */     HarmfulGasParticleTypes.initialize();
/* 14 */     HarmfulGasParticleFactories.initialize();
/* 15 */     HarmfulGasNetworking.initialize();
/* 16 */     HarmfulGasTextureSheets.initialize();
/*    */   }
/*    */ }


/* Location:              /Users/alex/BAK/vini2003/Mods/Harmful Gas/1.0.4/harmfulgas-1.0.4+1.16.5.jar!/vini2003/xyz/harmfulgas/HarmfulGasClient.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
/*    */ package vini2003.xyz.harmfulgas.registry.client;
/*    */ 
/*    */ import net.fabricmc.fabric.api.client.rendering.v1.WorldRenderContext;
/*    */ import net.fabricmc.fabric.api.client.rendering.v1.WorldRenderEvents;
/*    */ import vini2003.xyz.harmfulgas.client.util.GasParticleUtils;
/*    */ 
/*    */ public class HarmfulGasCallbacks {
/*    */   private static void recalculateRotatedVertices(WorldRenderContext context) {
/*  9 */     GasParticleUtils.recalculateRotatedVertices(context);
/*    */   }
/*    */   
/*    */   public static void initialize() {
/* 13 */     WorldRenderEvents.START.register(HarmfulGasCallbacks::recalculateRotatedVertices);
/*    */   }
/*    */ }


/* Location:              /Users/alex/BAK/vini2003/Mods/Harmful Gas/1.0.4/harmfulgas-1.0.4+1.16.5.jar!/vini2003/xyz/harmfulgas/registry/client/HarmfulGasCallbacks.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
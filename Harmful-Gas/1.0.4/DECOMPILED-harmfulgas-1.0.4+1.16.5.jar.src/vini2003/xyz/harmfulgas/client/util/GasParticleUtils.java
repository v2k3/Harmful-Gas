/*    */ package vini2003.xyz.harmfulgas.client.util;
/*    */ 
/*    */ import net.fabricmc.fabric.api.client.rendering.v1.WorldRenderContext;
/*    */ import net.minecraft.class_1160;
/*    */ 
/*    */ public class GasParticleUtils
/*    */ {
/*    */   public static class_1160[] rotatedVertices;
/*    */   public static boolean shouldClear = false;
/*    */   
/*    */   public static void recalculateRotatedVertices(WorldRenderContext context) {
/* 12 */     class_1160[] newRotatedVertices = { new class_1160(-6.0F, -6.0F, 0.0F), new class_1160(-6.0F, 6.0F, 0.0F), new class_1160(6.0F, 6.0F, 0.0F), new class_1160(6.0F, -6.0F, 0.0F) };
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 19 */     for (int i = 0; i < 4; i++) {
/* 20 */       class_1160 vertex = newRotatedVertices[i];
/*    */       
/* 22 */       vertex.method_19262(context.camera().method_23767());
/*    */     } 
/*    */     
/* 25 */     rotatedVertices = newRotatedVertices;
/*    */   }
/*    */ }


/* Location:              /Users/alex/BAK/vini2003/Mods/Harmful Gas/1.0.4/harmfulgas-1.0.4+1.16.5.jar!/vini2003/xyz/harmfulgas/client/util/GasParticleUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
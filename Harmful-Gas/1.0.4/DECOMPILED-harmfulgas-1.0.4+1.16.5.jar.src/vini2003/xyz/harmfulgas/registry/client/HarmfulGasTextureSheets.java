/*    */ package vini2003.xyz.harmfulgas.registry.client;
/*    */ 
/*    */ import com.mojang.blaze3d.systems.RenderSystem;
/*    */ import net.minecraft.class_1059;
/*    */ import net.minecraft.class_1060;
/*    */ import net.minecraft.class_287;
/*    */ import net.minecraft.class_289;
/*    */ import net.minecraft.class_290;
/*    */ import net.minecraft.class_3999;
/*    */ import net.minecraft.class_4493;
/*    */ 
/*    */ public class HarmfulGasTextureSheets {
/* 13 */   public static final class_3999 GAS = new class_3999() {
/*    */       public void method_18130(class_287 bufferBuilder, class_1060 textureManager) {
/* 15 */         textureManager.method_22813(class_1059.field_17898);
/*    */         
/* 17 */         RenderSystem.enableBlend();
/* 18 */         RenderSystem.depthMask(false);
/* 19 */         RenderSystem.blendFuncSeparate(class_4493.class_4535.field_22541, class_4493.class_4534.field_22523, class_4493.class_4535.field_22534, class_4493.class_4534.field_22527);
/* 20 */         RenderSystem.alphaFunc(516, 0.003921569F);
/*    */         
/* 22 */         bufferBuilder.method_1328(7, class_290.field_1584);
/*    */       }
/*    */       
/*    */       public void method_18131(class_289 tessellator) {
/* 26 */         tessellator.method_1350();
/*    */       }
/*    */     };
/*    */   
/*    */   public static void initialize() {}
/*    */ }


/* Location:              /Users/alex/BAK/vini2003/Mods/Harmful Gas/1.0.4/harmfulgas-1.0.4+1.16.5.jar!/vini2003/xyz/harmfulgas/registry/client/HarmfulGasTextureSheets.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
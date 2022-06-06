/*    */ package vini2003.xyz.harmfulgas;
/*    */ 
/*    */ import net.fabricmc.api.ModInitializer;
/*    */ import net.minecraft.class_2960;
/*    */ import vini2003.xyz.harmfulgas.registry.common.HarmfulGasCallbacks;
/*    */ import vini2003.xyz.harmfulgas.registry.common.HarmfulGasCommands;
/*    */ import vini2003.xyz.harmfulgas.registry.common.HarmfulGasComponents;
/*    */ 
/*    */ public class HarmfulGas implements ModInitializer {
/*    */   public static final String ID = "harmfulgas";
/*    */   
/*    */   public static class_2960 identifier(String path) {
/* 13 */     return new class_2960("harmfulgas", path);
/*    */   }
/*    */ 
/*    */   
/*    */   public void onInitialize() {
/* 18 */     HarmfulGasCommands.initialize();
/* 19 */     HarmfulGasComponents.initialize();
/* 20 */     HarmfulGasCallbacks.initialize();
/*    */   }
/*    */ }


/* Location:              /Users/alex/BAK/vini2003/Mods/Harmful Gas/1.0.4/harmfulgas-1.0.4+1.16.5.jar!/vini2003/xyz/harmfulgas/HarmfulGas.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
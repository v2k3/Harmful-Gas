/*    */ package vini2003.xyz.harmfulgas.mixin.client;
/*    */ 
/*    */ import com.google.common.collect.EvictingQueue;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import java.util.Queue;
/*    */ import net.minecraft.class_3999;
/*    */ import net.minecraft.class_702;
/*    */ import net.minecraft.class_703;
/*    */ import org.spongepowered.asm.mixin.Final;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.Mutable;
/*    */ import org.spongepowered.asm.mixin.Shadow;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Inject;
/*    */ import org.spongepowered.asm.mixin.injection.Redirect;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
/*    */ import vini2003.xyz.harmfulgas.client.util.GasParticleUtils;
/*    */ import vini2003.xyz.harmfulgas.registry.client.HarmfulGasTextureSheets;
/*    */ 
/*    */ 
/*    */ @Mixin({class_702.class})
/*    */ public class ParticleManagerMixin
/*    */ {
/*    */   @Final
/*    */   @Shadow
/*    */   @Mutable
/*    */   private static List<class_3999> field_17820;
/*    */   @Shadow
/*    */   @Final
/*    */   private Map<class_3999, Queue<class_703>> field_3830;
/*    */   
/*    */   @Redirect(at = @At(value = "INVOKE", target = "Lcom/google/common/collect/EvictingQueue;create(I)Lcom/google/common/collect/EvictingQueue;"), method = {"method_18125"})
/*    */   private static <E> EvictingQueue<E> harmfulgas_method_18125(int maxSize) {
/* 36 */     return EvictingQueue.create(131072);
/*    */   }
/*    */   
/*    */   @Inject(at = {@At("HEAD")}, method = {"tick"})
/*    */   void harmfulgas_tick(CallbackInfo ci) {
/* 41 */     if (GasParticleUtils.shouldClear) {
/* 42 */       if (this.field_3830 != null && 
/* 43 */         this.field_3830.containsKey(HarmfulGasTextureSheets.GAS)) {
/* 44 */         ((Queue)this.field_3830.get(HarmfulGasTextureSheets.GAS)).clear();
/*    */       }
/*    */ 
/*    */       
/* 48 */       GasParticleUtils.shouldClear = false;
/*    */     } 
/*    */   }
/*    */   
/*    */   static {
/* 53 */     List<class_3999> newSheets = new ArrayList<>();
/*    */     
/* 55 */     newSheets.addAll(field_17820);
/*    */     
/* 57 */     newSheets.add(HarmfulGasTextureSheets.GAS);
/*    */     
/* 59 */     field_17820 = newSheets;
/*    */   }
/*    */ }


/* Location:              /Users/alex/BAK/vini2003/Mods/Harmful Gas/1.0.4/harmfulgas-1.0.4+1.16.5.jar!/vini2003/xyz/harmfulgas/mixin/client/ParticleManagerMixin.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
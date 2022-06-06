/*    */ package vini2003.xyz.harmfulgas.client.particle;
/*    */ import java.util.Random;
/*    */ import net.minecraft.class_1058;
/*    */ import net.minecraft.class_2394;
/*    */ import net.minecraft.class_2400;
/*    */ import net.minecraft.class_4002;
/*    */ import net.minecraft.class_4184;
/*    */ import net.minecraft.class_4588;
/*    */ import net.minecraft.class_638;
/*    */ import net.minecraft.class_703;
/*    */ import org.jetbrains.annotations.Nullable;
/*    */ import vini2003.xyz.harmfulgas.client.util.GasParticleUtils;
/*    */ 
/*    */ public class GasCloudParticle extends class_4003 {
/*    */   public GasCloudParticle(class_638 clientWorld, double x, double y, double z) {
/* 16 */     super(clientWorld, x, y, z);
/*    */   }
/*    */ 
/*    */   
/*    */   public void method_3074(class_4588 vertexConsumer, class_4184 camera, float tickDelta) {
/* 21 */     if (this.field_3841 < 0.25F) {
/* 22 */       this.field_3841 += 5.0E-4F;
/*    */     } else {
/* 24 */       this.field_3841 = 0.25F;
/*    */     } 
/*    */     
/* 27 */     if (ClientUtils.getPlayer().method_5649(this.field_3874, this.field_3854, this.field_3871) > 36864.0D) {
/*    */       return;
/*    */     }
/*    */     
/* 31 */     float cX = (float)(this.field_3874 - camera.method_19326().method_10216());
/* 32 */     float cY = (float)(this.field_3854 - camera.method_19326().method_10214());
/* 33 */     float cZ = (float)(this.field_3871 - camera.method_19326().method_10215());
/*    */     
/* 35 */     vertexConsumer.method_22912((GasParticleUtils.rotatedVertices[0].method_4943() + cX), (GasParticleUtils.rotatedVertices[0].method_4945() + cY), (GasParticleUtils.rotatedVertices[0].method_4947() + cZ)).method_22913(method_18134(), method_18136()).method_22915(this.field_3861, this.field_3842, this.field_3859, this.field_3841).method_22916(15728880).method_1344();
/* 36 */     vertexConsumer.method_22912((GasParticleUtils.rotatedVertices[1].method_4943() + cX), (GasParticleUtils.rotatedVertices[1].method_4945() + cY), (GasParticleUtils.rotatedVertices[1].method_4947() + cZ)).method_22913(method_18134(), method_18135()).method_22915(this.field_3861, this.field_3842, this.field_3859, this.field_3841).method_22916(15728880).method_1344();
/* 37 */     vertexConsumer.method_22912((GasParticleUtils.rotatedVertices[2].method_4943() + cX), (GasParticleUtils.rotatedVertices[2].method_4945() + cY), (GasParticleUtils.rotatedVertices[2].method_4947() + cZ)).method_22913(method_18133(), method_18135()).method_22915(this.field_3861, this.field_3842, this.field_3859, this.field_3841).method_22916(15728880).method_1344();
/* 38 */     vertexConsumer.method_22912((GasParticleUtils.rotatedVertices[3].method_4943() + cX), (GasParticleUtils.rotatedVertices[3].method_4945() + cY), (GasParticleUtils.rotatedVertices[3].method_4947() + cZ)).method_22913(method_18133(), method_18136()).method_22915(this.field_3861, this.field_3842, this.field_3859, this.field_3841).method_22916(15728880).method_1344();
/*    */   }
/*    */ 
/*    */   
/*    */   public class_3999 method_18122() {
/* 43 */     return HarmfulGasTextureSheets.GAS;
/*    */   }
/*    */   
/*    */   public static class Factory implements class_707<class_2400> {
/*    */     private final class_4002 spriteProvider;
/*    */     
/*    */     public Factory(class_4002 spriteProvider) {
/* 50 */       this.spriteProvider = spriteProvider;
/*    */     }
/*    */ 
/*    */     
/*    */     @Nullable
/*    */     public class_703 createParticle(class_2400 parameters, class_638 world, double x, double y, double z, double velocityX, double velocityY, double velocityZ) {
/* 56 */       GasCloudParticle gasCloudParticle = new GasCloudParticle(world, x, y, z);
/* 57 */       gasCloudParticle.field_17886 = this.spriteProvider.method_18139(gasCloudParticle.field_3840);
/* 58 */       gasCloudParticle.field_3847 = 2147483647;
/* 59 */       gasCloudParticle.field_17867 = 6.0F;
/* 60 */       gasCloudParticle.field_3841 = 0.0F;
/*    */       
/* 62 */       return (class_703)gasCloudParticle;
/*    */     }
/*    */   }
/*    */ }


/* Location:              /Users/alex/BAK/vini2003/Mods/Harmful Gas/1.0.4/harmfulgas-1.0.4+1.16.5.jar!/vini2003/xyz/harmfulgas/client/particle/GasCloudParticle.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
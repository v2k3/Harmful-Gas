/*    */ package vini2003.xyz.harmfulgas.registry.client;
/*    */ import io.netty.buffer.Unpooled;
/*    */ import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
/*    */ import net.fabricmc.fabric.api.networking.v1.PacketSender;
/*    */ import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
/*    */ import net.minecraft.class_1657;
/*    */ import net.minecraft.class_2338;
/*    */ import net.minecraft.class_2394;
/*    */ import net.minecraft.class_2540;
/*    */ import net.minecraft.class_2960;
/*    */ import net.minecraft.class_310;
/*    */ import net.minecraft.class_3222;
/*    */ import net.minecraft.class_634;
/*    */ import vini2003.xyz.harmfulgas.HarmfulGas;
/*    */ import vini2003.xyz.harmfulgas.client.util.GasParticleUtils;
/*    */ 
/*    */ public class HarmfulGasNetworking {
/* 18 */   public static final class_2960 ADD_GAS_CLOUD = HarmfulGas.identifier("add_gas_cloud");
/*    */   
/* 20 */   public static final class_2960 REFRESH_GAS_CLOUD = HarmfulGas.identifier("refresh_gas_cloud");
/*    */   
/*    */   private static void receiveAddGasCloudPacket(class_310 client, class_634 handler, class_2540 buf, PacketSender sender) {
/* 23 */     if (client.field_1687 != null) {
/* 24 */       client.field_1687.method_8406((class_2394)HarmfulGasParticleTypes.GAS, buf.readInt(), buf.readInt(), buf.readInt(), 0.0D, 0.0D, 0.0D);
/*    */     }
/*    */   }
/*    */   
/*    */   private static void receiveRefreshGasCloudPacket(class_310 client, class_634 handler, class_2540 buf, PacketSender sender) {
/* 29 */     GasParticleUtils.shouldClear = true;
/*    */   }
/*    */   
/*    */   public static void sendAddGasCloudPacket(class_1657 player, class_2338 pos) {
/* 33 */     class_2540 buf = new class_2540(Unpooled.buffer());
/*    */     
/* 35 */     buf.writeInt(pos.method_10263());
/* 36 */     buf.writeInt(pos.method_10264());
/* 37 */     buf.writeInt(pos.method_10260());
/*    */     
/* 39 */     ServerPlayNetworking.send((class_3222)player, ADD_GAS_CLOUD, buf);
/*    */   }
/*    */   
/*    */   public static void sendRefreshGasCloudPacket(class_1657 player) {
/* 43 */     class_2540 buf = new class_2540(Unpooled.buffer());
/*    */     
/* 45 */     ServerPlayNetworking.send((class_3222)player, REFRESH_GAS_CLOUD, buf);
/*    */   }
/*    */   
/*    */   public static void initialize() {
/* 49 */     ClientPlayNetworking.registerGlobalReceiver(ADD_GAS_CLOUD, HarmfulGasNetworking::receiveAddGasCloudPacket);
/*    */     
/* 51 */     ClientPlayNetworking.registerGlobalReceiver(REFRESH_GAS_CLOUD, HarmfulGasNetworking::receiveRefreshGasCloudPacket);
/*    */   }
/*    */ }


/* Location:              /Users/alex/BAK/vini2003/Mods/Harmful Gas/1.0.4/harmfulgas-1.0.4+1.16.5.jar!/vini2003/xyz/harmfulgas/registry/client/HarmfulGasNetworking.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
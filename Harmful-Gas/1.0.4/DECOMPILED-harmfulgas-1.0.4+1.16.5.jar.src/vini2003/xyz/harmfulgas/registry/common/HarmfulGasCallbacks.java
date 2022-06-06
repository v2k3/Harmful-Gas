/*    */ package vini2003.xyz.harmfulgas.registry.common;
/*    */ 
/*    */ import me.shedaniel.cloth.api.common.events.v1.PlayerLeaveCallback;
/*    */ import net.fabricmc.fabric.api.entity.event.v1.ServerEntityWorldChangeEvents;
/*    */ import net.fabricmc.fabric.api.entity.event.v1.ServerPlayerEvents;
/*    */ import net.minecraft.class_1657;
/*    */ import net.minecraft.class_1937;
/*    */ import vini2003.xyz.harmfulgas.common.component.WorldGasComponent;
/*    */ import vini2003.xyz.harmfulgas.registry.client.HarmfulGasNetworking;
/*    */ 
/*    */ public class HarmfulGasCallbacks {
/*    */   private static void playerChangeWorld(class_1657 player, class_1937 origin, class_1937 destination) {
/* 13 */     WorldGasComponent gasComponent = WorldGasComponent.get(origin);
/*    */     
/* 15 */     gasComponent.getParticles().remove(player.method_5667());
/* 16 */     gasComponent.getCooldowns().put(player.method_5667(), Integer.valueOf(150));
/*    */     
/* 18 */     HarmfulGasNetworking.sendRefreshGasCloudPacket(player);
/*    */   }
/*    */   
/*    */   private static void playerRespawn(class_1657 oldPlayer, class_1657 newPlayer, boolean alive) {
/* 22 */     WorldGasComponent gasComponent = WorldGasComponent.get(newPlayer.method_5770());
/*    */     
/* 24 */     gasComponent.getParticles().remove(newPlayer.method_5667());
/* 25 */     gasComponent.getCooldowns().put(newPlayer.method_5667(), Integer.valueOf(150));
/*    */     
/* 27 */     HarmfulGasNetworking.sendRefreshGasCloudPacket(newPlayer);
/*    */   }
/*    */   
/*    */   private static void playerLeave(class_1657 player) {
/* 31 */     WorldGasComponent gasComponent = WorldGasComponent.get(player.method_5770());
/*    */     
/* 33 */     gasComponent.getParticles().remove(player.method_5667());
/*    */   }
/*    */   
/*    */   public static void initialize() {
/* 37 */     ServerEntityWorldChangeEvents.AFTER_PLAYER_CHANGE_WORLD.register(HarmfulGasCallbacks::playerChangeWorld);
/*    */     
/* 39 */     ServerPlayerEvents.AFTER_RESPAWN.register(HarmfulGasCallbacks::playerRespawn);
/*    */     
/* 41 */     PlayerLeaveCallback.EVENT.register(HarmfulGasCallbacks::playerLeave);
/*    */   }
/*    */ }


/* Location:              /Users/alex/BAK/vini2003/Mods/Harmful Gas/1.0.4/harmfulgas-1.0.4+1.16.5.jar!/vini2003/xyz/harmfulgas/registry/common/HarmfulGasCallbacks.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
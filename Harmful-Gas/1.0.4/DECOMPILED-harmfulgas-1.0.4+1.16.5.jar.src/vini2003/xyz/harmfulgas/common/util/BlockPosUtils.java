/*    */ package vini2003.xyz.harmfulgas.common.util;
/*    */ 
/*    */ import java.util.List;
/*    */ import net.minecraft.class_1657;
/*    */ import net.minecraft.class_2338;
/*    */ 
/*    */ public class BlockPosUtils
/*    */ {
/*    */   public static double minimumSquaredDistance(List<? extends class_1657> players, class_2338 pos) {
/* 10 */     double minimumSquaredDistance = Double.MAX_VALUE;
/*    */     
/* 12 */     for (class_1657 player : players) {
/* 13 */       if (minimumSquaredDistance > squaredDistance(player, pos)) {
/* 14 */         minimumSquaredDistance = squaredDistance(player, pos);
/*    */       }
/*    */     } 
/*    */     
/* 18 */     return minimumSquaredDistance;
/*    */   }
/*    */   
/*    */   public static double squaredDistance(class_1657 player, class_2338 pos) {
/* 22 */     return player.method_5649(pos.method_10263() + 0.5D, pos.method_10264(), pos.method_10260() + 0.5D);
/*    */   }
/*    */ }


/* Location:              /Users/alex/BAK/vini2003/Mods/Harmful Gas/1.0.4/harmfulgas-1.0.4+1.16.5.jar!/vini2003/xyz/harmfulgas/common/util/BlockPosUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
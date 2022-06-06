/*    */ package vini2003.xyz.harmfulgas.common.util;
/*    */ 
/*    */ import net.minecraft.class_1937;
/*    */ import net.minecraft.class_2338;
/*    */ import net.minecraft.class_2902;
/*    */ 
/*    */ public class TimeUtils {
/*    */   public static int calculateMaximumHeight(class_1937 world, class_2338 pos, long age, int speed) {
/*  9 */     return Math.min(world.method_8598(class_2902.class_2903.field_13202, pos).method_10264() + 2, (int)(96.0F + (float)age / 1500.0F / (21 - speed)));
/*    */   }
/*    */   
/*    */   public static int calculateMinimumHeight(long age, int speed) {
/* 13 */     return (int)(48.0F - (float)age / 3000.0F / (21 - speed));
/*    */   }
/*    */ 
/*    */   
/*    */   public static int calculateMinimumDistance(long age, int speed) {
/* 18 */     return (int)(64.0F + (float)age / 375.0F / (21 - speed));
/*    */   }
/*    */   
/*    */   public static int calculateFollowTime(long age) {
/* 22 */     return (age < 600L) ? 200 : 600;
/*    */   }
/*    */ }


/* Location:              /Users/alex/BAK/vini2003/Mods/Harmful Gas/1.0.4/harmfulgas-1.0.4+1.16.5.jar!/vini2003/xyz/harmfulgas/common/util/TimeUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
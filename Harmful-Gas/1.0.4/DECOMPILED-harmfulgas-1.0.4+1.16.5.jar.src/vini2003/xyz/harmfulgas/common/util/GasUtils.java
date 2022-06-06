/*    */ package vini2003.xyz.harmfulgas.common.util;
/*    */ import net.minecraft.class_1922;
/*    */ import net.minecraft.class_1937;
/*    */ import net.minecraft.class_2338;
/*    */ import net.minecraft.class_2350;
/*    */ import net.minecraft.class_2378;
/*    */ import net.minecraft.class_2680;
/*    */ import net.minecraft.class_2769;
/*    */ 
/*    */ public class GasUtils {
/*    */   public static boolean isTraversableForPropagation(class_1937 world, class_2680 centerState, class_2338 centerPos, class_2680 sideState, class_2338 sidePos, class_2350 direction) {
/* 12 */     if (world == null) return false;
/*    */     
/* 14 */     return (sideState.method_26227().method_15769() && (
/* 15 */       !class_2378.field_11146.method_10221(sideState.method_26204()).toString().equals("astromine:airlock") || ((Boolean)sideState.method_11654((class_2769)class_2741.field_12484)).booleanValue()) && (sideState
/* 16 */       .method_26215() || !sideState.method_26206((class_1922)world, sidePos, direction.method_10153())) && (centerState
/* 17 */       .method_26215() || (!centerState.method_26206((class_1922)world, centerPos, direction) && 
/* 18 */       !sideState.method_26216((class_1922)world, centerPos))));
/*    */   }
/*    */ }


/* Location:              /Users/alex/BAK/vini2003/Mods/Harmful Gas/1.0.4/harmfulgas-1.0.4+1.16.5.jar!/vini2003/xyz/harmfulgas/common/util/GasUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
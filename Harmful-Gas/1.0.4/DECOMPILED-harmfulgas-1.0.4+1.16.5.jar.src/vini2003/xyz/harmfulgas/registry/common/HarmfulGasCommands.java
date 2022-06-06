/*    */ package vini2003.xyz.harmfulgas.registry.common;
/*    */ import com.mojang.brigadier.CommandDispatcher;
/*    */ import com.mojang.brigadier.arguments.IntegerArgumentType;
/*    */ import com.mojang.brigadier.builder.LiteralArgumentBuilder;
/*    */ import com.mojang.brigadier.context.CommandContext;
/*    */ import com.mojang.brigadier.exceptions.CommandSyntaxException;
/*    */ import com.mojang.brigadier.tree.CommandNode;
/*    */ import com.mojang.brigadier.tree.LiteralCommandNode;
/*    */ import net.minecraft.class_2168;
/*    */ import net.minecraft.class_2170;
/*    */ import net.minecraft.class_2561;
/*    */ import net.minecraft.class_2588;
/*    */ import net.minecraft.class_3218;
/*    */ import net.minecraft.class_3222;
/*    */ import vini2003.xyz.harmfulgas.common.component.WorldGasComponent;
/*    */ 
/*    */ public class HarmfulGasCommands {
/*    */   public static int start(CommandContext<class_2168> context) throws CommandSyntaxException {
/* 19 */     class_3218 class_3218 = ((class_2168)context.getSource()).method_9225();
/*    */     
/* 21 */     class_3222 class_3222 = ((class_2168)context.getSource()).method_9207();
/*    */     
/* 23 */     WorldGasComponent gasComponent = WorldGasComponent.get(class_3218);
/*    */     
/* 25 */     gasComponent.add(class_3218.method_27911());
/* 26 */     gasComponent.setOriginPos(class_3218.method_27911());
/* 27 */     gasComponent.getCooldowns().put(class_3222.method_5667(), Integer.valueOf(300));
/*    */     
/* 29 */     ((class_2168)context.getSource()).method_9226((class_2561)new class_2588("text.harmfulgas.start"), true);
/*    */     
/* 31 */     return 1;
/*    */   }
/*    */   
/*    */   public static int pause(CommandContext<class_2168> context) throws CommandSyntaxException {
/* 35 */     class_3218 class_3218 = ((class_2168)context.getSource()).method_9225();
/*    */     
/* 37 */     WorldGasComponent gasComponent = WorldGasComponent.get(class_3218);
/*    */     
/* 39 */     gasComponent.setPaused(true);
/*    */     
/* 41 */     ((class_2168)context.getSource()).method_9226((class_2561)new class_2588("text.harmfulgas.paused"), true);
/*    */     
/* 43 */     return 1;
/*    */   }
/*    */   
/*    */   public static int resume(CommandContext<class_2168> context) throws CommandSyntaxException {
/* 47 */     class_3218 class_3218 = ((class_2168)context.getSource()).method_9225();
/*    */     
/* 49 */     WorldGasComponent gasComponent = WorldGasComponent.get(class_3218);
/*    */     
/* 51 */     gasComponent.setPaused(false);
/*    */     
/* 53 */     ((class_2168)context.getSource()).method_9226((class_2561)new class_2588("text.harmfulgas.resumed"), true);
/*    */     
/* 55 */     return 1;
/*    */   }
/*    */ 
/*    */   
/*    */   public static int speed(CommandContext<class_2168> context) throws CommandSyntaxException {
/* 60 */     class_3218 class_3218 = ((class_2168)context.getSource()).method_9225();
/*    */     
/* 62 */     WorldGasComponent gasComponent = WorldGasComponent.get(class_3218);
/*    */     
/* 64 */     int speed = IntegerArgumentType.getInteger(context, "speed");
/*    */     
/* 66 */     ((class_2168)context.getSource()).method_9226((class_2561)new class_2588("text.harmfulgas.speed", new Object[] { Integer.valueOf(gasComponent.getSpeed()), Integer.valueOf(speed) }), true);
/*    */     
/* 68 */     gasComponent.setSpeed(speed);
/*    */     
/* 70 */     return 1;
/*    */   }
/*    */   
/*    */   public static int refresh(CommandContext<class_2168> context) throws CommandSyntaxException {
/* 74 */     class_3218 class_3218 = ((class_2168)context.getSource()).method_9225();
/*    */     
/* 76 */     class_3222 class_3222 = ((class_2168)context.getSource()).method_9207();
/*    */     
/* 78 */     WorldGasComponent gasComponent = WorldGasComponent.get(class_3218);
/*    */     
/* 80 */     HarmfulGasNetworking.sendRefreshGasCloudPacket((class_1657)class_3222);
/*    */     
/* 82 */     gasComponent.getParticles().remove(class_3222.method_5667());
/* 83 */     gasComponent.getCooldowns().put(class_3222.method_5667(), Integer.valueOf(150));
/*    */     
/* 85 */     ((class_2168)context.getSource()).method_9226((class_2561)new class_2588("text.harmfulgas.refresh"), true);
/*    */     
/* 87 */     return 1;
/*    */   }
/*    */   
/*    */   public static void initialize() {
/* 91 */     CommandRegistrationCallback.EVENT.register((dispatcher, dedicated) -> {
/*    */           LiteralCommandNode<class_2168> harmfulGasRoot = class_2170.method_9247("harmfulgas").build();
/*    */           LiteralCommandNode<class_2168> harmfulGasPlace = ((LiteralArgumentBuilder)((LiteralArgumentBuilder)class_2170.method_9247("start").requires(())).executes(HarmfulGasCommands::start)).build();
/*    */           LiteralCommandNode<class_2168> harmfulGasPause = ((LiteralArgumentBuilder)((LiteralArgumentBuilder)class_2170.method_9247("pause").requires(())).executes(HarmfulGasCommands::pause)).build();
/*    */           LiteralCommandNode<class_2168> harmfulGasResume = ((LiteralArgumentBuilder)((LiteralArgumentBuilder)class_2170.method_9247("resume").requires(())).executes(HarmfulGasCommands::resume)).build();
/*    */           LiteralCommandNode<class_2168> harmfulGasSpeed = ((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)class_2170.method_9247("speed").requires(())).then((CommandNode)((RequiredArgumentBuilder)class_2170.method_9244("speed", (ArgumentType)IntegerArgumentType.integer(1, 100)).executes(HarmfulGasCommands::speed)).build())).executes(HarmfulGasCommands::pause)).build();
/*    */           LiteralCommandNode<class_2168> harmfulGasRefresh = ((LiteralArgumentBuilder)((LiteralArgumentBuilder)class_2170.method_9247("refresh").requires(())).executes(HarmfulGasCommands::refresh)).build();
/*    */           harmfulGasRoot.addChild((CommandNode)harmfulGasPlace);
/*    */           harmfulGasRoot.addChild((CommandNode)harmfulGasPause);
/*    */           harmfulGasRoot.addChild((CommandNode)harmfulGasResume);
/*    */           harmfulGasRoot.addChild((CommandNode)harmfulGasSpeed);
/*    */           harmfulGasRoot.addChild((CommandNode)harmfulGasRefresh);
/*    */           dispatcher.getRoot().addChild((CommandNode)harmfulGasRoot);
/*    */         });
/*    */   }
/*    */ }


/* Location:              /Users/alex/BAK/vini2003/Mods/Harmful Gas/1.0.4/harmfulgas-1.0.4+1.16.5.jar!/vini2003/xyz/harmfulgas/registry/common/HarmfulGasCommands.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
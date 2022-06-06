/*     */ package vini2003.xyz.harmfulgas.common.component;
/*     */ import dev.onyxstudios.cca.api.v3.component.Component;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import java.util.UUID;
/*     */ import net.minecraft.class_1282;
/*     */ import net.minecraft.class_1657;
/*     */ import net.minecraft.class_1937;
/*     */ import net.minecraft.class_2338;
/*     */ import net.minecraft.class_2350;
/*     */ import net.minecraft.class_2487;
/*     */ import net.minecraft.class_2520;
/*     */ import net.minecraft.class_2680;
/*     */ import vini2003.xyz.harmfulgas.common.util.BlockPosUtils;
/*     */ import vini2003.xyz.harmfulgas.common.util.GasUtils;
/*     */ import vini2003.xyz.harmfulgas.common.util.TimeUtils;
/*     */ import vini2003.xyz.harmfulgas.registry.client.HarmfulGasNetworking;
/*     */ 
/*     */ public final class WorldGasComponent implements Component, ServerTickingComponent {
/*  23 */   private final Set<class_2338> nodes = new HashSet<>();
/*  24 */   private final List<class_2338> nodesIndexed = new ArrayList<>();
/*  25 */   private final Set<class_2338> nodesToAdd = new HashSet<>();
/*     */   
/*  27 */   private final Map<UUID, Set<class_2338>> particles = new HashMap<>();
/*     */   
/*  29 */   private final Map<UUID, Integer> cooldowns = new HashMap<>();
/*     */   
/*     */   private final class_1937 world;
/*     */   
/*  33 */   private class_2338 originPos = new class_2338(0, 0, 0);
/*     */   
/*     */   private boolean paused;
/*     */   
/*     */   private long age;
/*     */   
/*     */   private int progress;
/*     */   
/*     */   private int speed;
/*     */   
/*     */   public WorldGasComponent(class_1937 world) {
/*  44 */     this.world = world;
/*  45 */     this.paused = false;
/*  46 */     this.age = 0L;
/*  47 */     this.progress = 0;
/*  48 */     this.speed = 20;
/*     */   }
/*     */   
/*     */   public void add(class_2338 pos) {
/*  52 */     this.nodesToAdd.add(pos);
/*     */   }
/*     */ 
/*     */   
/*     */   public void serverTick() {
/*  57 */     if (this.world == null) {
/*     */       return;
/*     */     }
/*  60 */     if (!isPaused()) {
/*  61 */       this.age++;
/*     */       
/*  63 */       int start = this.nodesIndexed.size() / this.speed * this.progress;
/*     */       
/*  65 */       int end = Math.min(Math.max(256, start + this.nodesIndexed.size() / this.speed), this.nodesIndexed.size());
/*     */       
/*  67 */       for (int i = start; i < end; i++) {
/*  68 */         class_2338 pos = this.nodesIndexed.get(i);
/*     */         
/*  70 */         double maxDist = TimeUtils.calculateMinimumDistance(this.age, this.speed);
/*     */         
/*  72 */         double posDist = BlockPosUtils.minimumSquaredDistance(this.world.method_18456(), pos);
/*     */         
/*  74 */         for (class_2350 direction : DirectionUtils.DIRECTIONS) {
/*  75 */           class_2338 sidePos = pos.method_10093(direction);
/*     */           
/*  77 */           double sidePosDist = BlockPosUtils.minimumSquaredDistance(this.world.method_18456(), sidePos);
/*     */           
/*  79 */           if (!this.nodes.contains(sidePos) && sidePos
/*  80 */             .method_10264() < TimeUtils.calculateMaximumHeight(this.world, sidePos, this.age, this.speed) && sidePos
/*  81 */             .method_10264() > TimeUtils.calculateMinimumHeight(this.age, this.speed) && ((this.age % 
/*  82 */             TimeUtils.calculateFollowTime(this.age) == 0L && sidePosDist < posDist) || (this.age % this.speed == 0L && sidePos.method_19771((class_2382)this.originPos, maxDist)))) {
/*  83 */             class_2680 sideState = this.world.method_8320(sidePos);
/*  84 */             class_2680 centerState = this.world.method_8320(pos);
/*     */             
/*  86 */             if (GasUtils.isTraversableForPropagation(this.world, centerState, pos, sideState, sidePos, direction)) {
/*  87 */               this.nodesToAdd.add(sidePos);
/*     */             }
/*     */           } 
/*     */         } 
/*     */         
/*  92 */         for (class_1657 player : this.world.method_18456()) {
/*  93 */           double distance = BlockPosUtils.squaredDistance(player, pos);
/*     */           
/*  95 */           this.cooldowns.putIfAbsent(player.method_5667(), Integer.valueOf(150));
/*     */           
/*  97 */           if (distance < 1.0D && ((Integer)this.cooldowns.get(player.method_5667())).intValue() <= 0) {
/*  98 */             player.method_5643(class_1282.field_5859, 1.0F);
/*     */           }
/*     */           
/* 101 */           if (pos.method_10263() % 3 == 0 && pos.method_10260() % 3 == 0) {
/* 102 */             this.particles.putIfAbsent(player.method_5667(), new HashSet<>());
/*     */             
/* 104 */             if (!((Set)this.particles.get(player.method_5667())).contains(pos)) {
/* 105 */               HarmfulGasNetworking.sendAddGasCloudPacket(player, pos);
/*     */               
/* 107 */               ((Set<class_2338>)this.particles.get(player.method_5667())).add(pos);
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */       
/* 113 */       for (class_1657 player : this.world.method_18456()) {
/* 114 */         this.cooldowns.putIfAbsent(player.method_5667(), Integer.valueOf(150));
/*     */         
/* 116 */         if (((Integer)this.cooldowns.get(player.method_5667())).intValue() > 0) {
/* 117 */           this.cooldowns.put(player.method_5667(), Integer.valueOf(((Integer)this.cooldowns.get(player.method_5667())).intValue() - 1));
/*     */         }
/*     */       } 
/*     */       
/* 121 */       this.nodes.addAll(this.nodesToAdd);
/* 122 */       this.nodesIndexed.addAll(this.nodesToAdd);
/*     */       
/* 124 */       this.nodesToAdd.clear();
/*     */       
/* 126 */       this.progress++;
/*     */       
/* 128 */       if (this.progress >= this.speed) {
/* 129 */         this.progress = 0;
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void writeToNbt(class_2487 tag) {
/* 136 */     if (this.world == null) {
/*     */       return;
/*     */     }
/* 139 */     class_2487 dataTag = new class_2487();
/*     */     
/* 141 */     dataTag.method_10569("OriginX", this.originPos.method_10263());
/* 142 */     dataTag.method_10569("OriginY", this.originPos.method_10264());
/* 143 */     dataTag.method_10569("OriginZ", this.originPos.method_10260());
/*     */     
/* 145 */     dataTag.method_10556("Paused", this.paused);
/*     */     
/* 147 */     dataTag.method_10544("Age", this.age);
/*     */     
/* 149 */     dataTag.method_10569("Progress", this.progress);
/* 150 */     dataTag.method_10569("Speed", this.speed);
/*     */     
/* 152 */     int i = 0;
/*     */     
/* 154 */     for (class_2338 pos : this.nodes) {
/* 155 */       class_2487 pointTag = new class_2487();
/* 156 */       pointTag.method_10544("Pos", pos.method_10063());
/*     */       
/* 158 */       dataTag.method_10566(String.valueOf(i), (class_2520)pointTag);
/* 159 */       i++;
/*     */     } 
/*     */     
/* 162 */     tag.method_10566("Data", (class_2520)dataTag);
/*     */   }
/*     */ 
/*     */   
/*     */   public void readFromNbt(class_2487 tag) {
/* 167 */     if (this.world == null) {
/*     */       return;
/*     */     }
/* 170 */     class_2487 dataTag = tag.method_10562("Data");
/*     */     
/* 172 */     this
/*     */ 
/*     */       
/* 175 */       .originPos = new class_2338(dataTag.method_10550("OriginX"), dataTag.method_10550("OriginY"), dataTag.method_10550("OriginZ"));
/*     */ 
/*     */     
/* 178 */     this.paused = dataTag.method_10577("Paused");
/*     */     
/* 180 */     this.age = dataTag.method_10537("Age");
/*     */     
/* 182 */     this.progress = dataTag.method_10550("Progress");
/* 183 */     this.speed = dataTag.method_10550("Speed");
/*     */     
/* 185 */     for (String key : dataTag.method_10541()) {
/* 186 */       class_2487 pointTag = dataTag.method_10562(key);
/*     */       
/* 188 */       this.nodesToAdd.add(class_2338.method_10092(pointTag.method_10537("Pos")));
/*     */     } 
/*     */   }
/*     */   
/*     */   @Nullable
/*     */   public static <V> WorldGasComponent get(V v) {
/*     */     try {
/* 195 */       return (WorldGasComponent)HarmfulGasComponents.WORLD_GAS_COMPONENT.get(v);
/* 196 */     } catch (Exception justShutUpAlready) {
/* 197 */       return null;
/*     */     } 
/*     */   }
/*     */   
/*     */   public Map<UUID, Set<class_2338>> getParticles() {
/* 202 */     return this.particles;
/*     */   }
/*     */   
/*     */   public Set<class_2338> getParticles(UUID uuid) {
/* 206 */     return this.particles.get(uuid);
/*     */   }
/*     */   
/*     */   public Map<UUID, Integer> getCooldowns() {
/* 210 */     return this.cooldowns;
/*     */   }
/*     */   
/*     */   public long getAge() {
/* 214 */     return this.age;
/*     */   }
/*     */   
/*     */   public boolean isPaused() {
/* 218 */     return this.paused;
/*     */   }
/*     */   
/*     */   public void setPaused(boolean paused) {
/* 222 */     this.paused = paused;
/*     */   }
/*     */   
/*     */   public int getSpeed() {
/* 226 */     return this.speed;
/*     */   }
/*     */   
/*     */   public void setSpeed(int speed) {
/* 230 */     this.speed = speed;
/*     */   }
/*     */   
/*     */   public class_2338 getOriginPos() {
/* 234 */     return this.originPos;
/*     */   }
/*     */   
/*     */   public void setOriginPos(class_2338 originPos) {
/* 238 */     this.originPos = originPos;
/*     */   }
/*     */ }


/* Location:              /Users/alex/BAK/vini2003/Mods/Harmful Gas/1.0.4/harmfulgas-1.0.4+1.16.5.jar!/vini2003/xyz/harmfulgas/common/component/WorldGasComponent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
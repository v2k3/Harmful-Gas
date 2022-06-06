/*    */ package vini2003.xyz.harmfulgas.registry.common;
/*    */ import dev.onyxstudios.cca.api.v3.component.ComponentKey;
/*    */ import dev.onyxstudios.cca.api.v3.component.ComponentRegistry;
/*    */ import dev.onyxstudios.cca.api.v3.world.WorldComponentFactory;
/*    */ import dev.onyxstudios.cca.api.v3.world.WorldComponentFactoryRegistry;
/*    */ import dev.onyxstudios.cca.api.v3.world.WorldComponentInitializer;
/*    */ import vini2003.xyz.harmfulgas.HarmfulGas;
/*    */ import vini2003.xyz.harmfulgas.common.component.WorldGasComponent;
/*    */ 
/*    */ public class HarmfulGasComponents implements WorldComponentInitializer {
/* 11 */   public static final ComponentKey<WorldGasComponent> WORLD_GAS_COMPONENT = ComponentRegistry.getOrCreate(HarmfulGas.identifier("world_gas_component"), WorldGasComponent.class);
/*    */ 
/*    */ 
/*    */   
/*    */   public static void initialize() {}
/*    */ 
/*    */   
/*    */   public void registerWorldComponentFactories(WorldComponentFactoryRegistry worldComponentFactoryRegistry) {
/* 19 */     worldComponentFactoryRegistry.register(WORLD_GAS_COMPONENT, WorldGasComponent::new);
/*    */   }
/*    */ }


/* Location:              /Users/alex/BAK/vini2003/Mods/Harmful Gas/1.0.4/harmfulgas-1.0.4+1.16.5.jar!/vini2003/xyz/harmfulgas/registry/common/HarmfulGasComponents.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
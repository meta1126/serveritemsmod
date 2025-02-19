package com.meta.serveritemsmod.common;

import com.meta.serveritemsmod.ServerItemsMod;
import com.meta.serveritemsmod.items.ModItems;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

public class ModEvents {
    @Mod.EventBusSubscriber(modid = "ServerItemsMod", bus = Mod.EventBusSubscriber.Bus.FORGE)
    public class DeathPenaltyHandler {
        @SubscribeEvent
        public static void  onPlayerDeath(LivingDeathEvent event) {
            if (event.getEntity() instanceof ServerPlayer player) {
                handleDeathPenalty(player);
            }
        }
    }
    private static void handleDeathPenalty(ServerPlayer player){
        ItemStack penaltyItem = findPenaltyItem(player);
        if (!penaltyItem.isEmpty()) {
            penaltyItem.shrink(1);
        }else{
            dropInventory(player);
        }
    }
    private  static ItemStack findPenaltyItem(ServerPlayer player) {
        for (ItemStack stack : player.getInventory().items) {
            if (stack.getItem() == ModItems.SOULBALL.get()){
                return stack;
            }
        }
        return  ItemStack.EMPTY;
    }
    private static  void dropInventory(ServerPlayer player){
        for (ItemStack stack : player.getInventory().items) {
            if (!stack.isEmpty()) {
                player.drop(stack, true, false);
            }
        }
    }
}

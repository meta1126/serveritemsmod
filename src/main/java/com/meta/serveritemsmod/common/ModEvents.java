package com.meta.serveritemsmod.common;

import com.meta.serveritemsmod.ServerItemsMod;
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
        ItemStack penaltyItem = findPenaktyItem(player);
        if (!penaltyItem.isEmpty()) {
            penaltyItem.shrink(1);
        }else{
            dropInventory(player);
        }
    }
}

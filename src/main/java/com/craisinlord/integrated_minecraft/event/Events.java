package com.craisinlord.integrated_minecraft.event;

import com.craisinlord.integrated_minecraft.IntegratedMinecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraftforge.event.ItemAttributeModifierEvent;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.orcinus.galosphere.mixin.LootTableAccessor;

import java.util.List;

public class Events {

//    @SubscribeEvent(priority = EventPriority.HIGH)
    public static void filterLootTableLoad(LootTableLoadEvent event) {
        ResourceLocation name = event.getName();
        LootTable table = event.getTable();
        List<LootPool> pools = ((LootTableAccessor)table).getPools();
        if (name.equals(new ResourceLocation("entities/pillager"))) {
            for (int i = 0; i< pools.size(); i++) {
                IntegratedMinecraft.LOGGER.error("POMEGRANATE pool get name is " + pools.get(i).getName());
                if (pools.get(i).getName().equals("silver_nugget")) {
                    pools.remove(i);
                }
            }
        }
        if (name.equals(new ResourceLocation("chests/pillager_outpost")) || name.equals(new ResourceLocation("chests/abandoned_mineshaft"))) {
            for (int i = 0; i< pools.size(); i++) {
                IntegratedMinecraft.LOGGER.error("POMEGRANATE pool get name is " + pools.get(i).getName());
                if (pools.get(i).getName().equals("silver_upgrade_smithing_template")) {
                    pools.remove(i);
                }
            }
        }
    }
}

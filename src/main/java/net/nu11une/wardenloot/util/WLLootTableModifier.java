package net.nu11une.wardenloot.util;

import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.provider.number.BinomialLootNumberProvider;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.util.Identifier;
import net.nu11une.wardenloot.core.WLItems;

public class WLLootTableModifier {

    private static final Identifier AC_CHEST_ID = new Identifier("minecraft", "chests/ancient_city");

    public static void registerWLLootPools() {
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            if (EntityType.WARDEN.getLootTableId().equals(id)) {
                LootPool.Builder heartPool = LootPool.builder().with(ItemEntry.builder(WLItems.WARDEN_HEART));
                LootPool.Builder soulPool = LootPool.builder().with(ItemEntry.builder(WLItems.SCULK_SOUL)).rolls(BinomialLootNumberProvider.create(12, 0.5F));
                LootPool.Builder soulPoolBonus = LootPool.builder().with(ItemEntry.builder(WLItems.SCULK_SOUL)).rolls(ConstantLootNumberProvider.create(4));
                tableBuilder.pool(heartPool);
                tableBuilder.pool(soulPool);
                tableBuilder.pool(soulPoolBonus);
            }
            if(Blocks.SCULK.getLootTableId().equals(id)) {
                LootPool.Builder pool = LootPool.builder().with(ItemEntry.builder(WLItems.SCULK_SOUL)).rolls(BinomialLootNumberProvider.create(1, 0.006F));
                tableBuilder.pool(pool);
            }
            if(AC_CHEST_ID.equals(id)) {
                LootPool.Builder ingotPool = LootPool.builder().with(ItemEntry.builder(WLItems.SCULK_INGOT)).conditionally(RandomChanceLootCondition.builder(0.06F));
                LootPool.Builder soulPool = LootPool.builder().with(ItemEntry.builder(WLItems.SCULK_SOUL)).rolls(BinomialLootNumberProvider.create(4, 0.08F));
                tableBuilder.pool(ingotPool);
                tableBuilder.pool(soulPool);
            }
        });
    }
}

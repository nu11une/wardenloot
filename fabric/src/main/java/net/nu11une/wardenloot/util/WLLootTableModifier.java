package net.nu11une.wardenloot.util;

import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.condition.KilledByPlayerLootCondition;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.EnchantRandomlyLootFunction;
import net.minecraft.loot.provider.number.BinomialLootNumberProvider;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.util.Identifier;
import net.nu11une.wardenloot.WardenLoot;
import net.nu11une.wardenloot.register.WLEnchants;
import net.nu11une.wardenloot.register.WLItems;
import net.nu11une.wardenloot.register.WLTrinketItems;
import net.nu11une.wardenloot.register.WLWardenHeart;

public class WLLootTableModifier {

    private static final Identifier AC_CHEST_ID = new Identifier("minecraft", "chests/ancient_city");

    public static void registerWLLootPools() {
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            if (EntityType.WARDEN.getLootTableId().equals(id) && WardenLoot.config.lootTables.wardenDropsModLoot) {
                if(WardenLoot.config.registry.registerHelmetLeggingsBoots || WardenLoot.config.registry.registerChestplate){
                    LootPool.Builder heartPool = LootPool.builder().with(ItemEntry.builder(WLWardenHeart.WARDEN_HEART)).conditionally(KilledByPlayerLootCondition.builder());
                    tableBuilder.pool(heartPool);
                }
                LootPool.Builder soulPool = LootPool.builder().with(ItemEntry.builder(WLItems.SCULK_SOUL)).rolls(BinomialLootNumberProvider.create(12, 0.5F)).conditionally(KilledByPlayerLootCondition.builder());
                LootPool.Builder soulPoolBonus = LootPool.builder().with(ItemEntry.builder(WLItems.SCULK_SOUL)).rolls(ConstantLootNumberProvider.create(3)).conditionally(KilledByPlayerLootCondition.builder());
                LootPool.Builder soulPoolConstant = LootPool.builder().with(ItemEntry.builder(WLItems.SCULK_SOUL)).rolls(ConstantLootNumberProvider.create(1));
                tableBuilder.pool(soulPool);
                tableBuilder.pool(soulPoolBonus);
                tableBuilder.pool(soulPoolConstant);
            }
            if(Blocks.SCULK.getLootTableId().equals(id) && WardenLoot.config.lootTables.sculkDropsSoul) {
                LootPool.Builder pool = LootPool.builder().with(ItemEntry.builder(WLItems.SCULK_SOUL)).rolls(BinomialLootNumberProvider.create(1, WardenLoot.config.lootTables.soulChanceFromSculk));
                tableBuilder.pool(pool);
            }
            if(AC_CHEST_ID.equals(id) && WardenLoot.config.lootTables.ancientCityHasModLoot) {
                LootPool.Builder ingotPool = LootPool.builder().with(ItemEntry.builder(WLItems.SCULK_INGOT)).conditionally(RandomChanceLootCondition.builder(0.06F));
                LootPool.Builder soulPool = LootPool.builder().with(ItemEntry.builder(WLItems.SCULK_SOUL)).rolls(BinomialLootNumberProvider.create(4, 0.08F));
                LootPool.Builder enchantPool = LootPool.builder().with(ItemEntry.builder(Items.BOOK).apply(new EnchantRandomlyLootFunction.Builder().add(WLEnchants.WARDEN_DAMAGE))).rolls(BinomialLootNumberProvider.create(3, 0.03F));
                tableBuilder.pool(ingotPool);
                tableBuilder.pool(soulPool);
                tableBuilder.pool(enchantPool);
            }
            if(AC_CHEST_ID.equals(id) && WardenLoot.isModLoaded("trinkets") && WardenLoot.config.lootTables.ancientCityHasModLoot) {
                LootPool.Builder pool = LootPool.builder().with(ItemEntry.builder(WLTrinketItems.WARDEN_EARS_TRINKET)).conditionally(RandomChanceLootCondition.builder(0.02F));
                tableBuilder.pool(pool);
            }
            if (EntityType.WARDEN.getLootTableId().equals(id) && WardenLoot.isModLoaded("trinkets") && WardenLoot.config.lootTables.wardenDropsModLoot) {
                LootPool.Builder pool = LootPool.builder().with(ItemEntry.builder(WLTrinketItems.WARDEN_EARS_TRINKET)).rolls(BinomialLootNumberProvider.create(1, 0.3F));
                tableBuilder.pool(pool);
            }
        });
    }
}

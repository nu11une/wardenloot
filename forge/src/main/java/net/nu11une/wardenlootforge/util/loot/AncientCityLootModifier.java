package net.nu11une.wardenlootforge.util.loot;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.world.item.EnchantedBookItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentInstance;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.loot.LootModifier;
import net.nu11une.wardenlootforge.register.ModEnchants;
import net.nu11une.wardenlootforge.register.ModItems;
import net.nu11une.wardenlootforge.util.Settings;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;

public class AncientCityLootModifier extends LootModifier {
    public static final Codec<AncientCityLootModifier> CODEC = RecordCodecBuilder.create(inst -> codecStart(inst)
            .apply(inst, AncientCityLootModifier::new));

    public AncientCityLootModifier(LootItemCondition[] conditionsIn) {
        super(conditionsIn);
    }

    @Nonnull
    @Override
    protected @NotNull ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {
        if(Settings.cityLoot){
            int x = 0;
            int y = 0;
            while(x < 4){
                if(context.getRandom().nextFloat() < 0.08F){
                    generatedLoot.add(new ItemStack(ModItems.SCULK_SOUL.get(), 1));
                }
                x += 1;
            }
            if(context.getRandom().nextFloat() < 0.06F){
                generatedLoot.add(new ItemStack(ModItems.SCULK_INGOT.get(), 1));
            }
            if(Settings.enchantment){
                while(y < 3){
                    if(context.getRandom().nextFloat() < 0.03F){
                        generatedLoot.add(EnchantedBookItem.createForEnchantment(new EnchantmentInstance(ModEnchants.WARDEN_DAMAGE.get(), Math.round((context.getRandom().nextFloat() * 4) + 1))));
                    }
                    y += 1;
                }
            }
        }
        return generatedLoot;
    }

    @Override
    public Codec<AncientCityLootModifier> codec() {
        return CODEC;
    }
}

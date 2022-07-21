package net.nu11une.wardenlootforge.util.loot;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.loot.LootModifier;
import net.nu11une.wardenlootforge.register.ModItems;
import net.nu11une.wardenlootforge.util.Settings;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;

public class SculkBlockLootModifier extends LootModifier {

    public static final Codec<SculkBlockLootModifier> CODEC = RecordCodecBuilder.create(inst -> codecStart(inst)
            .apply(inst, SculkBlockLootModifier::new));

    protected SculkBlockLootModifier(LootItemCondition[] conditionsIn) {
        super(conditionsIn);
    }

    @Nonnull
    @Override
    protected @NotNull ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {
        if(Settings.dropsSoul){
            if(context.getRandom().nextFloat() < Settings.soulChance){
                generatedLoot.add(new ItemStack(ModItems.SCULK_SOUL.get(), 1));
            }
        }
        return generatedLoot;
    }

    @Override
    public Codec<SculkBlockLootModifier> codec() {
        return CODEC;
    }
}

package net.nu11une.wardenlootforge.util.loot;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.loot.LootModifier;

import com.google.gson.JsonObject;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.registries.ForgeRegistries;
import net.nu11une.wardenlootforge.util.Settings;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;

public class SculkBlockLootModifier extends LootModifier {
    private final Item addition;

    protected SculkBlockLootModifier(LootItemCondition[] conditionsIn, Item addition) {
        super(conditionsIn);
        this.addition = addition;
    }

    @Nonnull
    @Override
    protected @NotNull ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {
        if(Settings.dropsSoul){
            if(context.getRandom().nextFloat() < Settings.soulChance){
                generatedLoot.add(new ItemStack(addition, 1));
            }
        }
        return generatedLoot;
    }

    public static class Serializer extends GlobalLootModifierSerializer<SculkBlockLootModifier> {

        @Override
        public SculkBlockLootModifier read(ResourceLocation name, JsonObject object,
                                       LootItemCondition[] conditionsIn) {
            Item addition = ForgeRegistries.ITEMS.getValue(
                    new ResourceLocation(GsonHelper.getAsString(object, "addition")));
            return new SculkBlockLootModifier(conditionsIn, addition);
        }

        @Override
        public JsonObject write(SculkBlockLootModifier instance) {
            JsonObject json = makeConditions(instance.conditions);
            json.addProperty("addition", ForgeRegistries.ITEMS.getKey(instance.addition).toString());
            return json;
        }
    }
}

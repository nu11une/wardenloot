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
import net.nu11une.wardenlootforge.register.ModItems;
import net.nu11une.wardenlootforge.util.Settings;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;

public class WardenLootModifier extends LootModifier {
    private final Item addition;

    protected WardenLootModifier(LootItemCondition[] conditionsIn, Item addition) {
        super(conditionsIn);
        this.addition = addition;
    }

    @Nonnull
    @Override
    protected @NotNull ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {
        if(Settings.wardenLoot){
            int x = 0;
            while(x < 12){
                if(context.getRandom().nextFloat() > 0.5F){
                    generatedLoot.add(new ItemStack(ModItems.SCULK_SOUL.get(), 1));
                }
                x += 1;
            }
            generatedLoot.add(new ItemStack(ModItems.SCULK_SOUL.get(), 4));
            if(Settings.chestplate || Settings.helmetleggingsboots){
                generatedLoot.add(new ItemStack(addition, 1));
            }
        }
        return generatedLoot;
    }

    public static class Serializer extends GlobalLootModifierSerializer<WardenLootModifier> {

        @Override
        public WardenLootModifier read(ResourceLocation name, JsonObject object,
                                                        LootItemCondition[] conditionsIn) {
            Item addition = ForgeRegistries.ITEMS.getValue(
                    new ResourceLocation(GsonHelper.getAsString(object, "addition")));
            return new WardenLootModifier(conditionsIn, addition);
        }

        @Override
        public JsonObject write(WardenLootModifier instance) {
            JsonObject json = makeConditions(instance.conditions);
            json.addProperty("addition", ForgeRegistries.ITEMS.getKey(instance.addition).toString());
            return json;
        }
    }
}

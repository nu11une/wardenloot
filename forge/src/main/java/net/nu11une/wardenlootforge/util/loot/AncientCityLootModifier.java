package net.nu11une.wardenlootforge.util.loot;

import com.google.gson.JsonObject;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.item.EnchantedBookItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentInstance;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.common.loot.LootModifier;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.ForgeRegistries;
import net.nu11une.wardenlootforge.register.ModEnchants;
import net.nu11une.wardenlootforge.register.ModItems;
import net.nu11une.wardenlootforge.util.Settings;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;

public class AncientCityLootModifier extends LootModifier {
    private final Item addition;

    protected AncientCityLootModifier(LootItemCondition[] conditionsIn, Item addition) {
        super(conditionsIn);
        this.addition = addition;
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

    public static class Serializer extends GlobalLootModifierSerializer<AncientCityLootModifier> {

        @Override
        public AncientCityLootModifier read(ResourceLocation name, JsonObject object,
                                           LootItemCondition[] conditionsIn) {
            Item addition = ForgeRegistries.ITEMS.getValue(
                    new ResourceLocation(GsonHelper.getAsString(object, "addition")));
            return new AncientCityLootModifier(conditionsIn, addition);
        }

        @Override
        public JsonObject write(AncientCityLootModifier instance) {
            JsonObject json = makeConditions(instance.conditions);
            json.addProperty("addition", ForgeRegistries.ITEMS.getKey(instance.addition).toString());
            return json;
        }
    }
}

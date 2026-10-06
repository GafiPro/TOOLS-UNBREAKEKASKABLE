package dev.gafipro.toolsunbreakable;

import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.ItemEnchantmentsComponent;
import net.minecraft.component.type.UnbreakableComponent;
import net.minecraft.item.ItemStack;

public final class EnchantedUnbreakable {
    private EnchantedUnbreakable() {
    }

    public static void apply(ItemStack stack) {
        ItemEnchantmentsComponent enchantments =
                stack.get(DataComponentTypes.ENCHANTMENTS);

        if (enchantments == null
                || enchantments.isEmpty()
                || stack.contains(DataComponentTypes.UNBREAKABLE)) {
            return;
        }

        stack.set(
                DataComponentTypes.UNBREAKABLE,
                new UnbreakableComponent(true)
        );
    }
}

package dev.gafipro.toolsunbreakable;

import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.ItemEnchantmentsComponent;
import net.minecraft.component.type.UnbreakableComponent;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.tag.ItemTags;

public final class EnchantedUnbreakable {
    private EnchantedUnbreakable() {
    }

    public static void apply(ItemStack stack) {
        if (!isMiningTool(stack)) {
            return;
        }

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

    private static boolean isMiningTool(ItemStack stack) {
        return stack.isIn(ItemTags.PICKAXES)
                || stack.isIn(ItemTags.SHOVELS)
                || stack.isIn(ItemTags.HOES);
    }
}

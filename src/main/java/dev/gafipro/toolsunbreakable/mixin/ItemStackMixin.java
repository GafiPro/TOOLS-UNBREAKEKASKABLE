package dev.gafipro.toolsunbreakable.mixin;

import dev.gafipro.toolsunbreakable.EnchantedUnbreakable;
import net.minecraft.component.ComponentType;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.ItemEnchantmentsComponent;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ItemStack.class)
public abstract class ItemStackMixin {

    @Inject(
            method = "set(Lnet/minecraft/component/ComponentType;Ljava/lang/Object;)Ljava/lang/Object;",
            at = @At("RETURN")
    )
    private void toolsUnbreakable$afterSet(
            ComponentType<?> type,
            Object value,
            CallbackInfoReturnable<?> cir
    ) {
        if (type == DataComponentTypes.ENCHANTMENTS
                && value instanceof ItemEnchantmentsComponent enchantments
                && !enchantments.isEmpty()) {
            EnchantedUnbreakable.apply((ItemStack) (Object) this);
        }
    }

    @Inject(method = "isDamageable", at = @At("RETURN"), cancellable = true)
    private void toolsUnbreakable$enchantedStacksAreNotDamageable(
            CallbackInfoReturnable<Boolean> cir
    ) {
        ItemStack stack = (ItemStack) (Object) this;

        if (stack.hasEnchantments()) {
            cir.setReturnValue(false);
        }
    }
}

package dev.gafipro.toolsunbreakable.mixin;

import dev.gafipro.toolsunbreakable.EnchantedUnbreakable;
import net.minecraft.component.ComponentChanges;
import net.minecraft.component.ComponentMap;
import net.minecraft.component.ComponentType;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.ItemEnchantmentsComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.entry.RegistryEntry;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
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

    @Inject(
            method = "<init>(Lnet/minecraft/registry/entry/RegistryEntry;ILnet/minecraft/component/ComponentChanges;)V",
            at = @At("TAIL")
    )
    private void toolsUnbreakable$afterComponentConstructor(
            RegistryEntry<Item> item,
            int count,
            ComponentChanges changes,
            CallbackInfo ci
    ) {
        EnchantedUnbreakable.apply((ItemStack) (Object) this);
    }

    @Inject(method = "applyChanges", at = @At("TAIL"))
    private void toolsUnbreakable$afterApplyChanges(
            ComponentChanges changes,
            CallbackInfo ci
    ) {
        EnchantedUnbreakable.apply((ItemStack) (Object) this);
    }

    @Inject(method = "applyUnvalidatedChanges", at = @At("TAIL"))
    private void toolsUnbreakable$afterApplyUnvalidatedChanges(
            ComponentChanges changes,
            CallbackInfo ci
    ) {
        EnchantedUnbreakable.apply((ItemStack) (Object) this);
    }

    @Inject(method = "applyComponentsFrom", at = @At("TAIL"))
    private void toolsUnbreakable$afterApplyComponentsFrom(
            ComponentMap components,
            CallbackInfo ci
    ) {
        EnchantedUnbreakable.apply((ItemStack) (Object) this);
    }
}

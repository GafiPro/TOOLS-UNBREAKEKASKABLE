# Tools Unbreakable

Fabric mod for Minecraft 1.21.1.

## What it does

Any item that has at least one normal enchantment becomes unbreakable.

The rule uses the item's minecraft:enchantments component, so it works with
enchanted tools and any other damageable item.

The protection is applied in two ways:

1. Enchanted stacks receive the vanilla minecraft:unbreakable component when
   their enchantments are set.
2. ItemStack#isDamageable() returns false for enchanted stacks, so vanilla
   durability damage is blocked even for stacks created or loaded by another
   system.

This means an enchanted item:

- does not lose durability through normal Minecraft damage;
- reports itself as unbreakable to ItemStack#isUnbreakable();
- keeps working after being copied or saved/loaded.

The mod does not require Fabric API.

## Build

Requires Java 21 and Gradle.

    gradle clean build --no-daemon --max-workers=1

The built JAR is in build/libs/.

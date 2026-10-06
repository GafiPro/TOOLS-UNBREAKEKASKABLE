# Tools Unbreakable

Fabric mod for **Minecraft 1.21.1**.

## What it does

When a mining tool has at least one normal enchantment in its
minecraft:enchantments component, the mod adds the vanilla
minecraft:unbreakable component.

Supported tool categories:

- Pickaxes
- Shovels
- Hoes

The tool:

- stops losing durability;
- shows the vanilla **Unbreakable** tooltip;
- keeps the unbreakable component when the stack is copied, saved and loaded.

The mod does not require Fabric API.

## Build

Requires Java 21 and Gradle.

Run:

    gradle clean build --no-daemon --max-workers=1

The built JAR is in build/libs/.

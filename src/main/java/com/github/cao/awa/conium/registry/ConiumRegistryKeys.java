package com.github.cao.awa.conium.registry;

import com.github.cao.awa.conium.datapack.inject.item.ItemPropertyInject;
import net.minecraft.recipe.Recipe;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;

public class ConiumRegistryKeys {
    public static final RegistryKey<Registry<ItemPropertyInject<?>>> ITEM_PROPERTY_INJECT = of("property/item");

    private static <T> RegistryKey<Registry<T>> of(String id) {
        return RegistryKey.ofRegistry(Identifier.of("conium", id));
    }
}

package org.leiers.leplugin.api.item;

import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public interface ItemBuilderBase<T> {
    ItemStack build();

    ItemBuilderBase<?> displayName(T displayName);

    ItemBuilderBase<?> lore(T... lore);

    ItemBuilderBase<?> glow();

    ItemStack getItem();

    ItemMeta getMeta();
}

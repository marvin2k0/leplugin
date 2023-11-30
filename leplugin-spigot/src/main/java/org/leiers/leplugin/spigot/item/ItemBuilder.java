package org.leiers.leplugin.spigot.item;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.leiers.leplugin.api.item.ItemBuilderBase;

import java.util.Arrays;

public class ItemBuilder implements ItemBuilderBase<String> {
    private final ItemStack item;
    private final ItemMeta meta;

    public static ItemBuilder with(Material type) {
        return new ItemBuilder(type);
    }

    private ItemBuilder(Material type) {
        this.item = new ItemStack(type);
        this.meta = item.getItemMeta();
    }

    @Override
    public ItemStack build() {
        this.item.setItemMeta(this.meta);
        return this.item;
    }

    @Override
    public ItemBuilder displayName(String displayName) {
        this.meta.setDisplayName(displayName);
        return this;
    }

    @Override
    public ItemBuilder lore(String... lore) {
        this.meta.setLore(Arrays.asList(lore));
        return this;
    }

    @Override
    public ItemBuilder glow() {
        this.meta.addEnchant(Enchantment.CHANNELING, 1, true);
        this.meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        return this;
    }

    @Override
    public ItemStack getItem() {
        return this.item;
    }

    @Override
    public ItemMeta getMeta() {
        return this.meta;
    }
}

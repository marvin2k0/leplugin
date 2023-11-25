package org.leiers.paper.item;

import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.leiers.leplugin.api.item.ItemBuilderBase;

import java.util.Arrays;
import java.util.List;

public class ItemBuilder implements ItemBuilderBase<Component> {

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
    public ItemBuilder displayName(Component displayName) {
        this.meta.displayName(displayName);
        return this;
    }

    @Override
    public ItemBuilder lore(Component... lore) {
        this.meta.lore(Arrays.stream(lore).toList());
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
        return item;
    }

    @Override
    public ItemMeta getMeta() {
        return meta;
    }
}

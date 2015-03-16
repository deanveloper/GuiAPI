package com.deanveloper.gui;

import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import java.util.function.Consumer;

public class GUIItem {
    private Consumer<InventoryClickEvent> toRun;
    private ItemStack item;

    public GUIItem(ItemStack item, Consumer<InventoryClickEvent> toRun) {
        this.toRun = toRun;
        this.item = item;
    }

    ItemStack getBukkitItem() {
        return this.item;
    }

    void run(InventoryClickEvent e) {
        this.toRun.accept(e);
    }
}

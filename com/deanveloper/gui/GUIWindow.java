package com.deanveloper.gui;

import org.bukkit.Bukkit;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.inventory.Inventory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GUIWindow {
    static Map<Inventory, GUIWindow> windows = new HashMap<>();

    private Inventory inv;
    private List<GUIItem> items;
	private Consumer<InventoryOpenEvent> onOpen = null;
	private Consumer<InventoryCloseEvent> onClose = null;

    private boolean registered;

    public GUIWindow(String name, int rows) {
        this.inv = Bukkit.createInventory(null, rows * 9, name);
        this.items = new ArrayList<>(rows * 9);
		windows.put(inv, this);

        this.registered = true;
    }

    public void setItem(int slot, GUIItem item) {
        if(!this.registered) throw new IllegalStateException("GUI is unregistered!");

        this.items.set(slot, item);
        this.inv.setItem(slot, item.getBukkitItem());
    }

	public void setItem(int x, int y, GUIItem item){
		setItem(x*9 + y, item);
	}

    public GUIItem getItem(int slot) {
		if(!this.registered) throw new IllegalStateException("GUI is unregistered!");
        return this.items.get(slot);
    }

	public GUIItem getItem(int x, int y){
		return getItem(x*9 + y);
	}

	public void setOpenEvent(Consumer<InventoryOpenEvent> e){
		if(!this.registered) throw new IllegalStateException("GUI is unregistered!");
		this.onOpen = e;
	}

	@Deprecated
	void callOpen(InventoryOpenEvent e){
		if(onOpen != null) onOpen.accept(e);
		if(!this.registered) throw new IllegalStateException("GUI is unregistered!");
	}

	public void setCloseEvent(Consumer<InventoryCloseEvent> e){
		if(!this.registered) throw new IllegalStateException("GUI is unregistered!");
		this.onClose = e;
	}

	@Deprecated
	void callClosed(InventoryCloseEvent e){
		if(!this.registered) throw new IllegalStateException("GUI is unregistered!");
		if(onClose != null) onClose.accept(e);
	}

    @Deprecated
    /**
     * @deprecated only use if you know what you're doing
     */
    public Inventory getBukkitInventory() {
		if(!this.registered) throw new IllegalStateException("GUI is unregistered!");
        return this.inv;
    }

    public void unregister() {
		if(!this.registered) throw new IllegalStateException("GUI is unregistered!");
        windows.remove(this.inv);
        this.items.clear();
		this.items = null;
        this.registered = false;
    }
}

package com.deanveloper.gui;

import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryInteractEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;

public class GUIListener implements Listener{
	@EventHandler
	public void onClick(InventoryClickEvent e){
		GUIWindow window = GUIWindow.windows.get(e.getInventory());
		if(window != null){
			GUIItem item = window.getItem(e.getSlot());
			if(item != null){
				item.run(e);
			}
			e.setResult(Event.Result.DENY);
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void onOpen(InventoryOpenEvent e){
		GUIWindow window = GUIWindow.windows.get(e.getInventory());
		if(window != null){
			window.callOpen(e);
		}
	}

	@EventHandler
	public void onClose(InventoryCloseEvent e){
		GUIWindow window = GUIWindow.windows.get(e.getInventory());
		if(window != null){
			window.callClosed(e);
		}
	}

	@EventHandler
	public void onInteract(InventoryInteractEvent e){
		if(GUIWindow.windows.containsKey(e.getInventory())){
			e.setResult(Event.Result.DENY);
			e.setCancelled(true);
		}
	}
}

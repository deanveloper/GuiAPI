# GuiAPI
Create Bukkit GUIs super easily!

## Installing

All you need to do is copy the files into your plugin. You do not need to copy ``Consumer.java`` if you are sure that the plugin will only be run on Java 8

## Usage
````java
GUIWindow gui = new GUIWindow(title, rows);
GUIItem guiItem = new GUIItem(itemToShow, whenClicked);

gui.setItem(x, y, guiItem);
````

The parameters for the constructors are
#### GUIWindow
 - ``String title`` - The title of your GUI window
 - ``int rows`` - How many rows the GUI will have

#### GUIItem
 - ``ItemStack itemToShow`` - The item that a GUIItem will display as in the GUIWindow
 - ``Consumer<InventoryClickEvent> whenClicked`` - What action to perform when clicked

## Example usage
#### Java 7
````java
ItemStack redstone = new ItemStack(Material.REDSTONE);
GUIWindow gui = new GUIWindow("Get some redstone!", 3);
GUIItem guiItem = new GUIItem(redstone, new Consumer<>() {
  @Override
  public void accept (InventoryClickEvent event){
    event.getWhoClicked().getInventory().addItem(redstone));
  }
}

gui.setItem(4, 1, guiItem);
````

#### Java 8 (Much Simpler)
````java
ItemStack redstone = new ItemStack(Material.REDSTONE);
GUIWindow gui = new GUIWindow("Get some redstone!", 3);
GUIItem guiItem = new GUIItem(redstone, event -> event.getWhoClicked().getInventory().addItem(redstone));

gui.setItem(4, 1, guiItem);
````

## Tips

 - There are also setOpenEvent() and setCloseEvent() methods!
 - in ``setItem (x, y, guiItem)``, x and y can also be replaced with a single ``int`` to place it in a raw position
 - a ``Consumer`` is basically just a ``Runnable`` that passes an argument into the ``run`` method
 - If you only need the GUI for a short period of time, use the ``unregister()`` method when you don't need it anymore

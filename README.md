# GuiAPI
=================

## GUIWindow
GUIWindow is the main class that you will be working with when using the GUIApi. It will be the base for each GUI that you make, and is the equivalent of an Inventory if you were to be creating a GUI from scratch.

### Syntax
Method Syntax | Description
--------------|------------
new GUIWindow(String name, int rows) | Creates a `GUIWindow` with the title `name` and `rows` rows
void setItem(int slot, GUIItem item) | Sets slot `slot` in the inventory to `item`
void setItem(int x, int y, GUIItem item) | Sets slot at the proper `x` and `y` coordinates to `item`
GUIItem getItem(int slot) | Gets the item in the slot `slot`
GUIItem getItem(int x, int y) | Gets the item in the proper `x` and `y` coordinates
void setOpenEvent(Consumer<InventoryOpenEvent> e) | Sets what to do when the inventory is opened. A `Consumer` is pretty much a `Runnable` but has an argument in the run method
void setCloseEvent(Consumer<InventoryCloseEvent> e) | Sets what to do when the inventory is closed
void unregister() | Frees up ram by setting all values to `null`

----
## GUIItem
`GUIItem`s are a way to store a `Consumable` (A `Runnable` with arguments) with their respective `ItemStack`. They are very easy to use.

### Syntax
Method Syntax | Description
new GUIItem(ItemStack item, Consumer<InventoryClickEvent> toRun) | The ItemStack and what it will do when it is clicked

The Consumer is also lambda-compatible, although don't use lambdas unless you know for a *fact* that your plugin will only be used with `Java 8`. I have provided a `Consumer` class to keep compatibility with any previous Java versions.

----
That's it! Thanks for using my resource, leave a star on the repo if you liked it!

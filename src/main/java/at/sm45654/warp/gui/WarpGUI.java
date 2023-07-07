package at.sm45654.warp.gui;

import at.sm45654.warp.Warp;
import at.sm45654.warp.util.ChatUtil;
import at.sm45654.warp.util.Warplist;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class WarpGUI implements Listener {

    public static Inventory warpgui;

    public static void WarpGui() {
        warpgui = Bukkit.createInventory(null, 54, ChatUtil.GREEN +"§lWarps");
    }

    public static void createItem(String warp) {
        warpgui.addItem(newItem(warp));
    }

    public static void deleteItem(String warp) {
        warpgui.removeItem(newItem(warp));
    }


    protected static ItemStack newItem(String warp) {
        final ItemStack item = new ItemStack(Material.OAK_SIGN, 1);
        final ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(warp);
        item.setItemMeta(meta);

        return item;
    }


    @EventHandler
    public void onInventoryClick(final InventoryClickEvent e) {
        if (!(e.getInventory().equals(warpgui))) return;
        e.setCancelled(true);
        final ItemStack clickedItem = e.getCurrentItem();
        if (clickedItem == null || clickedItem.getType().isAir()) return;
        final Player p = (Player) e.getWhoClicked();
        e.setCancelled(true);

        String warp = clickedItem.getItemMeta().getDisplayName();
        if (!Warplist.warplist.contains(warp)) {
            p.sendMessage(Warp.prefix + ChatUtil.RED + "Warp " + ChatUtil.ORANGE + warp + ChatUtil.RED + " does not exist.");
        } else {
            e.getWhoClicked().teleport(Warp.main.wm.getWarp(warp));


        }
    }

    @EventHandler
    public void onInventoryClick (final InventoryDragEvent e){
        if (e.getInventory().equals(warpgui)) {
            e.setCancelled(true);
        }
    }
}



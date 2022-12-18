package me.number3504.serverlinks.listeners;

import me.number3504.serverlinks.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class InventoryClickListener implements Listener {

    private final Main main;

    public InventoryClickListener(Main main) {
        this.main = main;
    }

    @EventHandler
    public void onInvClick(InventoryClickEvent e) {
        Player player = (Player) e.getWhoClicked();
        if (e.getView().getTitle().equalsIgnoreCase(main.getConfig().getString("messages.guiName"))) {
            e.setCancelled(true);
            player.sendMessage(e.getCurrentItem().getItemMeta().lore().get(0));
        }
    }

}

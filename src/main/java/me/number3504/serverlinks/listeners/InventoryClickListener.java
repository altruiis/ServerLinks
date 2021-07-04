package me.number3504.serverlinks.listeners;

import me.number3504.serverlinks.Main;
import me.number3504.serverlinks.Utils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class InventoryClickListener implements Listener {

    Main main;

    public InventoryClickListener(Main main) {
        this.main = main;
    }

    @EventHandler
    public void onInvClick(InventoryClickEvent e) {
        Player player = (Player) e.getWhoClicked();
        if (e.getView().getTitle().equalsIgnoreCase(Utils.msg(main.getConfig().getString("messages.guiName")))) {
            e.setCancelled(true);
            player.sendMessage(e.getCurrentItem().getItemMeta().getLore().get(0));
        }
    }

}

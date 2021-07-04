package me.number3504.serverlinks;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class InvClick implements Listener {

    Main main;

    public InvClick(Main main) {
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

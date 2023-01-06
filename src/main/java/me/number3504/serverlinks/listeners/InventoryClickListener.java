package me.number3504.serverlinks.listeners;

import me.number3504.serverlinks.Main;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;

public class InventoryClickListener implements Listener {

    private final Main main;
    private final MiniMessage mm = MiniMessage.miniMessage();
    private final NamespacedKey key;

    public InventoryClickListener(Main main) {
        this.main = main;
        this.key = new NamespacedKey(main, "link");
    }

    @EventHandler
    public void onInvClick(InventoryClickEvent e) {
        Player player = (Player) e.getWhoClicked();
        if (e.getView().title().equals(mm.deserialize(main.getConfig().getString("gui.title")))) {
            e.setCancelled(true);
            if (e.getCurrentItem() == null) return;
            ItemStack item = e.getCurrentItem();
            if (!main.getConfig().getString("gui.clickMessage").isEmpty()) {
                String link = item.getItemMeta().getPersistentDataContainer().get(key, PersistentDataType.STRING);
                String value = main.getConfig().getString("links." + link);
                String msg = main.getConfig().getString("gui.clickMessage")
                        .replace("%link%", value)
                        .replace("%link-unformatted%", mm.stripTags(value));
                if (!msg.isEmpty()) {
                    player.sendRichMessage(msg);
                }
                if (main.getConfig().getBoolean("gui.closeOnClick")) {
                    main.getServer().getScheduler().runTask(main, () -> player.closeInventory());
                }
            }
        }
    }

}

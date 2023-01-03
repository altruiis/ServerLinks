package me.number3504.serverlinks.commands;

import me.number3504.serverlinks.Main;
import me.number3504.serverlinks.Utils;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

import java.util.ArrayList;

public class GUICommand extends CommandExecutor {

    private final Main main;
    private final MiniMessage mm = MiniMessage.miniMessage();
    private final NamespacedKey key;

    public GUICommand(Main main) {
        this.main = main;
        setCommand("gui");
        setLength(1);
        this.key = new NamespacedKey(main, "SL-link");
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (sender instanceof Player player) {
            ConfigurationSection section = main.getConfig().getConfigurationSection("links");
            if (section == null) {
                sender.sendRichMessage(main.getConfig().getString("messages.sectionNotFound"));
                return;
            }
            if (section.getKeys(false).stream().allMatch(s -> main.getConfig().getString("links." + s).isEmpty())) {
                sender.sendRichMessage(main.getConfig().getString("messages.prefix") + main.getConfig().getString("messages.linksNotSet"));
                return;
            }
            int size = main.getConfig().getInt("gui.size");
            Component title = mm.deserialize(main.getConfig().getString("gui.title"));
            Inventory inv = main.getServer().createInventory(null, size, title);
            int index = 0;
            for (String s : section.getKeys(false)) {
                if (!main.getConfig().getString("links." + s).isEmpty()) {
                    ItemStack item = new ItemStack(Material.valueOf(main.getConfig().getString("gui.itemFormat.material")));
                    ItemMeta meta = item.getItemMeta();
                    String name = main.getConfig().getString("gui.itemFormat.name")
                            .replace("%link%", s).replace("%link-capital%", Utils.cap(s));
                    meta.displayName(mm.deserialize(name));
                    ArrayList<Component> lore = new ArrayList<>();
                    String link = main.getConfig().getString("links." + s);
                    for (String toAdd : main.getConfig().getStringList("gui.itemFormat.lore"))
                        lore.add(mm.deserialize(toAdd.replace("%value%", link).replace("%value-unformatted%", mm.stripTags(link))));
                    meta.lore(lore);
                    meta.getPersistentDataContainer().set(key, PersistentDataType.STRING, s);
                    item.setItemMeta(meta);
                    inv.setItem(index, item);
                    index++;
                }
            }
            player.openInventory(inv);
        }
    }
}

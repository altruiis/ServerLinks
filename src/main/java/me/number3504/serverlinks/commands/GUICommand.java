package me.number3504.serverlinks.commands;

import me.number3504.serverlinks.Main;
import me.number3504.serverlinks.Utils;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class GUICommand extends CommandExecutor {

    private final Main main;
    private final MiniMessage mm = MiniMessage.miniMessage();

    public GUICommand(Main main) {
        this.main = main;
        setCommand("gui");
        setLength(1);
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (sender instanceof Player player) {
            ConfigurationSection section = main.getConfig().getConfigurationSection("links");
            if (section.getKeys(false).stream().allMatch(s -> main.getConfig().getString("links." + s).isEmpty())) {
                sender.sendRichMessage(main.getConfig().getString("messages.prefix") + main.getConfig().getString("messages.linksNotSet"));
                return;
            }
            Inventory inv = main.getServer().createInventory(null, 18, mm.deserialize(main.getConfig().getString("messages.guiName")));
            int index = -1;
            for (Object s : section.getKeys(false)) {
                if (!main.getConfig().getString("links." + s).isEmpty()) {
                    index++;
                    ItemStack item = new ItemStack(Material.PAPER);
                    ItemMeta meta = item.getItemMeta();
                    meta.displayName(mm.deserialize(main.getConfig().getString("messages.guiItemColor") + Utils.cap(s.toString())));
                    ArrayList<Component> lore = new ArrayList<>();
                    lore.add(mm.deserialize(main.getConfig().getString("links." + s)));
                    meta.lore(lore);
                    item.setItemMeta(meta);
                    inv.setItem(index, item);
                }
            }
            player.openInventory(inv);
        }
    }
}

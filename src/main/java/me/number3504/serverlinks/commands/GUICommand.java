package me.number3504.serverlinks.commands;

import me.number3504.serverlinks.Main;
import me.number3504.serverlinks.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class GUICommand extends CommandExecutor {

    Main main;

    public GUICommand(Main main) {
        this.main = main;
        setCommand("gui");
        setLength(1);
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (sender instanceof Player player) {
            if (main.getConfig().getConfigurationSection("links").getKeys(false).stream().allMatch(s -> main.getConfig().getString("links." + s).equals(""))) {
                sender.sendMessage(Utils.msg(main.getConfig().getString("messages.prefix") + main.getConfig().getString("messages.linksNotSet")));
                return;
            }
            Inventory inv = Bukkit.createInventory(null, 18, Utils.msg(main.getConfig().getString("messages.guiName")));
            int index = -1;
            for (Object s : main.getConfig().getConfigurationSection("links").getKeys(false)) {
                if (!main.getConfig().getString("links." + s).equals("")) {
                    index++;
                    ItemStack item = new ItemStack(Material.PAPER);
                    ItemMeta meta = item.getItemMeta();
                    meta.setDisplayName(Utils.msg(main.getConfig().getString("messages.guiItemColor") + Utils.cap(s.toString())));
                    ArrayList<String> lore = new ArrayList<>();
                    lore.add(Utils.msg(main.getConfig().getString("links." + s)));
                    meta.setLore(lore);
                    item.setItemMeta(meta);
                    inv.setItem(index, item);
                }
            }
            player.openInventory(inv);
        }
    }
}

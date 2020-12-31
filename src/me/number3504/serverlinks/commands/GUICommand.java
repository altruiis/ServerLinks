package me.number3504.serverlinks.commands;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import me.number3504.serverlinks.ServerLinksMain;
import me.number3504.serverlinks.Utils;

public class GUICommand extends CommandExecutor {

	JavaPlugin main = ServerLinksMain.main;

	public GUICommand() {
		setCommand("gui");
		setLength(1);
	}

	@Override
	public void execute(CommandSender sender, String[] args) {
		if (sender instanceof Player) {
			Player player = (Player) sender;
			Inventory inv = Bukkit.createInventory(null, 18, Utils.msg(main.getConfig().getString("messages.guiName")));
			int index = -1;
			for (Object s : main.getConfig().getConfigurationSection("links").getKeys(false)) {
				if (!main.getConfig().getString("links." + s).equals("")) {
					index++;
					ItemStack item = new ItemStack(Material.PAPER);
					ItemMeta meta = item.getItemMeta();
					meta.setDisplayName(
							Utils.msg(main.getConfig().getString("messages.guiItemColor") + Utils.cap(s.toString())));
					ArrayList<String> lore = new ArrayList<String>();
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

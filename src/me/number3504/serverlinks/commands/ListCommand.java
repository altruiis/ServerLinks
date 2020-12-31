package me.number3504.serverlinks.commands;

import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import me.number3504.serverlinks.ServerLinksMain;
import me.number3504.serverlinks.Utils;

public class ListCommand extends CommandExecutor {

	JavaPlugin main = ServerLinksMain.main;
	
	public ListCommand() {
		setCommand("list");
		setLength(1);
	}

	@Override
	public void execute(CommandSender sender, String[] args) {
		main.getConfig().getConfigurationSection("links").getKeys(false).forEach(key -> {
			if (!main.getConfig().getString("links." + key).equals("")) {
				sender.sendMessage(Utils.msg("&3" + Utils.cap(key) + "&7:&r " + main.getConfig().getString("links." + key)));
			}
		});
	}
}

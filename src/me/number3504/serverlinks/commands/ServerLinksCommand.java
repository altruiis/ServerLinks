package me.number3504.serverlinks.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import me.number3504.serverlinks.ServerLinksMain;

public class ServerLinksCommand extends CommandExecutor {
	
	static ServerLinksMain main;
	

	public ServerLinksCommand(ServerLinksMain serverLinksMain) {
		main = serverLinksMain;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (label.equalsIgnoreCase("serverlinks")) {
			if (args.length == 0) {
				sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
						"&7Server running&3 ServerLinks"));
				sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
						"&7Plugin version&3 " + main.getDescription().getVersion()));
				sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
						"&7Plugin made by&3 Number3504"));
				sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
						"&7If you like my plugin, consider leaving a &3review&7 on the SpigotMC page to help me out!"));
				sender.sendMessage(
						ChatColor.translateAlternateColorCodes('&', "&7To find plugin commands, do &3/sl help"));
				return true;
			}
		}
		return false;
	}

}

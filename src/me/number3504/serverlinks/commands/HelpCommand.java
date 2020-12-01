package me.number3504.serverlinks.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class HelpCommand extends CommandExecutor {

	public HelpCommand() {
		setCommand("help");
		setLength(2);
		setOptional(true);
	}

	@Override
	public void execute(CommandSender sender, String[] args) {
		if (args.length == 1) {
			sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
					"&8&m &8&m &8&m &8&m&r &bServerLinks Commands &8&m &8&m &8&m &8&m &r &7(1/2)"));
			sender.sendMessage(
					ChatColor.translateAlternateColorCodes('&', "&8>&r &3/ServerLinks &8- &bBase plugin command"));
			sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
					"&8>&r &3/ServerLinks help &8- &bShows you this help message"));
			sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
					"&8>&r &3/ServerLinks set <link> &8- &bSets the specified link"));
			sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
					"&8>&r &3/ServerLinks reload &8- &bReloads the plugin's config and messages"));
			sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
					"&8>&r &3/ServerLinks <link> &8- &bShows you the specified link"));
			sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
					"&8>&r &3/ServerLinks help 2 &8- &bShows you the second page of help"));
		}
		if (args[1].equalsIgnoreCase("2")) {
			sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
					"&8&m &8&m &8&m &8&m&r &bServerLinks Commands &8&m &8&m &8&m &8&m &r &7(2/2)"));
			sender.sendMessage(
					ChatColor.translateAlternateColorCodes('&', "&8>&r &3/ServerLinks list &8- &bLists all the links"));
			sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
					"&8>&r &3/ServerLinks reset <link | all> &8- &bSets the specified link to blank"));
			sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
					"&8>&r &3/ServerLinks prefix &8- &bShows you the plugin's prefix"));
			sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
					"&8>&r &3/ServerLinks permissions &8- &bShows a list of permissions"));
		}
	}

}

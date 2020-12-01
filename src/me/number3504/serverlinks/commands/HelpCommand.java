package me.number3504.serverlinks.commands;

import org.bukkit.command.CommandSender;

import me.number3504.serverlinks.Utils;

public class HelpCommand extends CommandExecutor {

	public HelpCommand() {
		setCommand("help");
		setLength(1);
	}

	@Override
	public void execute(CommandSender sender, String[] args) {
		sender.sendMessage(Utils.msg("&8&m &8&m &8&m &8&m&r &bServerLinks Commands &8&m &8&m &8&m &8&m "));
		sender.sendMessage(Utils.msg("&8>&r &3/ServerLinks &8- &bBase plugin command"));
		sender.sendMessage(Utils.msg("&8>&r &3/ServerLinks help &8- &bShows you this help message"));
		sender.sendMessage(Utils.msg("&8>&r &3/ServerLinks set <link> &8- &bSets the specified link"));
		sender.sendMessage(Utils.msg("&8>&r &3/ServerLinks reload &8- &bReloads the plugin's config and messages"));
		sender.sendMessage(Utils.msg("&8>&r &3/ServerLinks <link> &8- &bShows you the specified link"));
		sender.sendMessage(Utils.msg("&8>&r &3/ServerLinks list &8- &bLists all the links"));
		sender.sendMessage(Utils.msg("&8>&r &3/ServerLinks reset <link | all> &8- &bSets the specified link to blank"));
		sender.sendMessage(Utils.msg("&8>&r &3/ServerLinks prefix &8- &bShows you the plugin's prefix"));
		sender.sendMessage(Utils.msg("&8>&r &3/ServerLinks permissions &8- &bShows a list of permissions"));
	}

}

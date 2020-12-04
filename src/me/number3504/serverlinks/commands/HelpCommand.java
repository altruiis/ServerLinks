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
		sender.sendMessage(Utils.msg("&8>&r &3/ServerLinks info &8- &bMisc. information about the plugin"));
		sender.sendMessage(Utils.msg("&8>&r &3/ServerLinks help &8- &bShows this help message"));
		sender.sendMessage(Utils.msg("&8>&r &3/ServerLinks set <link> &8- &bSets the specified link"));
		sender.sendMessage(Utils.msg("&8>&r &3/ServerLinks reload &8- &bReloads the plugin's config"));
		sender.sendMessage(Utils.msg("&8>&r &3/ServerLinks link <link> &8- &bShows the specified link"));
		sender.sendMessage(Utils.msg("&8>&r &3/ServerLinks list &8- &bLists all the links"));
		sender.sendMessage(Utils.msg("&8>&r &3/ServerLinks vote &8- &bLists vote links"));
		sender.sendMessage(Utils.msg("&8>&r &3/ServerLinks reset <link> &8- &bSets the specified link to blank"));
	}

}

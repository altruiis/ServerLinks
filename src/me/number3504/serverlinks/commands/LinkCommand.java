package me.number3504.serverlinks.commands;

import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import me.number3504.serverlinks.ServerLinksMain;
import me.number3504.serverlinks.Utils;

public class LinkCommand extends CommandExecutor {

	public LinkCommand() {
		setCommand("link");
		setLength(2);
	}

	JavaPlugin main = ServerLinksMain.main;

	@Override
	public void execute(CommandSender sender, String[] args) {
		if (!main.getConfig().contains("links." + args[1])) {
			sender.sendMessage(Utils.msg(
					main.getConfig().getString("messages.prefix") + main.getConfig().getString("messages.noLinkSet")));
			return;
		}
		if (main.getConfig().getString("links." + args[1]).equals("")) {
			sender.sendMessage(Utils.msg(
					main.getConfig().getString("messages.prefix") + main.getConfig().getString("messages.noLinkSet")));
		}
		sender.sendMessage(Utils.msg(main.getConfig().getString("links." + args[1])));
	}

}

package me.number3504.serverlinks.commands;

import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import me.number3504.serverlinks.ServerLinksMain;
import me.number3504.serverlinks.Utils;

public class ResetCommand extends CommandExecutor {

	public ResetCommand() {
		setCommand("reset");
		setLength(2);
		setPermission("links.reset");
		setUsage(main.getConfig().getString("messages.resetUsage"));
	}

	JavaPlugin main = ServerLinksMain.main;

	@Override
	public void execute(CommandSender sender, String[] args) {
		main.getConfig().set("links." + args[1], "");
		main.saveConfig();
		main.reloadConfig();
		sender.sendMessage(Utils.msg(main.getConfig().getString("messages.prefix")
				+ main.getConfig().getString("messages.linkReset").replace("%link%", args[1])));
	}

}

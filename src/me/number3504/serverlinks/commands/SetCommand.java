package me.number3504.serverlinks.commands;

import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import me.number3504.serverlinks.ServerLinksMain;
import me.number3504.serverlinks.Utils;

public class SetCommand extends CommandExecutor {
	
	public SetCommand() {
		setCommand("set");
		setLength(3);
		setPermission("links.set");
	}
	
	JavaPlugin main = ServerLinksMain.main;

	@Override
	public void execute(CommandSender sender, String[] args) {
		StringBuilder s = new StringBuilder();
		for (int i = 2; i < args.length; i++) {
			s.append(args[i] + " ");
		}
		String link = s.toString();
		main.getConfig().set("links." + args[1], link);
		main.saveConfig();
		sender.sendMessage(Utils.msg(main.getConfig().getString("messages.prefix") + main.getConfig().getString("messages.linkSet").replace("%link%", args[1]) + link));
		main.reloadConfig();
	}

}

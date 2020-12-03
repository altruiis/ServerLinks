package me.number3504.serverlinks.commands;

import java.util.HashMap;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import me.number3504.serverlinks.ServerLinksMain;
import me.number3504.serverlinks.Utils;

public class CommandHandler implements org.bukkit.command.CommandExecutor {

	private HashMap<String, CommandExecutor> commands = new HashMap<String, CommandExecutor>();

	public CommandHandler() {
		commands.put("info", new InfoCommand());
		commands.put("help", new HelpCommand());
		commands.put("reload", new ReloadCommand());
		commands.put("list", new ListCommand());
		commands.put("set", new SetCommand());
		commands.put("reset", new ResetCommand());
	}

	JavaPlugin main = ServerLinksMain.main;

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("serverlinks") || (cmd.getName().equalsIgnoreCase("sl"))) {
			if (args.length == 0) {
				sender.sendMessage(Utils.msg("&7Server running&3 ServerLinks"));
				sender.sendMessage(Utils.msg("&7Plugin version&3 3.0"));
				sender.sendMessage(Utils.msg("&7Plugin made by&3 Number3504"));
				sender.sendMessage(Utils.msg(
						"&7If you like my plugin, consider leaving a &3review&7 on the SpigotMC page to help me out!"));
				sender.sendMessage(Utils.msg("&7To find plugin commands, do &3/sl help"));
				return true;
			}
			if (args[0] != null) {
				String name = args[0].toLowerCase();
				if (commands.containsKey(name)) {
					final CommandExecutor command = commands.get(name);

					if (command.getPermission() != null && !sender.hasPermission(command.getPermission())) {
						sender.sendMessage(Utils.msg(main.getConfig().getString("messages.noPermission").replace("%permission%", command.getPermission())));
						return true;
					}
					if (command.getLength() > args.length) {
						sender.sendMessage(
								Utils.msg("&7Incorrect usage. Are you sure you are using the correct command?"));
						return true;
					}
					command.execute(sender, args);
					return true;
				}
			}
		}
		return false;
	}
}
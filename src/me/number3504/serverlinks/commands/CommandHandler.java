package me.number3504.serverlinks.commands;

import java.util.HashMap;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import me.number3504.serverlinks.ServerLinksMain;
import me.number3504.serverlinks.Utils;

public class CommandHandler implements org.bukkit.command.CommandExecutor {
	
	private HashMap<String, CommandExecutor> commands = new HashMap<String, CommandExecutor>();
	
	public CommandHandler() {
		commands.put("info", new ServerLinksCommand());
	}
	
	static ServerLinksMain plugin;
	

	public CommandHandler(ServerLinksMain serverLinksMain) {
		plugin = serverLinksMain;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		String name = cmd.getName().toLowerCase();
		if (commands.containsKey(name)) {
			final CommandExecutor command = commands.get(name);
			
			if (command.getPermission() != null && !sender.hasPermission(command.getPermission())) {
				sender.sendMessage(Utils.msg(plugin.config.getString("noPermission")));
			}
		}
		
		return false;
	}
}
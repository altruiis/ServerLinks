package me.number3504.serverlinks.commands;

import java.util.HashMap;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class CommandHandler implements org.bukkit.command.CommandExecutor {
	
	private HashMap<String, CommandExecutor> commands = new HashMap<String, CommandExecutor>();
	
	public CommandHandler() {
		
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		
		return false;
	}
}
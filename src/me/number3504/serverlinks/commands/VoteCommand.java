package me.number3504.serverlinks.commands;

import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import me.number3504.serverlinks.ServerLinksMain;
import me.number3504.serverlinks.Utils;

public class VoteCommand extends CommandExecutor {

	public VoteCommand() {
		setCommand("vote");
		setLength(1);
	}
	
	JavaPlugin main = ServerLinksMain.main;
	
	@Override
	public void execute(CommandSender sender, String[] args) {
		for (String s : main.getConfig().getStringList("vote")) {
			sender.sendMessage(Utils.msg(s));
		}
		
	}

}

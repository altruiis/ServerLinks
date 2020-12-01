package me.number3504.serverlinks.commands;

import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import me.number3504.serverlinks.ServerLinksMain;
import me.number3504.serverlinks.Utils;

public class InfoCommand extends CommandExecutor {

	JavaPlugin main = ServerLinksMain.main;

	public InfoCommand() {
		setCommand("info");
		setLength(1);
	}

	public void execute(CommandSender sender, String[] args) {
		sender.sendMessage(Utils.msg(main.getConfig().getString("messages.prefix")));
		sender.sendMessage(Utils
				.msg("&7Need assistance? Leave a reply on &3https://www.spigotmc.org/threads/serverlinks.271288/"));
		sender.sendMessage(Utils
				.msg("&7Make sure to include relevant server info, like your &3Server version &7and &3console log"));
		sender.sendMessage(
				Utils.msg("&7You can also leave a review on &3https://www.spigotmc.org/resources/serverlinks.46807/"));
		sender.sendMessage(Utils.msg("&7To find plugin commands, do &3/sl help"));
	}

}

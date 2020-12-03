package me.number3504.serverlinks.commands;

import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import me.number3504.serverlinks.ServerLinksMain;
import me.number3504.serverlinks.Utils;

public class ReloadCommand extends CommandExecutor {

	JavaPlugin main = ServerLinksMain.main;

	public ReloadCommand() {
		setCommand("reload");
		setPermission("links.reload");
		setLength(1);
	}

	@Override
	public void execute(CommandSender sender, String[] args) {
		main.saveConfig();
		main.reloadConfig();
		sender.sendMessage(Utils.msg(
				main.getConfig().getString("messages.prefix") + main.getConfig().getString("messages.configReloaded")));
	}
}

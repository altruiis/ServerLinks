package me.number3504.serverlinks.commands;

import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import me.number3504.serverlinks.ServerLinksMain;
import me.number3504.serverlinks.Utils;

public class ListCommand extends CommandExecutor {

	JavaPlugin main = ServerLinksMain.main;

	@Override
	public void execute(CommandSender sender, String[] args) {
		sender.sendMessage(Utils.msg(main.getConfig().getString("messages.prefix")));
		sender.sendMessage(Utils.msg("&3Twitter: &b" + main.getConfig().getString("links.twitter")));
		sender.sendMessage(Utils.msg("&3Facebook: &b" + main.getConfig().getString("links.facebook")));
		sender.sendMessage(Utils.msg("&3Instagram: &b" + main.getConfig().getString("links.instagram")));
		sender.sendMessage(Utils.msg("&3Youtube: &b" + main.getConfig().getString("links.youtube")));
		sender.sendMessage(Utils.msg("&3Forum: &b" + main.getConfig().getString("links.forum")));
		sender.sendMessage(Utils.msg("&3Discord: &b" + main.getConfig().getString("links.discord")));
		sender.sendMessage(Utils.msg("&3Reports: &b" + main.getConfig().getString("links.reports")));
		sender.sendMessage(Utils.msg("&3Appeals: &b" + main.getConfig().getString("links.appeals")));
		sender.sendMessage(Utils.msg("&3Webstore: &b" + main.getConfig().getString("links.webstore")));
	}
}

package me.number3504.serverlinks;

import org.bukkit.plugin.java.JavaPlugin;

import me.number3504.serverlinks.commands.CommandHandler;

public class ServerLinksMain extends JavaPlugin {

	public static JavaPlugin main;

	public void onEnable() {
		main = this;
		getCommand("serverlinks").setExecutor(new CommandHandler());
		loadConfiguration();
		loadMessages();
		System.out.print(Utils.msg(getConfig().getString("messages.prefix") + "&aServerLinks successfully enabled"));
	}

	public void onDisable() {
		System.out.print(Utils.msg(getConfig().getString("messages.prefix") + "&aServerLinks successfully disabled"));
	}

	public void loadMessages() {
		getConfig().addDefault("messages.linkSet", "&aYou set the&7 %link% &ato: ");
		getConfig().addDefault("messages.noPermission", "&cYou do not have the&4 %permission% &cpermission!");
		getConfig().addDefault("messages.prefix", "&7[&3ServerLinks&7] &r");
		getConfig().addDefault("messages.invalidCmd", "&cUnknown command. Do /sl help for commands.");
		getConfig().addDefault("messages.configReloaded", "&aConfiguration reloaded successfully!");
		getConfig().addDefault("messages.linkReset", "&aYou reset the&7 %link%&a.");
		getConfig().addDefault("messages.specifyMessage", "&cPlease specify a message.");
		getConfig().addDefault("messages.specifyLink", "&cPlease specify a link.");
		getConfig().addDefault("messages.allReset", "&aYou reset all links.");
		getConfig().addDefault("messages.noLinkSet", "&cNo link has been set. Please contact an administrator.");
	}

	public void loadConfiguration() {
		getConfig().addDefault("links.appeals", "");
		getConfig().addDefault("links.twitter", "");
		getConfig().addDefault("links.facebook", "");
		getConfig().addDefault("links.discord", "");
		getConfig().addDefault("links.youtube", "");
		getConfig().addDefault("links.forum", "");
		getConfig().addDefault("links.instagram", "");
		getConfig().addDefault("links.reports", "");
		getConfig().addDefault("links.webstore", "");
		getConfig().options().copyDefaults(true);
		saveConfig();
	}

}
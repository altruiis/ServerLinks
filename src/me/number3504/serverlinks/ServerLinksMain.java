package me.number3504.serverlinks;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import me.number3504.serverlinks.commands.CommandHandler;

public class ServerLinksMain extends JavaPlugin {

	public static JavaPlugin main;

	public void onEnable() {
		main = this;
		getCommand("serverlinks").setExecutor(new CommandHandler());
		loadConfiguration();
		loadMessages();
		System.out.print(ChatColor.translateAlternateColorCodes('&',
				String.valueOf(getConfig().getString("messages.prefix")) + "&aServerLinks successfully enabled"));
	}

	public void onDisable() {
		System.out.print(ChatColor.translateAlternateColorCodes('&',
				String.valueOf(getConfig().getString("messages.prefix")) + "&aServerLinks successfully disabled"));
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

	/*
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if (cmd.getName().equalsIgnoreCase("serverlinks"))
			try {
				if (args[0].equalsIgnoreCase("appeals")) {
					if (getConfig().getString("links.appeals").equals("")) {
						sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
								String.valueOf(this.config.getString("prefix")) + this.config.getString("noLinkSet")));
						return true;
					}
					sender.sendMessage(
							ChatColor.translateAlternateColorCodes('&', getConfig().getString("links.appeals")));
					return true;
				}
				if (args[0].equalsIgnoreCase("youtube")) {
					if (getConfig().getString("links.youtube").equals("")) {
						sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
								String.valueOf(this.config.getString("prefix")) + this.config.getString("noLinkSet")));
						return true;
					}
					sender.sendMessage(
							ChatColor.translateAlternateColorCodes('&', getConfig().getString("links.youtube")));
					return true;
				}
				if (args[0].equalsIgnoreCase("reports")) {
					if (getConfig().getString("links.reports").equals("")) {
						sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
								String.valueOf(this.config.getString("prefix")) + this.config.getString("noLinkSet")));
						return true;
					}
					sender.sendMessage(
							ChatColor.translateAlternateColorCodes('&', getConfig().getString("links.reports")));
					return true;
				}
				if (args[0].equalsIgnoreCase("discord")) {
					if (getConfig().getString("links.discord").equals("")) {
						sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
								String.valueOf(this.config.getString("prefix")) + this.config.getString("noLinkSet")));
						return true;
					}
					sender.sendMessage(
							ChatColor.translateAlternateColorCodes('&', getConfig().getString("links.discord")));
					return true;
				}
				if (args[0].equalsIgnoreCase("instagram")) {
					if (getConfig().getString("links.instagram").equals("")) {
						sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
								String.valueOf(this.config.getString("prefix")) + this.config.getString("noLinkSet")));
						return true;
					}
					sender.sendMessage(
							ChatColor.translateAlternateColorCodes('&', getConfig().getString("links.instagram")));
					return true;
				}
				if (args[0].equalsIgnoreCase("facebook")) {
					if (getConfig().getString("links.facebook").equals("")) {
						sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
								String.valueOf(this.config.getString("prefix")) + this.config.getString("noLinkSet")));
						return true;
					}
					sender.sendMessage(
							ChatColor.translateAlternateColorCodes('&', getConfig().getString("links.facebook")));
					return true;
				}
				if (args[0].equalsIgnoreCase("twitter")) {
					if (getConfig().getString("links.twitter").equals("")) {
						sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
								String.valueOf(this.config.getString("prefix")) + this.config.getString("noLinkSet")));
						return true;
					}
					sender.sendMessage(
							ChatColor.translateAlternateColorCodes('&', getConfig().getString("links.twitter")));
					return true;
				}
				if (args[0].equalsIgnoreCase("webstore")) {
					if (getConfig().getString("links.webstore").equals("")) {
						sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
								String.valueOf(this.config.getString("prefix")) + this.config.getString("noLinkSet")));
						return true;
					}
					sender.sendMessage(
							ChatColor.translateAlternateColorCodes('&', getConfig().getString("links.webstore")));
					return true;
				}
				if (args[0].equalsIgnoreCase("forum")) {
					if (getConfig().getString("links.forum").equals("")) {
						sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
								String.valueOf(this.config.getString("prefix")) + this.config.getString("noLinkSet")));
						return true;
					}
					sender.sendMessage(
							ChatColor.translateAlternateColorCodes('&', getConfig().getString("links.forum")));
					return true;
				}
			} catch (Exception e) {
				sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
						String.valueOf(getConfig().getString("messages.prefix")) + getConfig().getString("messages.invalidCommand")));
				Bukkit.getLogger().log(Level.SEVERE, "--------");
				Bukkit.getLogger().log(Level.SEVERE, "There was an error with the /sl command.");
				Bukkit.getLogger().log(Level.SEVERE, "Try running the command again.");
				Bukkit.getLogger().log(Level.SEVERE, "Otherwise, do /sl reload");
				Bukkit.getLogger().log(Level.SEVERE, "--------");
				e.printStackTrace();
			}
		return true;
	}
	*/

}
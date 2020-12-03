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
				if (args[0].equalsIgnoreCase("reset")) {
					if (!sender.hasPermission("links.reset")) {
						sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
								String.valueOf(this.config.getString("prefix")) + this.config.getString("noPermission")
										.replace("%permission%", "links.reset")));
						return true;
					}
					if (args.length == 1) {
						sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
								String.valueOf(this.config.getString("prefix"))
										+ this.config.getString("specifyLink")));
						return true;
					}
					if (args[1].equalsIgnoreCase("all")) {
						sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
								String.valueOf(this.config.getString("prefix")) + this.config.getString("allReset")));
						getConfig().set("links.discord", "");
						getConfig().set("links.youtube", "");
						getConfig().set("links.forum", "");
						getConfig().set("links.appeals", "");
						getConfig().set("links.reports", "");
						getConfig().set("links.instagram", "");
						getConfig().set("links.facebook", "");
						getConfig().set("links.twitter", "");
						saveConfig();
						reloadConfig();
						return true;
					}
					if (args[1].equalsIgnoreCase("discord")) {
						getConfig().set("links.discord", "");
						saveConfig();
						reloadConfig();
						sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
								String.valueOf(this.config.getString("prefix"))
										+ this.config.getString("linkReset").replace("%link%", "discord")));
						return true;
					}
					if (args[1].equalsIgnoreCase("webstore")) {
						getConfig().set("links.webstore", "");
						saveConfig();
						reloadConfig();
						sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
								String.valueOf(this.config.getString("prefix"))
										+ this.config.getString("linkReset").replace("%link%", "webstore")));
						return true;
					}
					if (args[1].equalsIgnoreCase("forum")) {
						getConfig().set("links.forum", "");
						saveConfig();
						reloadConfig();
						sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
								String.valueOf(this.config.getString("prefix"))
										+ this.config.getString("linkReset").replace("%link%", "forum")));
						return true;
					}
					if (args[1].equalsIgnoreCase("youtube")) {
						getConfig().set("links.youtube", "");
						saveConfig();
						reloadConfig();
						sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
								String.valueOf(this.config.getString("prefix"))
										+ this.config.getString("linkReset").replace("%link%", "youtube")));
						return true;
					}
					if (args[1].equalsIgnoreCase("reports")) {
						getConfig().set("links.reports", "");
						saveConfig();
						reloadConfig();
						sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
								String.valueOf(this.config.getString("prefix"))
										+ this.config.getString("linkReset").replace("%link%", "reports")));
						return true;
					}
					if (args[1].equalsIgnoreCase("appeals")) {
						getConfig().set("links.appeals", "");
						saveConfig();
						reloadConfig();
						sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
								String.valueOf(this.config.getString("prefix"))
										+ this.config.getString("linkReset").replace("%link%", "appeals")));
						return true;
					}
					if (args[1].equalsIgnoreCase("instagram")) {
						getConfig().set("links.instagram", "");
						saveConfig();
						reloadConfig();
						sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
								String.valueOf(this.config.getString("prefix"))
										+ this.config.getString("linkReset").replace("%link%", "instagram")));
						return true;
					}
					if (args[1].equalsIgnoreCase("facebook")) {
						getConfig().set("links.facebook", "");
						saveConfig();
						reloadConfig();
						sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
								String.valueOf(this.config.getString("prefix"))
										+ this.config.getString("linkReset").replace("%link%", "facebook")));
						return true;
					}
					if (args[1].equalsIgnoreCase("twitter")) {
						getConfig().set("links.twitter", "");
						saveConfig();
						reloadConfig();
						sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
								String.valueOf(this.config.getString("prefix"))
										+ this.config.getString("linkReset").replace("%link%", "twitter")));
						return true;
					}
				}
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
				if (args[0].equalsIgnoreCase("set")) {
					if (!sender.hasPermission("links.set")) {
						sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
								String.valueOf(this.config.getString("prefix"))
										+ this.config.getString("noPermission").replace("%permission%", "links.set")));
						return true;
					}
					if (args.length == 1) {
						sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
								String.valueOf(this.config.getString("prefix"))
										+ this.config.getString("specifyLink")));
						return true;
					}
					if (args[1].equalsIgnoreCase("prefix")) {
						if (args.length == 2) {
							sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
									String.valueOf(this.config.getString("prefix"))
											+ this.config.getString("specifyMessage")));
							return true;
						}
						StringBuilder string = new StringBuilder();
						for (int i = 2; i < args.length; i++)
							string.append(String.valueOf(args[i]) + " ");
						String prefix = string.toString();
						this.config.set("prefix", prefix);
						this.config.load(this.f);
						saveConfig();
						sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
								String.valueOf(this.config.getString("prefix"))
										+ this.config.getString("linkSet").replace("%link%", "prefix")
										+ ChatColor.translateAlternateColorCodes('&', prefix)));
						reloadConfig();
						return true;
					}
					if (args[1].equalsIgnoreCase("forum")) {
						if (args.length == 2) {
							sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
									String.valueOf(this.config.getString("prefix"))
											+ this.config.getString("specifyMessage")));
							return true;
						}
						StringBuilder string = new StringBuilder();
						for (int i = 2; i < args.length; i++)
							string.append(String.valueOf(args[i]) + " ");
						String forum = string.toString();
						getConfig().set("links.forum", forum);
						saveConfig();
						sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
								String.valueOf(this.config.getString("prefix"))
										+ this.config.getString("linkSet").replace("%link%", "forum")
										+ ChatColor.translateAlternateColorCodes('&', forum)));
						reloadConfig();
						return true;
					}
					if (args[1].equalsIgnoreCase("reports")) {
						if (args.length == 2) {
							sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
									String.valueOf(this.config.getString("prefix"))
											+ this.config.getString("specifyMessage")));
							return true;
						}
						StringBuilder string = new StringBuilder();
						for (int i = 2; i < args.length; i++)
							string.append(String.valueOf(args[i]) + " ");
						String forumreports = string.toString();
						getConfig().set("links.reports", forumreports);
						saveConfig();
						sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
								String.valueOf(this.config.getString("prefix"))
										+ this.config.getString("linkSet").replace("%link%", "reports")
										+ ChatColor.translateAlternateColorCodes('&', forumreports)));
						reloadConfig();
						return true;
					}
					if (args[1].equalsIgnoreCase("appeals")) {
						if (args.length == 2) {
							sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
									String.valueOf(this.config.getString("prefix"))
											+ this.config.getString("specifyMessage")));
							return true;
						}
						StringBuilder string = new StringBuilder();
						for (int i = 2; i < args.length; i++)
							string.append(String.valueOf(args[i]) + " ");
						String forumappeals = string.toString();
						getConfig().set("links.appeals", forumappeals);
						saveConfig();
						sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
								String.valueOf(this.config.getString("prefix"))
										+ this.config.getString("linkSet").replace("%link%", "appeals")
										+ ChatColor.translateAlternateColorCodes('&', forumappeals)));
						reloadConfig();
						return true;
					}
					if (args[1].equalsIgnoreCase("youtube")) {
						if (args.length == 2) {
							sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
									String.valueOf(this.config.getString("prefix"))
											+ this.config.getString("specifyMessage")));
							return true;
						}
						StringBuilder string = new StringBuilder();
						for (int i = 2; i < args.length; i++)
							string.append(String.valueOf(args[i]) + " ");
						String youtube = string.toString();
						getConfig().set("links.youtube", youtube);
						saveConfig();
						sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
								String.valueOf(this.config.getString("prefix"))
										+ this.config.getString("linkSet").replace("%link%", "youtube")
										+ ChatColor.translateAlternateColorCodes('&', youtube)));
						reloadConfig();
						return true;
					}
					if (args[1].equalsIgnoreCase("instagram")) {
						if (args.length == 2) {
							sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
									String.valueOf(this.config.getString("prefix"))
											+ this.config.getString("specifyMessage")));
							return true;
						}
						StringBuilder string = new StringBuilder();
						for (int i = 2; i < args.length; i++)
							string.append(String.valueOf(args[i]) + " ");
						String instagram = string.toString();
						getConfig().set("links.instagram", instagram);
						saveConfig();
						sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
								String.valueOf(this.config.getString("prefix"))
										+ "linkSet".replace("%link%", "instagram")
										+ ChatColor.translateAlternateColorCodes('&', instagram)));
						reloadConfig();
						return true;
					}
					if (args[1].equalsIgnoreCase("facebook")) {
						if (args.length == 2) {
							sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
									String.valueOf(this.config.getString("prefix"))
											+ this.config.getString("specifyMessage")));
							return true;
						}
						StringBuilder string = new StringBuilder();
						for (int i = 2; i < args.length; i++)
							string.append(String.valueOf(args[i]) + " ");
						String facebook = string.toString();
						getConfig().set("links.facebook", facebook);
						saveConfig();
						sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
								String.valueOf(this.config.getString("prefix"))
										+ this.config.getString("linkSet").replace("%link%", "facebook")
										+ ChatColor.translateAlternateColorCodes('&', facebook)));
						reloadConfig();
						return true;
					}
					if (args[1].equalsIgnoreCase("discord")) {
						if (args.length == 2) {
							sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
									String.valueOf(this.config.getString("prefix"))
											+ this.config.getString("specifyMessage")));
							return true;
						}
						StringBuilder string = new StringBuilder();
						for (int i = 2; i < args.length; i++)
							string.append(String.valueOf(args[i]) + " ");
						String discord = string.toString();
						getConfig().set("links.discord", discord);
						saveConfig();
						sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
								String.valueOf(this.config.getString("prefix"))
										+ this.config.getString("linkSet").replace("%link%", "discord")
										+ ChatColor.translateAlternateColorCodes('&', discord)));
						reloadConfig();
						return true;
					}
					if (args[1].equalsIgnoreCase("webstore")) {
						if (args.length == 2) {
							sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
									String.valueOf(this.config.getString("prefix"))
											+ this.config.getString("specifyMessage")));
							return true;
						}
						StringBuilder string = new StringBuilder();
						for (int ii = 2; ii < args.length; ii++)
							string.append(String.valueOf(args[ii]) + " ");
						String webstore = string.toString();
						getConfig().set("links.webstore", webstore);
						saveConfig();
						sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
								String.valueOf(this.config.getString("prefix"))
										+ this.config.getString("linkSet").replace("%link%", "webstore")
										+ ChatColor.translateAlternateColorCodes('&', webstore)));
						reloadConfig();
						return true;
					}
				}
				if (args[1].equalsIgnoreCase("twitter")) {
					if (args.length == 2) {
						sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
								String.valueOf(this.config.getString("prefix"))
										+ this.config.getString("specifyMessage")));
						return true;
					}
					StringBuilder string = new StringBuilder();
					for (int iiiiii = 2; iiiiii < args.length; iiiiii++)
						string.append(String.valueOf(args[iiiiii]) + " ");
					String twitter = string.toString();
					getConfig().set("links.twitter", twitter);
					saveConfig();
					sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
							String.valueOf(this.config.getString("prefix"))
									+ this.config.getString("linkSet").replace("%link%", "twitter")
									+ ChatColor.translateAlternateColorCodes('&', twitter)));
					reloadConfig();
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
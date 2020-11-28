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

public class ServerLinksMain extends JavaPlugin {
	public void onEnable() {
		loadMessages();
		loadConfiguration();
		System.out.print(ChatColor.translateAlternateColorCodes('&',
				String.valueOf(this.config.getString("prefix")) + "&aServerLinks successfully enabled"));
	}

	public void onDisable() {
		System.out.print(ChatColor.translateAlternateColorCodes('&',
				String.valueOf(this.config.getString("prefix")) + "&aServerLinks successfully disabled"));
	}

	public void setMessage(String name, String message) {
		File f = new File(getDataFolder() + File.separator + "messages.yml");
		YamlConfiguration yamlConfiguration = YamlConfiguration.loadConfiguration(f);
		if (!yamlConfiguration.isSet(name)) {
			yamlConfiguration.set(name, message);
			try {
				yamlConfiguration.save(f);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public File f = new File(getDataFolder() + File.separator + "messages.yml");

	public FileConfiguration config = (FileConfiguration) YamlConfiguration.loadConfiguration(this.f);

	public void loadMessages() {
		File f = new File(getDataFolder() + File.separator + "messages.yml");
		if (!f.exists())
			try {
				f.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		this.config.addDefault("linkSet", "&aYou set the&7 %link% &ato: ");
		this.config.addDefault("noPermission", "&cYou do not have the&4 %permission% &cpermission!");
		this.config.addDefault("prefix", "&7[&3ServerLinks&7] &r");
		this.config.addDefault("invalidCmd", "&cUnknown command. Do /sl help for commands.");
		this.config.addDefault("configReloaded", "&aConfiguration reloaded successfully!");
		this.config.addDefault("linkReset", "&aYou reset the&7 %link%&a.");
		this.config.addDefault("specifyMessage", "&cPlease specify a message.");
		this.config.addDefault("specifyLink", "&cPlease specify a link.");
		this.config.addDefault("allReset", "&aYou reset every link.");
		this.config.addDefault("noLinkSet", "&cNo link has been set. Please contact an administrator.");
		this.config.options().copyDefaults(true);
		try {
			this.config.save(this.f);
		} catch (IOException e) {
			e.printStackTrace();
		}
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

	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if (cmd.getName().equalsIgnoreCase("serverlinks"))
			try {
				if (args[0].equalsIgnoreCase("permissions") || args[0].equalsIgnoreCase("perms")) {
					sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
							"&8&m &8&m &8&m &8&m&r &bServerLinks Permissions &8&m &8&m &8&m &8&m"));
					sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8>&r &3links.set"));
					sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8>&r &3links.reset"));
					sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8>&r &3links.reload"));
					sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8>&r &3links.*"));
					return true;
				}
				if (args[0].equalsIgnoreCase("prefix")) {
					sender.sendMessage(ChatColor.translateAlternateColorCodes('&', this.config.getString("prefix")));
					return true;
				}
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
				if (args[0].equalsIgnoreCase("info")) {
					sender.sendMessage(ChatColor.translateAlternateColorCodes('&', this.config.getString("prefix")));
					sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
							"&7Need assistance? Leave a reply on &3https://www.spigotmc.org/threads/serverlinks.271288/"));
					sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
							"&7Make sure to include relevant server info, like your &3Server version &7and &3console log"));
					sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
							"&7You can also leave a review on &3https://www.spigotmc.org/resources/serverlinks.46807/"));
					sender.sendMessage(
							ChatColor.translateAlternateColorCodes('&', "&7To find plugin commands, do &3/sl help"));
					return true;
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
				if (args[0].equalsIgnoreCase("list")) {
					sender.sendMessage(ChatColor.translateAlternateColorCodes('&', this.config.getString("prefix")));
					sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
							"&3Twitter account: &b" + getConfig().getString("links.twitter")));
					sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
							"&3Facebook account: &b" + getConfig().getString("links.facebook")));
					sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
							"&3Instagram account: &b" + getConfig().getString("links.instagram")));
					sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
							"&3Youtube channel: &b" + getConfig().getString("links.youtube")));
					sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
							"&3Forum website: &b" + getConfig().getString("links.forum")));
					sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
							"&3Discord server: &b" + getConfig().getString("links.discord")));
					sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
							"&3Reports URL: &b" + getConfig().getString("links.reports")));
					sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
							"&3Appeals URL: &b" + getConfig().getString("links.appeals")));
					sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
							"&3Webstore: &b" + getConfig().getString("links.webstore")));
					return true;
				}
				if (args[0].equalsIgnoreCase("reload")) {
					if (!sender.hasPermission("links.reload")) {
						sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
								String.valueOf(this.config.getString("prefix")) + this.config.getString("noPermission")
										.replace("%permission%", "links.reload")));
						return true;
					}
					saveConfig();
					reloadConfig();
					this.config.load(this.f);
					sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
							String.valueOf(this.config.getString("prefix")) + this.config.getString("configReloaded")));
					return true;
				}
				if (args[0].equalsIgnoreCase("help")) {
					if (args.length == 1) {
						sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
								"&8&m &8&m &8&m &8&m&r &bServerLinks Commands &8&m &8&m &8&m &8&m &r &7(1/2)"));
						sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
								"&8>&r &3/ServerLinks &8- &bBase plugin command"));
						sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
								"&8>&r &3/ServerLinks help &8- &bShows you this help message"));
						sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
								"&8>&r &3/ServerLinks set <link> &8- &bSets the specified link"));
						sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
								"&8>&r &3/ServerLinks reload &8- &bReloads the plugin's config and messages"));
						sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
								"&8>&r &3/ServerLinks <link> &8- &bShows you the specified link"));
						sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
								"&8>&r &3/ServerLinks help 2 &8- &bShows you the second page of help"));
						return true;
					}
					if (args[1].equalsIgnoreCase("2")) {
						sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
								"&8&m &8&m &8&m &8&m&r &bServerLinks Commands &8&m &8&m &8&m &8&m &r &7(2/2)"));
						sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
								"&8>&r &3/ServerLinks list &8- &bLists all the links"));
						sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
								"&8>&r &3/ServerLinks reset <link | all> &8- &bSets the specified link to blank"));
						sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
								"&8>&r &3/ServerLinks prefix &8- &bShows you the plugin's prefix"));
						sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
								"&8>&r &3/ServerLinks permissions &8- &bShows you a list of permissions"));
						return true;
					}
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
						String.valueOf(this.config.getString("prefix")) + this.config.getString("invalidCommand")));
				Bukkit.getLogger().log(Level.SEVERE, "--------");
				Bukkit.getLogger().log(Level.SEVERE, "There was an error with the /sl command.");
				Bukkit.getLogger().log(Level.SEVERE, "Try running the command again.");
				Bukkit.getLogger().log(Level.SEVERE, "Otherwise, do /sl reload");
				Bukkit.getLogger().log(Level.SEVERE, "--------");
				e.printStackTrace();
			}
		return true;
	}
}
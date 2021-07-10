package me.number3504.serverlinks;

import me.number3504.serverlinks.commands.CommandHandler;
import me.number3504.serverlinks.listeners.InventoryClickListener;
import me.number3504.serverlinks.listeners.TabCompleteListener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public class Main extends JavaPlugin {

    public void onEnable() {
        getCommand("serverlinks").setExecutor(new CommandHandler(this));
        getCommand("serverlinks").setTabCompleter(new TabCompleteListener(this));
        getServer().getPluginManager().registerEvents(new InventoryClickListener(this), this);
        loadConfiguration();
        loadMessages();
        getLogger().info("Plugin successfully enabled");
    }

    public void onDisable() {
        getLogger().info("Plugin successfully disabled");
    }

    public void loadMessages() {
        getConfig().addDefault("messages.linkSet", "&aYou set the&7 %link% &ato: ");
        getConfig().addDefault("messages.noPermission", "&cYou do not have the&4 %permission% &cpermission!");
        getConfig().addDefault("messages.prefix", "&7[&3ServerLinks&7] &r");
        getConfig().addDefault("messages.invalidCmd", "&cUnknown command or arguments. Are you sure you are using the correct command?");
        getConfig().addDefault("messages.configReloaded", "&aConfiguration reloaded successfully!");
        getConfig().addDefault("messages.linkReset", "&aYou reset the&7 %link%&a.");
        getConfig().addDefault("messages.noLinkSet", "&cNo link has been set. Please contact an administrator.");
        getConfig().addDefault("messages.setUsage", "&cUsage: /ServerLinks set <link> <message>");
        getConfig().addDefault("messages.resetUsage", "&cUsage: /ServerLinks reset <link>");
        getConfig().addDefault("messages.linkUsage", "&cUsage: /ServerLinks link <link>");
        getConfig().addDefault("messages.linksNotSet", "&cNo links have been set!");
        getConfig().addDefault("messages.guiName", "&3ServerLinks");
        getConfig().addDefault("messages.guiItemColor", "&3");
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
        List<String> vote = new ArrayList<>();
        vote.add("PlanetMinecraft");
        vote.add("MCSL");
        getConfig().addDefault("vote", vote);
        getConfig().options().copyDefaults(true);
        saveConfig();
    }

}
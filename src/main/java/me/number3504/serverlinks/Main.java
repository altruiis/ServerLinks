package me.number3504.serverlinks;

import me.number3504.serverlinks.commands.CommandHandler;
import me.number3504.serverlinks.listeners.InventoryClickListener;
import me.number3504.serverlinks.listeners.TabCompleteListener;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    private static Main instance;

    public void onEnable() {
        instance = this;
        getCommand("serverlinks").setExecutor(new CommandHandler(this));
        getCommand("serverlinks").setTabCompleter(new TabCompleteListener(this));
        getServer().getPluginManager().registerEvents(new InventoryClickListener(this), this);
        loadConfiguration();
        if (getServer().getPluginManager().getPlugin("PlaceholderAPI") != null) {
            new Placeholders(this).register();
        }
    }

    public void onDisable() {
    }

    public void loadConfiguration() {
        getConfig().options().copyDefaults(true);
        saveDefaultConfig();
    }

    public static Main getInstance() {
        return instance;
    }

}
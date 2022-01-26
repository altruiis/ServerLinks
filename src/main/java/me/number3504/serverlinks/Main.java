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
    }

    public void onDisable() { }

    public void loadConfiguration() {
        getConfig().options().copyDefaults(true);
        saveConfig();
    }

}
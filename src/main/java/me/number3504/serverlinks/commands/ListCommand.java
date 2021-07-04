package me.number3504.serverlinks.commands;

import me.number3504.serverlinks.Main;
import me.number3504.serverlinks.Utils;
import org.bukkit.command.CommandSender;

public class ListCommand extends CommandExecutor {

    Main main;

    public ListCommand(Main main) {
        this.main = main;
        setCommand("list");
        setLength(1);
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        main.getConfig().getConfigurationSection("links").getKeys(false).forEach(key -> {
            if (!main.getConfig().getString("links." + key).equals("")) {
                sender.sendMessage(Utils.msg("&3" + Utils.cap(key) + "&7:&r " + main.getConfig().getString("links." + key)));
            }
        });
    }
}

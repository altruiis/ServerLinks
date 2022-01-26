package me.number3504.serverlinks.commands;

import me.number3504.serverlinks.Main;
import me.number3504.serverlinks.Utils;
import org.bukkit.command.CommandSender;

public class ListCommand extends CommandExecutor {

    private final Main main;

    public ListCommand(Main main) {
        this.main = main;
        setCommand("list");
        setLength(1);
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (main.getConfig().getConfigurationSection("links").getKeys(false).stream().allMatch(s -> main.getConfig().getString("links." + s).equals(""))) {
            sender.sendMessage(Utils.msg(main.getConfig().getString("messages.prefix") + main.getConfig().getString("messages.linksNotSet")));
            return;
        }
        main.getConfig().getConfigurationSection("links").getKeys(false).forEach(key -> {
            if (!main.getConfig().getString("links." + key).equals("")) {
                sender.sendMessage(Utils.msg("&3" + Utils.cap(key) + "&7:&r " + main.getConfig().getString("links." + key)));
            }
        });
    }
}

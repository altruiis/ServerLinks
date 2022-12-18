package me.number3504.serverlinks.commands;

import me.number3504.serverlinks.Main;
import me.number3504.serverlinks.Utils;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.ConfigurationSection;

public class ListCommand extends CommandExecutor {

    private final Main main;

    public ListCommand(Main main) {
        this.main = main;
        setCommand("list");
        setLength(1);
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        ConfigurationSection section = main.getConfig().getConfigurationSection("links");
        if (section.getKeys(false).stream().allMatch(s -> main.getConfig().getString("links." + s).isEmpty())) {
            sender.sendRichMessage(main.getConfig().getString("messages.prefix") + main.getConfig().getString("messages.linksNotSet"));
            return;
        }
        section.getKeys(false).forEach(key -> {
            if (!main.getConfig().getString("links." + key).isEmpty()) {
                sender.sendRichMessage("<dark_aqua>" + Utils.cap(key) + "<gray>:<reset> " + main.getConfig().getString("links." + key));
            }
        });
    }
}

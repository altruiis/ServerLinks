package me.number3504.serverlinks.commands;

import me.number3504.serverlinks.Main;
import me.number3504.serverlinks.Utils;
import org.bukkit.command.CommandSender;

public class LinkCommand extends CommandExecutor {

    private final Main main;

    public LinkCommand(Main main) {
        this.main = main;
        setCommand("link");
        setLength(2);
        setUsage(main.getConfig().getString("messages.linkUsage"));
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (!main.getConfig().contains("links." + args[1])) {
            sender.sendMessage(Utils.msg(
                    main.getConfig().getString("messages.prefix") + main.getConfig().getString("messages.noLinkSet")));
            return;
        }
        if (main.getConfig().getString("links." + args[1]).equals("")) {
            sender.sendMessage(Utils.msg(
                    main.getConfig().getString("messages.prefix") + main.getConfig().getString("messages.noLinkSet")));
            return;
        }
        sender.sendMessage(Utils.msg(main.getConfig().getString("links." + args[1])));
    }

}

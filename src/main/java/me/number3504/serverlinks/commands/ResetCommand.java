package me.number3504.serverlinks.commands;

import me.number3504.serverlinks.Main;
import org.bukkit.command.CommandSender;

public class ResetCommand extends CommandExecutor {

    private final Main main;

    public ResetCommand(Main main) {
        this.main = main;
        setCommand("reset");
        setLength(2);
        setPermission("links.reset");
        setUsage(main.getConfig().getString("messages.resetUsage"));
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        main.getConfig().set("links." + args[1], null);
        main.saveConfig();
        main.reloadConfig();
        sender.sendRichMessage(main.getConfig().getString("messages.prefix")
                + main.getConfig().getString("messages.linkReset").replace("%link%", args[1]));
    }

}

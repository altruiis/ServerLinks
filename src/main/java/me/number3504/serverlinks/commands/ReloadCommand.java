package me.number3504.serverlinks.commands;

import me.number3504.serverlinks.Main;
import me.number3504.serverlinks.Utils;
import org.bukkit.command.CommandSender;

public class ReloadCommand extends CommandExecutor {


    Main main;

    public ReloadCommand(Main main) {
        this.main = main;
        setCommand("reload");
        setPermission("links.reload");
        setLength(1);
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        main.reloadConfig();
        sender.sendMessage(Utils.msg(
                main.getConfig().getString("messages.prefix") + main.getConfig().getString("messages.configReloaded")));
    }
}

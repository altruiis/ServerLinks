package me.number3504.serverlinks.commands;

import me.number3504.serverlinks.Main;
import me.number3504.serverlinks.Utils;
import org.bukkit.command.CommandSender;

public class InfoCommand extends CommandExecutor {

    Main main;

    public InfoCommand(Main main) {
        this.main = main;
        setCommand("info");
        setLength(1);
    }

    public void execute(CommandSender sender, String[] args) {
        sender.sendMessage(Utils.msg(main.getConfig().getString("messages.prefix")));
        sender.sendMessage(Utils
                .msg("&7Need assistance? Make an issue at &3https://github.com/Altruiis/ServerLinks/issues/"));
        sender.sendMessage(Utils
                .msg("&7Make sure to include relevant server info, like your &3server version &7and &3error log"));
        sender.sendMessage(
                Utils.msg("&7You can also leave a review on &3https://www.spigotmc.org/resources/serverlinks.46807/"));
        sender.sendMessage(Utils.msg("&7To find plugin commands, do &3/sl help"));
    }

}

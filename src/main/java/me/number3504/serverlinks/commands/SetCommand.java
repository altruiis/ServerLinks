package me.number3504.serverlinks.commands;

import me.number3504.serverlinks.Main;
import me.number3504.serverlinks.Utils;
import org.bukkit.command.CommandSender;

public class SetCommand extends CommandExecutor {

    Main main;

    public SetCommand(Main main) {
        this.main = main;
        setCommand("set");
        setLength(3);
        setPermission("links.set");
        setUsage(main.getConfig().getString("messages.setUsage"));
    }


    @Override
    public void execute(CommandSender sender, String[] args) {
        StringBuilder s = new StringBuilder();
        for (int i = 2; i < args.length; i++) {
            s.append(args[i] + " ");
        }
        String link = s.toString();
        main.getConfig().set("links." + args[1], link);
        main.saveConfig();
        main.reloadConfig();
        sender.sendMessage(Utils.msg(main.getConfig().getString("messages.prefix")
                + main.getConfig().getString("messages.linkSet").replace("%link%", args[1]) + link));
    }

}

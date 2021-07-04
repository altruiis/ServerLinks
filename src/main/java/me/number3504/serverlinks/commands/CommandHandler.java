package me.number3504.serverlinks.commands;

import me.number3504.serverlinks.Main;
import me.number3504.serverlinks.Utils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;

public class CommandHandler implements org.bukkit.command.CommandExecutor {

    private final HashMap<String, CommandExecutor> commands = new HashMap<>();

    Main main;

    public CommandHandler(Main main) {
        this.main = main;
        commands.put("info", new InfoCommand(main));
        commands.put("help", new HelpCommand());
        commands.put("reload", new ReloadCommand(main));
        commands.put("list", new ListCommand(main));
        commands.put("set", new SetCommand(main));
        commands.put("reset", new ResetCommand(main));
        commands.put("link", new LinkCommand(main));
        commands.put("vote", new VoteCommand(main));
        commands.put("gui", new GUICommand(main));
    }

    public boolean onCommand(@NotNull CommandSender sender, Command cmd, @NotNull String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("serverlinks")) {
            if (args.length == 0) {
                sender.sendMessage(Utils.msg("&7Server running&3 ServerLinks"));
                sender.sendMessage(Utils.msg("&7Plugin version&3 " + main.getDescription().getVersion()));
                sender.sendMessage(Utils.msg("&7Plugin made by&3 Number3504"));
                sender.sendMessage(Utils.msg(
                        "&7If you like my plugin, consider leaving a &3review&7 on the SpigotMC page to help me out!"));
                sender.sendMessage(Utils.msg("&7To find plugin commands, do &3/sl help"));
                return true;
            }
            if (args[0] != null) {
                String name = args[0].toLowerCase();
                if (!commands.containsKey(name)) {
                    sender.sendMessage(Utils.msg(main.getConfig().getString("messages.prefix")
                            + main.getConfig().getString("messages.invalidCmd")));
                    return true;
                }
                if (commands.containsKey(name)) {
                    final CommandExecutor command = commands.get(name);

                    if (command.getPermission() != null && !sender.hasPermission(command.getPermission())) {
                        sender.sendMessage(Utils.msg(main.getConfig().getString("messages.prefix") + main.getConfig()
                                .getString("messages.noPermission").replace("%permission%", command.getPermission())));
                        return true;
                    }
                    if (command.getLength() > args.length) {
                        if (command.getUsage() != null) {
                            sender.sendMessage(
                                    Utils.msg(main.getConfig().getString("messages.prefix") + command.getUsage()));
                            return true;
                        }
                    }
                    command.execute(sender, args);
                    return true;
                }
            }
        }
        return false;
    }
}
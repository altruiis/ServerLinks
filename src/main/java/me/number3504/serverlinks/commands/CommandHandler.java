package me.number3504.serverlinks.commands;

import me.number3504.serverlinks.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import java.util.HashMap;

public class CommandHandler implements org.bukkit.command.CommandExecutor {

    private final HashMap<String, CommandExecutor> commands = new HashMap<>();

    private final Main main;

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

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("serverlinks")) {
            if (args.length == 0) {
                commands.get("help").execute(sender, args);
                return true;
            }
            if (args[0] != null) {
                String name = args[0].toLowerCase();
                if (!commands.containsKey(name)) {
                    sender.sendRichMessage(main.getConfig().getString("messages.prefix")
                            + main.getConfig().getString("messages.invalidCmd"));
                    return true;
                }
                final CommandExecutor command = commands.get(name);
                if (command.getPermission() != null && !sender.hasPermission(command.getPermission())) {
                    sender.sendRichMessage(main.getConfig().getString("messages.prefix") + main.getConfig()
                            .getString("messages.noPermission").replace("%permission%", command.getPermission()));
                    return true;
                }
                if (command.getLength() > args.length) {
                    if (command.getUsage() != null) {
                        sender.sendRichMessage(main.getConfig().getString("messages.prefix") + command.getUsage());
                        return true;
                    }
                }
                command.execute(sender, args);
                return true;
            }
        }
        return true;
    }
}
package me.number3504.serverlinks.commands;

import me.number3504.serverlinks.Main;
import org.bukkit.command.CommandSender;

public class InfoCommand extends CommandExecutor {

    private final Main main;

    public InfoCommand(Main main) {
        this.main = main;
        setCommand("info");
        setLength(1);
    }

    public void execute(CommandSender sender, String[] args) {
        sender.sendRichMessage(main.getConfig().getString("messages.prefix"));
        sender.sendRichMessage("<gray>Need assistance? Make an issue on<dark_aqua> " +
                "<hover:show_text:'<aqua>Click to visit!'><click:open_url:'https://github.com/Altruiis/ServerLinks/'><u>GitHub");
        sender.sendRichMessage("<gray>Make sure to include relevant server info, like your <dark_aqua>server version <gray>and <dark_aqua>error log");
        sender.sendRichMessage("<gray>You can view the plugin on <hover:show_text:'<aqua>Click to visit!'><click:open_url:'https://modrinth.com/plugin/serverlinks'><dark_aqua><u>Modrinth");
        sender.sendRichMessage("<gray>To find plugin commands, do <hover:show_text:'<aqua><u>Click!'><click:run_command:'/sl help'><dark_aqua><u>/sl help");
    }

}

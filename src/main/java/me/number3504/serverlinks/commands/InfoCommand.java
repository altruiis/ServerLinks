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

    // TODO: Modrinth link
    public void execute(CommandSender sender, String[] args) {
        sender.sendRichMessage(main.getConfig().getString("messages.prefix"));
        sender.sendRichMessage("<gray>Need assistance? Make an issue on " +
                "<dark_aqua><click:open_url:https://github.com/Altruiis/ServerLinks/issues/><hover:show_text:Click to visit>the github");
        sender.sendRichMessage("<gray>Make sure to include relevant server info, like your <dark_aqua>server version <gray>and <dark_aqua>error log");
        sender.sendRichMessage("<gray>You can view the plugin on <dark_aqua>TODO");
        sender.sendRichMessage("<gray>To find plugin commands, do <dark_aqua>/sl help");
    }

}

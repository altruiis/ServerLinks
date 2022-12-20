package me.number3504.serverlinks.commands;

import org.bukkit.command.CommandSender;

public class HelpCommand extends CommandExecutor {

    public HelpCommand() {
        setCommand("help");
        setLength(1);
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        sender.sendRichMessage("<gray><st/><st>         <reset><gray>[<aqua>ServerLinks<gray>]<st/><st>         ");
        sender.sendRichMessage("<dark_gray>> <dark_aqua>/sl info <dark_gray>- <aqua>Misc. information about the plugin");
        sender.sendRichMessage("<dark_gray>> <dark_aqua>/sl help <dark_gray>- <aqua>Shows this help message");
        sender.sendRichMessage("<dark_gray>> <dark_aqua>/sl set <link> <dark_gray>- <aqua>Sets the specified link");
        sender.sendRichMessage("<dark_gray>> <dark_aqua>/sl reload <dark_gray>- <aqua>Reloads the plugin's config");
        sender.sendRichMessage("<dark_gray>> <dark_aqua>/sl link <link> <dark_gray>- <aqua>Shows the specified link");
        sender.sendRichMessage("<dark_gray>> <dark_aqua>/sl list <dark_gray>- <aqua>Lists all the links");
        sender.sendRichMessage("<dark_gray>> <dark_aqua>/sl vote <dark_gray>- <aqua>Lists vote links");
        sender.sendRichMessage("<dark_gray>> <dark_aqua>/sl reset <link> <dark_gray>- <aqua>Sets the specified link to blank");
    }

}

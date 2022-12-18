package me.number3504.serverlinks.commands;

import me.number3504.serverlinks.Main;
import org.bukkit.command.CommandSender;

public class VoteCommand extends CommandExecutor {


    private final Main main;

    public VoteCommand(Main main) {
        this.main = main;
        setCommand("vote");
        setLength(1);
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        for (String s : main.getConfig().getStringList("vote")) {
            sender.sendRichMessage(s);
        }

    }

}

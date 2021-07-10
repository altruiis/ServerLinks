package me.number3504.serverlinks.listeners;

import me.number3504.serverlinks.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.util.StringUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TabCompleteListener implements TabCompleter {

    Main main;

    public TabCompleteListener(Main main) {
        this.main = main;
    }

    private final List<String> commands = new ArrayList<>();

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String[] args) {
        final List<String> completions = new ArrayList<>();
        if (args.length == 1) {
            commands.add("info");
            commands.add("help");
            commands.add("link");
            commands.add("vote");
            commands.add("list");
            commands.add("gui");
            if (sender.hasPermission("links.set")) {
                commands.add("set");
                commands.add("reset");
                commands.add("reload");
            }
            StringUtil.copyPartialMatches(args[0], commands, completions);
        }
        if (args.length == 2) {
            if (args[0].equalsIgnoreCase("set")) {
                final List<String> links = new ArrayList<>(main.getConfig().getConfigurationSection("links").getKeys(false));
                StringUtil.copyPartialMatches(args[1], links, completions);
            }
            if (args[0].equalsIgnoreCase("reset") || args[0].equalsIgnoreCase("link")) {
                final List<String> links = new ArrayList<>();
                main.getConfig().getConfigurationSection("links").getKeys(false).forEach(s -> {
                    if (!main.getConfig().getString("links." + s).equalsIgnoreCase("")) {
                        links.add(s);
                    }
                });
                StringUtil.copyPartialMatches(args[1], links, completions);
            }
        }
        Collections.sort(completions);
        return completions;
    }
}

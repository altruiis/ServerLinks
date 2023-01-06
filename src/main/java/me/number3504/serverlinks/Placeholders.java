package me.number3504.serverlinks;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.OfflinePlayer;
import org.jetbrains.annotations.NotNull;

public class Placeholders extends PlaceholderExpansion {

    private final Main main;

    public Placeholders(Main main) {
        this.main = main;
    }

    @Override
    public @NotNull String getIdentifier() {
        return "serverlinks";
    }

    @Override
    public @NotNull String getAuthor() {
        return "Altruiis";
    }

    @Override
    public @NotNull String getVersion() {
        return "1.0.0";
    }

    @Override
    public boolean persist() {
        return true;
    }

    @Override
    public String onRequest(OfflinePlayer player, @NotNull String params) {
        if (main.getConfig().getConfigurationSection("links").getKeys(false).contains(params.replace("_stripped", ""))) {
            String link = main.getConfig().getString("links." + params.replace("_stripped", ""));
            if (link != null && !link.isEmpty()) {
                if (params.contains("_stripped")) {
                    return MiniMessage.miniMessage().stripTags(link);
                }
                return main.getConfig().getString("links." + params);
            }
        }
        return null;
    }

}

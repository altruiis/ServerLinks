package me.number3504.serverlinks;

import com.destroystokyo.paper.profile.PlayerProfile;
import com.destroystokyo.paper.profile.ProfileProperty;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.persistence.PersistentDataType;

import java.util.List;
import java.util.UUID;

public class Utils {

    private static final MiniMessage mm = MiniMessage.miniMessage();

    public static String cap(final String line) {
        return Character.toUpperCase(line.charAt(0)) + line.substring(1);
    }

    public static ItemStack customSkull(String link, String base64, String displayName, List<Component> lore) {
        PlayerProfile profile = Bukkit.createProfile(UUID.randomUUID());
        profile.setProperty(new ProfileProperty("textures", base64));
        ItemStack item = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta meta = (SkullMeta) item.getItemMeta();
        if (!displayName.isEmpty())
            meta.displayName(mm.deserialize(displayName));
        if (lore != null && lore.size() > 0) {
            meta.lore(lore);
        }
        meta.getPersistentDataContainer().set(new NamespacedKey(Main.getInstance(), "link"), PersistentDataType.STRING, link);
        meta.setPlayerProfile(profile);
        item.setItemMeta(meta);
        return item;
    }

}

package me.number3504.serverlinks;

import net.kyori.adventure.audience.Audience;
import net.kyori.adventure.text.minimessage.MiniMessage;

public class Utils {

    private static final MiniMessage mm = MiniMessage.miniMessage();

    public static String cap(final String line) {
        return Character.toUpperCase(line.charAt(0)) + line.substring(1);
    }

    public static void send(Audience audience, String message) {
        audience.sendMessage(mm.deserialize(message));
    }

}

package me.number3504.serverlinks;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.bukkit.Bukkit;

import net.md_5.bungee.api.ChatColor;

public class Utils {

	private final static Pattern pattern = Pattern.compile("#[a-fA-f0-9]{6}");

	public static String msg(String s) {
		if (Bukkit.getVersion().contains("1.16")) {
			Matcher match = pattern.matcher(s);
			while (match.find()) {
				String color = s.substring(match.start(), match.end());
				s = s.replace(color, ChatColor.of(color) + "");
				match = pattern.matcher(s);
			}
		}
		return ChatColor.translateAlternateColorCodes('&', s);
	}
	
	public static String cap(final String line) {
		return Character.toUpperCase(line.charAt(0)) + line.substring(1);
	}

}

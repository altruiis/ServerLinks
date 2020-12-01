package me.number3504.serverlinks.commands;

import org.bukkit.command.CommandSender;

public abstract class CommandExecutor {

	private String command;
	private String permission;
	private int length;
	private boolean optional;

	public abstract void execute(CommandSender sender, String[] args);

	public String getCommand() {
		return command;
	}

	public void setCommand(String command) {
		this.command = command;
	}

	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public boolean isOptional() {
		return optional;
	}

	public void setOptional(boolean optional) {
		this.optional = optional;
	}

}

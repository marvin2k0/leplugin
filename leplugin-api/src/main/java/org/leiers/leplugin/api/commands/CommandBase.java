package org.leiers.leplugin.api.commands;

import org.bukkit.command.Command;
import org.leiers.leplugin.api.LePluginBase;

import java.util.List;

public abstract class CommandBase extends Command {
    private final LePluginBase plugin;

    protected CommandBase(LePluginBase plugin, String name, String description, String usageMessage, List<String> aliases) {
        super(name, description, usageMessage, aliases);
        this.plugin = plugin;
    }
}

package org.leiers.paper.commands;

import org.bukkit.Bukkit;
import org.leiers.leplugin.api.LePluginBase;
import org.leiers.leplugin.api.commands.CommandBase;

import java.util.List;

public abstract class LePluginCommand extends CommandBase {
    protected LePluginCommand(LePluginBase plugin, String name, String description, String permission, List<String> aliases) {
        super(plugin, name, description, "", aliases);
        setPermission(permission);

        Bukkit.getCommandMap().register(
                getLabel(),
                getPlugin().getName(),
                this
        );
    }
}

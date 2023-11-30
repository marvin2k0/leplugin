package org.leiers.leplugin.spigot.config;

import org.bukkit.ChatColor;
import org.leiers.leplugin.api.LePluginBase;
import org.leiers.leplugin.api.config.Config;
import org.leiers.leplugin.api.config.Messages;

public class SpigotMessages implements Messages<String> {
    private final Config config;
    private final String prefix;

    public SpigotMessages(LePluginBase plugin, Config config) {
        this.config = config;
        this.prefix = config.getFileConfiguration().isSet("prefix")
                ? config.getFileConfiguration().getString("prefix")
                : ChatColor.BLUE + plugin.getName().trim();
    }

    @Override
    public String get(String path) {
        return get(path, true);
    }

    @Override
    public String get(String path, boolean usePrefix) {
        String message = getConfig().getFileConfiguration().getString(path);

        if (message == null)
            message = "<" + path + "> not found";
        else
            message = message.trim();

        if (usePrefix)
            return getPrefix() + message;

        return message;
    }

    @Override
    public String getPrefix() {
        return prefix;
    }

    @Override
    public Config getConfig() {
        return config;
    }
}

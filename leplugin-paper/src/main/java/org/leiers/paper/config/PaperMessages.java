package org.leiers.paper.config;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.configuration.file.FileConfiguration;
import org.leiers.leplugin.api.LePluginBase;
import org.leiers.leplugin.api.config.Messages;

public class PaperMessages implements Messages<Component> {
    private static final MiniMessage mm = MiniMessage.miniMessage();

    private final FileConfiguration config;
    private final Component prefix;

    public PaperMessages(LePluginBase plugin, FileConfiguration config) {
        this.config = config;
        this.prefix = (config.isSet("prefix") ? get("prefix", false) : mm.deserialize("<blue>" + plugin.getName().trim()))
                .append(Component.text(" "));
    }

    @Override
    public Component get(String path) {
        return get(path, false);
    }

    @Override
    public Component get(String path, boolean usePrefix) {
        String message = getConfig().getString(path);

        if (message == null)
            message = "<" + path + "> not found";
        else
            message = message.trim();

        return (usePrefix ? getPrefix().append(Component.text(" ")) : Component.text().asComponent())
                .append(mm.deserialize(message));
    }

    @Override
    public Component getPrefix() {
        return prefix;
    }

    @Override
    public FileConfiguration getConfig() {
        return config;
    }
}

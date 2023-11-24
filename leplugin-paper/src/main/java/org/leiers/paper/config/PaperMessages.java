package org.leiers.paper.config;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.leiers.leplugin.api.LePluginBase;
import org.leiers.leplugin.api.config.Config;
import org.leiers.leplugin.api.config.Messages;

import java.util.List;

public class PaperMessages implements Messages<Component> {
    private static final MiniMessage mm = MiniMessage.miniMessage();

    private final Config config;
    private final Component prefix;

    public PaperMessages(LePluginBase plugin, Config config) {
        this.config = config;
        this.prefix = (config.getFileConfiguration().isSet("prefix") ? get("prefix", false) : mm.deserialize("<blue>" + plugin.getName().trim()))
                .append(Component.text(" "));

        config.getFileConfiguration().options().setHeader(List.of(
                " ",
                "This file exclusively supports MiniMessage formatting for messages.",
                "Learn more about MiniMessages at:",
                "https://docs.advntr.dev/minimessage/format.html#minimessage-format"
        ));
        config.save();
    }

    @Override
    public Component get(String path) {
        return get(path, true);
    }

    @Override
    public Component get(String path, boolean usePrefix) {
        String message = getConfig().getFileConfiguration().getString(path);

        if (message == null)
            message = "<" + path + "> not found";
        else
            message = message.trim();

        if (usePrefix)
            return getPrefix().append(mm.deserialize(message));

        return mm.deserialize(message);
    }

    @Override
    public Component getPrefix() {
        return prefix;
    }

    @Override
    public Config getConfig() {
        return config;
    }
}

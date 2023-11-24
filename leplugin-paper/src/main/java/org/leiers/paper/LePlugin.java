package org.leiers.paper;

import net.kyori.adventure.text.Component;
import org.leiers.leplugin.api.LePluginBase;
import org.leiers.leplugin.api.config.Messages;
import org.leiers.paper.config.PaperMessages;

public class LePlugin extends LePluginBase {
    private final PaperMessages textFormatter;

    public LePlugin() {
        this.textFormatter = new PaperMessages();
    }

    @Override
    public Messages<Component> getText() {
        return textFormatter;
    }
}

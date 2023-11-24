package org.leiers.paper;

import net.kyori.adventure.text.Component;
import org.leiers.leplugin.api.LePluginBase;
import org.leiers.leplugin.api.config.TextFormatter;
import org.leiers.paper.config.PaperTextFormatter;

public class LePlugin extends LePluginBase {
    private final PaperTextFormatter textFormatter;

    public LePlugin() {
        this.textFormatter = new PaperTextFormatter();
    }

    @Override
    public TextFormatter<Component> getText() {
        return textFormatter;
    }
}

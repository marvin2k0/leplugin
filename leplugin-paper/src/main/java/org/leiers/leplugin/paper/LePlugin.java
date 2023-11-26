package org.leiers.leplugin.paper;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.leiers.leplugin.api.LePluginBase;
import org.leiers.leplugin.paper.config.PaperMessages;

import java.util.List;

public class LePlugin extends LePluginBase {
    private PaperMessages textFormatter;

    @Override
    protected final void setup() {
        this.textFormatter = new PaperMessages(this, getMessagesConfig());
    }

    protected void registerCommands(Command... commands) {
        Bukkit.getCommandMap().registerAll(getName(), List.of(commands));
    }

    @Override
    public PaperMessages getText() {
        return textFormatter;
    }
}

package org.leiers.leplugin.paper;

import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.leiers.leplugin.api.LePluginBase;
import org.leiers.leplugin.api.config.Messages;
import org.leiers.leplugin.paper.config.PaperMessages;

import java.util.List;

/**
 * Extend from this class to use LePlugin API with PaperMC plugins
 */
public class LePlugin extends LePluginBase {
    /**
     * Can be used to access messages from messages.yml
     */
    private Messages<Component> paperMessages;

    /**
     * This will be called after onLoad, after the file containing the messages has been set.
     */
    @Override
    protected final void setup() {
        this.paperMessages = new PaperMessages(this, getMessagesConfig());
    }

    /**
     * Easily register commands, because paper doesn't support it in their paper-plugin.yml
     *
     * @param commands Commands to be registered
     */
    protected void registerCommands(Command... commands) {
        Bukkit.getCommandMap().registerAll(getName(), List.of(commands));
    }

    /**
     *
     * @return Messages object to get messages from message file
     */
    @Override
    public Messages<Component> getMessages() {
        return this.paperMessages;
    }
}

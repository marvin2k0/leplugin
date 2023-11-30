package org.leiers.leplugin.spigot;

import org.leiers.leplugin.api.LePluginBase;
import org.leiers.leplugin.api.config.Messages;
import org.leiers.leplugin.spigot.config.SpigotMessages;

public class LePlugin extends LePluginBase {
    private Messages<String> messages;

    @Override
    protected void setup() {
        this.messages = new SpigotMessages(
                this,
                getMessagesConfig()
        );
    }

    @Override
    public Messages<String> getMessages() {
        return messages;
    }
}

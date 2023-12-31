package org.leiers.leplugin.api;

import lombok.Getter;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.leiers.leplugin.api.config.Config;
import org.leiers.leplugin.api.config.Messages;

import java.io.File;
import java.util.List;

public abstract class LePluginBase extends JavaPlugin {
    private boolean showBanner = true;
    private File messagesFile = new File(getDataFolder(), "messages.yml");

    @Getter
    private Config messagesConfig;

    @Override
    public final void onLoad() {
        this.prepareConfig();
        this.hideBanner();
        this.loading();
        this.createMessagesConfig(messagesFile);
        this.setup();
    }

    @Override
    public final void onEnable() {
        this.starting();

        if (!isEnabled())
            return;

        if (showBanner)
            this.sendBanner();
    }

    @Override
    public final void onDisable() {
        this.stopping();
    }

    protected void hideBanner() {
        this.showBanner = false;
    }

    protected void setMessagesFile(File file) {
        this.messagesFile = file;
    }

    private void prepareConfig() {
        if (getResource("config.yml") == null)
            saveConfig();
        else
            saveDefaultConfig();

        getConfig().options().setHeader(List.of(
                "=================================",
                "Plugin made with LePlugin-Library",
                "https://leiers.org/leplugin",
                "=================================",
                "",
                "Plugin version: " + getDescription().getVersion()
        ));

        saveConfig();
    }

    private void createMessagesConfig(File messagesFile) {
        if (getResource(messagesFile.getName()) != null && !messagesFile.exists())
            saveResource("messages.yml", false);

        this.messagesConfig = new Config(YamlConfiguration.loadConfiguration(messagesFile), messagesFile);
    }

    private void sendBanner() {
        getServer().getConsoleSender().sendMessage(ChatColor.BLUE + "  _              ____    _                   _         ");
        getServer().getConsoleSender().sendMessage(ChatColor.BLUE + " | |       ___  |  _ \\  | |  _   _    __ _  (_)  _ __  ");
        getServer().getConsoleSender().sendMessage(ChatColor.BLUE + " | |      / _ \\ | |_) | | | | | | |  / _` | | | | '_ \\ ");
        getServer().getConsoleSender().sendMessage(ChatColor.BLUE + " | |___  |  __/ |  __/  | | | |_| | | (_| | | | | | | |");
        getServer().getConsoleSender().sendMessage(ChatColor.BLUE + " |_____|  \\___| |_|     |_|  \\__,_|  \\__, | |_| |_| |_|");
        getServer().getConsoleSender().sendMessage(ChatColor.BLUE + "                                     |___/             ");
        getServer().getConsoleSender().sendMessage(ChatColor.GOLD + "          Visit https://leiers.org/leplugin");
    }

    protected final void registerEvents(Listener... listeners) {
        for (Listener listener : listeners)
            getServer().getPluginManager().registerEvents(listener, this);
    }

    public abstract Messages<?> getMessages();

    protected void setup() {
    }

    public void loading() {
    }

    public void starting() {
    }

    public void stopping() {
    }
}

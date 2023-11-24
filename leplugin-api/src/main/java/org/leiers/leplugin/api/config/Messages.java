package org.leiers.leplugin.api.config;

import org.bukkit.configuration.file.FileConfiguration;

public interface Messages<T> {
    T get(String path);

    T get(String path, boolean usePrefix);

    T getPrefix();

    FileConfiguration getConfig();
}

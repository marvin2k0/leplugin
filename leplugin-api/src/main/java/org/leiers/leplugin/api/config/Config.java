package org.leiers.leplugin.api.config;

import org.bukkit.configuration.file.FileConfiguration;

import java.io.File;
import java.io.IOException;

public class Config {
    private final FileConfiguration config;
    private final File file;

    public Config(FileConfiguration config, File file) {
        this.config = config;
        this.file = file;
    }

    public void save() {
        try {
            config.save(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public FileConfiguration getFileConfiguration() {
        return config;
    }
}

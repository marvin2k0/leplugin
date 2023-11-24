package org.leiers.leplugin.api.config;

public interface TextFormatter<T> {
    T get(String path);

    T getPrefix();
}

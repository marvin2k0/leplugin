package org.leiers.leplugin.api.config;

public interface Messages<T> {
    T get(String path);

    T get(String path, boolean usePrefix);

    T getPrefix();
}

package org.leiers.leplugin.api.nms;

import net.minecraft.server.level.EntityPlayer;
import org.bukkit.craftbukkit.v1_20_R2.entity.CraftPlayer;
import org.bukkit.entity.Player;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class ReflectionUtil {
    private static final String CRAFTBUKKIT_PACKAGE = "org.bukkit.craftbukkit";
    private static final Map<String, Class<?>> classCache = new HashMap<>();

    private static final Method getHandle;

    static {
        try {
            getHandle = getClass("v1_20_R2.entity.CraftPlayer").getMethod("getHandle");
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    public static EntityPlayer getEntityPlayer(Player player) {
        final org.bukkit.craftbukkit.v1_20_R2.entity.CraftPlayer craftPlayer = (CraftPlayer) player;

        try {
            return (EntityPlayer) getHandle.invoke(craftPlayer);
        } catch (InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public static Class<?> getClass(String path) {
        try {
            if (classCache.containsKey(path))
                return classCache.get(path);

            final Class<?> clazz = Class.forName(CRAFTBUKKIT_PACKAGE + "." + path);
            classCache.put(path, clazz);

            return clazz;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

package dev.gooch.discordlink;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.List;

public class PluginConfig {

    private static FileConfiguration configuration;

    public static void register(FileConfiguration config) {
        configuration = config;
    }

    public static String getString(String key) {
        return configuration.getString(key);
    }

    public static String getPrefix() {
        return Colours.applyLegacyColors(configuration.getString("prefix"));
    }

    public static int getInt(String key) {
        return configuration.getInt(key);
    }

    public static List<String> getStringList(String key) {
        return configuration.getStringList(key);
    }

    public static List<String> getBossNames() {
        return configuration.getStringList("bosses");
    }
}

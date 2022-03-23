package dev.gooch.discordlink;

import dev.gooch.discordlink.commands.Link;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class Discordlink extends JavaPlugin {

    public FileConfiguration config = this.getConfig();

    @Override
    public void onEnable() {
        PluginConfig.register(this.getConfig());

        getCommand("link").setExecutor(new Link());

    }

    @Override
    public void onDisable() {

    }
}

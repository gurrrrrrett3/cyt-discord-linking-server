package dev.gooch.discordlink.commands;

import dev.gooch.discordlink.Colours;
import dev.gooch.discordlink.PluginConfig;
import dev.gooch.discordlink.RequestManager;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.UUID;

public class Link implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (args.length == 0) {
            sender.sendMessage(Colours.applyLegacyColors(PluginConfig.getPrefix() + "&cUsage: /link <code>"));
            return true;
        } else {
            String code = args[0];
            if (code.length() != 4) {
                sender.sendMessage(Colours.applyLegacyColors(PluginConfig.getPrefix() + "&cInvalid code"));
                return true;
            }
            if (sender.hasPermission("discordlink.link")) {
                UUID uuid = Bukkit.getServer().getPlayer(sender.getName()).getUniqueId();
                try {

                    String res = RequestManager.SendGetRequest(PluginConfig.getString("host") + "/link/" + code + "/" + sender.getName() + "/" + uuid);
                    sender.sendMessage(Colours.applyLegacyColors(PluginConfig.getPrefix() + res));
                    return true;

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        return false;
    }
}

package com.tuplugin.listadoplugins;

import java.util.Arrays;
import java.util.Comparator;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class ListadoPlugins extends JavaPlugin implements CommandExecutor {

    @Override
    public void onEnable() {
        // Registrar el ejecutor del comando "pluginsversion"
        this.getCommand("pluginsversion").setExecutor(this);
        getLogger().info("ListadoPlugins habilitado.");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        sender.sendMessage("§ePlugins instalados y sus versiones:");
        
        // Obtener plugins y ordenarlos alfabéticamente
        Plugin[] plugins = Bukkit.getPluginManager().getPlugins();
        Arrays.sort(plugins, Comparator.comparing(Plugin::getName));
        
        for (Plugin plugin : plugins) {
            sender.sendMessage("§7- §f" + plugin.getName() + " §8| §a" + plugin.getDescription().getVersion());
        }
        return true;
    }
}


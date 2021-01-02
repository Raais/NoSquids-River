package com.raais.nosquids;

import com.raais.nosquids.events.Events;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new Events(),this);
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[NoSquids]: Plugin is enabled");
    }

    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "[NoSquids]: Plugin is disabled");
    }

}

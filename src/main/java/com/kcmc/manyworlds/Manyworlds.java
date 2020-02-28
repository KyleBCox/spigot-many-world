package com.kcmc.manyworlds;

import com.kcmc.manyworlds.commands.CommandWorldTeleport;
import com.kcmc.manyworlds.config.ManyWorldConfig;
import com.kcmc.manyworlds.config.model.MWWorld;
import com.kcmc.manyworlds.listeners.PlayerJoinListener;
import org.bukkit.Bukkit;
import org.bukkit.WorldCreator;
import org.bukkit.WorldType;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Map;

public final class Manyworlds extends JavaPlugin {

    @Override
    public void onEnable() {
        ManyWorldConfig.parseConfig();
        for (Map.Entry<String, MWWorld> world : ManyWorldConfig.worlds.entrySet()) {
            WorldCreator creator = new WorldCreator(world.getKey()).environment(world.getValue().type).type(world.getValue().genType).generateStructures(world.getValue().genStructures);
            Bukkit.createWorld(creator);
        }
        this.getCommand("tpmw").setExecutor(new CommandWorldTeleport());
        getServer().getPluginManager().registerEvents(new PlayerJoinListener(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}

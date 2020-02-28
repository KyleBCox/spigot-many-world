package com.kcmc.manyworlds;

import com.kcmc.manyworlds.commands.CommandWorldTeleport;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.WorldType;
import org.bukkit.plugin.java.JavaPlugin;

public final class Manyworlds extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        WorldCreator creator = new WorldCreator("world2").environment(World.Environment.NORMAL).generateStructures(false).type(WorldType.FLAT);
        Bukkit.createWorld(creator);
        this.getCommand("tpmw").setExecutor(new CommandWorldTeleport());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}

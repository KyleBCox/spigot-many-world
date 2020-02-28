package com.kcmc.manyworlds.config;

import com.kcmc.manyworlds.config.model.Coordinates;
import com.kcmc.manyworlds.config.model.MWWorld;
import org.bukkit.World;
import org.bukkit.WorldType;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.util.Vector;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class ManyWorldConfig {
    public static HashMap<String, MWWorld> worlds = new HashMap<>();

    public static void parseConfig() {
        FileConfiguration config = getConfig();
        for (String key : config.getKeys(false)) {
            ConfigurationSection worldsSection = config.getConfigurationSection(key);
            MWWorld world = new MWWorld();
            world.type = World.Environment.valueOf(worldsSection.getString("type"));
            world.exactSpawnPoint = worldsSection.getBoolean("exact-spawn-point");
            world.entryWorld = worldsSection.getBoolean("entry-world");
            String[] coords = worldsSection.getString("spawn").split("[,]");
            world.spawn = new Coordinates(Integer.parseInt(coords[0]), Integer.parseInt(coords[1]), Integer.parseInt(coords[2]));
            world.genType = WorldType.valueOf(worldsSection.getString("gen-type"));
            world.genStructures = worldsSection.getBoolean("gen-structures");
            worlds.put(key, world);
        }
    }

    private static FileConfiguration getConfig() {
        try {
            File file  = new File("./plugins/Configuration/mw-world-config.yaml");
            YamlConfiguration customConfig = new YamlConfiguration();
            customConfig.load(file);
            return customConfig;
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
        return null;
    }
}

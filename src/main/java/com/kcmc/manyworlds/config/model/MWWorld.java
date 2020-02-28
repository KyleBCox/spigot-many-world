package com.kcmc.manyworlds.config.model;

import org.bukkit.World;
import org.bukkit.WorldType;
import org.bukkit.util.Vector;

public class MWWorld {
    public boolean entryWorld;
    public boolean exactSpawnPoint;
    public Coordinates spawn;
    public World.Environment type;
    public WorldType genType;
    public boolean genStructures;
}

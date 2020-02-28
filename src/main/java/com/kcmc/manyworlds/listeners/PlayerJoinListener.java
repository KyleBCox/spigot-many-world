package com.kcmc.manyworlds.listeners;

import com.kcmc.manyworlds.Manyworlds;
import com.kcmc.manyworlds.config.ManyWorldConfig;
import com.kcmc.manyworlds.config.model.Coordinates;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.util.Vector;

import java.util.ArrayList;

public class PlayerJoinListener implements Listener {
    private static ArrayList<String> playerNames = new ArrayList<>();
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        if (!playerNames.contains(player.getName())) {
            playerNames.add(player.getName());
            for (String key : ManyWorldConfig.worlds.keySet()) {
                if (ManyWorldConfig.worlds.get(key).entryWorld) {
                    Coordinates spawn = ManyWorldConfig.worlds.get(key).spawn;
                    player.teleport(new Location(Bukkit.getServer().getWorld(key), spawn.x, spawn.y, spawn.z));
                }
            }
        }
    }
}

package com.kcmc.manyworlds.commands;

import com.kcmc.manyworlds.config.ManyWorldConfig;
import com.kcmc.manyworlds.config.model.Coordinates;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

public class CommandWorldTeleport implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player senderPlayer = (Player) sender;
        World toWorld = Bukkit.getServer().getWorld(args[0]);
        Bukkit.getLogger().info(args[0]);
        if (toWorld != null) {
            Coordinates spawnVec = ManyWorldConfig.worlds.get(args[0]).spawn;

            senderPlayer.teleport(new Location(toWorld, spawnVec.x, spawnVec.y, spawnVec.z));
            return true;
        }
        return false;
    }
}

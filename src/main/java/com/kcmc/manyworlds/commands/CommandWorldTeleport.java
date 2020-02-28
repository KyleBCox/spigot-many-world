package com.kcmc.manyworlds.commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandWorldTeleport implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player senderPlayer = (Player) sender;
        World toWorld = Bukkit.getWorld(args[0]);
        Bukkit.getLogger().info(args[0]);
        if (toWorld != null) {
            senderPlayer.teleport(toWorld.getSpawnLocation());
            return true;
        }
        return false;
    }
}

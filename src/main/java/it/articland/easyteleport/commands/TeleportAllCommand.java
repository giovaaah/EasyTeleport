package it.articland.easyteleport.commands;

import it.articland.easyteleport.EasyTeleport;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TeleportAllCommand implements CommandExecutor {
  @Override
  public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
    if(!(sender instanceof Player player)) return true;

    if(!player.hasPermission("easyteleport.tp.all")) {
      player.sendMessage(ChatColor.translateAlternateColorCodes('&',
          EasyTeleport.getNoPermissionMessage()));
      return true;
    }

    for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
      onlinePlayer.teleport(player); // Teleport every player to target (teleporter)
    }

    return true;
  }
}

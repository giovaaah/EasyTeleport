package it.articland.easyteleport.commands;

import it.articland.easyteleport.EasyTeleport;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TeleportCommand implements CommandExecutor {
  @Override
  public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
    if(!(sender instanceof Player player)) return true;

    if (args.length == 0) {
      player.sendMessage(ChatColor.translateAlternateColorCodes('&', EasyTeleport.getHelpMessage()));
      return true;
    }

    if(args.length == 1 || args.length == 2) {
      if(args.length == 1) {
        if(!player.hasPermission("easyteleport.tp")) {
          player.sendMessage(ChatColor.translateAlternateColorCodes('&',
              EasyTeleport.getNoPermissionMessage()));
          return true;
        }
        Player target = Bukkit.getPlayer(args[0]);
        player.teleport(target);
      }

      if(!player.hasPermission("easyteleport.tp.other")) {
        Player wished = Bukkit.getPlayer(args[0]); // Target
        Player target = Bukkit.getPlayer(args[1]);

        if(!wished.isOnline()) {
          player.sendMessage(ChatColor.translateAlternateColorCodes('&', EasyTeleport.getNoTargetFound()));
          return true;
        }

        if(!target.isOnline()) {
          player.sendMessage(ChatColor.translateAlternateColorCodes('&', EasyTeleport.getNoTargetFound()));
          return true;
        }

        wished.teleport(target);
        return true;
      }
    }
    return true;
  }
}

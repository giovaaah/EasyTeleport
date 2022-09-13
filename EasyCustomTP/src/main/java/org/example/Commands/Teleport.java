package github.com.giovaah.easyteleport.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Teleport implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {


        if ( sender instanceof  Player){
            Player player = (Player) sender;

            if (args.length == 0){
                player.sendMessage(ChatColor.RED + "You need to put the id of the user");
                player.sendMessage(ChatColor.RED + "To teleport yourself write /tp <otherplayer>");
                player.sendMessage(ChatColor.YELLOW + "To teleport other player write /tp <player> <otherplayer>");
            }else if(args.length == 1 ){
             Player target = Bukkit.getPlayer(args[0]);

             try{
                 player.teleport(target.getLocation());
             }catch (NullPointerException e){
                 player.sendMessage(ChatColor.RED + "Player doesent exist");
             }

             player.teleport(target.getLocation());
            }else if(args.length == 2){
                Player playerToSend = Bukkit.getPlayer(args[0]);
                Player target = Bukkit.getPlayer(args[1]);
                try{
                    playerToSend.teleport(target.getLocation());
                }catch (NullPointerException e){
                    player.sendMessage(ChatColor.RED + "Player doesent exist");
                }

            }
        }

        return true;
    }
}

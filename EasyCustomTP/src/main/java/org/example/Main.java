package github.com.giovaah.easyteleport;

import github.com.giovaah.easyteleport.Commands.Teleport;
import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.java.JavaPlugin;

public final class EasyTeleport extends JavaPlugin {

    @Override
    public void onEnable() {
      //START PLUGIN IN CONSOLE
        System.out.println("Welcome developer! I'm your favourite teleport plugin! ");

        getCommand("tp").setExecutor(new Teleport());
        getCommand("tpall").setExecutor(new Teleport());

    }
    @Override
    public void onDisable() {
        // SHUTDOWN PLUGIN IN CONSOLE

        System.out.println("Bye bye developer... see you next time");

    }
}

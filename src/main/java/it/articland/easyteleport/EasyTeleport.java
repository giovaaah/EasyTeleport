package it.articland.easyteleport;

import it.articland.easyteleport.commands.TeleportCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class EasyTeleport extends JavaPlugin {

  private static String NoPermissionMessage;
  private static String HelpMessage;
  private static String NoTargetFound;
  private static String TeleportedTo;

  @Override
  public void onEnable() {
    NoPermissionMessage = this.getConfig()
        .getString("Messages.NoPermission");
    HelpMessage = this.getConfig().getString("Messages.HelpMessage");
    NoTargetFound = this.getConfig().getString("Messages.NoTargetFound");
    TeleportedTo = this.getConfig().getString("Messages.TeleportedTo");

    this.getCommand("tp").setExecutor(new TeleportCommand());
    this.getCommand("tpall").setExecutor(new TeleportCommand());
  }

  public static String getNoPermissionMessage() {
    return NoPermissionMessage;
  }

  public static String getHelpMessage() {
    return HelpMessage;
  }

  public static String getNoTargetFound() {
    return NoTargetFound;
  }

  public static String getTeleportedTo() {
    return TeleportedTo;
  }
}

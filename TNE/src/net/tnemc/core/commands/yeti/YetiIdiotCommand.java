package net.tnemc.core.commands.yeti;

import com.github.tnerevival.commands.TNECommand;
import com.github.tnerevival.user.IDFinder;
import net.tnemc.core.TNE;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * The New Economy Minecraft Server Plugin
 *
 * This work is licensed under the Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/ or send a letter to
 * Creative Commons, PO Box 1866, Mountain View, CA 94042, USA.
 * Created by Daniel on 10/17/2017.
 */
public class YetiIdiotCommand extends TNECommand {

  public YetiIdiotCommand(TNE plugin) {
    super(plugin);
  }

  @Override
  public String getName() {
    return "idiot";
  }

  @Override
  public String[] getAliases() {
    return new String[0];
  }

  @Override
  public String getNode() {
    return "tne.yeti.idiot";
  }

  @Override
  public boolean console() {
    return true;
  }

  @Override
  public String getHelp() {
    return ChatColor.GREEN + "/yediot" + ChatColor.WHITE + " - Determine if a Yediot is near. http://www.urbandictionary.com/define.php?term=yediot";
  }

  @Override
  public boolean execute(CommandSender sender, String command, String[] arguments) {
    Player player = getPlayer(sender);
    Player yeti = Bukkit.getPlayer(IDFinder.getID("TheNetYeti"));
    Player growlf = Bukkit.getPlayer(IDFinder.getID("growlf"));

    if(player.getDisplayName().equalsIgnoreCase("TheNetYeti")) {
      sender.sendMessage(ChatColor.GREEN + "Congratulations you have found the Yediot.");
      return true;
    }

    if(yeti != null) {
      if(yeti.getLocation().distanceSquared(player.getLocation()) <= 25) {
        sender.sendMessage(ChatColor.WHITE + "There is a Yediot near you.");
        return true;
      }
      sender.sendMessage(ChatColor.WHITE + "There is a Yediot on this server.");
      return true;
    }

    if(growlf != null) {
      if(yeti.getLocation().distanceSquared(player.getLocation()) <= 25) {
        sender.sendMessage(ChatColor.WHITE + "There is a Yediot in disguise near you.");
        return true;
      }
      sender.sendMessage(ChatColor.WHITE + "There is a Yediot in disguise on this server.");
      return true;
    }
    sender.sendMessage(ChatColor.WHITE + "There is no Yediot on this server.");
    return true;
  }
}
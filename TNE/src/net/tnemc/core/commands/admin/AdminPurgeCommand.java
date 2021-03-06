package net.tnemc.core.commands.admin;

import com.github.tnerevival.commands.TNECommand;
import com.github.tnerevival.core.Message;
import com.github.tnerevival.user.IDFinder;
import net.tnemc.core.TNE;
import net.tnemc.core.common.WorldVariant;
import net.tnemc.core.common.account.WorldFinder;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;

/**
 * The New Economy Minecraft Server Plugin
 *
 * This work is licensed under the Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/ or send a letter to
 * Creative Commons, PO Box 1866, Mountain View, CA 94042, USA.
 * Created by Daniel on 7/10/2017.
 */
public class AdminPurgeCommand extends TNECommand {

  public AdminPurgeCommand(TNE plugin) {
    super(plugin);
  }

  @Override
  public String getName() {
    return "purge";
  }

  @Override
  public String[] getAliases() {
    return new String[0];
  }

  @Override
  public String getNode() {
    return "tne.admin.purge";
  }

  @Override
  public boolean console() {
    return true;
  }

  @Override
  public String getHelp() {
    return "Messages.Commands.Admin.Purge";
  }

  @Override
  public boolean execute(CommandSender sender, String command, String[] arguments) {
    String world = WorldFinder.getWorld(sender, WorldVariant.BALANCE);
    if(arguments.length >= 1) {
      if (Bukkit.getWorld(arguments[0]) == null)
        new Message("Messages.General.NoWorld").translate(world, sender);
      TNE.manager().purge(arguments[0]);
      Message m = new Message("Messages.Admin.PurgeWorld");
      m.addVariable("$world", arguments[0]);
      m.translate(world, IDFinder.getID(sender));
      return true;
    }
    help(sender);
    return true;
  }
}
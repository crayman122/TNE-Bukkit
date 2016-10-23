package com.github.tnerevival.commands.packages;

import com.github.tnerevival.TNE;
import com.github.tnerevival.commands.TNECommand;
import org.bukkit.command.CommandSender;

public class PackageCommand extends TNECommand {

  public PackageCommand(TNE plugin) {
    super(plugin);
    subCommands.add(new PackageListCommand(plugin));
    subCommands.add(new PackageBuyCommand(plugin));
  }

  @Override
  public String getName() {
    return "package";
  }

  @Override
  public String[] getAliases() {
    return new String[0];
  }

  @Override
  public String getNode() {
    return "tne.package";
  }

  @Override
  public boolean console() {
    return false;
  }

  @Override
  public Boolean confirm() { return true; }

  @Override
  public Boolean locked() {
    return true;
  }

  @Override
  public boolean execute(CommandSender sender, String command, String[] arguments) {
    return super.execute(sender, command, arguments);
  }
}
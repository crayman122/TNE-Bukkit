package net.tnemc.core.event.currency;

import org.bukkit.event.Cancellable;

/**
 * The New Economy Minecraft Server Plugin
 *
 * This work is licensed under the Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/ or send a letter to
 * Creative Commons, PO Box 1866, Mountain View, CA 94042, USA.
 * Created by Daniel on 7/7/2017.
 */
public class TNECurrencyLoadEvent extends TNECurrencyEvent implements Cancellable {

  private boolean cancelled = false;

  public TNECurrencyLoadEvent(String world, String currency) {
    super(world, currency);
  }

  @Override
  public boolean isCancelled() {
    return cancelled;
  }

  @Override
  public void setCancelled(boolean cancelled) {
    this.cancelled = cancelled;
  }
}
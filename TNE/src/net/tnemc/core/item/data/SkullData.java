package net.tnemc.core.item.data;

import com.github.tnerevival.core.SaveManager;
import com.github.tnerevival.user.IDFinder;
import net.tnemc.core.item.SerialItemData;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.UUID;

/**
 * The New Economy Minecraft Server Plugin
 *
 * This work is licensed under the Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/ or send a letter to
 * Creative Commons, PO Box 1866, Mountain View, CA 94042, USA.
 * Created by Daniel on 11/10/2017.
 */
public class SkullData implements SerialItemData {

  private UUID owner;
  private boolean valid = false;

  @Override
  public SerialItemData initialize(ItemStack stack) {
    ItemMeta meta = stack.getItemMeta();
    if(meta instanceof SkullMeta) {
      valid = true;
      if(((SkullMeta) meta).hasOwner()) {
        owner = IDFinder.getID(((SkullMeta) meta).getOwner());
      }
    }
    return this;
  }

  @Override
  public ItemStack build(ItemStack stack) {
    if(valid) {
      SkullMeta meta = (SkullMeta)stack.getItemMeta();
      if(owner != null) meta.setOwner(owner.toString());
      stack.setItemMeta(meta);
    }
    return stack;
  }

  @Override
  public void save(SaveManager manager) {

  }

  @Override
  public SerialItemData load(SaveManager manager) {
    return null;
  }
}

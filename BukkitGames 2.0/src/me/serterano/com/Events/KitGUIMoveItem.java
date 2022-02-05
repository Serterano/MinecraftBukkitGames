package me.serterano.com.Events;

import java.util.HashMap;
import java.util.UUID;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.permissions.PermissionAttachment;

import me.serterano.com.main;
import me.serterano.com.Utilities.Perms;

public class KitGUIMoveItem implements Listener {
	private main plugin = main.getPlugin(main.class);
    @EventHandler
    public void clickEvent(InventoryClickEvent e){
        if(e.getClickedInventory().getTitle().equalsIgnoreCase(ChatColor.AQUA + "Kits")){
            Player player = (Player) e.getWhoClicked();
            switch(e.getCurrentItem().getType()){
                case REDSTONE:
                    player.closeInventory();
                    player.sendMessage(ChatColor.RED+"Vampir Kitini Seçtin");
                    Perms.playerPermissionString.put(player.getUniqueId(), "Bukkitgames.vampire");
                    break;
                case ARROW:
                    player.closeInventory();
                    player.sendMessage(ChatColor.RED+"KralOkçu Kitini Seçtin");
                    Perms.playerPermissionString.put(player.getUniqueId(), "Bukkitgames.kingarcher");
                    break;
                case DIAMOND_CHESTPLATE:
                    player.closeInventory();
                    //player.getInventory().addItem(new ItemStack(Material.DIAMOND_CHESTPLATE));
                    player.sendMessage(ChatColor.RED+"Poseidon Kitini Seçtin");
                    Perms.playerPermissionString.put(player.getUniqueId(), "Bukkitgames.poseidon");
                    break;
                case BLAZE_POWDER:
                	player.closeInventory();
                	player.sendMessage(ChatColor.RED+"Hades Kitini Seçtin");
                	Perms.playerPermissionString.put(player.getUniqueId(), "Bukkitgames.hades");
                	break;
                case CHAINMAIL_CHESTPLATE:
                	player.closeInventory();
                	player.sendMessage(ChatColor.RED+"Ares Kitini Seçtin");
                	Perms.playerPermissionString.put(player.getUniqueId(), "Bukkitgames.ares");
                	break;
                case STICK:
                	player.closeInventory();
                	player.sendMessage(ChatColor.RED+"Tarzan Kitini Seçtin");
                	Perms.playerPermissionString.put(player.getUniqueId(), "Bukkitgames.tarzan");
                	break;
                case ROTTEN_FLESH:
                	player.closeInventory();
                	player.sendMessage(ChatColor.RED+"Yamyam Kitini Seçtin");
                	Perms.playerPermissionString.put(player.getUniqueId(), "Bukkitgames.cannibal");
                	break;
                case IRON_HELMET:
                	player.closeInventory();
                	player.sendMessage(ChatColor.RED+"Boksor Kitini Seçtin");
                	Perms.playerPermissionString.put(player.getUniqueId(), "Bukkitgames.boxor");
                	break;
                default:
                	Perms.playerPermissionString.put(player.getUniqueId(), "Bukkitgames.default");
                	break;
            	}
 
            	e.setCancelled(true);
        	}  
    }
 
}

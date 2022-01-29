package me.serterano.com.CustomEvents;

import java.util.HashMap;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class KitGUIMoveItem implements Listener {
	//burada store et
	//5dk zamanlay�c� bitince oyuncuya en son se�ti�i kitin permi verilsin.
	private static HashMap<Player,String> players = new HashMap<>();
	
	public HashMap<Player,String> getPlayers(){
		return players;
	}
	
	 
    @EventHandler
    public void clickEvent(InventoryClickEvent e){
 
        if(e.getClickedInventory().getTitle().equalsIgnoreCase(ChatColor.AQUA + "Kit Se�me Ekran�")){
            Player player = (Player) e.getWhoClicked();
            switch(e.getCurrentItem().getType()){
                case REDSTONE:
                    player.closeInventory();
                    player.sendMessage(ChatColor.RED+"Vampir Kitini Se�tin");
                    players.put(player,"Eranobukkit.vampir");
                    break;
                case ARROW:
                    player.closeInventory();
                    player.sendMessage(ChatColor.RED+"KralOk�u Kitini Se�tin");
                    players.put(player,"Eranobukkit.kralokcu");
                    break;
                case DIAMOND_CHESTPLATE:
                    player.closeInventory();
                    //player.getInventory().addItem(new ItemStack(Material.DIAMOND_CHESTPLATE));
                    player.sendMessage(ChatColor.RED+"Poseidon Kitini Se�tin");
                    players.put(player,"Eranobukkit.poseidon");
                    break;
                case BLAZE_POWDER:
                	player.closeInventory();
                	player.sendMessage(ChatColor.RED+"Hades Kitini Se�tin");
                	players.put(player,"Eranobukkit.hades");
                	break;
                case CHAINMAIL_CHESTPLATE:
                	player.closeInventory();
                	player.sendMessage(ChatColor.RED+"Ares Kitini Se�tin");
                	players.put(player,"Eranobukkit.ares");
                	break;
                case STICK:
                	player.closeInventory();
                	player.sendMessage(ChatColor.RED+"Tarzan Kitini Se�tin");
                	players.put(player,"Eranobukkit.tarzan");
                	break;
                case ROTTEN_FLESH:
                	player.closeInventory();
                	player.sendMessage(ChatColor.RED+"Yamyam Kitini Se�tin");
                	players.put(player,"Eranobukkit.yamyam");
                	break;
                case IRON_HELMET:
                	player.closeInventory();
                	player.sendMessage(ChatColor.RED+"Boksor Kitini Se�tin");
                	players.put(player,"Eranobukkit.boksor");
                	break;
                default:
                	players.put(player,"Eranobukkit.default");
                	break;
            }
            //permi burda ver
 
 
            e.setCancelled(true); //So they cant take the items
        }
 
    }
 
}

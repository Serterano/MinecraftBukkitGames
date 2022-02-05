package me.serterano.com.Utilities;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.UUID;

import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.permissions.PermissionAttachment;

import me.serterano.com.main;

public class Perms {
	public static HashMap<UUID,PermissionAttachment> playerPermission = new HashMap<>();
	public static HashMap<UUID,String> playerPermissionString = new HashMap<>();
	private static main plugin = main.getPlugin(main.class);
	public static void setAttachment(Player player) {
		if(playerPermissionString.containsKey(player.getUniqueId())) {
			for(UUID uuýd : playerPermissionString.keySet()) {
			
				PermissionAttachment pa = player.addAttachment(plugin);
				playerPermission.put(uuýd, pa);
				String a = playerPermissionString.get(uuýd);
				System.out.println(playerPermissionString.get(uuýd));
				pa.setPermission(a, true);
			
			
			}
		}
		
//		public static void permissionSetter(Player p) {
//    	PermissionAttachment attachment = p.addAttachment(plugin);
//    	playerPermission.put(p.getUniqueId(), attachment);
//    	
//    	for(String groups : plugin.getConfig().getConfigurationSection("Groups").getKeys(false)) {
//    		for(String permissions : plugin.getConfig().getStringList("Groups."+groups+".permissions")) {
//    			attachment.setPermission(permissions, true);
//    		}
//    	}
//    }
			
				
	}
//	public void leave(PlayerQuitEvent e) {
//		Player player =e.getPlayer();
//		playerPermission.remove(player.getUniqueId());
//	}
}

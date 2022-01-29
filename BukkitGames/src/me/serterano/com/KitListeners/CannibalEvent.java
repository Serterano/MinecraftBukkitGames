package me.serterano.com.KitListeners;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.serterano.com.main;
import net.md_5.bungee.api.ChatColor;

public class CannibalEvent implements Listener{
	
	@EventHandler
	public void eatThem(PlayerDeathEvent event){
		Player victim =event.getEntity();
		if(victim.getKiller()!=null) {
			Player killer = victim.getKiller();
			if(killer.hasPermission("Eranobukkit.yamyam")) {
				killer.setHealth(killer.getHealth()+10);
				killer.setFoodLevel(20);
				victim.sendMessage(ChatColor.RED+killer.getName()+ChatColor.GREEN+" yamyamý seni yedi!.");
			}
		}
		
	}
}

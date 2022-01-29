package me.serterano.com.KitListeners;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.serterano.com.main;

public class PoseidonEvent implements Listener{
	
	@EventHandler
	public void onSea(PlayerMoveEvent e) {
		if(e instanceof Player) {
			Player player = e.getPlayer();
			if(player.hasPermission("Eranobukkit.poseidon")) {
				Material m = player.getLocation().getBlock().getType();
				if(m == Material.STATIONARY_WATER || m == Material.WATER) {
					if(player.hasPermission("Eranobukkit.poseidon")) {
					player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 10, 3));
					}
				}
				
				player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP,10,3));
				
			}
		}
	}
	@EventHandler
	public void waterBreathing(EntityDamageEvent event) {
		//patlama ve yanma hasarýndan koru
		if(event.getEntity() instanceof Player) {
        	Player player =(Player)event.getEntity();
        	if(player.hasPermission("Eranobukkit.poseidon")){
        		if(event.getCause() == DamageCause.DROWNING) {
        			
        			player.addPotionEffect(new PotionEffect(PotionEffectType.WATER_BREATHING,10,3));	
        		}
        		//patlama korumasý zýrhý ver
        	}
        }
	}
}

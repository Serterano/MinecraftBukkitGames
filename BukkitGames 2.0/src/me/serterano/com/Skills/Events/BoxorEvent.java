package me.serterano.com.Skills.Events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.serterano.com.main;

public class BoxorEvent implements Listener{
	
	@EventHandler
	public void boxingGloves(EntityDamageByEntityEvent e) {
		if(e.getDamager() instanceof Player) {
			Player p = (Player)e.getDamager();
			if(p.hasPermission("Eranobukkit.boxor")&&!p.isOp()) {
				if(p.getItemInHand()==null) {
				e.setDamage(6);
				}
			}
		}
		
	}
	@EventHandler
	public void onWalk(PlayerMoveEvent e) {
		Player player = e.getPlayer();
		if(player.hasPermission("Eranobukkit.boksor")&&player.isOnGround()&&!player.isOp()) {
			player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED,10,3));
		}
	}

}

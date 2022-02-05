package me.serterano.com.Skills.Events;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;

import me.serterano.com.main;

public class KingArcherEvent implements Listener{
	
	@EventHandler
	public void onShoot(ProjectileHitEvent e) {
		Player player = (Player)e.getEntity().getShooter();
		if(player.hasPermission("Eranobukkit.kingarcher")&&!player.isOp()) {
			if(e.getEntity() instanceof Arrow) {
			Location lc = e.getEntity().getLocation();
			player.getWorld().createExplosion(lc, 2);
		}
	}
		
	}

}

package me.serterano.com.KitListeners;

import java.util.Random;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;

import me.serterano.com.main;

public class VampireEvent implements Listener{
	
	Random rand = new Random();
	@EventHandler
	public void lifeSteal(EntityDamageByEntityEvent e) {
		Entity entity = e.getDamager();
		Entity entity2 =e.getEntity();
		if(entity instanceof Player && entity2 instanceof Player) {
			Player attacker = (Player)entity;
			//Player kurban =(Player)entity2;
			if(attacker.hasPermission("Eranobukkit.vampir")) {
				int tmp = rand.nextInt(3);//0 ile 1.5 kalp aras� yenilenme
				attacker.setHealth(attacker.getHealth()+tmp);
			}
		}
	}

}

package me.serterano.com.KitListeners;

import java.util.Random;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.serterano.com.main;
import net.md_5.bungee.api.ChatColor;

public class AresEvent implements Listener{
	
	
	
	Random rand =new Random();
	@EventHandler
	public void poisenThem(EntityDamageByEntityEvent e) {
		Entity entity1 = e.getEntity();
		Entity entity2 = e.getDamager();
		if(entity1 instanceof Player && entity2 instanceof Player) {
			Player victim= (Player)entity1;
			Player attacker= (Player)entity2;
			if(attacker.hasPermission("Eranobukkit.ares")) {
				int variable = rand.nextInt(100);
				if(variable>0 && variable<13) {
					
				victim.addPotionEffect(new PotionEffect(PotionEffectType.POISON,10,2));
				victim.sendMessage(ChatColor.RED+attacker.getName()+ChatColor.GREEN+" Aresi seni zehirledi dikkat et !");
				}
			}
		}
	}

}

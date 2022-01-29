package me.serterano.com.KitListeners;

import java.util.Random;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.serterano.com.main;

public class HadesEvent implements Listener{
	
	private Random rand = new Random();
	@EventHandler
	public void lifeSteal(EntityDamageByEntityEvent e) {
		//getEntity hasarý yiyen
		//getDamager hasar vuran
		Entity entity = e.getDamager();
		Entity entity2 = e.getEntity();
		if(entity instanceof Player && entity2 instanceof Player) {
			Player attacker = (Player)entity;
			if(attacker.hasPermission("Eranobukkit.hades")) {
				int tmp = rand.nextInt(5);//0 ile 2.5 kalp arasý yenilenme
				attacker.setHealth(attacker.getHealth()+tmp);
			}
		}
	}
	@EventHandler
    public void checkBurn(EntityDamageEvent event) {
        if(event.getEntity() instanceof Player) {
        	Player player =(Player)event.getEntity();
        	if(player.hasPermission("Eranobukkit.Hades")){
        		if(event.getCause() == DamageCause.FIRE || event.getCause() == DamageCause.FIRE_TICK) {
        			// Yanýyor mu ? kontrolu. 
        			//yanýyorsa güç iksiri bas
        			player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 10, 3));
        		}
        	}
        }
    }

}

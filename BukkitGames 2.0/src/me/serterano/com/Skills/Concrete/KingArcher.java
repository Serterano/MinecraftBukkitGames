package me.serterano.com.Skills.Concrete;
import org.bukkit.Material;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import me.serterano.com.Skills.Abstracts.Kit;
public class KingArcher extends Kit{

		public KingArcher() {
			setName("KingArcher");
			setCooldown(0);
			setItem(new ItemStack(Material.BOW));
		}
		
}

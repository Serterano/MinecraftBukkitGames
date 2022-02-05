package me.serterano.com.Skills.Concrete;

import org.bukkit.Material;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import me.serterano.com.Skills.Abstracts.Kit;

public class Default extends Kit{
	private ItemStack handItem;
	public ItemStack getHandItem() {
		return handItem;
	}
	public void setHandItem(ItemStack handItem) {
		this.handItem = handItem;
	}
	public Default() {
		setName("Default");
		setCooldown(0);
		setItem(new ItemStack(Material.LEATHER_CHESTPLATE));
		
		setHandItem(new ItemStack(Material.WOOD_SWORD));
		
		setHelmet(new ItemStack(Material.LEATHER_HELMET));
		setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE));
		setPant(new ItemStack(Material.LEATHER_LEGGINGS));
		setBoots(new ItemStack(Material.LEATHER_BOOTS));
		
		setFood(new ItemStack(Material.APPLE));
		setFoodCount(32);
	}
	
	

}

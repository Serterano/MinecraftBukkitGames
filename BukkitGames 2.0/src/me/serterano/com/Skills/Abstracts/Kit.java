package me.serterano.com.Skills.Abstracts;

import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public abstract class Kit {
	
	private String name;
	private int cooldown;
	private ItemStack item;
	
	private ItemStack helmet;
	private ItemStack chestplate;
	private ItemStack pant;
	private ItemStack boots;
	private ItemStack food;
	private int foodCount;
	//public abstract void execute(PlayerInteractEvent event);
	
	public int getFoodCount() {
		return foodCount;
	}
	public void setFoodCount(int foodCount) {
		this.foodCount = foodCount;
	}
	public ItemStack getFood() {
		return food;
	}
	public void setFood(ItemStack food) {
		this.food = food;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setCooldown(int cooldown) {
		this.cooldown = cooldown;
	}
	public String getName() {
		return name;
	}
	public int getCooldown() {
		return cooldown;
	}
	public ItemStack getItem() {
		return item;
	}
	public void setItem(ItemStack item) {
		this.item = item;
	}
	public ItemStack getHelmet() {
		return helmet;
	}
	public void setHelmet(ItemStack helmet) {
		this.helmet = helmet;
	}
	public ItemStack getChestplate() {
		return chestplate;
	}
	public void setChestplate(ItemStack chestplate) {
		this.chestplate = chestplate;
	}
	public ItemStack getPant() {
		return pant;
	}
	public void setPant(ItemStack pant) {
		this.pant = pant;
	}
	public ItemStack getBoots() {
		return boots;
	}
	public void setBoots(ItemStack boots) {
		this.boots = boots;
	}
	
	
	
}

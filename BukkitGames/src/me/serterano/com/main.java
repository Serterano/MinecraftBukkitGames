package me.serterano.com;

import java.util.ArrayList;

import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

import me.serterano.com.Commands.KillAllEntitiesCommand;
import me.serterano.com.Commands.KitGUICommand;
import me.serterano.com.Commands.OnlinePlayersCommand;
import me.serterano.com.CustomEvents.KitGUIMoveItem;
import me.serterano.com.CustomEvents.Tasks.AllGameTask;
import me.serterano.com.CustomEvents.Tasks.Timer1GameStarter;
import me.serterano.com.CustomEvents.Tasks.Timer2Invýncible;
import me.serterano.com.CustomEvents.Tasks.Timer3FinalBattle;
import me.serterano.com.KitListeners.KingArcherEvent;

public class main extends JavaPlugin implements Listener{
	
	Timer1GameStarter timer1;
	AllGameTask task;
	@Override
	public void onEnable() {
		System.out.println("Plugin aktif");
		//5dk sayacý bittiðinde oyun baþlar ve eventleri orda register et
//	    getCommand("KillEntities").setExecutor(new KillAllEntitiesCommand());
//		getServer().getPluginManager().registerEvents(new VampirEvent(),this);
	    
	    startGame();
	    
	//    	e.getPlayer().setInvulnerable(true);
	//gamerule doMobSpawning true olayýný koda ekle
        
	}
	
	public void startGame() {
		timer1 =new Timer1GameStarter(this,60);
		task = new AllGameTask(this);
		
	}
	@Override
	public void onDisable() {
		this.saveConfig();
	}
        
	


}

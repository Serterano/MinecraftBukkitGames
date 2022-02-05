package me.serterano.com;

import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import me.serterano.com.Commands.KitGUICommand;
import me.serterano.com.Events.BlockBreak;
import me.serterano.com.Events.KitGUIMoveItem;
import me.serterano.com.Events.NoFallEvent;
import me.serterano.com.Skills.Events.AresEvent;
import me.serterano.com.Skills.Events.BoxorEvent;
import me.serterano.com.Skills.Events.CannibalEvent;
import me.serterano.com.Skills.Events.HadesEvent;
import me.serterano.com.Skills.Events.KingArcherEvent;
import me.serterano.com.Skills.Events.PoseidonEvent;
import me.serterano.com.Skills.Events.TarzanEvent;
import me.serterano.com.Skills.Events.VampireEvent;
import me.serterano.com.Tasks.AllGameTask;
import me.serterano.com.Tasks.Timer1GameStarter;

public class main extends JavaPlugin implements Listener{
	

	@Override
	public void onEnable() {
		System.out.println("Plugin aktif");
		this.getConfig().options().copyDefaults(true);
		this.saveConfig();
		getServer().getPluginManager().registerEvents(new AresEvent(), this);
        getServer().getPluginManager().registerEvents(new BoxorEvent(), this);
        getServer().getPluginManager().registerEvents(new CannibalEvent(), this);
        getServer().getPluginManager().registerEvents(new HadesEvent(), this);
        getServer().getPluginManager().registerEvents(new KingArcherEvent(), this);
        getServer().getPluginManager().registerEvents(new PoseidonEvent(), this);
        getServer().getPluginManager().registerEvents(new TarzanEvent(), this);
        getServer().getPluginManager().registerEvents(new VampireEvent(), this);
        getCommand("Kit").setExecutor(new KitGUICommand());
        getServer().getPluginManager().registerEvents(new NoFallEvent(), this);
        getServer().getPluginManager().registerEvents(new KitGUIMoveItem(),this);
//        getServer().getPluginManager().registerEvents(new BlockBreak(),this);
//		getServer().getPluginManager().registerEvents(new VampirEvent(),this);
	    startGame();
        
	}
	public static boolean isGamePlaying=false;
	public void startGame() {
		Timer1GameStarter timer1 =new Timer1GameStarter(this,180+1);
		
	}
	@Override
	public void onDisable() {
		//playerPermission.clear();
		//HandlerList.unregisterAll();
		
	}
        
	
//	Groups:
//		   Default:
//		      permissions:
//		         -BukkitGames.Default
//		         -Bukkit.survival
//		   Tarzan:
//		      permissions:
//		         -BukkitGames.Tarzan
//		         -Bukkit.survival
//		   Ares:
//		      permissions:
//		         -BukkitGames.Ares
//		         -Bukkit.survival
//		   Hades:
//		      permissions:
//		         -BukkitGames.Hades
//		         -Bukkit.survival
//		   KingArcher:
//		      permissions:
//		         -BukkitGames.KingArcher
//		         -Bukkit.survival
//		   Boxor:
//		      permissions:
//		         -BukkitGames.Boxor
//		         -Bukkit.survival
//		   Cannibal:
//		      permissions:
//		         -BukkitGames.Cannibal
//		         -Bukkit.survival
//		   Poseidon:
//		      permissions:
//		         -BukkitGames.Poseidon
//		         -Bukkit.survival
//		   Vampire:
//		      permissions:
//		         -BukkitGames.Vampire
//		         -Bukkit.survival

}

package me.serterano.com.Tasks;

import java.util.ArrayList;
import java.util.Random;

import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.jetbrains.annotations.NotNull;

import me.serterano.com.main;
import me.serterano.com.Skills.Events.AresEvent;
import me.serterano.com.Skills.Events.BoxorEvent;
import me.serterano.com.Skills.Events.CannibalEvent;
import me.serterano.com.Skills.Events.HadesEvent;
import me.serterano.com.Skills.Events.KingArcherEvent;
import me.serterano.com.Skills.Events.PoseidonEvent;
import me.serterano.com.Skills.Events.TarzanEvent;
import me.serterano.com.Skills.Events.VampireEvent;

public class Timer4DeathmatchPunishment extends BukkitRunnable{
	//final battle dan sonra bu thread çalýþacak
	
	private static int max_seconds;

    private static int now_seconds=Integer.valueOf(0);
    
    private static int now_mins;
    
    private main plugin;
    
    public Timer4DeathmatchPunishment(final @NotNull JavaPlugin plugin) {
		this.max_seconds = max_seconds;
        this.now_seconds = max_seconds;
        this.plugin=(main)plugin;
        World world =plugin.getServer().getWorld("world");
        world.setPVP(true);
        world.setMonsterSpawnLimit(0);
        world.setAnimalSpawnLimit(0);
        this.start();
	}
    public void start() {
        this.runTaskTimer(this.plugin, 0, 20L);
        
    }
	public void stop() {
        this.cancel();
    }
	
	private Random rand = new Random();
	@Override
	public void run() {
		ArrayList<Player> survivors= getAlivePlayers();
		if(now_seconds>60) {
			if(now_seconds%10==0) {
				//survival modundakilere yýldýrým at
				int random = rand.nextInt(getOnlinePlayers().length);
				Player p = survivors.get(random);
				Location l = p.getLocation();
				World world =plugin.getServer().getWorld("world");
//				world.strikeLightningEffect(l);
				world.strikeLightning(l);
			}
		}
		
		
		now_seconds++;
	}
	public ArrayList<Player> getAlivePlayers(){
		ArrayList<Player> tmp = new ArrayList<>();
		for(Player alive :getOnlinePlayers()) {
			if(alive.getGameMode().equals(GameMode.SURVIVAL)) {
				tmp.add(alive);
			}
		}
		
		return tmp;
	}
	@Override
    public synchronized void cancel() throws IllegalStateException {
        if (!this.isCancelled())
            super.cancel();
    }//dýþardan cancel etmek için
	public Player[] getOnlinePlayers() {
    	ArrayList<Player> online = new ArrayList<>();
		for(Player p : plugin.getServer().getOnlinePlayers()) {
			online.add(p);
		}
		return (Player[]) online.toArray(new Player[0]);
	}
	public static int getMaxSeconds() {
        return max_seconds;
    }

    public static int getNowSeconds() {
        return now_seconds;
    }
	

}

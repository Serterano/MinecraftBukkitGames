package me.serterano.com.Tasks;

import java.util.ArrayList;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.jetbrains.annotations.NotNull;

public class AllGameTask extends BukkitRunnable{
	private JavaPlugin pl;
	private Timer1GameStarter timer1;
	private Timer2Invýncible timer2;
	public AllGameTask(final @NotNull JavaPlugin pl) {
		this.pl=pl;
        this.start();
    }
    public void start() {
        this.runTaskTimer(this.pl, 0, 20L);
    }
	public void stop() {
        this.cancel();
    }
	//oyun baþladýktan sonraki kontrolleri yap
	@Override
	public void run() {
		
		if(timer1.isCancelled()) {
			
			
			
			if(timer2.isCancelled()) {
				
			}
		}
		
		
	}
	public Player[] getOnlinePlayers() {
    	ArrayList<Player> online = new ArrayList<>();
		for(Player p : pl.getServer().getOnlinePlayers()) {
			online.add(p);
		}
		return (Player[]) online.toArray(new Player[0]);
	}

}

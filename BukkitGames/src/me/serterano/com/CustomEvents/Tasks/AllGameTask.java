package me.serterano.com.CustomEvents.Tasks;

import java.util.ArrayList;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.jetbrains.annotations.NotNull;

public class AllGameTask extends BukkitRunnable{
	private JavaPlugin pl;
	private Timer1GameStarter timer1;
	private Timer2Inv�ncible timer2;
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
	//oyun ba�lad�ktan sonraki kontrolleri yap
	@Override
	public void run() {
		//chestlerin k�r�lmas�na engel olan event laz�m
		if(timer1.isCancelled()) {
			
			
			//chest yenileme olaylar�n�da burda yap
			if(timer2.isCancelled()) {
				//hasar alma a��k
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

package me.serterano.com.CustomEvents.Tasks;

import java.util.ArrayList;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.jetbrains.annotations.NotNull;

public class Timer4DeathmatchPunishment extends BukkitRunnable{
	//final battle dan sonra bu thread çalýþacak
	
	private static int max_seconds;

    private static int now_seconds;
    
    private static int now_mins;
    
    private JavaPlugin plugin;
    
    public Timer4DeathmatchPunishment(final @NotNull JavaPlugin plugin,final int max_seconds) {
		this.max_seconds = max_seconds;
        this.now_seconds = max_seconds;
        this.plugin=plugin;
        // run task
        this.start();
	}
    public void start() {
        this.runTaskTimer(this.plugin, 0, 20L);
    }
	public void stop() {
        this.cancel();
    }
	
	
	
	@Override
	public void run() {
		
		
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

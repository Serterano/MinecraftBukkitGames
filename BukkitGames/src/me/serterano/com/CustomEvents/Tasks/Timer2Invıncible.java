package me.serterano.com.CustomEvents.Tasks;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.jetbrains.annotations.NotNull;

import net.md_5.bungee.api.ChatColor;

public final class Timer2Invýncible extends BukkitRunnable {
	
	 	private static int max_seconds;

	    private static int now_seconds;
	    
	    private static int now_mins;
	    
	    private JavaPlugin plugin;
	    
	public Timer2Invýncible(final @NotNull JavaPlugin plugin,final int max_seconds) {
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
        Timer3FinalBattle timer3 =new Timer3FinalBattle(plugin,1200);
    }
	private World world= Bukkit.getWorld("world");
    Location l;
	@Override
	public void run() {
		if (this.now_seconds <= 0) {
			plugin.getServer().broadcastMessage(ChatColor.GOLD+"Ölümsüzlük sona erdi!");
            //startgame
            this.stop();
            return;
        }
		else if(now_seconds>0) {
        	if(now_seconds%60==0) {
        		now_mins =now_seconds/60;
        		plugin.getServer().broadcastMessage(ChatColor.GOLD+"Ölümsüzlüðün kapanmasýna "+now_mins+" dakika kaldi");
        	}
        	else if(now_seconds<=60 && now_seconds%10==0 && now_seconds!=10 && now_seconds!=0) {
        		plugin.getServer().broadcastMessage(ChatColor.GOLD+"Ölümsüzlüðün kapanmasýna "+now_seconds+" saniye kaldi");
        	}
        	else if(now_seconds<=10) {
        		plugin.getServer().broadcastMessage(ChatColor.GOLD+"Ölümsüzlüðün kapanmasýna "+ChatColor.RED+now_seconds+ChatColor.GOLD+" saniye kaldi");
        		for(Player p : plugin.getServer().getOnlinePlayers()) {
        			l = p.getLocation();
        			p.playSound(l, Sound.ENTITY_SNOWBALL_THROW, 1, 4);
        		}
        	}
        }
		now_seconds--;
		
	}
	@Override
    public synchronized void cancel() throws IllegalStateException {
        if (!this.isCancelled())
            super.cancel();
    }

}

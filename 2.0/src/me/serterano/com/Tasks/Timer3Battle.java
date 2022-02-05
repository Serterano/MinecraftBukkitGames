package me.serterano.com.Tasks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.jetbrains.annotations.NotNull;

import me.serterano.com.main;
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
import me.serterano.com.Utilities.Perms;
import net.md_5.bungee.api.ChatColor;

public class Timer3Battle extends BukkitRunnable{
	private static int max_seconds;

    private static int now_seconds;
    
    private static int now_mins;
    
    private main plugin;
    
    public Timer3Battle(final @NotNull JavaPlugin plugin,final int max_seconds) {
		this.max_seconds = max_seconds;
        this.now_seconds = max_seconds;
        this.plugin=(main)plugin;
        // run task
        World world =plugin.getServer().getWorld("world");
        world.setPVP(true);
        world.setMonsterSpawnLimit(0);
        world.setAnimalSpawnLimit(0);
        this.start();
	}
    public void start() {
        this.runTaskTimer(this.plugin, 0, 20L);
        for(Player p : getOnlinePlayers()) {
        	Perms.setAttachment(p);
        }
        
    }
	public void stop() {
        this.cancel();
        
        //deathmatch timer lazým
        //yýldýrýmlarýn çarpmaya baþlayacaðý zaman sn
        Timer4DeathmatchPunishment timer = new Timer4DeathmatchPunishment(plugin);
    }
	private World world= Bukkit.getWorld("world");
    Location l;
    //Arena proplarý burda olsun
	@Override
	public void run() {
		//Final Battle 20 dk say//ok
		//son 5 dk her dk baþýna 1 bildirim gönder//ok
		//eðer 1 kiþi hariç herkes ölürse server yeniden baþlatýlýr.
		//ölenler spectator moduna alýnýr.
		//en son kalan kiþinin etrafýnda havai fiþekler fýrlatýlýr ve creative geçilir
		//Server her yeniden baþladýgýnda gamemodelarý sýfýrla
		if (this.now_seconds <= 0) {
			for(Player p : getOnlinePlayers()) {
        		l = p.getLocation();
        		p.teleport(world.getSpawnLocation());
        		//spawn point yerine arena spawn yerleri yap
        		p.sendMessage("Arenaya ýþýnlandýn");//spawn yerine arena baþlangýç noktalarý al configden
        		l = p.getLocation();
        		world.playSound(l, Sound.BLOCK_ANVIL_PLACE, 2, 1);
        	}
			plugin.getServer().broadcastMessage(ChatColor.GOLD+"Final battle has started!");
            this.stop();
            return;
        }
		else if(now_seconds>0 && now_seconds<=300) {
        	if(now_seconds%60==0) {
        		now_mins =now_seconds/60;
        		plugin.getServer().broadcastMessage(ChatColor.GOLD+"Final savasina "+now_mins+" dakika kaldi");
        	}
        	else if(now_seconds<=60 && now_seconds%10==0 && now_seconds!=10 && now_seconds!=0) {
        		plugin.getServer().broadcastMessage(ChatColor.GOLD+"Final savasina "+now_seconds+" saniye kaldi");
        	}
        	else if(now_seconds<=10) {
        		plugin.getServer().broadcastMessage(ChatColor.GOLD+"Final savasina "+ChatColor.RED+now_seconds+ChatColor.GOLD+" saniye kaldi");
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

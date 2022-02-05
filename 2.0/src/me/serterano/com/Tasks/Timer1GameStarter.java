package me.serterano.com.Tasks;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import me.serterano.com.main;
import me.serterano.com.Commands.KitGUICommand;
import me.serterano.com.Events.BlockBreak;
import me.serterano.com.Events.KitGUIMoveItem;
import me.serterano.com.Events.NoFallEvent;
import net.md_5.bungee.api.ChatColor;

public final class Timer1GameStarter extends BukkitRunnable {

    private static int max_seconds;

    private static int now_seconds;
    
    private static int now_mins;
    
    private Integer min_player = Integer.valueOf(1);
    
    private static main plugin;
    
//    public static GameTimer1 runTimer(final @NotNull JavaPlugin plugin, final int max_seconds) {
//        return new GameTimer1(plugin, max_seconds);
//    }
	
    public Timer1GameStarter(JavaPlugin plugin_, final int max_seconds) {
        this.max_seconds = max_seconds;
        this.now_seconds = max_seconds;
        plugin=(main) plugin_;
        World world =plugin.getServer().getWorld("world");
        world.setPVP(false);
        world.setMonsterSpawnLimit(0);
        world.setAnimalSpawnLimit(0);//burasý çalýþmassa kapat
        this.start();
    }
    public void start() {
    	plugin.isGamePlaying=false;
        this.runTaskTimer(this.plugin, 0, 20L);
        
    }
	public void stop() {
        this.cancel();
        plugin.isGamePlaying=true;
        //kit seçme kapat
        Timer2Invýncible timer2 = new Timer2Invýncible(plugin,60);
    }
    
    //oyunculara dokunulmazlýk ve blok kýramama ver
    private World world= Bukkit.getWorld("world");
    //setworldspawn yap oyunda
    //hasar almayý kapat blok kýrmayý kapat
    Location l;
	@Override
    public void run() {
        if (this.now_seconds <= 0 && getOnlinePlayers().length>=min_player) {
            //spawnpointe ýþýnla herkesi
        	for(Player p : getOnlinePlayers()) {
        		l = p.getLocation();
        		p.teleport(world.getSpawnLocation());//spawn point
        		p.sendMessage("Spawna ýþýnlandýn");
        		l = p.getLocation();
        		world.playSound(l, Sound.BLOCK_ANVIL_PLACE, 2, 1);
        	}
        	plugin.getServer().broadcastMessage(ChatColor.GOLD+"Kendi rotaný oluþtur !");
//            GameTimer2.runTimer(plugin, 60);
        	this.stop();
            return;
        }
        else if(this.now_seconds<=0 && getOnlinePlayers().length<=min_player){
        	//timer reset scope
        	now_seconds = max_seconds;
        	System.out.println("Zamanlayici yeniden baþlatiliyor");
        	plugin.getServer().broadcastMessage(ChatColor.GOLD+"Oyunun baþlayabilmesi için minimum oyuncu sayýsý :"+ChatColor.RED+min_player);
        }
        else if(now_seconds>0) {
        	if(now_seconds%60==0) {
        		now_mins =now_seconds/60;
        		plugin.getServer().broadcastMessage(ChatColor.GOLD+"Oyunun baslamasina "+now_mins+" dakika kaldi");
        	}
        	else if(now_seconds<=60 && now_seconds%10==0 && now_seconds!=10 && now_seconds!=0) {
        		plugin.getServer().broadcastMessage(ChatColor.GOLD+"Oyunun baslamasina "+now_seconds+" saniye kaldi");
        	}
        	else if(now_seconds<=10) {
        		plugin.getServer().broadcastMessage(ChatColor.GOLD+"Baþlýyor.. "+now_seconds);
        		for(Player p : plugin.getServer().getOnlinePlayers()) {
        			l = p.getLocation();
        			p.playSound(l, Sound.ENTITY_SNOWBALL_THROW, 1, 4);
        		}
        	}
        }
        
        
        now_seconds--;
    }
    public Player[] getOnlinePlayers() {
    	ArrayList<Player> online = new ArrayList<>();
		for(Player p : plugin.getServer().getOnlinePlayers()) {
			online.add(p);
		}
		return (Player[]) online.toArray(new Player[0]);
	}

    @Override
    public synchronized void cancel() throws IllegalStateException {
        if (!this.isCancelled())
            super.cancel();
    }

    public static int getMaxSeconds() {
        return max_seconds;
    }

    public static int getNowSeconds() {
        return now_seconds;
    }
}
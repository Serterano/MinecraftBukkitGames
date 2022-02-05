package me.serterano.com.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.serterano.com.main;
import net.md_5.bungee.api.ChatColor;

public class OnlinePlayersCommand implements CommandExecutor{
	private static main instance;
	public OnlinePlayersCommand(main instance) {
		this.instance=instance;
	}
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player){
			Player player = (Player) sender;
			int counter =0;
			for(Player p : instance.getServer().getOnlinePlayers()) {
				counter++;
			}
			player.sendMessage(ChatColor.GREEN+"Þuanda oynayan "+ChatColor.GOLD+counter+ChatColor.GREEN+" oyuncu var");
		}
		
		return true;
	}
	

}

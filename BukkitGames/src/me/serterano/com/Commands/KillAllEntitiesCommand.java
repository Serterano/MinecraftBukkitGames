package me.serterano.com.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

public class KillAllEntitiesCommand implements CommandExecutor{
	@Override
    public boolean onCommand(CommandSender sender, Command command,
            String label, String[] args) {
          if(label.equalsIgnoreCase("killmobs"));
          Player player = (Player) sender;
          for(Entity en : player.getWorld().getEntities()){
              if(!(en instanceof Player)) {
 
              en.remove();
              }
        }
        return false;
                }
}

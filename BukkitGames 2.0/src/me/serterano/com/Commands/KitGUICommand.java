package me.serterano.com.Commands;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.serterano.com.main;

public class KitGUICommand implements CommandExecutor {
	private main plugin = main.getPlugin(main.class);
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
 
        if(sender instanceof Player && plugin.isGamePlaying==false){
            Player player = (Player) sender;
            Inventory gui = Bukkit.createInventory(player, 36, ChatColor.AQUA + "Kits");
 
            ItemStack Vampir = new ItemStack(Material.REDSTONE);
            ItemStack Kralok�u =  new ItemStack(Material.ARROW); 
            ItemStack Poseidon = new ItemStack(Material.DIAMOND_CHESTPLATE); 
            ItemStack Hades = new ItemStack(Material.BLAZE_POWDER);
            ItemStack Ares = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
            ItemStack Tarzan = new ItemStack(Material.STICK);
            ItemStack Yamyam = new ItemStack(Material.ROTTEN_FLESH);
            ItemStack Boksor = new ItemStack(Material.IRON_HELMET);
 
            ItemMeta Vampir_meta = Vampir.getItemMeta();
            Vampir_meta .setDisplayName(ChatColor.RED + "Vampir");
            ArrayList<String> Vampir_lore = new ArrayList<>();
            Vampir_lore.add(ChatColor.GOLD + "Vurduk�a can yeniler");
            Vampir_lore.add(ChatColor.RED + "30 coin");
            Vampir_meta.setLore(Vampir_lore);
            Vampir.setItemMeta(Vampir_meta );
 
            ItemMeta Kralok�u_meta = Kralok�u.getItemMeta();
            Kralok�u_meta.setDisplayName(ChatColor.DARK_GREEN + "KralOk�u");
            ArrayList<String> Kralok�u_lore = new ArrayList<>();
            Kralok�u_lore.add(ChatColor.GOLD + "Att���n�z oklar tnt etkisi yarat�r");
            Kralok�u_lore.add(ChatColor.RED+"60 coin");
            Kralok�u_meta.setLore(Kralok�u_lore);
            Kralok�u.setItemMeta(Kralok�u_meta);
 
            ItemMeta Poseidon_meta = Poseidon.getItemMeta();
            Poseidon_meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
            Poseidon_meta.setDisplayName(ChatColor.LIGHT_PURPLE + "Poseidon");
            ArrayList<String> Poseidon_lore = new ArrayList<>();
            Poseidon_lore.add(ChatColor.GOLD + "Suda g��lenir.");
            Poseidon_lore.add(ChatColor.GOLD +"Patlama ve d��me hasar�n� emer.");
            Poseidon_lore.add(ChatColor.GOLD +"Y�ksek z�plar");
//            Poseidon_lore.add(ChatColor.GOLD +"Bo�ulmaz");
            Poseidon_lore.add(ChatColor.RED+"60 coin");
            Poseidon_meta.setLore(Poseidon_lore);
            Poseidon.setItemMeta(Poseidon_meta);
            
            ItemMeta Hades_meta = Hades.getItemMeta();
            Hades_meta.setDisplayName(ChatColor.RED+"Hades");
            ArrayList<String> Hades_lore = new ArrayList<>();
            Hades_lore.add(ChatColor.GOLD+"Ate�te g��lenir.");
//            Hades_lore.add(ChatColor.GOLD+"Yanma Hasar� almaz");
            Hades_lore.add(ChatColor.GOLD+"Vurduk�a can yeniler.");
            Hades_lore.add(ChatColor.RED+"60 coin");
            Hades_meta.setLore(Hades_lore);
            Hades.setItemMeta(Hades_meta);
            
            ItemMeta Ares_meta = Ares.getItemMeta();
            Ares_meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
            Ares_meta.setDisplayName(ChatColor.YELLOW+"Ares");
            ArrayList<String> Ares_lore = new ArrayList<>();
            Ares_lore.add(ChatColor.GOLD+"Vuru�lar�n zehir atma �ans� vard�r");
            Ares_lore.add(ChatColor.BLUE+"Ucretsiz");
            Ares_meta.setLore(Ares_lore);
            Ares.setItemMeta(Ares_meta);
            
            ItemMeta Yamyam_meta = Yamyam.getItemMeta();
            Yamyam_meta.setDisplayName(ChatColor.RED+"Yamyam");
            ArrayList<String> Yamyam_lore = new ArrayList<>();
            Yamyam_lore.add(ChatColor.GOLD+"Bir�ey �ld�rd���n�zde");
            Yamyam_lore.add(ChatColor.GOLD+"sa�l���n�z ve a�l���n�z dolar.");
            Yamyam_lore.add(ChatColor.BLUE+"Ucretsiz");
            Yamyam_meta.setLore(Yamyam_lore);
            Yamyam.setItemMeta(Yamyam_meta);
            
            ItemMeta Tarzan_meta = Tarzan.getItemMeta();
            Tarzan_meta.setDisplayName(ChatColor.DARK_GRAY+"Tarzan");
            ArrayList<String> Tarzan_lore = new ArrayList<>();
            Tarzan_lore.add(ChatColor.GOLD+"�ubuk ile yap�lan vuru�lar�n");
            Tarzan_lore.add(ChatColor.GOLD+"rakibin elindeki itemi alma �ans� vard�r.");
            Tarzan_lore.add(ChatColor.GOLD +"Y�ksek z�plar h�zl� ko�ar");
            Tarzan_lore.add(ChatColor.BLUE+"Ucretsiz");
            Tarzan_meta.setLore(Tarzan_lore);
            Tarzan.setItemMeta(Tarzan_meta);
            
            ItemMeta Boksor_meta = Boksor.getItemMeta();
            Boksor_meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
            Boksor_meta.setDisplayName(ChatColor.DARK_GRAY+"Boksor");
            ArrayList<String> Boksor_lore = new ArrayList<>();
            Boksor_lore.add(ChatColor.GOLD+"Yumruk ile yap�lan vuru�lar�n");
            Boksor_lore.add(ChatColor.GOLD+"demir k�l�� hasar� ile ayn�d�r.");
            Boksor_lore.add(ChatColor.GOLD +"H�zl� ko�ar.");
            Boksor_lore.add(ChatColor.BLUE+"Ucretsiz");
            Boksor_meta.setLore(Boksor_lore);
            Boksor.setItemMeta(Boksor_meta);
            
            //burada vip ve �cretsiz kitlerin aras�na cam koy ???
            ItemStack[] menu_items = 
            {Vampir, Kralok�u, Poseidon, Hades, Ares, Tarzan, Yamyam, Boksor};
            gui.setContents(menu_items);
            //gui.setItem(index,itemstackinstance) da olur tek tek
            player.openInventory(gui);
            
 
 
        }
        else {
        	sender.sendMessage(ChatColor.RED+"You cant run this command during game");
        }
 
        return true;
    }
}

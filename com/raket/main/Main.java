package com.raket.main;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.Vector;

import net.md_5.bungee.api.ChatColor;

public class Main extends JavaPlugin {
   
    @Override
    public void onEnable() {
    	getLogger().info("raket-plugin is aan!");
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    	Player p = (Player) sender;
    	
    	if(label.equalsIgnoreCase("rocket")) {
    		if(!(sender.hasPermission("rocket.*"))) {
    			sender.sendMessage(ChatColor.RED + "Je hebt geen permissies!");
    		} else if (args.length == 0) {
    			sender.sendMessage(ChatColor.RED + "Usage: /rocket <naam>");
    		} else {
    			Player target = getServer().getPlayer(args[0]);
    			if(target == null) {
    				sender.sendMessage(ChatColor.RED + "Kan de speler " + ChatColor.YELLOW + args[0] + ChatColor.RED + " niet vinden!");
    			} else {
    				Vector v = p.getLocation().getDirection().add(new Vector(0, 100, 0));
    				target.setVelocity(v);
    				Bukkit.broadcastMessage(ChatColor.RED + "Speler " + ChatColor.YELLOW + sender.getName() + ChatColor.RED + " is ge-rocket door " + ChatColor.YELLOW + target.getName() + ChatColor.RED + "!");
    			}
    		}
    	}
     	
		return true;
    	
    }
    
}



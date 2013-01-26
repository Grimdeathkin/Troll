package com.idlebrits.Troll;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;


public class TrollCommandExecutor implements CommandExecutor{
	public Troll plugin;
	
	public TrollCommandExecutor(Troll instance){
		plugin = instance;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("sendcustom")){
			if(args.length == 0){
				if(sender.hasPermission("Troll.sendcustom.self")){
					sender.sendMessage(plugin.getConfig().getString("Custom Message"));
				}else{
					sender.sendMessage(ChatColor.RED + "You do not have permission to do this.");
				}
			}else if(args.length == 1){
				if(sender.hasPermission("Troll.sendcustom.self")){
				if(sender.getServer().getPlayer(args[0]) != null){
					Player target = sender.getServer().getPlayer(args[0]);
					target.sendMessage((plugin.getConfig()).getString("Custom Message"));
					}
				}else{
					sender.sendMessage(ChatColor.RED + "You do not have permission to do this.");
				}
			}
		}
		if(cmd.getName().equalsIgnoreCase("freeze")){
			if(args.length == 0){
				if(sender.hasPermission("Troll.freeze.self")){
					if(plugin.hashmap.containsKey(sender)){
						plugin.hashmap.remove(sender);
						sender.sendMessage("You have been unfrozen.");
					
					}else {
						plugin.hashmap.put((Player) sender, null);
						sender.sendMessage("You have frozen yourself.");
					}
				}else{
					sender.sendMessage(ChatColor.RED + "You do not have permission to do this.");
				}
			}else if (args.length == 1){
				if(sender.hasPermission("Troll.freeze.other")){
					if(sender.getServer().getPlayer(args[0]) != null){
					Player target = sender.getServer().getPlayer(args[0]);
						if(!plugin.hashmap.containsKey(target)){
							sender.sendMessage("You have frozen" + target.getDisplayName() + ".");
							plugin.hashmap.put(target, null);
							target.sendMessage("You have been frozen.");
						}else {
							sender.sendMessage("You have unfrozen" + target.getDisplayName() + ".");
							plugin.hashmap.remove(target);
							target.sendMessage("You have been unfrozen.");
						}
					}
				}else{
					sender.sendMessage(ChatColor.RED + "You do not have permission to do this.");
				}
			}
			
		}
		if(cmd.getName().equalsIgnoreCase("burn")){
			if(args.length == 0){
				if(sender.hasPermission("Troll.burn.self")){
					Player player = (Player) sender;
					player.setFireTicks(10000);
					sender.sendMessage("You have burned yourself.");
				} else {
					sender.sendMessage(ChatColor.RED + "You do not have permission to do this.");
				}
			} else if (args.length == 1){
				if(sender.hasPermission("Troll.burn.other")){
					Player target = sender.getServer().getPlayer(args[0]);
					target.setFireTicks(10000);
					target.sendMessage("You have been burned.");
				} else {
					sender.sendMessage(ChatColor.RED + "You do not have permission to do this.");
				}
			} 
		}
		if(cmd.getName().equalsIgnoreCase("explode")){
			if(args.length == 0){
				if(sender.hasPermission("Troll.explode.self")){
					float explosionPower = 4F;
					Player player = (Player) sender;
					player.getWorld().createExplosion(player.getLocation(), explosionPower);
				}
			}
			else if(args.length == 1){
				if(sender.hasPermission("Troll.explode.other")){
					float explosionPower = 4F; 
					Player target = ((Server) ((Location) sender).getWorld()).getPlayer(args[0]);
					target.getWorld().createExplosion(target.getLocation(), explosionPower);
					target.setHealth(0);
			}else{
				sender.sendMessage(ChatColor.RED + "You do not have permission to do this.");
			}
		}
	}
	if(cmd.getName().equalsIgnoreCase("poison")){
		if(args.length == 0){
			if(sender.hasPermission("Troll.poison.self")){
				Player player = (Player) sender;
				player.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 1000, 1));
				player.sendMessage("You have been posioned");
			}else{
				sender.sendMessage(ChatColor.RED + "You do not have permission to do this.");
			}
		}else if (args.length == 1){
			if(sender.hasPermission("Troll.poison.other")){
				Player target = sender.getServer().getPlayer(args[0]);
				target.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 1000, 1));
				target.sendMessage("You have been poisoned.");
			}else{
				sender.sendMessage(ChatColor.RED + "You do not have permission to do this.");
			}
		}
	}
	if(cmd.getName().equalsIgnoreCase("wither")){
		if(args.length == 0){
			if(sender.hasPermission("Troll.wither.self")){
				Player player = (Player) sender;
				player.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 200, 1));
				player.sendMessage("You have been withered");
			}else{
				sender.sendMessage(ChatColor.RED + "You do not have permission to do this.");
			}
		}else if (args.length == 1){
			if(sender.hasPermission("Troll.wither.other")){
				Player target = sender.getServer().getPlayer(args[0]);
				target.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 1000, 1));
				target.sendMessage("You have been withered.");
			}else{
				sender.sendMessage(ChatColor.RED + "You do not have permission to do this.");
			}
		}
	}
	if(cmd.getName().equalsIgnoreCase("trollface")){
		if(args.length == 0){
			if(sender.hasPermission("Troll.trollface.self")){
				sender.sendMessage("░░░░░▄▄▄▄▀▀▀▀▀▀▀▀▄▄▄▄▄▄░░░░░░░");
				sender.sendMessage("░░░░░█░░░░▒▒▒▒▒▒▒▒▒▒▒▒░░▀▀▄░░░░");
				sender.sendMessage("░░░░█░░░▒▒▒▒▒▒░░░░░░░░▒▒▒░░█░░░");
				sender.sendMessage("░░░█░░░░░░▄██▀▄▄░░░░░▄▄▄░░░░█░░");
				sender.sendMessage("░▄▀▒▄▄▄▒░█▀▀▀▀▄▄█░░░██▄▄█░░░░█░");
				sender.sendMessage("█░▒█▒▄░▀▄▄▄▀░░░░░░░░█░░░▒▒▒▒▒░█");
				sender.sendMessage("█░▒█░█▀▄▄░░░░░█▀░░░░▀▄░░▄▀▀▀▄▒█");
				sender.sendMessage("░█░▀▄░█▄░█▀▄▄░▀░▀▀░▄▄▀░░░░█░░█░");
				sender.sendMessage("░░█░░░▀▄▀█▄▄░█▀▀▀▄▄▄▄▀▀█▀██░█░░");
				sender.sendMessage("░░░█░░░░██░░▀█▄▄▄█▄▄█▄████░█░░░");
				sender.sendMessage("░░░░█░░░░▀▀▄░█░░░█░█▀██████░█░░");
				sender.sendMessage("░░░░░▀▄░░░░░▀▀▄▄▄█▄█▄█▄█▄▀░░█░░");
				sender.sendMessage("░░░░░░░▀▄▄░▒▒▒▒░░░░░░░░░░▒░░░█░");
				sender.sendMessage("░░░░░░░░░░▀▀▄▄░▒▒▒▒▒▒▒▒▒▒░░░░█░");
				sender.sendMessage("░░░░░░░░░░░░░░▀▄▄▄▄▄░░░░░░░░█░░");
			}else{
				sender.sendMessage(ChatColor.RED + "You do not have permission to do this.");
			}
		}else if(args.length == 1){
			if(sender.hasPermission("Troll.trollface.other")){
				Player target = sender.getServer().getPlayer(args[0]);
				target.sendMessage("░░░░░▄▄▄▄▀▀▀▀▀▀▀▀▄▄▄▄▄▄░░░░░░░");
				target.sendMessage("░░░░░█░░░░▒▒▒▒▒▒▒▒▒▒▒▒░░▀▀▄░░░░");
				target.sendMessage("░░░░█░░░▒▒▒▒▒▒░░░░░░░░▒▒▒░░█░░░");
				target.sendMessage("░░░█░░░░░░▄██▀▄▄░░░░░▄▄▄░░░░█░░");
				target.sendMessage("░▄▀▒▄▄▄▒░█▀▀▀▀▄▄█░░░██▄▄█░░░░█░");
				target.sendMessage("█░▒█▒▄░▀▄▄▄▀░░░░░░░░█░░░▒▒▒▒▒░█");
				target.sendMessage("█░▒█░█▀▄▄░░░░░█▀░░░░▀▄░░▄▀▀▀▄▒█");
				target.sendMessage("░█░▀▄░█▄░█▀▄▄░▀░▀▀░▄▄▀░░░░█░░█░");
				target.sendMessage("░░█░░░▀▄▀█▄▄░█▀▀▀▄▄▄▄▀▀█▀██░█░░");
				target.sendMessage("░░░█░░░░██░░▀█▄▄▄█▄▄█▄████░█░░░");
				target.sendMessage("░░░░█░░░░▀▀▄░█░░░█░█▀██████░█░░");
				target.sendMessage("░░░░░▀▄░░░░░▀▀▄▄▄█▄█▄█▄█▄▀░░█░░");
				target.sendMessage("░░░░░░░▀▄▄░▒▒▒▒░░░░░░░░░░▒░░░█░");
				target.sendMessage("░░░░░░░░░░▀▀▄▄░▒▒▒▒▒▒▒▒▒▒░░░░█░");
				target.sendMessage("░░░░░░░░░░░░░░▀▄▄▄▄▄░░░░░░░░█░░");
			}else{
				sender.sendMessage(ChatColor.RED + "You do not have permission to do this.");
			}
		}
	if(cmd.getName().equalsIgnoreCase("trollreload")){
		if(sender.hasPermission("Troll.reload")){
			plugin.reloadConfig();
		}else{
			sender.sendMessage(ChatColor.RED + "You do not have permission to do this.");
		}
	}
	}
	return false;	
}
}

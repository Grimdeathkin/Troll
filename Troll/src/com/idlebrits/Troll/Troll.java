package com.idlebrits.Troll;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Troll extends JavaPlugin{
	public final TrollCommandExecutor ce = new TrollCommandExecutor(this);
	public final TrollPlayerListener pl = new TrollPlayerListener(this);
	public final HashMap<Player, ArrayList<Block>> hashmap = new HashMap<Player, ArrayList<Block>>();
	
	
	public void onEnable(){
		File file = new File(getDataFolder() + File.separator + "config.yml");
		if(!file.exists()) {
        	this.saveDefaultConfig();
        }
	getCommand("sendcustom").setExecutor(new TrollCommandExecutor(this));
	getCommand("freeze").setExecutor(new TrollCommandExecutor(this));
	getCommand("burn").setExecutor(new TrollCommandExecutor(this));
	getCommand("explode").setExecutor(new TrollCommandExecutor(this));
	getCommand("poison").setExecutor(new TrollCommandExecutor(this));
	getCommand("wither").setExecutor(new TrollCommandExecutor(this));
	getCommand("trollface").setExecutor(new TrollCommandExecutor(this));
	getCommand("trollreload").setExecutor(new TrollCommandExecutor(this));
	}
	public void onDisable(){
		
	}
}

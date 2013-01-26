package com.idlebrits.Troll;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class TrollPlayerListener implements Listener{
	public Troll plugin;
	
	public TrollPlayerListener(Troll instance){
		plugin = instance;
	}

	@EventHandler
	public void onPlayerMove(PlayerMoveEvent event){
		if (plugin.hashmap.containsKey(event.getPlayer())){
			event.getPlayer().teleport(event.getPlayer());
			event.getPlayer().sendMessage("You are unable to move!");
		}
	}
}

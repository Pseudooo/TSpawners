package me.pseudo.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import me.pseudo.TSpawners;
import me.pseudo.spawners.TSpawner;

public class BlockBreakListener implements Listener {

	public BlockBreakListener(TSpawners plugin) {
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}
	
	@EventHandler
	public void onBlockBreak(BlockBreakEvent e) {
		
	}
	
}

package me.pseudo.listeners;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import me.pseudo.TSpawners;
import me.pseudo.spawners.TSpawner;
import me.pseudo.spawners.TSpawnerHandler;

public class BlockBreakListener implements Listener {
	
	private final TSpawnerHandler spawnerHandler;

	// Register listener with server
	public BlockBreakListener(TSpawners plugin, TSpawnerHandler spawnerHandler) {
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
		this.spawnerHandler = spawnerHandler;
	}
	
	@EventHandler
	public void onBlockBreak(BlockBreakEvent e) {
		
		// Non-spawners require no action
		if(e.getBlock().getType() != Material.SPAWNER)
			return;
		
		// Non-registered spawners require no action
		if(!spawnerHandler.isRegistered(e.getBlock().getLocation()))
			return;
		
		// Unregister spawner
		spawnerHandler.unregisterTSpawner(e.getBlock().getLocation());
		
	}
	
}

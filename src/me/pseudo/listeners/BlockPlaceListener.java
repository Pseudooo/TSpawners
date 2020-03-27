package me.pseudo.listeners;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import me.pseudo.TSpawners;
import me.pseudo.spawners.TSpawner;
import me.pseudo.spawners.TSpawnerHandler;

public class BlockPlaceListener implements Listener {
	
	private final TSpawnerHandler spawnerHandler;

	// Register listener with server
	public BlockPlaceListener(TSpawners plugin, TSpawnerHandler spawnerHandler) {
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
		this.spawnerHandler = spawnerHandler;
	}
	
	@EventHandler
	public void onBlockPlace(BlockPlaceEvent e) {
		
		// No-action on non-spawners
		if(e.getBlock().getType() != Material.SPAWNER)
			return;
		
		// Register spawner
		TSpawner spawner = new TSpawner(e.getBlock().getLocation());
		this.spawnerHandler.registerSpawner(spawner);
		
	}
	
}

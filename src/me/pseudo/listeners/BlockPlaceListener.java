package me.pseudo.listeners;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import me.pseudo.TSpawners;

public class BlockPlaceListener implements Listener {

	// Register listener with server
	public BlockPlaceListener(TSpawners plugin) {
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}
	
	@EventHandler
	public void onBlockPlace(BlockPlaceEvent e) {
		
		// No-action on non-spawners
		if(e.getBlock().getType() != Material.SPAWNER)
			return;
		
		// TODO Determine how to register spawner
		
	}
	
}

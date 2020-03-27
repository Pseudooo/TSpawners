package me.pseudo;

import org.bukkit.plugin.java.JavaPlugin;

import me.pseudo.listeners.BlockBreakListener;
import me.pseudo.listeners.BlockPlaceListener;
import me.pseudo.spawners.TSpawnerHandler;

public class TSpawners extends JavaPlugin {

	public void onEnable() {
		
		// create a spawner handler
		TSpawnerHandler spawnerHandler = new TSpawnerHandler();
		
		// * * * * * REGISTER LISTENERS
		new BlockPlaceListener(this, spawnerHandler);
		new BlockBreakListener(this, spawnerHandler);
		
	}
	
	public void onDisable() {
		
	}
	
}

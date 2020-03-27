package me.pseudo.spawners;

import org.bukkit.Location;

public class TSpawner {

	/*
	 * TSpawner class will be used to represent an individual spawner block
	 * that is to be tracked by the plugin
	 */
	
	private final Location location;
	
	
	public TSpawner(Location location) {
		this.location = location;
	}
	
}

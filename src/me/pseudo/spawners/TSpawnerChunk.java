package me.pseudo.spawners;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Chunk;
import org.bukkit.Location;

public class TSpawnerChunk {

	/*
	 * TSpawner chunk will be used to track all spawner's that are contained within
	 * a given chunk. Allowing for all spawner's located within a given chunk to be
	 * obtained effectively.
	 */
	
	private final Chunk chunk;
	
	private final Map<Location, TSpawner> spawners;
	
	public TSpawnerChunk(Chunk chunk) {
		this.chunk = chunk;
		this.spawners = new HashMap<Location, TSpawner>();
	}
	
	public void registerTSpawner(TSpawner spawner) {
		
		// no-need to check if the spawner is registered
		this.spawners.put(spawner.getLocation(), spawner);
		System.out.println("Spawner registered!");
		
	}
	
	/**
	 * Check if a given location is registered
	 * @param location to check
	 * @return status
	 */
	public boolean isRegistered(Location location) {
		return spawners.containsKey(location);
	}
	
	/**
	 * Unregister a given TSpawner
	 * @param spawner to unregister
	 */
	public void unregisterTSpawner(TSpawner spawner) {
		unregisterTSpawner(spawner.getLocation());
	}
	
	/**
	 * Unregister a given location
	 * @param location to unregister
	 */
	public void unregisterTSpawner(Location location) {
		spawners.remove(location);
		System.out.println("Spawner unregistered");
	}
	
}

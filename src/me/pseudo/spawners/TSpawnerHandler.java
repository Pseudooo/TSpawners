package me.pseudo.spawners;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Chunk;
import org.bukkit.Location;

public class TSpawnerHandler {

	private final Map<String, TSpawnerChunk> chunks;
	
	public TSpawnerHandler() {
		this.chunks = new HashMap<String, TSpawnerChunk>();
	}
	
	/**
	 * Register a spawner to be tracked by plugin
	 * @param spawner to be registered
	 */
	public void registerSpawner(TSpawner spawner) {
		
		// If the chunk isn't registered, register it
		Chunk spawnerChunk = spawner.getLocation().getChunk();
		if(!this.chunks.containsKey(chunkStringLocation(spawnerChunk))) {
			
			this.chunks.put(chunkStringLocation(spawnerChunk), new TSpawnerChunk(spawnerChunk));
		
		}
		
		// Call for chunk to register spawner
		this.chunks.get(chunkStringLocation(spawnerChunk)).registerTSpawner(spawner);
		
	}
	
	/**
	 * Check if a given location is registered
	 * @param location to check
	 * @return status
	 */
	public boolean isRegistered(Location location) {
		
		// Unregistered chunk -> unregistered location
		if(!chunks.containsKey(chunkStringLocation(location.getChunk())))
			return false;
		
		// Get status from chunk
		return chunks.get(chunkStringLocation(location.getChunk())).isRegistered(location);
		
	}
	
	public void unregisterTSpawner(TSpawner spawner) {
		unregisterTSpawner(spawner.getLocation());
	}
	
	public void unregisterTSpawner(Location location) {
		chunks.get(chunkStringLocation(location.getChunk())).unregisterTSpawner(location);
	}
	
	/**
	 * Chunk interface does not offer an implementation
	 * of hashcode so strings will be used to hash instead
	 * @param chunk to convert
	 * @return String repr of location
	 */
	private String chunkStringLocation(Chunk chunk) {
		return String.format("%s@[%d,%d]", 
				chunk.getWorld().getName(),
				chunk.getX(),
				chunk.getZ());
	}
	
}

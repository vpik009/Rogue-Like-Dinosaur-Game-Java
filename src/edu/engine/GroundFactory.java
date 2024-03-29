package edu.engine;

/**
 * Interface for factory classes used by GameMap to create new map locations.
 */
public interface GroundFactory {
	Ground newGround(char displayChar);
}

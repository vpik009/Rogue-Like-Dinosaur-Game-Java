package game;

import edu.engine.Actions;
import edu.engine.Actor;
import edu.engine.Ground;
import edu.engine.Location;

/**
 * A public class Grass that is extended from Ground
 */
public class Grass extends Ground {

	/**
	 * A constant private final integer addFood of 5, shows how much food level actor should get upon consumption of this class instance
	 */
	private static final int ADD_FOOD = 5;

	/**
	 * A public constructor that determines displayChar and addCapability of
	 * EAT_BY_SELF_HERBIVORE from DinoCapability
	 */
	public Grass() {
		super('^');
		this.addCapability(DinoCapability.EAT_BY_SELF_HERBIVORE);
	}

	/**
	 * A getter int foodToConsume that returns addFood
	 * @return addFood
	 */
	@Override
	public int foodToConsume() {
		return ADD_FOOD;
	}

	
}

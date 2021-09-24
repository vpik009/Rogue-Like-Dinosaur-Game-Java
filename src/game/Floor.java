package game;

import edu.monash.fit2099.engine.Ground;

/**
 * A class that represents the floor inside a building.
 */
public class Floor extends Ground {

	/**
	 * A private constant and static integer ADD_FOOD of 0, specifies how much food should be added to an actor upon consumption
	 */
	private static final int ADD_FOOD = 0;

	/**
	 * A public constructor Floor that determines its display character
	 */
	public Floor() {
		super('_');
	}

	/**
	 * A public int getter for getFood that returns addFood
	 * @return ADD_FOOD
	 */
	@Override
	public int foodToConsume() {
		return ADD_FOOD;
	}

}

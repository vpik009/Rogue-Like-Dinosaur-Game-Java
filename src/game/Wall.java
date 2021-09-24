package game;

import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Ground;

/**
 * public class wall extends from ground. This is a type of ground that a player cannot enter
 */
public class Wall extends Ground {

	/**
	 * private constant and static integer ADD_FOOD that specifies how much food an actor should get if it were to eat a wall
	 */
	private static final int ADD_FOOD = 0;

	/**
	 * Public constructor that creates a ground type by passing a display character to the parent constructor
	 */
	public Wall() {
		super('#');
	}
	
	@Override
	/**
	 * public overriden method to not allow the player to enter this ground type
	 * @return false: boolean
	 */
	public boolean canActorEnter(Actor actor) {
		return false;
	}
	
	@Override
	/**
	 * Public method overriden from its super class
	 * @see Ground#blocksThrownObjects()
	 */
	public boolean blocksThrownObjects() {
		return true;
	}

	@Override
	/**
	 * A publc getter to get ADD_FOOD attribute
	 */
	public int foodToConsume() {
		return ADD_FOOD;
	}
}

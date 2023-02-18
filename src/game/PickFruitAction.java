package game;

import edu.engine.Action;
import edu.engine.Actor;
import edu.engine.GameMap;
import edu.engine.Location;

/**
 * A public class PickFruitAction that is extended from Action
 * This allows a player to pick up fruit from the ground
 */
public class PickFruitAction extends Action {
	
	protected Location location;

	/**
	 * A public constructor
	 * @praram Location location
	 */
	public PickFruitAction(Location location) {
		this.location = location;
		
	}

	/**
	 * Perform the pickFruitAction.
	 *
	 * @param actor The actor performing the action.
	 * @param map The map the actor is on.
	 * @return a description of if a fruit is picked successfully or not
	 */
	@Override
	public String execute(Actor actor, GameMap map) {

		int chanceToFail = 60;
		double random = Math.random()*100;
		
		if(random>=chanceToFail) 
		{
			Fruit fruit = new Fruit();
			actor.addItemToInventory(fruit);
			return "picked a fruit successfully";
		}
		
		return "failed to pick a fruit";
	}

	/**
	 * Returns a descriptive string of picking up a fruit
	 * @param actor The actor performing the action.
	 * @return the text we put on the menu
	 */
	@Override
	public String menuDescription(Actor actor) {
		return actor + " picks a fruit from a tree";
	}


}

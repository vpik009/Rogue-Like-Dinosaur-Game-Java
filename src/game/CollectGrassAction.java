package game;

import java.util.Random;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actions;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;
import edu.monash.fit2099.engine.Location;
import edu.monash.fit2099.engine.Weapon;

/**
 * CollectGrassAction is used for an actor to be able to collect grass if he is standing on it
 */
public class CollectGrassAction extends Action {
	
	/**
	 * Location to be picked for grass
	 */
	protected Location location;


	/**
	 * A Public Constructor
	 * @param location : location of the grass to be collected
	 */
	public CollectGrassAction(Location location) {
		this.location = location;
		
	}

	/**
	 * A public method which adds eco points and add hay to inventory
	 * @param actor The actor performing the action.
	 * @param map The map the actor is on.
	 * @return
	 */
	@Override
	public String execute(Actor actor, GameMap map) {


		location.setGround(new Dirt());
		actor.addItemToInventory(new Hay());
		
		if(actor instanceof Player) {
			((Player) actor).addEco(1);
		}

		return actor + " collected grass and gained 1 eco point";
	}

	/**
	 * A public method which returns name of the actor and a message " collects grass"
	 * @param actor The actor performing the action.
	 * @return : name of the actor and a message " collects grass"
	 */
	@Override
	public String menuDescription(Actor actor) {
		return actor + " collects grass";
	}

}

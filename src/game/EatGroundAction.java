package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Ground;

/**
 * Extended from Action Class, this class implements eating ground as food
 */
public class EatGroundAction extends Action {

	/**
	 * private attribute of type ground. The ground that is to be eaten
	 */
    private Ground ground;

	/**
	 * A public Constructor which instantiate the object of this class
	 * @param ground
	 */
	public EatGroundAction(Ground ground){
        this.ground = ground;
    }

	/**
	 * A public method which increases the food level, removes the food (item) after being eaten from the ground, and add food (item) to the actor.
	 * @param actor The actor performing the action.
	 * @param map The map the actor is on.
	 * @return
	 */
    @Override
	public String execute(Actor actor, GameMap map) {
		//remove the item from map and add its food to the actor
		map.locationOf(actor).setGround(new Dirt());
        ((Dinosaur)actor).addFood(ground.foodToConsume());
		return actor +" at [" + map.locationOf(actor).x() + "]["+map.locationOf(actor).y() +"] eats " + ground.getClass().getName().substring(5) + " and gains " + (ground.foodToConsume() + " to its food level");
	}

	/**
	 * Description of the food level added and the food (item) eaten from the ground
	 * @param actor The actor performing the action.
	 * @return
	 */
	@Override
	public String menuDescription(Actor actor) {
		return actor + " eats " + ground.getClass().getName().substring(5) + " and gains " + (ground.foodToConsume()+ " to its food level");
	}
    
}

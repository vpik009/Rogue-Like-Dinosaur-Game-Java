package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;

/**
 * Extended from Action Class, this class implements eating items food
 */
public class EatItemAction extends Action {

	/**
	 * private attribute of type Item. The item to be eaten
	 */
    private Item item;

	/**
	 * A public Constructor which instantiate the object of this class
	 * @param item
	 */
	public EatItemAction(Item item){
        this.item = item;
    }

	/**
	 * A public method which increases the food level, removes the food (item) after being eaten, and add food (item) to the actor.
	 * @param actor The actor performing the action.
	 * @param map The map the actor is on.
	 * @return
	 */
    @Override
	public String execute(Actor actor, GameMap map) {
		//remove the item from map and add its food to the actor
		map.locationOf(actor).removeItem(item);
        actor.addFood(item.foodToConsume());
		return actor +" at [" + map.locationOf(actor).x() + "]["+map.locationOf(actor).y() +"] eats " + item + " and gains " + (item.foodToConsume() + " to its food level");
	}

	/**
	 * Description of the food level added and the food (item) eaten
	 * @param actor The actor performing the action.
	 * @return
	 */
	@Override
	public String menuDescription(Actor actor) {
		return actor + " eats " + item + " and gains " + (item.foodToConsume() + " to its food level");
	}
    
}

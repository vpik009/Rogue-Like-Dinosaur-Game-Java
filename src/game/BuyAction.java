package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;

/**
 * BuyAction inherits from Action, and is used to buy items from a vending machine
 */
public class BuyAction extends Action {
	
	/**
	 * private attribute item of type Purchasable (interface)
	 * stores the item that is being purchased
	 */
	private Purchasable item;

	/**
	 * Public constructor to instantiate objects of this class
	 * @param item , sets the item attribute of this instance to item parameter
	 */
	public BuyAction(Purchasable item){
		this.item = item;
	}
	


	@Override
	/**
	 * public execute method is used to execute this action and perform a series of operations
	 * @param actor , the actor that is performing this action
	 * @param map , the map the actor is on
	 * @return a String specifying whether an item has been bought, or that the actor has too few eco points to purchase the item
	 * @see Action#execute(Actor, GameMap)
	 */
	public String execute(Actor actor, GameMap map) {
		if(actor instanceof Player && ((Player) actor).getEco()>=item.getCost()) {
			// Need to create new egg instance to prevent it from instanly hatching
			if(item instanceof AllosaurEgg){
				actor.addItemToInventory(new AllosaurEgg());
			}
			else if (item instanceof StegosaurEgg){
				actor.addItemToInventory(new StegosaurEgg());
			}
			else if (item instanceof AgilisaurusEgg){
				actor.addItemToInventory(new AgilisaurusEgg());
			}
			else if (item instanceof ArchaeopteryxEgg){
				actor.addItemToInventory(new ArchaeopteryxEgg());
			}

			else{
				actor.addItemToInventory((Item)item);
			}
			((Player) actor).addEco(-(item.getCost()));
			return item + " has been added to " + actor + "'s inventory ";
		}
		return "Too few eco points to purchase "+item.toString();
	}

	@Override
	/**
	 * Menu description is a method  that displays a message on the menu when the action is able to be performed
	 * @param actor , the actor that is performing this action
	 * @see Action#menuDescription(Actor)
	 */
	public String menuDescription(Actor actor) {
		return "Buy "+item;
	}
}

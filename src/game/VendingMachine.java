package game;

import edu.monash.fit2099.engine.*;

/**
 * Vending machine is a public class extended from Ground.
 * Vending machine is placed on the map at (2,4) and it allows a player to buy items.
 */
public class VendingMachine extends Ground{

	/**
	 * private attribute final integer used to specify a value of addFood
	 */
	private static final int ADD_FOOD = 0;

	/**
	 * an array of buyActions that hold an option of what a player can buy from the vending machien
	 */
	protected BuyAction[] buyActions;

	/**
	 * Public Constructor to instantiate objects of this class and add options inside the buyActions array.
	 */
	public VendingMachine() {
		super('M');

		buyActions = new BuyAction[]
		{
			new BuyAction(new Hay()),
			new BuyAction(new Fruit()),
			new BuyAction(new LaserGun()),
			new BuyAction(new CarnivoreMealKit()),
			new BuyAction(new HerbivoreMealKit()),
			new BuyAction(new StegosaurEgg()),
			new BuyAction(new AllosaurEgg()),
			new BuyAction(new AgilisaurusEgg()),
			new BuyAction(new ArchaeopteryxEgg())
		};

	}

	/**
	 * Override this to implement impassable terrain
	 *
	 * @param actor the Actor to check
	 * @return false
	 */
	@Override
	public boolean canActorEnter(Actor actor) {
		return false;
	}

	/**
	 * Add Buy actions inside the allowable actions of a player.
	 * Loop through each element inside the buyActions Array and add it
	 * inside the actionsList.
	 *
	 * @param actor the Actor acting
	 * @param location the current Location
	 * @param direction the direction of the Ground from the Actor
	 * @return actionsList
	 */
	@Override
	public Actions allowableActions(Actor actor, Location location, String direction){
		Actions actionsList = new Actions();
		for(BuyAction buyAc: buyActions){
			actionsList.add(buyAc);
		}
		return actionsList;
	}

	/**
	 * a getter for addFood
	 * @return addFood
	 */
	@Override
	public int foodToConsume() {
		return ADD_FOOD;
	}

}

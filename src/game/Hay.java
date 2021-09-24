package game;

import edu.monash.fit2099.engine.Item;

/**
 * A public class Hay that is extended from PortableItem that implements Purchasable and Feedable
 */
public class Hay extends PortableItem implements Purchasable, Feedable{

	/**
	 * A private static and constant integer COST of 20, specifies how many eco points the item costs if bought from a vending machine
	 */
	private static final int COST = 20;

	/**
	 * A private static and constant integer ADD_FOOD of 20, specifies how much food should be added to an actor upon consumption
	 */
	private static final int ADD_FOOD = 20;

	/**
	 * A private static and constant integer ADD_ECO of 100, specifies how much eco a player should get upon feeding this item to another actor
	 */
	private static final int ADD_ECO = 10;

	/**
	 * A public constructor that determines name and display character for Hay
	 */
	public Hay() {
		super("Hay",'h');//Hay is represented by h and is portable
		this.addCapability(DinoCapability.FEED_HERBIVORE);
	}

	/**
	 * A public int getter that returns cost
	 * @return COST
	 */
	public int getCost(){
		return COST;
	}

	@Override
	/**
	 * A public int getter that returns addFood
	 * @return ADD_FOOD
	 */
	public int foodToConsume(){
		return ADD_FOOD;
	}

	/**
	 * A public int getter that returns addEco
	 * @return ADD_ECO
	 */
	public int getAddEco(){
		return ADD_ECO;
	}
}
